
/**
 * Demo Timer
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelTextoRunnableBotones extends JPanel implements Runnable, MouseListener{
    private static final int ANCHO_REC = 20; // ancho cuadrado a dibujar
    private static final int ALTO_REC = 20; // alto cuadrado a dibujar
    private int x; // posición inicial del texto en el panel
    private int y;
    private boolean rojo; // a true indica que toca escribir el texto que se desplaza en rojo, a false en
    // blanco
    private int tamanioLetra = 1;
    private boolean up;
    private Thread hilo;

    private static final int MILISEGUNDOS=200;

    /**
     * Constructor de la clase PanelTexto
     */
    public PanelTextoRunnableBotones(int ancho, int alto) {
        Dimension dimension = new Dimension(ancho, alto);
        this.setPreferredSize(dimension);
        this.x = (int) dimension.getWidth() / 3;
        this.y = (int) dimension.getHeight() / 3;
        rojo = true;
        hilo= new Thread(this);
        hilo.start();
        this.addMouseListener(this);

    }

    /**
     * Cada vez que se dibuja el panel se modifica el color de la letra y las
     * coordenada x e y en las que se escribe el texto
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);

        if (rojo) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.white);
        }

        rojo = !rojo;

        // g.drawString("Texto que se desplaza", x, 100);
        // g.setFont(new Font("Verdana", Font.BOLD, 16));

        if (tamanioLetra < 56) {
            g.setFont(new Font("Verdana", Font.BOLD, tamanioLetra));
            tamanioLetra += 1;
        } else {
            tamanioLetra = 1;
        }

        g.drawString("Texto que se desplaza", x, y);

    }


    /**
     * Calcular las nuevas coordenadas de posición del texto
     */
    private void actualizar() {
        if (this.x > this.getWidth()) {
            x = 0;
        }
        x += 5;

        if (up) {
            y -= 10;
        } else {
            y += 10;
        }
        up = !up;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!hilo.isInterrupted()){
            this.pararAnimacion();
        }else {
            this.iniciarAnimacion();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        while (!hilo.isInterrupted()){
        this.actualizar();
        this.repaint();
        this.pausar();
        }
    }
    public void pararAnimacion(){
        this.hilo.interrupt();
    }
    public void iniciarAnimacion(){
        hilo=new Thread(this);
        hilo.start();
    }
    private void pausar(){
        try {
            Thread.sleep(MILISEGUNDOS);
        } catch (InterruptedException e) {
            pararAnimacion();
        }
    }
}
