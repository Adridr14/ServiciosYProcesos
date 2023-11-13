import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSaludoFecha
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Uso: java <ip servidor> <puerto servidor>");
			return;
		}

		Scanner sc= new Scanner(System.in);
		try {
			Socket cliente = new Socket(args[0], Integer.parseInt(args[1]));
			System.out.println("Cliente conectado a servidor de IP "+cliente.getPort());

			PrintWriter alServidor= new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())));
			//BufferedReader delServidor= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			Scanner delServidor= new Scanner(cliente.getInputStream());

			System.out.println("Dime tu nombre:");
			String texto= sc.nextLine();

			//Envia al servidor
			alServidor.println(texto);
			alServidor.flush();

			//Recibe del servidor
			String saludo= delServidor.nextLine();
			System.out.println("Recibido del Servidor: "+saludo);

			//Cierra los streams y los sockets
			alServidor.close();
			delServidor.close();
			cliente.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
		
		
		
		
		
		

	}

}
