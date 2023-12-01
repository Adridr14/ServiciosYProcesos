import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Servidor que atiende a un único cliente
 * El cliente envía líneas de datos con formato oper:numero1:numero2
 * el servidor calculará el resultado dependiendo de la operaci�n y lo
 * envía al cliente
 * Cuando el cliente no quiere enviar más datos envía una línea con
 * formato oper donde oper vale QUIT
 */


public class ServidorCalculadora {
    private final int PUERTO = 6000;
    private Calculadora c;


    /**
     * Constructor - crea el socket de servidor y llama a inicar()
     * para aceptar la conexión del cliente y procesarla
     */
    public ServidorCalculadora() {
        c = new Calculadora();
        int numCliente=0;
        ServerSocket servidor=null;
        try {
            servidor=new ServerSocket(PUERTO);
            System.out.println("Servidor concurrente conectado y eschuchando en el puerto: "+servidor.getLocalPort());
            iniciar(servidor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * acepta y procesa los mensajes del cliente
     * el servidor iterará hasta que detecte que el cliente ya no le va
     * a enviar más datos
     */
    public void iniciar(ServerSocket servidor) {
        int numCliente=0;
        try {

            while (true){
                numCliente++;
                Socket socket= servidor.accept();
                System.out.println("En servidor conexión de cliente"+ numCliente+" aceptada desde IP:"+socket.getInetAddress());

                PrintWriter alServidor= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                Scanner delServidor= new Scanner(socket.getInputStream());
                new ManejadorCliente(numCliente,socket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                servidor.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /**
     * @param oper    la operación a realizar (suma, resta, producto, division)
     * @param numero1 el primer nº
     * @param numero2 el segundo nº
     * @return la cadena resultado, por ej,  "La suma de 2 y 5 es 7"
     */
    private String calcularResultado(String oper, int numero1, int numero2) {
        String resultado = null;
        switch (oper){
            case "+":  resultado="La suma es: "+c.sumar(numero1,numero2);
            break;
            case "-":resultado="La resta es: "+c.restar(numero1,numero2);
            break;
            case "*":resultado="La multiplicación es: "+c.multiplicar(numero1,numero2);
            break;
            case "/":resultado="La división es: "+c.dividir(numero1,numero2);
        }
        return resultado;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        new ServidorCalculadora();

    }
}
