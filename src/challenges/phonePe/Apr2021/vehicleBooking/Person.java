package challenges.phonePe.Apr2021.vehicleBooking;

public class Person {

    String name;
    String address;
    String aadharId;//since we're in India, and we want to keep it simple

    public Person(String name, String address, String aadharId) {
        this.name = name;
        this.address = address;
        this.aadharId = aadharId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", aadharId='" + aadharId + '\'' +
            '}';
    }
}
