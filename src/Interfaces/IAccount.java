package Interfaces;
import Object.Account;

public interface IAccount {
    void getMoney(double cantidad);
    void depositMoney(double cantidad);
    void showBalance(Account acc);
}
