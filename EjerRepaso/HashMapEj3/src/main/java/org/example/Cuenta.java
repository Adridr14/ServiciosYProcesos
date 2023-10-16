package org.example;

public class Cuenta {
    private int numCuenta;
    private int balance;

    public Cuenta(int numCuenta, int balance) {
        this.numCuenta = numCuenta;
        this.balance = balance;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cuenta{");
        sb.append("numCuenta=").append(numCuenta);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
