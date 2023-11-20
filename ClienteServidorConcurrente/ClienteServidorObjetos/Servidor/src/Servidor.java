import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Servidor {
    private static  final int PUERTO=9876;
    public static void main(String[] args) {
      new Servidor().iniciar();
    }

    private void iniciar() {
        int numCliente=0;
        ServerSocket servidor=null;
        try {
            servidor= new ServerSocket(PUERTO);
            System.out.println("Servidor funcionando...");
            while (true){
                new Repositorio();
                numCliente++;
                Socket socket= servidor.accept();
                new ManejadorCliente(numCliente,socket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}