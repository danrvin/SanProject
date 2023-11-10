import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class BankAccount {
    private final String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = ThreadLocalRandom.current().nextDouble(1000, 10000);
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return false;
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public String toString() {
        return "BankAccount - " + "account number: " + accountNumber;
    }
}