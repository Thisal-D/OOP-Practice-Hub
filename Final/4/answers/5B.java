import java.util.ArrayList;

// Interface
interface Registrable {
    String getVehicleID();

    String getModel();

    void displayInfo();
}

// Vehicle class implementing Registrable
class Vehicle implements Registrable {
    private String vehicleID;
    private String model;
    private String owner;
    private static int registrationYear;

    // Constructor
    public Vehicle(String vehicleID, String model, String owner) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.owner = owner;
    }

    // Interface method implementations
    public String getVehicleID() {
        return vehicleID;
    }

    public String getModel() {
        return model;
    }

    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Model: " + model);
        System.out.println("Owner: " + owner);
        System.out.println("Registration Year: " + registrationYear);
        System.out.println("-----------------------------");
    }

    // Additional methods
    public String getOwner() {
        return owner;
    }

    public static void setRegistrationYear(int year) {
        registrationYear = year;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }
}

// VehicleRegistry class
class VehicleRegistry {
    private ArrayList<Vehicle> vehicles;

    public VehicleRegistry() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void displayAllVehicles() {
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        // Set common registration year
        Vehicle.setRegistrationYear(2025);

        // Create vehicle objects
        Vehicle v1 = new Vehicle("V001", "Toyota Corolla", "Alice");
        Vehicle v2 = new Vehicle("V002", "Honda Civic", "Bob");
        Vehicle v3 = new Vehicle("V003", "Ford Focus", "Charlie");

        // Create VehicleRegistry and add vehicles
        VehicleRegistry registry = new VehicleRegistry();
        registry.addVehicle(v1);
        registry.addVehicle(v2);
        registry.addVehicle(v3);

        // Display all vehicle details
        registry.displayAllVehicles();
    }
}
