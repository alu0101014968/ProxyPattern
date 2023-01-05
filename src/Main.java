import Service.BankAccountB;
import Interfaces.IAccount;
import Proxy.ProxyAccount;
import Object.Account;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1, "User", 1000);
        Account account1 = new Account(2, "User2", 10000);

        IAccount proxy = new ProxyAccount(new BankAccountB());
        proxy.showBalance(account);
        account = proxy.depositMoney(account,50);
        account = proxy.getMoney(account, 20);
        proxy.showBalance(account);
        proxy.showBalance(account1);

        IAccount proxy2 = new ProxyAccount();
        proxy2.showBalance(account1);
        proxy2.depositMoney(account1, 1000);
        proxy2.showBalance(account1);
        proxy2.getMoney(account1, 30000);
    }
}
