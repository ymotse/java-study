package abstrato.heranca;

public class AccountTest {

    public static void main(String[] args) {
        
        CheckingAccount currentAccount = new CheckingAccount(12345, 1000);
        currentAccount.profitability();
        System.out.println(String.format("[Checking Account] Amount: %.2f", currentAccount.amount));
        
        System.out.println("\n--------------\n");
        
        SavingsAccount savingsAccount = new SavingsAccount(98765, 1000);
        savingsAccount.profitability();
        System.out.println(String.format("[Savings Account] Amount: %.2f", savingsAccount.amount));
    }

}
