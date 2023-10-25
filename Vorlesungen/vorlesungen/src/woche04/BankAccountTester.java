package woche04;

public class BankAccountTester {
    
    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("John Doe", 123456, 50.0);
        BankAccount acct2 = new BankAccount("Jane Doe", 654321);
        BankAccount acct3 = new BankAccount("John", 234567, 100000.0);
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);

        acct1.withdraw(20.0);
        System.out.println(acct1);

        acct2.deposit(100.0);
        System.out.println(acct2);

        acct3.computeInterest();
        System.out.println(acct3);
    }
}
