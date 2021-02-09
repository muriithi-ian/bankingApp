public class BankingApp {
    public static void main(String[] args) {

    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

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
        }else if(previousTransaction<0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }else{
            System.out.println("No previous transaction");
        }
    }

    void showMenu(){

    }
}