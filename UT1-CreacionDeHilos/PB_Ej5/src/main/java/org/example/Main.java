package org.example;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File f = new File("aleatorios.txt");
        EscritorNumeros hiloEsc= new EscritorNumeros();
        LectorNumeros hiloLec= new LectorNumeros(f);
    }
}