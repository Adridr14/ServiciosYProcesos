import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FiltroCallesPorTipo extends Thread{
    private List<Calle> listaOrdenada;
    private File file;

    public FiltroCallesPorTipo(File archivo){
        this.file=archivo;
        listaOrdenada=new ArrayList<>();
    }

    @Override
    public void run() {
        Thread.currentThread();
        try(BufferedReader br= new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea=br.readLine())!=null) {
                String[] partes=linea.split(";");
                Calle calle=new Calle(Integer.parseInt(partes[0]),partes[1],partes[2]);
                listaOrdenada.add(calle);
            }
            Collections.sort(listaOrdenada);
            Iterator it= listaOrdenada.iterator();
            System.out.println(Thread.currentThread().getName()+": Imprimendo calles ordenadas:");
            while (it.hasNext()){
                Calle calle= (Calle) it.next();

                System.out.println(calle.getTipo()+" "+calle.getNombre()+" ("+calle.getCodigo()+")");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
