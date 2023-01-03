package Proxy;

import Interfaces.IAccount;
import Object.Account;

import java.util.logging.Logger;

public class ProxyAccount implements IAccount {
    private IAccount concreteAccount;
    private final static Logger LOGGER = Logger.getLogger(ProxyAccount.class.getName());

    public ProxyAccount(IAccount account) {
        this.concreteAccount = account;
    }

    public void setConcreteAccount(IAccount concreteAccount) {
        this.concreteAccount = concreteAccount;
    }

    @Override
    public void getMoney(double cantidad) {
        LOGGER.info("----Proxy Account - Get Money----");
        /*if (concreteAccount == null) {
            concreteAccount = new CuentaBancoAImpl();
            return cuentaReal.retirarDinero(cuenta, monto);
        } else {
            return cuentaReal.retirarDinero(cuenta, monto);
        }*/
        concreteAccount.getMoney(cantidad);
        concreteAccount.showBalance();
    }

    @Override
    public void depositMoney(double cantidad) {
        LOGGER.info("----Proxy Account - Deposit Money----");
        concreteAccount.depositMoney(cantidad);
        concreteAccount.showBalance();
    }

    @Override
    public void showBalance() {
        LOGGER.info("----Proxy Account - Show Balance----");
        concreteAccount.showBalance();
    }
}
