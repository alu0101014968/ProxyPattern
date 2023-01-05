package Service;

import Interfaces.IAccount;
import Object.Account;

public class BankAccountA implements IAccount {
    public BankAccountA() {

    }

    @Override
    public Account getMoney(Account account, double amount) {
        double currentBalance = account.getBalance() - amount;
        account.setBalance(currentBalance);
        //System.out.println("Current Balance: " + account.getBalance());
        showBalance(account);
        return account;
    }

    @Override
    public Account depositMoney(Account account, double amount) {
        double currentBalance = account.getBalance() + amount;
        account.setBalance(currentBalance);
        showBalance(account);
        return account;
    }

    @Override
    public void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }
}
