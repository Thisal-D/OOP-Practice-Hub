import java.util.Scanner;

// Custom Exception for Invalid Product Code
class InvalidProductCode extends Exception {
    public InvalidProductCode(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Price Range
class InvalidPriceRange extends Exception {
    public InvalidPriceRange(String message) {
        super(message);
    }
}

// Main Application Class
class ProductRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get product code from user
            System.out.print("Enter product code: ");
            String productCode = scanner.nextLine();

            // Validate product code: must contain at least one letter and one digit
            if (!productCode.matches(".*[a-zA-Z].*") || !productCode.matches(".*\\d.*")) {
                throw new InvalidProductCode("Product code must contain both letters and numbers");
            }

            // Get product price from user
            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();

            // Validate price range
            if (price <= 0.01) {
                throw new InvalidPriceRange("Product price must be greater than $0.01");
            }

            // If all inputs are valid
            System.out.println("Product registered successfully!");
            System.out.println("Code: " + productCode);
            System.out.println("Price: $" + price);

        } catch (InvalidProductCode e) {
            System.out.println(e.getMessage());
        } catch (InvalidPriceRange e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid data.");
        }

        scanner.close();
    }
}
