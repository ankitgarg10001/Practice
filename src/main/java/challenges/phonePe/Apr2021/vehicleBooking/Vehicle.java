package challenges.phonePe.Apr2021.vehicleBooking;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Vehicle {

    private final String vehicleId;
    private final String model;
    private final String regNo;
    private final VehicleType vehicleType;
    private List<BookingDetails> bookingDetails;
    //in case of any issue, we should have all bookings from past, usually this would be in a DB so search would be better,
    // instead of whole iteration. which can be cleaned up regularly by regular jobs

    public Vehicle(String model, String regNo, VehicleType vehicleType) {
        this.model = model;
        this.regNo = regNo;
        this.vehicleType = vehicleType;
        this.vehicleId = UUID.randomUUID().toString();
        bookingDetails = new LinkedList<>();
    }

    //No setter for these
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public String getRegNo() {
        return regNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public List<BookingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getVehicleId(), vehicle.getVehicleId()) && Objects.equals(getModel(), vehicle.getModel())
            && Objects.equals(getRegNo(), vehicle.getRegNo()) && getVehicleType() == vehicle.getVehicleType() && Objects
            .equals(getBookingDetails(), vehicle.getBookingDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleId(), getModel(), getRegNo(), getVehicleType(), getBookingDetails());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "vehicleId='" + vehicleId + '\'' +
            ", model='" + model + '\'' +
            ", regNo='" + regNo + '\'' +
            ", vehicleType=" + vehicleType +
            ", bookingDetails=" + bookingDetails +
            '}';
    }
}
