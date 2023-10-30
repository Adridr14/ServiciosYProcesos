import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LimpiadorFichero extends Thread{
    private List<Calle>listaCalles;
    private File archivo;

    public LimpiadorFichero(File archivo){
        this.archivo=archivo;
        this.listaCalles=new ArrayList<>();
    }

    @Override
    public void run() {
        Thread.currentThread();
        File archivo2= new File("listado-calles-limpio.csv");
        try(BufferedReader br=new BufferedReader(new FileReader(archivo)); BufferedWriter bw=new BufferedWriter(new FileWriter(archivo2))) {
            String linea;
            br.readLine();br.readLine();
            while ((linea=br.readLine())!=null){
                linea=linea.replace(" ","");
                linea=linea.replace("\"","");
                String[] partes=linea.split(";");
                Calle calle;
                if (partes[2].isEmpty()||partes[3].isEmpty()||partes[4].isEmpty()){}
                else {
                calle=new Calle(Integer.parseInt(partes[2]),partes[3],partes[4]);
                    listaCalles.add(calle);}

            }
            Iterator it= listaCalles.iterator();
            while (it.hasNext()){
                Calle calle= (Calle) it.next();
                bw.write(calle.toString());
                bw.newLine();
            }
            System.out.println(Thread.currentThread().getName()+" Fichero limpio creado correctamente");
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
