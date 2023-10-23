package org.example;

public class CuentaBancaria {
    private double balance;

    public CuentaBancaria(){
        balance=0;
    }
    public synchronized void depositar(double cantidad){
        System.out.println("Depositado: "+cantidad);
        double nuevoBalance= balance +cantidad;
        System.out.println(", nuevo balance es "+ nuevoBalance);
        balance=nuevoBalance;
    }
    public double getBalance(){
        return balance;
    }
}
