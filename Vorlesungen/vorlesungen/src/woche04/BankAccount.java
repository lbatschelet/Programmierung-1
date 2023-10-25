package woche04;

public class BankAccount {
    
    private String owner;
    private int acctNumber;
    private double balance;

    private final double INTEREST_RATE = 0.015;
    private final double FEE = 2.50;

    public BankAccount(String owner, int acctNumber, double balance) {
        this.owner = owner;
        this.acctNumber = acctNumber;
        this.balance = balance;
    }

    public BankAccount(String owner, int acctNumber) {
        this.owner = owner;
        this.acctNumber = acctNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance - (amount + this.FEE) < 0) {
                System.out.println("Insufficient funds");
                return;
            } else {
                this.balance -= amount + FEE;
            }
        } else {
            System.out.println("Invalid amount");
            return;
        }
    }

    public void computeInterest() {
        double interest = this.balance * this.INTEREST_RATE;
        this.balance += interest;
    }

    public String toString() {
        return this.owner + " " + this.acctNumber + " " + this.balance;
    }
}
