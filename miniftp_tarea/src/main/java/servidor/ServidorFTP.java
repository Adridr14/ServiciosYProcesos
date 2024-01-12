package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorFTP {

    public final static int PUERTO = 41;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PUERTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                new ManejadorCliente(clientSocket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
