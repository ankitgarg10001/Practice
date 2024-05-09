package challenges.phonePe.Apr2021.vehicleBooking;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Branch {

    public String name;
    private final Map<VehicleType, Set<Vehicle>> vehicles;
    private final Map<VehicleType, Double> rate;

    public Branch(String name) {
        this.name = name;
        this.vehicles = new HashMap<>();
        this.rate = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    //can be used, not frequently though
    public void setName(String name) {
        this.name = name;
    }

    public Map<VehicleType, Set<Vehicle>> getVehicles() {
        return vehicles;
    }

    public Map<VehicleType, Double> getRate() {
        return rate;
    }

}
