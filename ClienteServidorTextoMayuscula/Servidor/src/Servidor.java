import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 5000;
        try {
            //Creacion del servidor
            ServerSocket servidor = new ServerSocket(PUERTO);

            System.out.println("Esperando una conexión...");

            //Acepta la conexion del cliente
            Socket socket= servidor.accept();
            System.out.println("Un cliente se ha conectado desde la IP "+socket.getInetAddress().getHostName());

            //Obtener los flujos de entrada y salida de información
            PrintWriter alCliente= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            BufferedReader delCliente= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Recibe el texto del cliente y lo devuelve conevertido a Mayusculas
            String linea= delCliente.readLine();
            alCliente.println("Desde el Servidor: "+linea.toUpperCase());
            alCliente.flush();

            //Cierra los streams y el socket
            alCliente.close();
            delCliente.close();
            socket.close();
            servidor.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}