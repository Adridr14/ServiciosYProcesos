package org.example;

public class Persona implements Comparable<Persona> {
    private int edad;
    private String dni;

    public Persona(){
        this(0,null);
    }
    public Persona(int edad, String dni) {
        this.edad = edad;
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona [Edad: "+edad+ "DNI: "+dni+"]";
    }

    @Override
    public int compareTo(Persona o) {
        return this.edad -o.edad;
    }
}
