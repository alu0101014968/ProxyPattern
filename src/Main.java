import Banks.BankAccountA;
import Banks.BankAccountB;
import Proxy.ProxyAccount;
import Object.Account;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1, "User", 1000);
        ProxyAccount proxy = new ProxyAccount(new BankAccountB(account));
        proxy.showBalance();
        proxy.depositMoney(50);
        proxy.getMoney(20);
        proxy.showBalance();
    }
}
