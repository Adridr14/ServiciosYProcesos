import java.io.*;

public class ContadorCaracteres extends Thread{
    private String nombre;
    private File archivo;
    public ContadorCaracteres ( File archivo){

        this.archivo=archivo;
    }

    @Override
    public void run() {
        Thread.currentThread();
        try (BufferedReader br=new BufferedReader(new FileReader(archivo))){
            String linea;
            StringBuilder sb=new StringBuilder();
            while ((linea=br.readLine())!=null){
                sb.append(linea);

            }
            System.out.println(Thread.currentThread().getName()+": El archivo "+archivo.getName()+" cuenta con: "+sb.length()+" caracteres");

        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
