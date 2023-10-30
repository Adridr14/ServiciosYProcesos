public class Calle implements Comparable<Calle>{
    private int codigo;
    private String tipo;
    private String nombre;

    public Calle(int codigo, String tipo, String nombre) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Calle() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
       sb.append(codigo+";");sb.append(tipo+";");sb.append(nombre+";");
        return sb.toString();
    }

    @Override
    public int compareTo(Calle o) {
        if ((this.getTipo().compareTo(o.getTipo()) != 0 )){
            return this.getTipo().compareTo(o.getTipo());
        }else return this.getNombre().compareTo(o.getNombre());

    }
}
