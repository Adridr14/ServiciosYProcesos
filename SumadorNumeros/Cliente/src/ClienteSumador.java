import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ClienteSumador {
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Uso: java <ip servidor> <puerto servidor>");
            return;
        }

        Scanner sc= new Scanner(System.in);
        try {
            Socket cliente = new Socket(args[0], Integer.parseInt(args[1]));
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



            //Cierra los streams y los sockets
            alServidor.close();
            delServidor.close();
            cliente.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}