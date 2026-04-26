// Custom Exception Class
class NotSufficientFundException extends Exception {
    public NotSufficientFundException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {
    private double balance;

    // Constructor initializes balance to 1000.00
    public BankAccount() {
        balance = 1000.00;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    // Withdraw method
    public void withdraw(double amount) throws NotSufficientFundException {
        if (amount > balance) {
            throw new NotSufficientFundException("Not Sufficient Fund");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Current Balance: " + balance);
        }
    }
}

// Main Class
public class BankingApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Deposit 1000.00
        account.deposit(1000.00);

        try {
            // Withdrawals
            account.withdraw(400.00);
            account.withdraw(300.00);
            account.withdraw(500.00); // This will throw exception
        } catch (NotSufficientFundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}