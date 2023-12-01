import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientePuntos
{
	private static final String HOST="localhost";
	private static final int PUERTO=5000;
	/**
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public  static void main(String[] args)  
	{
		try {
			Socket socket=new Socket(HOST,PUERTO);
			System.out.println("Cliente conectado a servidor en puerto "+socket.getPort());
			//Crear flujos de E/S el orden debe ser inverso al servidor
			Scanner sc= new Scanner(System.in);
			ObjectOutputStream salida= new ObjectOutputStream(socket.getOutputStream());
			int numP=sc.nextInt();

			salida.writeInt(numP);
			salida.flush();

			for (int i=0;i<numP;i++){
				int x=sc.nextInt();
				int y=sc.nextInt();
				Punto p=new Punto(x,y);
				System.out.println(p.toString());
				salida.writeObject(p);
				salida.flush();
			}

			sc.close();
			salida.close();
			socket.close();



		} catch (IOException e) {
			System.err.println(e.getMessage());
		}


	}
}
