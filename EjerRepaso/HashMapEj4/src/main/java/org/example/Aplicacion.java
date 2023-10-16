package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Aplicacion {
    private Map<String, HashSet<String >> diccionario;

    public Aplicacion(Map<String, HashSet<String>> diccionario) {
        this.diccionario = new HashMap<>();
    }

    public void addSinonimo(String palabra,String sinonimo){
        Set<String> sinonimos=diccionario.get(palabra);
        if (sinonimos==null){
            sinonimos=new HashSet<>();
        }
        sinonimos.add(sinonimo);
        diccionario.put(palabra,sinonimos);
    }
    public boolean borrarSinonimo(String palabra,String sinonimo){
        Set<String>sinonimos=diccionario.get(palabra);
        if (sinonimos==null){return false;}

        if (sinonimos.remove(sinonimo)){
            diccionario.put(palabra,sinonimos);
            return true;
        }
        return false;
    }
}
