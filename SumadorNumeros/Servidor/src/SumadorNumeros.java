import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SumadorNumeros {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Error, Sintaxis: java SumadorNumero <puerto>");
        }
        try {
            //Creacion del servidor
            ServerSocket servidor = new ServerSocket(Integer.parseInt(args[0]));

            System.out.println("Esperando una conexión...");

            //Acepta la conexion del cliente
            Socket socket= servidor.accept();
            System.out.println("Un cliente se ha conectado desde la IP "+socket.getInetAddress().getHostName());

            //Obtener los flujos de entrada y salida de información
            DataOutput alCliente= new DataOutputStream(socket.getOutputStream());
            DataInputStream delCliente= new DataInputStream(socket.getInputStream());
            //Recibe el texto del cliente y lo devuelve conevertido a Mayusculas
            int numero=delCliente.readInt();
            int total=0;
            int cont=0;
            int max=0;
            while (numero!=0){
                total
            }
            alCliente.println("Desde el Servidor: "+linea.toUpperCase());
            alCliente.flush();

            //Cierra los streams y el socket
            alCliente.close();
            delCliente.close();
            socket.close();
            servidor.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e){
            System.err.println("Error al convertir el puerto "+e.getMessage()+" for input string: "+"\""+args[0]+"\"");
        }
    }
}