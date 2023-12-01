package org.example;

import java.io.*;
import java.net.Socket;

public class HiloCliente implements Runnable{
    private int cliente;
    private Socket socket;
    public HiloCliente(Socket socket, int numCliente) {
        this.cliente=numCliente;
        this.socket=socket;
        Thread th=new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        try{
            BufferedReader desdeCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter haciaCliente= new PrintWriter(socket.getOutputStream(),true);
           String nombreFichero= desdeCliente.readLine();
            BufferedReader leerFichero=new BufferedReader(new FileReader(nombreFichero));
            String linea;
            while ((linea=leerFichero.readLine())!=null){
                haciaCliente.println(linea);
            }
                haciaCliente.println("fichero finalizado, deteniendo lectura");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
