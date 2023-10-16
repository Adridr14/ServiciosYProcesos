package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LibreriaOrdenada {
    private Set <Libro> lista;
    private String nombre;

    public LibreriaOrdenada(String nombre) {
        this.nombre = nombre;
        this.lista= new TreeSet<>();

    }
    public void addLibro(Libro libro){ this.lista.add(libro);}

    public Libro buscarLibro(String titulo){
        Libro libro= null;
        Iterator<Libro> it= lista.iterator();
        while (it.hasNext() && libro ==null){
            Libro l= it.next();
            if (l.getTitulo().equals(titulo)){
                libro=l;
            }
        }return libro;

    }

    public void  prestarLibro(String titulo){
        Iterator<Libro>it= lista.iterator();
        boolean libroEncontrado=false;
        while (it.hasNext()&&libroEncontrado==false){
            Libro l=it.next();
            if (l.getTitulo().equalsIgnoreCase(titulo)){
                if (l.getEstado().equals(ESTADO.PRESTADO)){
                    System.out.println("El libro "+titulo+" ya se encuentra prestado");
                }else {l.setEstado(ESTADO.PRESTADO);}
                libroEncontrado = true;
            }
        }
        if (!libroEncontrado){
            System.out.println("El libro "+titulo+" no se encuentra en la librería");
        }
    }

    public String listarLibros(){
        Iterator <Libro> it= lista.iterator();
        StringBuilder sb= new StringBuilder();
        while (it.hasNext()){
            sb.append(it.next().toString()+" ");
        }
        return sb.toString();
    }
    public Set<Libro> relacionLibrosPrestaods(){
        Set<Libro> listPrestados=new HashSet<>();
        for (Libro l:lista) {
            if (l.getEstado().equals(ESTADO.PRESTADO)){
                listPrestados.add(l);
            }
        }return listPrestados;
    }
    public boolean hayLibrosDe(String autor){
        Iterator <Libro> it= lista.iterator();
        while (it.hasNext()){
            if (it.next().getAutor().equals(autor)){
                return true;
            }
        }return false;
    }
    public void borrarLibroAutor(String autor){
        Iterator it= lista.iterator();
        int librosBorrados=0;
        while (it.hasNext()){
            Libro l= (Libro) it.next();
            if (l.getAutor().equals(autor)){
                it.remove();
                librosBorrados++;
            }
        }
        if (librosBorrados==0){
            System.out.println("No se ha encontrado ningún libro de "+autor);
        }
    }
    public int contarLibros(){
        return this.lista.size();
    }

    public Set<Libro> getLista() {
        return lista;
    }

    public void setLista(Set<Libro> lista) {
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
