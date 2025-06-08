import java.util.ArrayList;

// 1. Interface Accountable
interface Accountable {
    int getAccountID();

    String getCustomerName();

    void displayAccountDetails();
}

// 2. CustomerAccount class implementing Accountable
class CustomerAccount implements Accountable {
    private int accountID;
    private String customerName;
    private double balance;

    private static int idCounter = 1000; // Starting ID from 1000 (can be any number)

    // Constructor
    public CustomerAccount(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
        this.accountID = generateAccountID();
    }

    // Synchronized method to ensure thread safety (optional)
    private static synchronized int generateAccountID() {
        return idCounter++;
    }

    // Implement interface methods
    @Override
    public int getAccountID() {
        return accountID;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Account ID: " + accountID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: $" + balance);
        System.out.println("-------------------------");
    }

    // Additional method
    public double getBalance() {
        return balance;
    }

    // Static method to get total accounts created
    public static int getTotalAccounts() {
        return idCounter - 1000;
    }
}

// 3. AccountManager class
class AccountManager {
    private ArrayList<CustomerAccount> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }

    public void addAccount(CustomerAccount acc) {
        accounts.add(acc);
    }

    public void displayAllAccounts() {
        for (CustomerAccount acc : accounts) {
            acc.displayAccountDetails();
        }
    }
}

// 4. Main class with main method
class CustomerAccountManagementApp {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();

        CustomerAccount acc1 = new CustomerAccount("Alice Johnson", 1500.75);
        CustomerAccount acc2 = new CustomerAccount("Bob Smith", 2350.00);
        CustomerAccount acc3 = new CustomerAccount("Charlie Brown", 980.50);

        manager.addAccount(acc1);
        manager.addAccount(acc2);
        manager.addAccount(acc3);

        System.out.println("Displaying all customer accounts:");
        manager.displayAllAccounts();

        System.out.println("Total accounts created: " + CustomerAccount.getTotalAccounts());
    }
}
