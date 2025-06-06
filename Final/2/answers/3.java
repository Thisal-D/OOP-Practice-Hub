import java.util.Scanner;

// Custom Exception for Invalid Student ID
class InvalidStudentID extends Exception {
    public InvalidStudentID() {
        super("Student ID must start with 'S' and max length is 6.");
    }
}

// Custom Exception for Invalid Grade Range
class InvalidGradeRange extends Exception {
    public InvalidGradeRange() {
        super("Grade must be between 0 and 100");
    }
}

// Main Application Class
class GradeValidationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Student ID
        System.out.print("Enter Student ID (Starts with 'S' and max 6 characters): ");
        String studentId = scanner.nextLine();

        try {

            // Validate Student ID format
            if (!studentId.startsWith("S") || studentId.length() > 6) {
                throw new InvalidStudentID();
            }

            // Input Grade
            System.out.print("Enter Grade (0 to 100): ");
            int grade = scanner.nextInt();

            // Validate Grade
            if (grade < 0 || grade > 100) {
                throw new InvalidGradeRange();
            }

            // If both validations pass
            System.out.println("Student ID and Grade are valid.");
            System.out.println("Student ID: " + studentId);
            System.out.println("Grade: " + grade);

        } catch (InvalidStudentID e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidGradeRange e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
