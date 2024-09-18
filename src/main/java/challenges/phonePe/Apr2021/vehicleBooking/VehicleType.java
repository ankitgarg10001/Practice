package challenges.phonePe.Apr2021.vehicleBooking;

public enum VehicleType {
    SEDAN("Sedan"),
    HATCHBACK("HatchBack"),
    SUV("SUV");

    String name;

    VehicleType(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
