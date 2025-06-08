import java.util.Scanner;

class InvalidEmployeeID extends Exception {
    public InvalidEmployeeID(String message) {
        super(message);
    }
}

class InvalidAgeRange extends Exception {
    public InvalidAgeRange(String message) {
        super(message);
    }
}

class EmployeeRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter Employee Age: ");
            int age = scanner.nextInt();

            if (empId.length() < 6 || !(empId.charAt(empId.length() - 3) == 'E'
                    && empId.charAt(empId.length() - 2) == 'M' && empId.charAt(empId.length() - 1) == 'P')) {
                throw new InvalidEmployeeID("Employee ID must end with 'EMP' and be at least 6 characters long");
            }

            if (age < 18 || age > 65) {
                throw new InvalidAgeRange("Employee age must be between 18 and 65");
            }

            System.out.println("Employee Registered Successfully");

        } catch (InvalidEmployeeID e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeRange e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        } finally {
            scanner.close();
        }
    }
}
