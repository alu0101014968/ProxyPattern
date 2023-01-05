package Object;

public class Account {
    private int idAccount;
    private String user;
    private double balance;

    public Account(int idAccount, String user, double balance) {
        this.idAccount = idAccount;
        this.user = user;
        this.balance = balance;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
