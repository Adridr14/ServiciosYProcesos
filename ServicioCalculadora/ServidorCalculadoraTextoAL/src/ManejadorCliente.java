import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class ManejadorCliente implements Runnable {
    private int numCliente;
    private Socket socket;
    private Calculadora c;

    public ManejadorCliente(int numCliente, Socket socket) {
        this.numCliente = numCliente;
        this.socket = socket;
        c = new Calculadora();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            PrintWriter alCliente = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            //BufferedReader delServidor= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            Scanner delCliente = new Scanner(socket.getInputStream());
            String oper=delCliente.nextLine();
            while (!oper.equalsIgnoreCase("q")) {
                int numero1 = delCliente.nextInt();
                int numero2 = delCliente.nextInt();
                String operacion = null;

                String resultado = null;
                switch (oper) {
                    case "+":
                        operacion = "Suma:" + numero1 + "+" + numero2;
                        resultado = "La suma es: " + c.sumar(numero1, numero2);
                        break;
                    case "-":
                        operacion = "Resta:" + numero1 + "-" + numero2;
                        resultado = "La resta es: " + c.restar(numero1, numero2);
                        break;
                    case "*":
                        operacion = "Multiplicación:" + numero1 + "/" + numero2;
                        resultado = "La multiplicación es: " + c.multiplicar(numero1, numero2);
                        break;
                    case "/":
                        operacion = "División:" + numero1 + "/" + numero2;
                        resultado = "La división es: " + c.dividir(numero1, numero2);
                }

                alCliente.println(operacion);
                System.out.println("Desde el servidor con cliente " + numCliente + " " + resultado);
                alCliente.println(resultado);
                oper = delCliente.nextLine();
            }


        } catch (IOException e){
            System.err.println(e.getMessage());}
    }
    }
