/*import java.util.HashMap;
import java.util.Map;

public class Ejemplo {
    // Interfaz del objeto real
    public interface Bank {
        public void withdraw(String account, double amount);

        public void deposit(String account, double amount);

        public double getBalance(String account);
    }

    // Implementación del objeto real
    public class RealBank implements Bank {
        private Map<String, Double> accounts;

        public RealBank() {
            accounts = new HashMap<>();
            accounts.put("12345", 1000.0);
            accounts.put("23456", 2000.0);
            accounts.put("34567", 3000.0);
        }

        @Override
        public void withdraw(String account, double amount) {
            if (accounts.containsKey(account)) {
                double balance = accounts.get(account);
                if (balance >= amount) {
                    accounts.put(account, balance - amount);
                    System.out.println("Retirada realizada con éxito");
                } else {
                    System.out.println("Saldo insuficiente");
                }
            } else {
                System.out.println("Cuenta inexistente");
            }
        }

        @Override
        public void deposit(String account, double amount) {
            if (accounts.containsKey(account)) {
                double balance = accounts.get(account);
                accounts.put(account, balance + amount);
                System.out.println("Depósito realizado con éxito");
            } else {
                System.out.println("Cuenta inexistente");
            }
        }

        @Override
        public double getBalance(String account) {
            if (accounts.containsKey(account)) {
                return accounts.get(account);
            } else {
                return 0.0;
            }
        }
    }

    // Clase proxy para el objeto real
    public class BankProxy implements Bank {
        private RealBank realBank;
        private Map<String, Double> cache;

        public BankProxy() {
            cache = new HashMap<>();
        }

        @Override
        public void withdraw(String account, double amount) {
            if (realBank == null) {
                realBank = new RealBank();
            }
            realBank.withdraw(account, amount);
        }

        @Override
        public void deposit(String account, double amount) {
            if (realBank == null) {
                realBank = new RealBank();
            }
            realBank.deposit(account, amount);
        }

        @Override
        public double getBalance(String account) {
            if (cache.containsKey(account)) {
                return cache.get(account);
            } else {
                if (realBank == null) {
                    realBank = new RealBank();
                }
                double balance = realBank.getBalance(account);
                cache.put(account, balance);
                return balance;
            }
        }
    }

    // Clase cliente
    public class Client {
        public static void main(String[] args) {
            Bank bank = new BankProxy();

            // Consulta el saldo de la cuenta "12345"
            double balance = bank.getBalance("12345");
            System.out.println("Saldo de la cuenta 12345: " + balance);

            // Realiza un depósito de 500 en la cuenta "12345"
            bank.deposit("12345", 500);
            balance = bank.getBalance("12345");
            System.out.println("Saldo de la cuenta 12345: " + balance);

            // Realiza una retirada de 1000 de la cuenta "12345"
            bank.withdraw("12345", 1000);
            balance = bank.getBalance("12345");
            System.out.println("Saldo de la cuenta 12345: " + balance);

            // Consulta el saldo de la cuenta "23456"
            balance = bank.getBalance("23456");
            System.out.println("Saldo de la cuenta 23456: " + balance);
        }
    }
}

/*
En este ejemplo, la clase RealBank es el objeto real que representa un banco, mientras que la clase BankProxy es el
proxy que proporciona acceso a los servicios del banco.

La clase Client es el cliente que utiliza el proxy para acceder a los servicios del banco.

Cuando se llama al método getBalance() de la clase BankProxy, el proxy verifica si ya ha consultado el saldo de la
cuenta en cuestión y lo tiene en caché. Si es así, devuelve el saldo almacenado en caché. Si no es así, llama al método
getBalance() del objeto real y almacena el resultado en caché para futuras consultas.

De esta manera, se reduce el tiempo de acceso a los servicios del banco y se mejora el rendimiento.
* */