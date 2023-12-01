package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Cliente {
    private static final String HOST="localhost";
    private static final int PUERTO=1500;
    public static void main(String[] args) {
       try {
           Socket socket= new Socket(HOST,PUERTO);
           System.out.println("Cliente conectado a servidor en "+socket.getPort());
           Scanner sc= new Scanner(System.in);
           PrintWriter haciaServidor= new PrintWriter(socket.getOutputStream(),true);
           BufferedReader desdeServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           System.out.println("Introduce el nombre del fichero a leer:");
           String fichero= sc.nextLine();
           haciaServidor.println(fichero);
           String linea;
           while ((linea=desdeServidor.readLine()).equals("fichero finalizado, deteniendo lectura")){
               System.out.println(linea);
           }
       } catch (UnknownHostException e) {
           System.err.println(e.fillInStackTrace());
       } catch (IOException e) {
           System.err.println(e.getMessage());
       }
    }
}