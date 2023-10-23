package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Secuencia secuencia = new Secuencia();
       Thread hilo1= new SecuenciaThread(secuencia);
        Thread hilo2= new SecuenciaThread(secuencia);
      hilo1.start();
      hilo2.start();
    }
}