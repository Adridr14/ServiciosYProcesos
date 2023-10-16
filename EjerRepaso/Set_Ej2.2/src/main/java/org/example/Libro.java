package org.example;

public class Libro implements Comparable <Libro> {
    private String titulo;
    private String autor;
    private int paginas;
    private ESTADO estado;

    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.estado=ESTADO.NOPRESTADO;
    }
    public Libro(){
        this(null,null,0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }
    public void prestar() throws  IllegalStateException{
        if (this.estado.equals(ESTADO.NOPRESTADO)){
            this.estado=ESTADO.PRESTADO;
        }else {
            throw new IllegalStateException("El libro ya está prestado");
        }
    }
    public void devolver() throws  IllegalStateException{
        if (this.estado.equals(ESTADO.PRESTADO)){
            this.estado=ESTADO.NOPRESTADO;
        }else {
            throw new IllegalStateException("El libro ya está prestado");
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas=" + paginas +
                ", estado=" + estado +
                '}';
    }

    @Override
    public int compareTo(Libro o) {
       int n=this.autor.compareTo(o.getAutor());
       if (n==0){
           return this.titulo.compareTo(o.getTitulo());
       }
        return n;
    }
}
