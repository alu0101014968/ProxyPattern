package Banks;

import Interfaces.IAccount;
import Object.Account;

public class BankAccountA implements IAccount {
    private Account account;

    public BankAccountA(Account account) {
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void getMoney(double cantidad) {
        double saldoActual = account.getSaldoInicial() - cantidad;
        account.setSaldoInicial(saldoActual);
        showBalance();
    }

    @Override
    public void depositMoney(double cantidad) {
        double saldoActual = account.getSaldoInicial() + cantidad;
        account.setSaldoInicial(saldoActual);
        showBalance();
    }

    @Override
    public void showBalance() {
        System.out.println("Current Balance: " + account.getSaldoInicial());
    }
}
