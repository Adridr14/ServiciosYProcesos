import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class HiloCliente extends Thread
{
	private int cliente;
	private Socket socket;
	private ObjectInputStream desdeCliente;
	private ObjectOutputStream haciaCliente;
	
	public HiloCliente(int cliente, Socket socket)
	{
		this.cliente = cliente;
		this.socket = socket;
		this.start();
	}
	
	public void run()
	{
		try
		{// completar
			System.out.println("Aceptada conexión cliente "+cliente);

			//Crear flujos de E/S el orden debe ser inverso al servidor
			ObjectInputStream entrada= new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream salida= new ObjectOutputStream(socket.getOutputStream());
			int numP=entrada.readInt();
			System.out.println("Recibiendo de cliente "+numP+" puntos");
			for (int i=0;i<numP;i++){
				Punto p= (Punto) entrada.readObject();
				System.out.println(p.toString());
			}

			entrada.close();
			salida.close();
			socket.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
