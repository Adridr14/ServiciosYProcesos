import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SumadorNumeros {
    private static DataOutput alCliente;

    public SumadorNumeros(){

    }

    public static void main(String[] args) {

        try {
            //Creacion del servidor
            ServerSocket servidor = new ServerSocket(5000);

            System.out.println("Esperando una conexión...");

            //Acepta la conexion del cliente
            Socket socket= servidor.accept();
            System.out.println("Un cliente se ha conectado desde la IP "+socket.getInetAddress().getHostName());

            //Obtener los flujos de entrada y salida de información
            DataOutputStream alCliente= new DataOutputStream(socket.getOutputStream());
            DataInputStream delCliente= new DataInputStream(socket.getInputStream());
            //Recibe el texto del cliente y lo devuelve conevertido a Mayusculas
            int numero=delCliente.readInt();
            int total=0;
            int cont=0;
            int max=0;
            while (numero!=0){
                total+=numero;
                System.out.println("Recibiendo del Cliente: "+numero);
                if (max<numero){max=numero;}

                cont++;
                numero=delCliente.readInt();
            }
            System.out.println("Enviando suma, max y media...");
            alCliente.writeInt(total);
            alCliente.flush();
            alCliente.writeInt(max);
            alCliente.flush();
            double media= (double) total /cont;
            alCliente.writeDouble(media);
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