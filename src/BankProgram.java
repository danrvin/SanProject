import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class BankProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        Map<String, BankAccount> accounts = new HashMap<>();
        accounts.put("Daniil",new BankAccount("1"));
        accounts.put("Wlad",new BankAccount("2"));
        accounts.put("Anton", new BankAccount("3"));
          
        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Accounts");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your account number: ");
                String accountNumber = scanner.next();
                if (accounts.containsKey(accountNumber)) {
                    BankAccount account = accounts.get(accountNumber);
                    displayAccountMenu(scanner, account);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                System.out.println(accounts);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayAccountMenu(Scanner scanner, BankAccount account) {
        while (true) {
            System.out.println("Account Number: " + account.getBalance());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transaction History");
            System.out.println("4. Log Out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    List<Transaction> transactions = account.getTransactionHistory();
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.getDescription() + " - Amount: $" + transaction.getAmount()
                                + " - Date: " + transaction.getDate());
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
