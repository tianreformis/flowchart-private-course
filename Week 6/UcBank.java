import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountName;
    private double balance;

    public Account(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }


    public void updateBalance(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }
}

public class UcBank {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add new account");
            System.out.println("2. Check account details");
            System.out.println("3. Update account balance");
            System.out.println("4. Delete account");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewAccount();
                    break;
                case 2:
                    checkAccountDetails();
                    break;
                case 3:
                    updateAccountBalance();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    System.out.println("Thank you for using UC Bank.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addNewAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter account balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        accounts.add(new Account(accountNumber, accountName, balance));
        System.out.println("Successfully added new account.");
    }

    private static void checkAccountDetails() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + ": " + accounts.get(i));
        }

        System.out.print("Select account number to view details: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < accounts.size()) {
            System.out.println(accounts.get(index));
        } else {
            System.out.println("No such account.");
        }
    }

    private static void updateAccountBalance() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + ": " + accounts.get(i));
        }

        System.out.print("Select account number to update balance: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < accounts.size()) {
            System.out.print("Enter amount to add/subtract (use negative for subtraction): ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (accounts.get(index).getBalance() + amount < 0) {
                System.out.println("You do not have enough balance.");
            } else {
                accounts.get(index).updateBalance(amount);
                System.out.println("Balance updated successfully.");
            }
        } else {
            System.out.println("No such account.");
        }
    }

    private static void deleteAccount() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + ": " + accounts.get(i));
        }

        System.out.print("Select account number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < accounts.size()) {
            accounts.remove(index);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println ("No such account.");
        }
    }
}