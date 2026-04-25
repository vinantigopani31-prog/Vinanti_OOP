import java.util.*;
class BankAccount {
    String accountId;
    String accountHolderName;
    double Balance;

    void assignValues(String acid, String acholdername, double balance) {
        accountId = acid;
        accountHolderName = acholdername;
        Balance = balance;
    }
    void displayValue() {
        System.out.println("Account Id            : " + accountId);
        System.out.println("Account holader name  : " + accountHolderName);
        System.out.println("Acccount Balance      : " + Balance);
        System.out.println();
    }
    static void search(BankAccount[] accounts, String accountId, int num) {
        int found = 0;
        for (int i = 0; i < num; i++) {
            if (accounts[i].accountId.equals(accountId)) {
                accounts[i].displayValue();
                found = 1;
            }
        }
        if (found == 0)
            System.out.println("Account_id does not found.");
    }
}
public class pr-2.2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("how many account you want to create : ");
        int num = sc.nextInt();
        BankAccount[] accounts = new BankAccount[num];
        if (num < 5) {
            System.out.println("Please create at least 5 accounts.");
        } 
        else {
            for (int i = 0; i < num; i++) {
                accounts[i] = new BankAccount();
                System.out.print("Enter account Id : ");
                String id = sc.next();
                System.out.print("Enter account Holder name  : ");
                String name = sc.next();
                System.out.print("Enter account Balance: ");
                Double bal = sc.nextDouble();
                System.out.println();
                accounts[i].assignValues(id, name, bal);
            }
            System.out.println("please read below instruction.");
            System.out.println("==================================================");
            System.out.println("press 1 for disply all customrer details.");
            System.out.println("press 2 for find account detail using account id.");
            System.out.println("press 3 for exit the program.");
            System.out.println("==================================================");
            int choice;
            do {
                System.out.print("Enetr your choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        for (int i = 0; i < num; i++) {
                            accounts[i].displayValue();
                        }
                        break;
                    case 2:
                        System.out.println("Enter an account id you wants found : ");
                        String found_id = sc.next();
                        BankAccount.search(accounts, found_id, num);
                        break;
                    case 3:
                        System.out.println("Exiting....");
                        break;
                    default:
                        System.out.println("Please enter valid choice! Try angain.");
                        break;
                }
            } while (choice != 3);
            sc.close();
        }
    }
}