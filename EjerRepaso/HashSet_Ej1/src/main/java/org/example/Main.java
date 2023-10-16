package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //ConjuntoEnteros gestor =new ConjuntoEnteros(10);
        ConjuntoEnterosOrdenados gestor =new ConjuntoEnterosOrdenados(10);
        System.out.println(gestor.getPares());
        gestor.borrarPares();
        gestor.printConjunto();
        gestor.addNumero(3);
        gestor.addNumero(44);
        gestor.addNumero(45);
        gestor.printConjunto();
        gestor.borrarPares();
    }
}