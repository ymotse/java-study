package abstrato.heranca;

public class SavingsAccount extends Account {

    public SavingsAccount(long accountNumber, double amount) {
        super(accountNumber, amount);
        System.out.println(String.format("Created Savings Account no. %d with initial amount: %.2f", accountNumber, amount));
    }

    @Override
    public void profitability() {
        double profitability = this.amount * 0.05;
        this.amount += profitability;
        System.out.println(String.format("[Savings Account] Profitability: %.2f", profitability));
    }

}
