import java.io.IOException;
import java.net.Socket;

public class EscaneadorPuertosTcp
{
	private String host;
	private int desde; // puerto a partir del cual se realiza el escaneo
	private int hasta; // puerto hasta el que se realiza el escaneo

	public EscaneadorPuertosTcp(String host, int desde, int hasta)
	{
		this.host = host;
		this.desde = desde;
		this.hasta = hasta;
	}

	/**
	 * Para escanear este programa cliente intenta establecer conexión (creando un Socket) con cada
	 * uno de los puertos del host destino que hay en el rango. Si la conexión se establece 
	 * es que hay algún proceso servidor escuchando, en ese caso se 
	 * muestra el mensaje "Conexión establecida en puerto XXX - Puerto abierto"
	 * Si falla el intento de conexión se indica con el mensaje
	 * "Puerto no abierto, fallo en la conexión"
	 * 
	 * Se capturarán todas las posibles excepciones
	 */
	public void escanear() 
	{
		for (int i = desde;i<=hasta;i++){
		Socket socket=null;
		try {
			socket=new Socket("localhost",i);
			System.out.println("Conexión establecida en puerto "+i+" - Puerto abierto");
		} catch (IOException e) {
			System.out.println("Conexión no establecida en puerto "+i+" - Puerto cerrado");
		}finally {
			if (socket!=null){
				try{
					socket.close();
				} catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		}


		
		
	}

	/**
	 * 
	 */
	public static void main(String[] args)  
	{

		EscaneadorPuertosTcp escaneadorPuertosTcp=new EscaneadorPuertosTcp("localhost",1,5001);
		// aceptar los tres argumentos
		// crear un objeto EscaneadorPuertosTcp y llamar al método escanear()
		escaneadorPuertosTcp.escanear();

	}

}
