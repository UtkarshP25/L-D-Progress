abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract method
    public abstract double calculateInterest();

    public void display() {
        System.out.println("Account: " + accountNumber + ", Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.01; // 1% interest
    }
}

public class LearnAbstraction {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("123", 10000);
        BankAccount current = new CurrentAccount("456", 10000);

        savings.display();
        System.out.println("Savings Interest: " + savings.calculateInterest());

        current.display();
        System.out.println("Current Interest: " + current.calculateInterest());
    }
}
