import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ClienteSumador {
    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);
        try {
            Socket cliente = new Socket("localhost", 5000);
            System.out.println("Cliente conectado a servidor de IP "+cliente.getPort());

            DataOutputStream alServidor= new DataOutputStream(cliente.getOutputStream());
            DataInputStream delServidor= new DataInputStream(cliente.getInputStream());

            int numero;
            do{
            System.out.println("Dame un número para enviar al servidor, 0 terminar");
             numero= sc.nextInt();

                alServidor.writeInt(numero);
                alServidor.flush();

            }while (numero!=0);

            //Recibe del servidor
            System.out.println("Desde Servidor la suma es: "+delServidor.readInt());
            System.out.println("Desde Servidor el máximo es: "+delServidor.readInt());
            System.out.println("Desde Servidor la media es: "+delServidor.readDouble());


            //Cierra los streams y los sockets
            alServidor.close();
            delServidor.close();
            cliente.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}