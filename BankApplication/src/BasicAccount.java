public class BasicAccount implements IAccount {
    private int accountNumber;
    private double withdrawalLimit;
    private double balance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = Math.max(0, withdrawalLimit);
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        double maxWithdrawal = Math.min(withdrawalLimit, balance);
        double withdrawn = Math.min(amount, maxWithdrawal);
        balance -= withdrawn;
        return withdrawn;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}

