
import java.net.Socket;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.ISO;

// Custom exception class for invalid email format
class InvalidEmailFormat extends Exception {
    public InvalidEmailFormat() {
        super("The email address must contain '@' symbol :/");
    }
}

// Custom exception class for invalid phone number length
class InvalidPhoneNumberLength extends Exception {
    public InvalidPhoneNumberLength() {
        super("The phone number must be exactly 10 digits long :/");
    }
}

class ValidationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = sc.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = sc.nextLine();

        // Validate email
        try {
            boolean isEmailValid = false;
            // Go though the email and check if '@' exist in any index
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    isEmailValid = true;
                    break; // if '@' exist then break the loop, because no point of going though next part
                }
            }
            if (!isEmailValid) {
                throw new InvalidEmailFormat();
            }
            System.out.println("Email adrress is valid :).");
        } catch (InvalidEmailFormat e) {
            System.out.println(e.getMessage());

        }

        // Validate phone number length
        try {
            if (phone.length() != 10) {
                throw new InvalidPhoneNumberLength();
            }
            System.out.println("Phone number is valid :).");
        } catch (InvalidPhoneNumberLength e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
