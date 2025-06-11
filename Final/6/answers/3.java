import java.util.Scanner;

class InvalidISBNFormat extends Exception {
    public InvalidISBNFormat() {
        super("ISBN must be exactly 13 digits long and start with '978' or '979'");
    }
}

class InvalidPublicationYear extends Exception {
    public InvalidPublicationYear() {
        super("Publication year must be between 1900 and current year");
    }
}

class BookRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input ISBN
            System.out.print("Enter Book ISBN: ");
            String isbn = scanner.nextLine();

            // Validate ISBN
            if (isbn.length() != 13 || (!isbn.startsWith("978") && !isbn.startsWith("979"))) {
                throw new InvalidISBNFormat();
            }

            // Input publication year
            System.out.print("Enter Publication Year: ");
            int year = scanner.nextInt();

            // Validate publication year
            if (year < 1900 || year > 2025) {
                throw new InvalidPublicationYear();
            }

            // If all validations pass
            System.out.println("Book registered successfully");

        } catch (InvalidISBNFormat e) {
            System.out.println(e.getMessage());
        } catch (InvalidPublicationYear e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }

        scanner.close();
    }
}
