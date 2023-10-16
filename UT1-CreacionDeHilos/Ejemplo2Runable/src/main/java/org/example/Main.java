package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Thread hiloSaludo= new Thread(new Saludo());

        hiloSaludo.start();
        Thread hiloDespedida= new Thread(new Despedida());
        hiloDespedida.start();

        System.out.println("Fin del hilo Main");
    }
}