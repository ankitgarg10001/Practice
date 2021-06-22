package challenges.phonePe.Apr2021.vehicleBooking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class City {

    String name;
    String currency;
    Map<String, Branch> branches;

    public City(String name, String currency) {
        this.name = name;
        this.currency = currency;
        this.branches = new HashMap<>();
    }


    /**
     * books a vehicle if available
     *
     * @return rate user would be charged
     */
    Double bookVehicle(Person requestee, VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime) {
        assert startTime.isBefore(endTime);
        //can be created based on strategy, maybe get strategy as a param
        System.out.printf("Trying to book a vehicle Type %s from Person %s from %s to %s \n", vehicleType, requestee, startTime, endTime);
        List<Branch> strategicBranchOrder = getCostStrategyBranchOrder(vehicleType);

        for (Branch currentBranch : strategicBranchOrder) {
            if (currentBranch.getVehicles() == null || !currentBranch.getVehicles().containsKey(vehicleType)) {
                continue;
            }
            final Set<Vehicle> vehicles = currentBranch.getVehicles().get(vehicleType);
            for (Vehicle currentVehicle : vehicles) {
                boolean vehicleAvailable = true;
                for (BookingDetails bookingDetail : currentVehicle.getBookingDetails()) {
                    if ((endTime.isBefore(bookingDetail.getBookingEndTime()) && endTime.isBefore(bookingDetail.getBookingStartTime()))
                        || (startTime.isAfter(bookingDetail.getBookingEndTime()) && startTime
                        .isAfter(bookingDetail.getBookingStartTime()))
                    ) {
                        continue;
                    }
                    if (startTime.isBefore(bookingDetail.getBookingEndTime()) || endTime.isAfter(bookingDetail.getBookingStartTime())) {
                        vehicleAvailable = false;
                        break;
                    }
                }
                if (vehicleAvailable) {
                    System.out.println(
                        "Selected vehicle " + currentVehicle.getVehicleId() + " With Registration Number " + currentVehicle.getRegNo()
                            + " from branch " + currentBranch.getName());
                    currentVehicle.getBookingDetails().add(new BookingDetails(startTime, endTime, requestee));
                    return currentBranch.getRate().get(vehicleType) * Duration.between(startTime, endTime).toHours();
                }

            }

        }
        System.out.println("No Vehicle Available");

        return 0d;
    }

    private List<Branch> getCostStrategyBranchOrder(
        VehicleType vehicleType) {
        return branches.values().stream()
            .filter(a -> a.getRate().get(vehicleType) != null)
            .sorted((a, b) -> (int) (a.getRate().get(vehicleType) - b.getRate().get(vehicleType))).collect(Collectors.toList());
    }


    /**
     * adds lowercase branchName
     */
    synchronized Branch addBranch(String branchName) throws BranchException {
        System.out.printf("Trying to add a branch %s \n", branchName);
        branchName = branchName.toLowerCase();//keep it in lower case to avoid branches like This/THIS or ThIs
        if (branches.containsKey(branchName)) {
            throw new BranchException("Branch with required name already exists");
        }
        final Branch branch = new Branch(branchName);
        branches.put(branchName, branch);
        return branch;
    }

    /**
     * returns old price associated with this, or null if none was allocated earlier
     */
    Double allocatePrice(String branchName, VehicleType vehicleType, Double price) throws BranchException {
        System.out
            .printf("Attempting to add %s vehicleType for Price %s at branch %s \n", vehicleType.getName(), price, branchName);
        final Branch branch = getBranch(branchName);
        return branch.getRate().put(vehicleType, price);
    }

    protected Branch getBranch(String branchName) throws BranchException {
        final Branch branch = branches.get(branchName.toLowerCase());
        if (branch == null) {
            throw new BranchException("Branch not found: " + branchName);
        }
        return branch;
    }

    /**
     * returns true if vehicle is added, false if it was already there
     */
    boolean addVehicle(
        Vehicle vehicle, String branchName) throws VehicleException, BranchException {
        System.out.printf("Trying to add a vehicle %s to branch %s \n", vehicle, branchName);
        final Branch branch = getBranch(branchName);
        if (branch.getRate().get(vehicle.getVehicleType()) == null) {
            throw new VehicleException(
                "VehicleType " + vehicle.getVehicleType().getName() + " not supported by branch " + branchName + " yet");
        }
        synchronized (this) {
            final Set<Vehicle> vehicles = branch.getVehicles().computeIfAbsent(vehicle.getVehicleType(), k -> new HashSet<>());
            return vehicles.add(vehicle);
        }
    }

}
