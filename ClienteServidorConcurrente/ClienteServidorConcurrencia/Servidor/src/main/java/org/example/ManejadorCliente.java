package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ManejadorCliente implements Runnable{

    private int numCliente;
    private Socket socket;
    public ManejadorCliente(int numCliente, Socket socket){
        this.numCliente=numCliente;
        this.socket=socket;
        Thread hilo=new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        System.out.println("Aceptada conexión del cliente "+this.numCliente);
        System.out.println("Cliente en IP: "+socket.getInetAddress().toString());
        try {
            PrintWriter alCliente = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            //BufferedReader delServidor= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            Scanner delCliente = new Scanner(socket.getInputStream());

            //Leemos texto del cliente y se lo devolvemos convertida a Mayusculas
            String texto= delCliente.nextLine();
            alCliente.println("Recibido del servidor: "+texto.toUpperCase());
            //Cerramos los recursos
            alCliente.close();
            delCliente.close();
            socket.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}
