package abstrato.heranca;

public class CheckingAccount extends Account {

    public CheckingAccount(long accountNumber, double amount) {
        super(accountNumber, amount);
        System.out.println(String.format("Created Checking Account no. %d with initial amount: %.2f", accountNumber, amount));
    }

    @Override
    public void profitability() {
        double profitability = this.amount * 0.03;
        this.amount += profitability;
        System.out.println(String.format("[Checking Account] Profitability: %.2f", profitability));
    }
    
    
}
