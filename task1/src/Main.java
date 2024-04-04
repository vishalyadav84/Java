import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance
        }
    }
}

// ATM class with user interface and methods for transactions
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance for withdrawal.");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + bankAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + bankAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM with the user's bank account
        ATM atmMachine = new ATM(userAccount);

        // Main loop for the ATM
        while (true) {
            atmMachine.displayMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            atmMachine.processOption(choice);
        }
    }
}
