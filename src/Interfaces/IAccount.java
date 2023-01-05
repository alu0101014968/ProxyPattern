package Interfaces;
import Object.Account;

public interface IAccount {
    Account getMoney(Account account, double amount);
    Account depositMoney(Account account, double amount);
    void showBalance(Account account);
}
