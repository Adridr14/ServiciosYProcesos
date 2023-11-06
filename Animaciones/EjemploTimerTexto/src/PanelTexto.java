
/**
 * Demo Timer
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class PanelTexto extends JPanel implements ActionListener, MouseListener{
    private static final int ANCHO_REC = 20; // ancho cuadrado a dibujar
    private static final int ALTO_REC = 20; // alto cuadrado a dibujar
    private int x; // posición inicial del texto en el panel
    private int y;
    private boolean rojo; // a true indica que toca escribir el texto que se desplaza en rojo, a false en
    // blanco
    private int tamanioLetra = 1;
    private boolean up;
    private Timer timer;
    private static final int MILISEGUNDOS=200;

    /**
     * Constructor de la clase PanelTexto
     */
    public PanelTexto(int ancho, int alto) {
        Dimension dimension = new Dimension(ancho, alto);
        this.setPreferredSize(dimension);
        this.x = (int) dimension.getWidth() / 3;
        this.y = (int) dimension.getHeight() / 3;
        rojo = true;
        timer = new Timer(MILISEGUNDOS,this);
        timer.start();
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
    public void actionPerformed(ActionEvent e) {
        this.actualizar();
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.timer.isRunning()){
            this.timer.stop();
        }else {
            this.timer.start();
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
}
