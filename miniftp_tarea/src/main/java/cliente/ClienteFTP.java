package cliente;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ClienteFTP {

    /**
     * Puerto para env�o y recepci�n de los comandos. Se utiliza el 41 por estar
     * el 21 ocupado.
     */
    private static final int PUERTO_COMANDOS = 41;
    private ResourceBundle rb = ResourceBundle.getBundle("cliente");
    private BufferedReader reader;
    private Socket socket;
    private BufferedWriter writer;
    /**
     * Para leer los mensajes que se introducen por teclado.
     */
    private static BufferedReader teclado = new BufferedReader(
            new InputStreamReader(System.in));

    public static void main(String[] args) {
        new ClienteFTP();
    }

    public ClienteFTP() {
        establecerConexion();
        String path;
        boolean quit = false;
        do {
            if (socket == null) {
                establecerConexion();
            } else {
                int opcion = menu();
                switch (opcion) {
                    case 1: // Listar el directorio
                        try {
                            listarDirectorio();
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                        break;
                    case 2: // Descargar fichero
                        path = pedirCadena(rb
                                .getString("client.downloadFile"));
                        try {
                            descargarFichero(path);
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                        break;

                    case 3: // Subir fichero
                        path = pedirCadena(rb.getString("client.uploadFile"));
                        try {
                            subirFichero(path);
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                        break;

                    case 4: // Borrar fichero
                        path = pedirNombreFichero(rb.getString("client.deleteFile"));
                        try {
                            borrarFichero(path);
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                        break;

                    case 5: // Cerrar conexion
                        try {
                            this.cerrarConexion();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        quit = true;
                        break;

                    default:
                        System.out.println(rb.getString("menu.invalidOption"));
                        break;
                }
            }
        } while (!quit);
    }

    /**
     * Cierra la conexi�n con el servidor a trav�s del comando QUIT.
     *
     * @throws IOException
     */
    private void cerrarConexion() throws IOException {
        try {
            enviarComando("QUIT");
            String response = reader.readLine();
            if (!response.startsWith("221 ")) {
                throw new IOException(rb.getString("client.notClosed"));
            } else
                System.out.println(rb.getString("client.closed"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null)
                socket.close();
            cerrar();
        }

    }

    /**
     * Envia un fichero al servidor.
     *
     * @param path ruta del fichero a subir.
     * @throws IOException
     */
    private void subirFichero(String path) {


    }

    /**
     * Descarga un fichero del servidor.
     *
     * @param path ruta del fichero en el servidor.
     */
    private void descargarFichero(String path) throws IOException {
        enviarComando("RETR " + path);

        String response = reader.readLine();
        if (response.startsWith("150 ")) {
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new BufferedWriter(new FileWriter(path)));
            } catch (Exception e) {
                System.out.println(rb.getString("error.fileName"));
            }

            System.out.println(rb.getString("client.downloading"));
            String linea = null;
            while (((linea = reader.readLine()).equals("ENDRETR")) == false) {
                pw.println(linea);
            }
            pw.flush();
            pw.close();

            System.out.println(rb.getString("client.downloadOk") + path);

            if (response.startsWith("451 ")) {
                System.out.println(rb.getString("client.actionAborted"));
            }
        } else if (response.startsWith("450 ")) {
            System.out.println(rb.getString("client.fileUnavailable"));
        } else if (response.startsWith("550 ")) {
            System.out.println(rb.getString("client.fileUnavailableAtServer"));
        }
    }

    /**
     * Borra un fichero del servidor.
     *
     * @param path ruta del fichero a borrar.
     * @throws IOException
     */
    private void borrarFichero(String path) throws IOException {

    }

    /**
     * Envia la peticion al servidor para que le devuelva un listado de su
     * directorio de trabajo.
     *
     * @throws IOException
     */
    private void listarDirectorio() throws IOException {
        enviarComando("LIST");
        String response= reader.readLine();
        if (response.startsWith("150")){
            while ()
        }

    }

    /**
     * Pide al usuario que introduzca el nombre de un fichero que desear subir o
     * descargar del servidor.
     *
     * @param mensaje mensaje a mostrar para pedir los datos deseados.
     * @return el nombre del fichero a cargar o descargar.
     */
    private String pedirNombreFichero(String mensaje) {
        System.out.print(mensaje);
        try {
            String fileName = teclado.readLine();
            if (fileName.length() > 0)
                return fileName;
            else {
                System.out.println(rb.getString("client.nullFile"));
                return pedirNombreFichero(mensaje);
            }
        } catch (IOException e) {
            System.out.println(rb.getString("client.nullFile"));
            return pedirNombreFichero(mensaje);
        }
    }

    /**
     * Imprime el men� principal
     *
     * @return la opcion seleccionada por el usuario.
     */
    private int menu() {
        int opcion = 0;
        System.out.println(rb.getString("line.separator"));
        System.out.println(rb.getString("menu.title"));
        System.out.println(rb.getString("line.separator"));
        System.out.println(rb.getString("menu.option1"));
        System.out.println(rb.getString("menu.option2"));
        System.out.println(rb.getString("menu.option3"));
        System.out.println(rb.getString("menu.option4"));
        System.out.println(rb.getString("menu.option5"));
        System.out.print(rb.getString("menu.option"));
        opcion = getOpcion();

        return opcion;
    }

    /**
     * Lee un n�mero entero introducido por el usuario a trav�s del teclado.
     *
     * @return el n�mero introducido.
     */
    private int getOpcion() {
        try {
            return Integer.parseInt(teclado.readLine());
        } catch (Exception e) {
            System.out.println(rb.getString("error.option"));
            return getOpcion();
        }
    }

    /**
     * Intenta conectarse al servidor deseado.
     */
    private void establecerConexion() {
        boolean connected = false;
        do {
            if (connected = conectar() == false)
                System.out.println(rb.getString("error.connection"));
            else
                connected = true;
        } while (!connected);
    }

    /**
     * Abre la conexion con el servidor indicado por el usuario.
     *
     * @return true si se pudo conectar correctamente.
     */
    private boolean conectar() {
        String host = pedirIpServidor();
        boolean connected = false;
        try {
            connected = this.abrirConexion(host);
        } catch (Exception e) {
            System.out.println(rb.getString("error.connectionAborted"));
        }
        return connected;
    }

    /**
     * Le pide al usuario que introduzca la IP del servidor al que se quiere
     * conectar.
     *
     * @return la IP introducida por el usuario.
     */
    private String pedirIpServidor() {
        System.out.println(rb.getString("line.separator"));
        System.out.println(rb.getString("menu.name"));
        System.out.println(rb.getString("line.separator"));
        System.out.print(rb.getString("menu.enterIp"));

        String ip = "";
        try {
            ip = teclado.readLine();
            if (ip.equalsIgnoreCase("x")) {
                cerrar();
            }
        } catch (IOException e) {
            System.out.println(rb.getString("error.ip"));
            return pedirIpServidor();
        }
        return ip;
    }

    /**
     * Imprime un mensaje de despedida y cierra la aplicaci�n.
     */
    private void cerrar() {
        System.out.println(rb.getString("client.close"));
        System.exit(0);
    }

    /**
     * Se conecta a un servidor FTP dada su IP. Para ello solicita un login y
     * password.
     *
     * @throws Exception
     */
    public boolean abrirConexion(String host) throws Exception {
        boolean conectado = false;
        if (socket != null) {
            throw new IOException(rb.getString("client.alreadyConnected"));
        }
        System.out.println(rb.getString("client.connecting") + host);
        socket = new Socket(host, PUERTO_COMANDOS);
        reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream()));

        String respuesta = reader.readLine();
        if (!respuesta.startsWith("220 ")) {
            throw new IOException(rb.getString("client.notReady"));
        }

        System.out.println(rb.getString("client.connectionOk"));
        conectado = true;

        return conectado;
    }

    /**
     * Envía un comando al servidor finalizando en "\r\n".
     *
     * @param linea línea que se desea enviar al servidor.
     * @throws IOException
     */
    private void enviarComando(String linea) throws IOException {
        if (socket == null) {
            System.out.println(rb.getString("error.connection"));
        }
        try {
            writer.write(linea + "\r\n");
            writer.flush();
        } catch (IOException e) {
            socket = null;
        }
    }

    /**
     * Pide al usuario que introduzca su nombre de usuario y contrase�a.
     *
     * @param data dato a introducir (usuario o contrase�a).
     * @return la cadena de texto introducida por teclado.
     */
    private String pedirCadena(String data) {
        System.out.println(rb.getString("menu.enterInput") + data + " > ");

        String input = "";
        try {
            input = teclado.readLine();
            if (input.equalsIgnoreCase("x"))
                cerrar();
            else {
                if (input.length() <= 0 || input.length() >= 20)
                    throw new IOException();
            }
        } catch (IOException e) {
            System.out.println(rb.getString("error.invalidInput"));
            return pedirCadena(data);
        }
        return input;
    }
}
