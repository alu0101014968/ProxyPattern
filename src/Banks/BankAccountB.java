package Banks;

import Interfaces.IAccount;
import Object.Account;

public class BankAccountB implements IAccount {
    private Account account;
    final double INTEREST = 0.20;

    public BankAccountB(Account account) {
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void getMoney(double cantidad) {
        double saldoActual = account.getSaldoInicial() - cantidad;
        account.setSaldoInicial(saldoActual);
    }

    @Override
    public void depositMoney(double cantidad) {
        double saldoActual = account.getSaldoInicial() + cantidad + INTEREST;
        account.setSaldoInicial(saldoActual);
    }

    @Override
    public void showBalance() {
        System.out.println("Current Balance: " + account.getSaldoInicial());
    }
}
