package Service;

import Interfaces.IAccount;
import Object.Account;

public class BankAccountB implements IAccount {
    final double INTEREST = 0.20;

   public BankAccountB() {

   }

    @Override
    public Account getMoney(Account account, double amount) {
        double currentBalance = account.getBalance() - amount;
        account.setBalance(currentBalance);
        showBalance(account);
        return account;
    }

    @Override
    public Account depositMoney(Account account, double amount) {
        double currentBalance = account.getBalance() + amount + INTEREST;
        account.setBalance(currentBalance);
        showBalance(account);
        return account;
   }

    @Override
    public void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }
}
