package org.example;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;

public class ClienteFTP {

    //Esta clase pertenece a java.util
    private static ResourceBundle rb= ResourceBundle.getBundle("server");
    private static FTPClient cliente;
    public static void main(String[] args) {
        cliente=new FTPClient();

        try {
            iniciarConexion();
            System.out.println(cliente.getReplyString());
            if(!loguear()){
                System.out.println(rb.getString("error.login"));
                cliente.disconnect();
            }
            mostrarDirectorioActual();
            listarFicheros();
            descargarFichero();
            cliente.logout();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void descargarFichero() throws IOException {
        String archivo= rb.getString("archivo_descargar");
        FileOutputStream stream=new FileOutputStream("src/main/resources/welcome.msg");
        cliente.retrieveFile(archivo,stream);
        stream.close();
    }

    private static void listarFicheros() throws IOException {
        FTPFile[] ficheros=cliente.listFiles();
        System.out.println("Numero de recursos en el directorio actual: "+ficheros.length);
        String[] tipos={"Fichero","Directorio","Enlace simbólico"};
        for (FTPFile fichero: ficheros){
            System.out.println(fichero.getName() +" - "+tipos[fichero.getType()]);
        }
    }

    private static void mostrarDirectorioActual() throws IOException {
        System.out.println(cliente.printWorkingDirectory());
        cliente.changeWorkingDirectory("/mirror");
        cliente.changeToParentDirectory();
    }

    private static boolean loguear() throws IOException {
        String user=rb.getString("user");
        String password= rb.getString("password");
        return cliente.login(user,password);
    }

    private static void iniciarConexion() throws IOException {
        String server = rb.getString("server");
        cliente.connect(server);
    }
}
