public class Main {
    public static void main(String[] args) {
        // Create the bank instance
        Bank bank = new Bank();

        // Create different accounts
        StandardAccount standard = new StandardAccount(1, -100); // Account number 1, credit limit -100
        BasicAccount basic = new BasicAccount(2, 100); // Account number 2, withdrawal limit 100
        PremiumAccount premium = new PremiumAccount(3); // Account number 3, no credit limit

        // Add accounts to the bank
        bank.openAccount(standard);
        bank.openAccount(basic);
        bank.openAccount(premium);

        // Deposit money into the accounts
        standard.deposit(500);
        basic.deposit(200);
        premium.deposit(1000);

        // Perform withdrawals
        System.out.println("Standard Account balance after withdrawing 600: " + standard.withdraw(600)); // Withdraw up to the credit limit
        System.out.println("Basic Account balance after withdrawing 150: " + basic.withdraw(150));     // Withdraw up to the withdrawal limit
        System.out.println("Premium Account balance after withdrawing 500: " + premium.withdraw(500)); // Unlimited withdrawal for premium

        // Display all accounts
        System.out.println("All Accounts:");
        for (IAccount account : bank.getAllAccounts()) {
            System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getCurrentBalance());
        }

        // Display accounts in debt
        System.out.println("Accounts in Debt:");
        for (IAccount account : bank.getAllAccountsInDebt()) {
            System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getCurrentBalance());
        }

        // Display accounts with balance > 300
        System.out.println("Accounts with Balance > 300:");
        for (IAccount account : bank.getAllAccountsWithBalance(300)) {
            System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getCurrentBalance());
        }

        // Attempt to close an account
        System.out.println("Closing accounts:");
        bank.closeAccount(1); // Should fail if the balance is negative
        bank.closeAccount(3); // Should succeed if the balance is positive
    }
}
