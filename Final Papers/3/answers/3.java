
// BankTransactionApp.java
import java.util.Scanner;

// InvalidAccountNumber.java
class InvalidAccountNumber extends Exception {
    public InvalidAccountNumber(String message) {
        super(message);
    }
}

// InsufficientBalance.java
class InsufficientBalance extends Exception {
    public InsufficientBalance(String message) {
        super(message);
    }
}

class BankTransactionApp {
    private static final double CURRENT_BALANCE = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get account number
            System.out.print("Enter 12-digit account number: ");
            String accountNumber = scanner.nextLine();

            // Validate account number
            if (!(accountNumber.length() == 12)) {
                throw new InvalidAccountNumber("Account number must be exactly 12 digits long");
            }

            // Get withdrawal amount
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();

            // Validate withdrawal amount
            if (withdrawalAmount > CURRENT_BALANCE) {
                throw new InsufficientBalance("Withdrawal amount cannot exceed current balance");
            }

            // If all validations pass
            double remainingBalance = CURRENT_BALANCE - withdrawalAmount;
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: $" + remainingBalance);

        } catch (InvalidAccountNumber e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientBalance e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
