import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static List<Coche> coches;
    public Repositorio(){
        this.coches=new ArrayList<>();
        this.crearAlmacen();

    }

    private void crearAlmacen() {
        coches.add(new Coche("Citroen","blanco"));
        coches.add(new Coche("Citroen","azul"));
        coches.add(new Coche("Audi","rojo"));
        coches.add(new Coche("Seat","negro"));

    }
    public static List<Coche> getCoches(){
        return coches;
    }
}
