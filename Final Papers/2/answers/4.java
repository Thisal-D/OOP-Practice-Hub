// Base Class: Account
class Account {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    // Parameterized Constructor
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number    : " + accountNumber);
        System.out.println("Account Holder    : " + accountHolderName);
        System.out.println("Current Balance   : $" + balance);
    }
}

// Derived Class: SavingsAccount
class SavingsAccount extends Account {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    // Getter
    public double getInterestRate() {
        return interestRate;
    }

    // Calculate interest
    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    // Display full details
    public void displaySavingsDetails() {
        displayAccountDetails();
        System.out.println("Interest Rate     : " + interestRate + "%");
        System.out.println("Calculated Interest: $" + calculateInterest());
        System.out.println();
    }
}

// Class: Transaction (Dependency)
class Transaction {
    private String transactionID;
    private double amount;

    // Constructor
    public Transaction(String transactionID, double amount) {
        this.transactionID = transactionID;
        this.amount = amount;
    }

    // Deposit
    public void processDeposit(Account account) {
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        System.out.println("Deposit of $" + amount + " successful.");
    }

    // Withdrawal
    public void processWithdrawal(Account account) {
        if (amount <= account.getBalance()) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Error: Insufficient balance for withdrawal of $" + amount);
        }
    }

    // Display transaction details
    public void displayTransactionDetails() {
        System.out.println("Transaction ID    : " + transactionID);
        System.out.println("Transaction Amount: $" + amount);
        System.out.println();
    }
}

// Main Class
class BankAccountManagementSystem {
    public static void main(String[] args) {
        // Step 1: Create SavingsAccount
        SavingsAccount savings = new SavingsAccount("AC1001", "Emma Brown", 1000.0, 4.5);

        // Step 2: Create Transactions
        Transaction deposit = new Transaction("TXN-D001", 300.0);
        Transaction withdrawal = new Transaction("TXN-W001", 500.0);

        // Step 3: Process Deposit
        deposit.processDeposit(savings);
        deposit.displayTransactionDetails();

        // Step 4: Process Withdrawal
        withdrawal.processWithdrawal(savings);
        withdrawal.displayTransactionDetails();

        savings.displaySavingsDetails();
    }
}
