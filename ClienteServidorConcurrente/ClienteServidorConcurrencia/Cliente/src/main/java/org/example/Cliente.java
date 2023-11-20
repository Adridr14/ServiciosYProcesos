package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Cliente {
    public static void main(String[] args) {
        final int PUERTO = 5000;
        final String HOST = "localhost";
        Scanner sc= new Scanner(System.in);
        try {
            Socket cliente = new Socket(HOST, PUERTO);

            PrintWriter alServidor= new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())));
            //BufferedReader delServidor= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            Scanner delServidor= new Scanner(cliente.getInputStream());

            System.out.println("Dame un texto:");
            String texto= sc.nextLine();

            //Envia al servidor
            alServidor.println(texto);
            alServidor.flush();

            //Recibe del servidor
            String textoMayusculas= delServidor.nextLine();
            System.out.println("Recibido del Servidor: "+textoMayusculas);

            //Cierra los streams y los sockets
            alServidor.close();
            delServidor.close();
            cliente.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}