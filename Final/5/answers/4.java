class VehicleManagementSystem {

    public static void main(String[] args) {
        Engine engine = new Engine("ENG12345", 2.0);
        Car car = new Car("V001", "Toyota", engine, 4, "Sedan");

        car.displayCarDetails();
    }
}

class Engine {
    private String engineNumber;
    private double capacity;

    public Engine(String engineNumber, double capacity) {
        this.engineNumber = engineNumber;
        this.capacity = capacity;
    }

    public void displayEngineDetails() {
        System.out.println("Engine Number: " + engineNumber);
        System.out.println("Engine Capacity: " + capacity + " liters");
    }
}

class Vehicle {
    private String vehicleID;
    private String manufacturer;
    private Engine engine; // Composition

    public Vehicle(String vehicleID, String manufacturer, Engine engine) {
        this.vehicleID = vehicleID;
        this.manufacturer = manufacturer;
        this.engine = engine;
    }

    public void displayVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Manufacturer: " + manufacturer);
        engine.displayEngineDetails();
    }
}

class Car extends Vehicle {
    private int numDoors;
    private String carType;

    public Car(String vehicleID, String manufacturer, Engine engine, int numDoors, String carType) {
        super(vehicleID, manufacturer, engine);
        this.numDoors = numDoors;
        this.carType = carType;
    }

    public void displayCarDetails() {
        displayVehicleDetails();
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Car Type: " + carType);
    }
}
