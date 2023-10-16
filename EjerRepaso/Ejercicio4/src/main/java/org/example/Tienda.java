package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tienda {
 public List<Dispositivo> inv=new ArrayList<Dispositivo>();

 public void addDispositivo(Dispositivo dispositivo){
     if(!inv.contains(dispositivo))
     {inv.add(dispositivo);
     System.out.println("Dispositivo creado");}
     else System.out.println("El dispositivo ya se encuentra añadido");

 }
 public void ordenPorPrecio(){
    inv.sort(new ComparadorPrecio());
     Iterator <Dispositivo>it=inv.iterator();
     while (it.hasNext()){
         Dispositivo d= it.next();
         System.out.println(d.toString());
     }

 }
 public void ordenMovilesPorPulagadas(){
     List<Movil> mvl=new ArrayList<Movil>();
     Iterator< Dispositivo> it= inv.iterator();

     while (it.hasNext()){
         if(it.next() instanceof Movil){
             Movil m=(Movil)it.next();
             mvl.add(m);
         }else it.next();
     }
     imprimirListaDispositivos((List)mvl);

 }
 public List<Portatil> ordenadoresConDVD(){
     List<Portatil> conDvd=new ArrayList<Portatil>();
     Iterator<Dispositivo> it=inv.iterator();
     int cont =0;
     while (it.hasNext()){
         if(it.next() instanceof Portatil){
             Portatil p=(Portatil) it.next();
            if (p.isDvd()){
              conDvd.add(p);
            }
         }else it.next();
     }
     return conDvd;
 }
 public  int borrarTabletsObsoletos(){
     Iterator<Dispositivo> it=inv.iterator();
     int cont=0;
     while (it.hasNext()){
         if (it.next() instanceof Tablet){
             Tablet t=(Tablet) it.next();
             if (t.getPulgadas()<=8){
                 inv.remove(t);
                 cont++;
             }
         }else it.next();
         System.out.println("Se han borrado "+ cont+" dispositivos");
     }
     return cont;
 }
 public List <Dispositivo> filtrarPorTipo(String tipo){
     Iterator<Dispositivo> it=inv.iterator();
     List <Dispositivo> disp=new ArrayList<Dispositivo>();
     while (it.hasNext()){
     if(it.getClass().getSimpleName().equals(tipo)){
      Dispositivo d=it.next();
      disp.add(d);
     }else it.next();
     }
     return disp;
 }
 public void imprimirListaDispositivos(List <Dispositivo> listaDispositivos){
     Iterator <Dispositivo> it= listaDispositivos.iterator();
     listaDispositivos=new ArrayList<Dispositivo>();
     while(it.hasNext()){
         Dispositivo d= it.next();
         System.out.println(d.toString());
     }
 }
 public String toString(){
     Iterator<Dispositivo> it= inv.iterator();
     StringBuilder sb=new StringBuilder();
     while (it.hasNext()){
         Dispositivo d=it.next();
         sb.append(d.toString());
     }
     return sb.toString();
 }
}
