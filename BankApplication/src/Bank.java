import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        IAccount account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);

        if (account == null) {
            return;
        }

        if (account.getCurrentBalance() < 0) {
            System.out.println("Cannot close account due to debt.");
        } else {
            accounts.remove(account);
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balance) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > balance) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}
