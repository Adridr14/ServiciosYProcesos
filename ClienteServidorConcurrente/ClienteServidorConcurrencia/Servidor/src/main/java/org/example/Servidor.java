package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Servidor {
    public static void main(String[] args) {
       final int PUERTO=5000;
        int numCliente=0;
        ServerSocket servidor=null;
       try{
           servidor= new ServerSocket(PUERTO);
           System.out.println("Servidor concurrente conectado y eschuchando en el puerto: "+servidor.getLocalPort());
        //Servidor ejecutandose de forma indefinida
           while (true){
            numCliente++;
            Socket socket=servidor.accept();
            //Creamos el manejador para cada una de las peticiones de los clientes
            new ManejadorCliente(numCliente,socket);
        }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }finally {
           try {
               servidor.close();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
    }
}