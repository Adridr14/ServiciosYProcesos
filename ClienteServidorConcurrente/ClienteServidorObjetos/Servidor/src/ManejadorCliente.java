import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ManejadorCliente implements Runnable{
    private  int numCliente;
    private Socket socket;

    public ManejadorCliente(int numCliente,Socket socket) {
        this.socket=socket;
        this.numCliente=numCliente;
        Thread hilo= new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {

        System.out.println("Aceptada conexión del cliente "+this.numCliente);
        System.out.println("Cliente en IP "+socket.getInetAddress().toString());

        //Crear flujos de E/S
        try{
            ObjectOutputStream salida= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada= new ObjectInputStream(socket.getInputStream());
            //Mensaje al cliente
            salida.writeUTF("Numero de coches que desea entre 1 y 4");
            salida.flush();

            //Recibde del cliente y envia coches correspondientes
            int numCoches= entrada.readInt();
            enviarCoches(numCoches,salida);
            System.out.println("Enviados "+numCoches);

            //Cerrar recursos
            entrada.close();
            salida.close();
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void enviarCoches(int numCoches, ObjectOutputStream salida) {
        for (int i=0;i<=numCoches;i++){
            int n=(int)(Math.random()*Repositorio.getCoches().size());
            Coche coche= Repositorio.getCoches().get(n);
            try {
                salida.writeObject(coche);
                salida.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }


    }
}
