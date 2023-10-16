package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Banco b=new Banco();
        b.addCuenta("Cliente 1",1,1000);
        b.addCuenta("Cliente 2",2,10000);
        b.addCuenta("Cliente 3",3,500);

        System.out.println(b.getCuenta("Cliente 1"));
        System.out.println(b.getCuenta("Cliente 3"));

        b.listarClientes();
        b.imprimirConKeySet();
        b.imprimirConEntrySet();
    }
}