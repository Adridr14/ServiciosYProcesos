package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       // Thread hiloAsc=new ContadorAscendente(10);
        //hiloAsc.start();
        ContadorAscendente hiloAsc=new ContadorAscendente(10);
        Thread hiloDesc=new Thread(new ContadorDescendente(10));
        //Thread hiloDesc= new ContadorDescendente(10);
        hiloDesc.start();
    }
}