package challenges.phonePe.Apr2021.vehicleBooking;


import java.time.LocalDateTime;

// Main class should be named 'Solution'
class Solution {

    public static void main(String[] args) throws BranchException, VehicleException {
        final City city = new City("Delhi", "INR");
        city.addBranch("Vasanth Vihar");
        city.addBranch("Cyber City");
        city.allocatePrice("Vasanth Vihar", VehicleType.SEDAN, 100d);
        city.allocatePrice("Vasanth Vihar", VehicleType.HATCHBACK, 80d);
        city.allocatePrice("Cyber City", VehicleType.SEDAN, 200d);
        city.allocatePrice("Cyber City", VehicleType.HATCHBACK, 50d);
        city.addVehicle(
            new Vehicle("1", "DL 01 MR 9310", VehicleType.SEDAN),
            "Vasanth Vihar");
        city.addVehicle(
            new Vehicle("2", "DL 01 MR 9311", VehicleType.SEDAN),
            "Cyber City");
        city.addVehicle(
            new Vehicle("3", "DL 01 MR 9312", VehicleType.HATCHBACK),
            "Cyber City");
        Double aDouble = city.bookVehicle(new Person("Ankit", "ABC", "DEF"),
            VehicleType.SEDAN,
            LocalDateTime.of(2020, 02, 29, 10, 00),
            LocalDateTime.of(2020, 02, 29, 13, 00));
        System.out.println("Vehicle booked at " + aDouble);
        aDouble = city.bookVehicle(new Person("Ankit", "ABC", "DEF"),
            VehicleType.SEDAN,
            LocalDateTime.of(2020, 02, 29, 14, 00),
            LocalDateTime.of(2020, 02, 29, 15, 00));
        System.out.println("Vehicle booked at " + aDouble);
        aDouble = city.bookVehicle(new Person("Ankit", "ABC", "DEF"),
            VehicleType.SEDAN,
            LocalDateTime.of(2020, 02, 29, 14, 00),
            LocalDateTime.of(2020, 02, 29, 15, 00));
        System.out.println("Vehicle booked at " + aDouble);
        aDouble = city.bookVehicle(new Person("Ankit", "ABC", "DEF"),
            VehicleType.SEDAN,
            LocalDateTime.of(2020, 02, 29, 14, 00),
            LocalDateTime.of(2020, 02, 29, 15, 00));
        System.out.println("Vehicle booked at " + aDouble);
    }
}
