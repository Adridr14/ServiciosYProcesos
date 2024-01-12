import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HiloCliente implements Runnable{
    private int nCliente;
    private Socket socket;
    private List<Persona> lista;
    public HiloCliente(int nCliente, Socket socket) {
        this.nCliente=nCliente;
        this.socket=socket;
        this.lista=new ArrayList<>();
        Thread hilo=new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        System.out.println("Cliente "+nCliente+" conectado");
        try {
            ObjectInputStream delCliente = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream alCliente= new ObjectOutputStream(socket.getOutputStream());

            int opcion=delCliente.readInt();
            while (opcion!=0){
                switch (opcion){
                    case 1->{
                        String nombre= delCliente.readUTF();
                        String dni= delCliente.readUTF();
                        int edad=delCliente.readInt();
                        System.out.println("Recibido del cliente "+nCliente+" "+nombre+"con edad: "+edad);
                        if (edad<18){
                            String mensaje=nombre+ " eres menor de edad - con dni: "+dni;
                            System.out.println("Conectando con cliente "+nCliente+" "+mensaje);
                            alCliente.writeUTF(mensaje);
                            alCliente.flush();
                        }else {
                            String mensaje=nombre+ " eres mayor de edad - con dni: "+dni;
                            System.out.println("Conectando con cliente "+nCliente+" "+mensaje);
                            alCliente.writeUTF(mensaje);
                            alCliente.flush();
                        }
                        Persona persona=new Persona(dni,nombre,edad);
                        lista.add(persona);
                        System.out.println("Persona añadida");

                    }
                    case 2 ->{
                        Collections.sort(lista);
                        System.out.println(lista.toString());
                        alCliente.writeObject(lista);
                        alCliente.flush();
                    }
                    case 3 ->{
                        int edadMax=delCliente.readInt();
                        int edadMin=delCliente.readInt();
                        List<Persona> edadFiltrada=new ArrayList<>();
                        for (Persona p:lista) {
                            if (p.getEdad()<=edadMax && p.getEdad()>=edadMin){
                                edadFiltrada.add(p);
                            }
                        }
                        Collections.sort(edadFiltrada);
                        alCliente.writeUnshared(edadFiltrada);

                    }
                }
                opcion=delCliente.readInt();
            }
            alCliente.close();
            socket.close();
            delCliente.close();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
