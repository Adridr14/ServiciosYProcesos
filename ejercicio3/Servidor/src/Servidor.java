import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    /**
     * @param args
     */
    private static int nCliente=0;
    private static int PUERTO=5000;
    public static void main(String[] args) throws IOException {

        try {


            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en puerto: " + serverSocket.getLocalPort());
            while (true) {
                Socket socket = serverSocket.accept();
                nCliente++;
                HiloCliente hiloCliente = new HiloCliente(nCliente, socket);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
