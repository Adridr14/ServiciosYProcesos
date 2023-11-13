 
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
 

public class ServidorFecha
{
	private final int PUERTO = 5000;
	// completa los atributos 
	
	
	
	public ServidorFecha()
	{
		 iniciarServidor();
	}
	
	/**
	 * Incluye todo el código de inicio del servidor, aceptar conexión,
	 *  obtención de flujos, lectura y envío de datos al cliente, cerrar
	 *  flujos y socket
	 *  Captura las excepciones adecuadamente
	 * 
	 */
	private void iniciarServidor()
	{
		final int PUERTO = 5000;
		try {
			//Creacion del servidor
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor conectado en puerto local "+servidor.getLocalPort());
			System.out.println("Esperando una conexión de cliente");

			//Acepta la conexion del cliente
			Socket socket= servidor.accept();
			System.out.println("Conexión aceptada desde la IP "+socket.getInetAddress().getHostName());

			//Obtener los flujos de entrada y salida de información
			PrintWriter alCliente= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			BufferedReader delCliente= new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//Recibe el texto del cliente y lo devuelve conevertido a Mayusculas
			String linea= delCliente.readLine();
			alCliente.println("Hola "+linea+" "+obtenerFechaActual());
			alCliente.flush();

			//Cierra los streams y el socket
			alCliente.close();
			delCliente.close();
			socket.close();
			servidor.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	/**
	 * Devuelve la fecha actual en formato STring como  "dia / nombremes / año"
	 * Completa el método consultando la API (o Internet)
	 * 
	 */
	private String obtenerFechaActual()
	{
		Calendar fec = new GregorianCalendar();
		int dia = fec.get(Calendar.DAY_OF_MONTH);
		int month=fec.get(Calendar.MONTH);
		String mesString;
		switch(month){
			case 0:
			{
				mesString="Enero";
				break;
			}
			case 1:
			{
				mesString="Febrero";
				break;
			}
			case 2:
			{
				mesString="Marzo";
				break;
			}
			case 3:
			{
				mesString="Abril";
				break;
			}
			case 4:
			{
				mesString="Mayo";
				break;
			}
			case 5:
			{
				mesString="Junio";
				break;
			}
			case 6:
			{
				mesString="Julio";
				break;
			}
			case 7:
			{
				mesString="Agosto";
				break;
			}
			case 8:
			{
				mesString="Septiembre";
				break;
			}
			case 9:
			{
				mesString="Octubre";
				break;
			}
			case 10:
			{
				mesString="Noviembre";
				break;
			}
			case 11:
			{
				mesString="Diciembre";
				break;
			}
			default:
			{
				mesString="Error";
				break;
			}
		}
		int anio= fec.get(Calendar.YEAR);

		
		return "hoy es "+dia+"-"+mesString+"-"+anio;
	}
	
	
	/*
	 * 
	 * Inicio de la aplicación
	 */
	public static void main(String[] args)
	{
		new ServidorFecha();
	}
}
