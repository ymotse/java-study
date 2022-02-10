package abstrato.heranca;

public abstract class Account {
    
    long accountNumber;
    double amount;
    
    public abstract void profitability();

    public Account(long accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}
