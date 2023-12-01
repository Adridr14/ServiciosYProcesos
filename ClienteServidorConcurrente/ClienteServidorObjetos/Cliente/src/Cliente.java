import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Cliente {
    private static final int PUERTO = 9876;
    private static final String HOST="localhost";
    private static final int NUM_COCHES=4;

    public static void main(String[] args) {
       new Cliente().iniciar();
    }

    private void iniciar() {
        try {
            Socket socket= new Socket(HOST,PUERTO);
            System.out.println("Conectado al servidor: "+socket.getInetAddress().toString());

            //Crear flujos de E/S el orden debe ser inverso al servidor
            ObjectInputStream entrada= new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream salida= new ObjectOutputStream(socket.getOutputStream());

            String inicio= entrada.readUTF();
            System.out.println(inicio);
            int numero=(int)(Math.random()*NUM_COCHES+1);
            salida.writeInt(numero);
            salida.flush();
            System.out.println(numero);


            //Recibe los coches
            recibirCoches(numero,entrada);

            //Cerramos recursos
            entrada.close();
            salida.close();
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void recibirCoches(int numero, ObjectInputStream entrada) {
        for (int i=1;i<=numero;i++){
            try {
                Coche coche= (Coche) entrada.readObject();
                System.out.println("Recibido\n"+coche.toString());
            } catch (IOException e) {
                System.err.println(e.getMessage());

            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }


    }
}