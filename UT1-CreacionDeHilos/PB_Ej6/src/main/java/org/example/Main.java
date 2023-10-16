package org.example;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        for (int i=0; i<args.length;i++) {
            ContadorPalabras contadorPalabras = new ContadorPalabras(new File("PB_Ej6/"+args[i]));
        }
    }
}
