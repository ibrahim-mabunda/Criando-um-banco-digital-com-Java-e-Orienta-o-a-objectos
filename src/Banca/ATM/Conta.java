package Banca.ATM;

public class Conta {
    private double balance;

    public Conta() {
        this.balance = 1000.0; // Saldo inicial
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void transfer(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
