import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        BankAccount ian = new BankAccount("Ian Muriithi", "ac-1");
        ian.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0 && balance > amount) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Not enough money in account. The available balance for withdrawal is: " + balance);
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No previous transaction");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome: " + customerName + " your id is: " + customerId);
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. View Previous Transaction");
        System.out.println("E. Exit");
        System.out.println("\n");


        do {
            System.out.println("=====================================");
            System.out.println("Select an action: ");
            System.out.println("=====================================");
            option = Character.toUpperCase(scanner.next().charAt(0));
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("------------------------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Invalid Option!!! Please enter again");
                    break;


            }

        } while (Character.toUpperCase(option) != 'E');

        System.out.println("--- Thanks for using our services ---");


        scanner.close();
    }
}