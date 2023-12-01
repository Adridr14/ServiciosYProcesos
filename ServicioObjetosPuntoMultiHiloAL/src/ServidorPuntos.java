import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPuntos
{
	private static final int PUERTO=5000;
	public  static void main(String[] args)  
	{
		 int numCliente=0;
		ServerSocket servidor=null;
		try{
			servidor=new ServerSocket(PUERTO);
			System.out.println("Servidor de puntos escuchando");
			while (true){
				numCliente++;
				Socket socket=servidor.accept();
				Thread thread=new HiloCliente(numCliente,socket);

			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
        }


    }
}
