import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    /**
     * @param args
     */
    private final static String HOST = "localhost";
    private final static int PORT = 5000;

    public static void main(String[] args) throws IOException {
        Scanner tec= new Scanner(System.in);
        try {

            Socket socket = new Socket(HOST, PORT);
            ObjectOutputStream alServidor=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream delServidor=new ObjectInputStream(socket.getInputStream());
            int n;
            do {
                 n = leerOpcion();
                 alServidor.writeInt(n);
                 alServidor.flush();
                switch (n) {
                    case 1 -> {
                        System.out.println("Introducir el nombre");
                        String nombre=tec.nextLine();
                        alServidor.writeUTF(nombre);
                        alServidor.flush();
                        System.out.println("Introducir DNI");
                        String dni= tec.nextLine();
                        alServidor.writeUTF(dni);
                        alServidor.flush();
                        int edad= (int) (Math.random()*30+1);
                        alServidor.writeInt(edad);
                        alServidor.flush();
                        String respuesta=delServidor.readUTF();
                        System.out.println(respuesta);

                    }
                    case 2 ->{
                        List<Persona> listaOrdenada= (List<Persona>) delServidor.readUnshared();
                        for (Persona p:listaOrdenada) {
                            System.out.println(p.toString());
                        }
                    }
                    case 3 ->{
                        System.out.println("Introduce edad máxima");
                        int edadMaxima=tec.nextInt();
                        tec.nextLine();
                        alServidor.writeInt(edadMaxima);
                        alServidor.flush();
                        System.out.println("Introduce edad mínima");
                        int edadMinima= tec.nextInt();
                        tec.nextLine();
                        alServidor.writeInt(edadMinima);
                        alServidor.flush();
                        List<Persona>listaFiltrada=(List<Persona>) delServidor.readObject();
                        for (Persona p : listaFiltrada){
                            System.out.println(p.toString());
                        }
                    }
                }
            } while (n != 0);
            alServidor.close();
            socket.close();
            delServidor.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }




    private static int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out
                .println("Elige la opción:");
        System.out
                .println("1. Utilizar servicio edad");
        System.out
                .println("2. Listar personas (ordenadas por nombre)");
        System.out
                .println("3. Buscar por rango de edad");
        System.out
                .println("4. Salir");
        opcion = Integer.parseInt(sc.nextLine());

        return opcion;
    }

}
