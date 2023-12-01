package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Servidor {
    private static final int PUERTO = 1500;

    public static void main(String[] args) {
        int numCliente=0;
        ServerSocket servidor=null;
        try {
            servidor=new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto "+servidor.getLocalPort());
            while (true){
                numCliente++;
                Socket socket= servidor.accept();
                new HiloCliente(socket,numCliente);
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}