package servidor;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class ManejadorCliente implements Runnable {
    public static final String SERVIDOR_DIR = "src/main/resources/servidor_dir";
    private Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    private ResourceBundle rb = ResourceBundle.getBundle("servidor");


    public ManejadorCliente(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Thread hilo = new Thread(this);
        System.out.println(rb.getString("message.230"));
        hilo.start();
    }

    @Override
    public void run() {
        try {
            escucharComandos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void escucharComandos() throws IOException {
        writer.println(rb.getString("message.220"));

        String linea;
        while ((linea = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea);
            String command = st.nextToken();

            if (command.equalsIgnoreCase("QUIT")) {
                cerrarCliente();
                break;
            } else if (command.equalsIgnoreCase("DELE")) {
                gestionarBorrado(linea);
            } else if (command.equalsIgnoreCase("LIST")) {
                listarDirectorio(SERVIDOR_DIR);
            } else if (command.equalsIgnoreCase("RETR")) {
                gestionarDescarga(linea);
            } else if (command.equalsIgnoreCase("STOR")) {
                gestionarSubida(linea);
            }
        }
    }

    /**
     * Recibe un fichero del cliente despu�s de que �ste haya hecho una petici�n
     * de subida sobre el mismo.
     */
    private void gestionarSubida(String linea) {


    }

    /**
     * Env�a un fichero al cliente despu�s de que �ste haya hecho una petici�n
     * de descarga sobre el mismo.
     */
    private void gestionarDescarga(String linea) {
        String path = String.format("%s/%s", SERVIDOR_DIR, linea.substring(5));

        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(Paths.get(path)));
        } catch (FileNotFoundException e) {
            writer.println(rb.getString("exception.550"));
        } catch (Exception e) {
            writer.println(rb.getString("exception.450"));
        }
        try {
            writer.println(rb.getString("message.150"));
            writer.println(contenido);
            writer.println("ENDRETR");
        } catch (Exception e) {
            writer.println(rb.getString("exception.451"));
        }
    }

    /**
     * Env�a el listado de ficheros y directorios contenido en el directorio
     * ra�z de trabajo del servidor.
     *
     * @param path ruta de trabajo del servidor.
     * @throws IOException
     */
    private void listarDirectorio(String path) {
        int numFiles=0;
        String [] fileNames=null;
        File dir=null;
        try {
            dir=new File(path);
            fileNames=dir.list();
            numFiles= fileNames!=null ? fileNames.length :0;

        }catch (Exception e) {

        }
        writer.println(rb.getString("message.150"));
        writer.println("total "+numFiles);
        for (int i=0;i<numFiles;i++){
            String fileName=fileNames[i];
            File arch=new File(dir,fileName);
            imprimirDetalles(arch);
        }
        writer.println("ENDLIST");
        writer.flush();
    }

    /**
     * Imprime el estado de un fichero o directorio al estilo del comando ls -l
     * de Linux.
     *
     * @param file Fichero a imprimir.
     */
    private void imprimirDetalles(File file) {
       Date date= new Date(file.lastModified());
       SimpleDateFormat dateFormat= new SimpleDateFormat("MMM dd hh:mm");
       String dataStr= dateFormat.format(date) ;
       

    }

    /**
     * Imprime espacios en blanco para utilizar en el formateo de los listados.
     *
     * @param length Número de espacios en blanco a generar.
     * @return una cadena de espacios en blanco.
     */
    private static String rellenarConEspacios(int length) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++)
            buf.append(' ');
        return buf.toString();
    }

    private void gestionarBorrado(String linea) {

    }

    /**
     * Cierra el socket de conexion con el cliente y se lo notifica al cliente.
     *
     * @throws IOException
     */
    private void cerrarCliente() throws IOException {
        writer.println(rb.getString("message.221"));
        socket.close();
        System.out.println(rb.getString("message.disconnect"));
    }
}
