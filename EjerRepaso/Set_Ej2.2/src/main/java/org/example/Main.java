package org.example;

import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LibreriaOrdenada libreria=new LibreriaOrdenada("Librería Municipal");
        libreria.addLibro(new Libro("Don Quijote","Miguel",400));
        libreria.addLibro(new Libro("Rinconete y Cortadillo", "Miguel",200));
        libreria.addLibro(new Libro("Harry Potter y la piedra filosofal","JK Rowling",350));
        libreria.addLibro(new Libro("Harry Potter y la cámara secreta","JK Rowling",350));
        libreria.addLibro(new Libro("Harry Potter y el prisioner de Azkaban","JK Rowling",350));
        System.out.println(libreria.contarLibros());
        libreria.hayLibrosDe("Miguel de Cervantes");
        System.out.println( libreria.buscarLibro("Don Quijote"));
        libreria.prestarLibro("Rinconete y Cortadillo");
        System.out.println(libreria.listarLibros());
        libreria.prestarLibro("Harry Potter y la cámara secreta");
        libreria.borrarLibroAutor("Miguel");
        Set<Libro> libPres=libreria.relacionLibrosPrestaods();
        for (Libro l:libPres) {
            System.out.println(l.toString());
        }
        System.out.println(libreria.contarLibros());
        System.out.println(libreria.listarLibros());

    }
}