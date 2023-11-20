import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCalculadora
{
    private final int PUERTO_SERVIDOR = 6000;
    private static String HOST = "localhost";
    private Teclado teclado;



    /**
     * conecta con el servidor y obtiene los flujos
     * llama a iniciar()
     */
    public ClienteCalculadora()
    {
        teclado = new Teclado();
        try {
            Socket cliente=new Socket(HOST,PUERTO_SERVIDOR);
            iniciar(cliente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * incliuye toda la lógica de proceso del cliente
     * lee una operación hasta 'q', leer los dos números
     * formar el mensaje para servidor, obtener resultado del servidor y mostrarlo
     *
     */
    public void iniciar(Socket cliente)
    {


        try {
            PrintWriter alServidor= new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())),true);
            Scanner delServidor= new Scanner(cliente.getInputStream());


        char oper = teclado.leerOperacion();
        while (Character.toUpperCase(oper) != 'Q') // mientras el cliente no
        // termine de enviar datos
        {

           int numero1= teclado.leerNumero();
           int numero2= teclado.leerNumero();

           alServidor.println(oper);
           alServidor.println(numero1);
           alServidor.println(numero2);
            oper= teclado.leerOperacion();

        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        new ClienteCalculadora();

    }
}
