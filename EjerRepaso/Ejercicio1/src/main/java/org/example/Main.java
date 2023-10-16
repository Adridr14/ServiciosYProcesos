package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CuentaAhorro cuenta1=new CuentaAhorro("Adri",1500,2);
        CuentaCorriente cuenta2=new CuentaCorriente("Guille",1000,600);
        System.out.println("Situacion inicial cuenta: "+cuenta1.toString());
        cuenta1.ingresar(2000);
        cuenta1.reintegrar(200);
        System.out.println(cuenta1.toString());
        System.out.println("Situacion inicial cuenta: "+cuenta2.toString());
        cuenta2.reintegrar(500);
        System.out.println("Recargo a aplicar: "+cuenta2.calcularRecargo());
        System.out.println(cuenta2.toString());
    }
}