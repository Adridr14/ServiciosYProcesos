package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria= new CuentaBancaria();
     Thread hilo1 = new TareaDeposito(cuentaBancaria);
        Thread hilo2 = new TareaDeposito(cuentaBancaria);
     hilo1.start();
     hilo2.start();
    }
}