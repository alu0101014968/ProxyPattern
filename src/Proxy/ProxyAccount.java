package Proxy;

import Service.BankAccountA;
import Interfaces.IAccount;
import Object.Account;

import java.util.Date;

public class ProxyAccount implements IAccount {
    private IAccount realBankAccount;
    //private final static Logger LOGGER = Logger.getLogger(ProxyAccount.class.getName());
    private final static String COLOR = "\u001B[31m";

    public ProxyAccount(IAccount account) {
        this.realBankAccount = account;
    }

    public ProxyAccount() {

    }

    public void setConcreteAccount(IAccount concreteAccount) {
        this.realBankAccount = concreteAccount;
    }

    @Override
    public Account getMoney(Account account, double amount) {
        //LOGGER.info("----Proxy Account - Get Money----");
        getDate();
        System.out.println("   INFO:  ----Proxy Account - Get Money----  Getting " + amount + "\u001B[0m");
        System.out.println("Previous Balance: " + account.getBalance());
        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance (" + (amount - account.getBalance()) + " left)");
            amount = account.getBalance();
        }
        if (checkAccount()) {
            realBankAccount = new BankAccountA();
            return realBankAccount.getMoney(account, amount);
        } else {
            return realBankAccount.getMoney(account, amount);
        }
    }

    @Override
    public Account depositMoney(Account account, double amount) {
        getDate();
        System.out.println("   INFO:  ----Proxy Account - Deposit Money----  Depositing " + amount + "\u001B[0m");
        System.out.println("Previous Balance: " + account.getBalance());
        //LOGGER.info("----Proxy Account - Deposit Money----");
        if (checkAccount()) {
            realBankAccount = new BankAccountA();
            return realBankAccount.depositMoney(account, amount);
        } else {
            return realBankAccount.depositMoney(account, amount);
        }
    }

    @Override
    public void showBalance(Account account) {
        //LOGGER.info("----Proxy Account - Show Balance----");
        getDate();
        System.out.println("   INFO:  ----Proxy Account - Show Balance----\u001B[0m");
        if (checkAccount()) {
            realBankAccount = new BankAccountA();
            realBankAccount.showBalance(account);
        } else {
            realBankAccount.showBalance(account);
        }
    }

    private boolean checkAccount() {
        return (realBankAccount == null);
    }

    private void getDate() {
        Date date = new Date();
        System.out.print(COLOR + date);
    }
}
