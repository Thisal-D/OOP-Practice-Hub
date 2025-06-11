import java.util.Scanner;

class GymClass {
    private String classId;
    private String className;
    private String classTime;
    private int spotsAvailable;

    // Constructor with all parameters
    public GymClass(String classId, String className, String classTime, int spotsAvailable) {
        this.classId = classId;
        this.className = className;
        this.classTime = classTime;
        this.spotsAvailable = spotsAvailable;
    }

    // Overloaded constructor with default values
    public GymClass(String classId, String className) {
        this.classId = classId;
        this.className = className;
        this.classTime = "To be announced";
        this.spotsAvailable = 0;
    }

    // Overloaded method: booking with parameter
    public void bookClass(int spotsRequested) {
        if (spotsRequested <= spotsAvailable) {
            spotsAvailable -= spotsRequested;
            System.out.println("Booking successful!");
        } else {
            System.out.println("Not enough spots available. Please select fewer spots or another class.");
        }
    }

    // Overloaded method: booking with no parameter (default 1 spot)
    public void bookClass() {
        bookClass(1); // reuse logic from other method
    }

    // Display class details
    public void displayClassDetails() {
        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        System.out.println("Class Time: " + classTime);
        System.out.println("Spots Available: " + spotsAvailable);
        System.out.println("------------------------------");
    }
}

class GymApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for class using full constructor
        System.out.println("Enter details for first class:");
        System.out.print("Class ID: ");
        String id1 = scanner.nextLine();
        System.out.print("Class Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Class Time: ");
        String time1 = scanner.nextLine();
        System.out.print("Spots Available: ");
        int spots1 = scanner.nextInt();
        scanner.nextLine(); // consume newline
        GymClass class1 = new GymClass(id1, name1, time1, spots1);

        // Input for class using overloaded constructor
        System.out.println("\nEnter details for second class:");
        System.out.print("Class ID: ");
        String id2 = scanner.nextLine();
        System.out.print("Class Name: ");
        String name2 = scanner.nextLine();
        GymClass class2 = new GymClass(id2, name2);

        // Booking for first class (with parameter)
        System.out.print("\nHow many spots to book in Class 1? ");
        int book1 = scanner.nextInt();
        class1.bookClass(book1);

        // Booking for second class (no parameter)
        System.out.println("Booking 1 spot in Class 2 by default:");
        class2.bookClass();

        // Display class details
        System.out.println("\nFinal Class Details:");
        class1.displayClassDetails();
        class2.displayClassDetails();

        scanner.close();
    }
}
