package org.example;

import java.util.HashSet;
import java.util.Set;

public class Diccionario {
    private String palabra;
    private Set<String> sinonimos;

    public Diccionario(String palabra, Set<String> sinonimos) {
        this.palabra = palabra;
        this.sinonimos = new HashSet<>();
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Set<String> getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(Set<String> sinonimos) {
        this.sinonimos = sinonimos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Diccionario{");
        sb.append("palabra='").append(palabra).append('\'');
        sb.append(", sinonimos=").append(sinonimos);
        sb.append('}');
        return sb.toString();
    }
}
