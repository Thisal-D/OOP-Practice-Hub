import java.util.Scanner;

class TableReservation {
    private int tableId;
    private int tableSize;
    private int reservedSeats;
    private boolean isReserved;

    // Constructor 1: only tableId and tableSize
    public TableReservation(int tableId, int tableSize) {
        this.tableId = tableId;
        this.tableSize = tableSize;
        this.reservedSeats = 0;
        this.isReserved = false;
    }

    // Constructor 2: all attributes
    public TableReservation(int tableId, int tableSize, int reservedSeats, boolean isReserved) {
        this.tableId = tableId;
        this.tableSize = tableSize;
        this.reservedSeats = reservedSeats;
        this.isReserved = isReserved;
    }

    // Method Overload 1: reserveTable with number of seats
    public void reserveTable(int seatsRequested) {
        if (isReserved) {
            System.out.println("This table is already reserved. Please select another table.");
        } else if (seatsRequested > tableSize) {
            System.out.println("Not enough seats available for this table. Please select a smaller number of seats.");
        } else {
            this.reservedSeats = seatsRequested;
            this.isReserved = true;
            System.out.println("Reservation successful!");
        }
    }

    // Method Overload 2: reserveTable with default 2 seats
    public void reserveTable() {
        reserveTable(2); // delegate to the main method
    }

    // Display details of the table
    public void displayTableDetails() {
        System.out.println("Table ID: " + tableId);
        System.out.println("Table Size: " + tableSize);
        System.out.println("Reserved Seats: " + reservedSeats);
        System.out.println("Available Seats: " + (tableSize - reservedSeats));
        System.out.println("Is Reserved: " + (isReserved ? "Reserved" : "Available"));
        System.out.println("-----------------------------");
    }
}

class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableReservation[] tables = new TableReservation[3];

        // Input details for 3 tables
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Table " + (i + 1));
            System.out.print("Table ID: ");
            int tableId = scanner.nextInt();
            System.out.print("Table Size: ");
            int tableSize = scanner.nextInt();

            // Create object using constructor with two parameters
            tables[i] = new TableReservation(tableId, tableSize);
        }

        // Reserve seats for each table
        for (int i = 0; i < 3; i++) {
            System.out.println("\nReservation for Table ID: " + (i + 1));
            System.out.print("Enter number of seats to reserve (0 to reserve 2 by default): ");
            int seats = scanner.nextInt();

            if (seats == 0) {
                tables[i].reserveTable(); // calls overloaded method with no parameters
            } else {
                tables[i].reserveTable(seats); // calls overloaded method with int parameter
            }
        }

        // Display table details
        System.out.println("\nFinal Table Details:");
        for (int i = 0; i < 3; i++) {
            tables[i].displayTableDetails();
        }

        scanner.close();
    }
}
