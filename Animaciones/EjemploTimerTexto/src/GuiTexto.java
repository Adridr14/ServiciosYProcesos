
/**
 *  
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class GuiTexto  extends JFrame
{
    private PanelTextoRunnable pnlTexto;

    /**
     * Constructor de la clase GuiTexto
     */
    public GuiTexto(int ancho, int alto)
    {
       
        pnlTexto = new PanelTextoRunnable(ancho, alto);
        this.add(pnlTexto);

        this.setTitle("Texto que se va moviendo horizontalmente y cambia de color");
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // centrar la ventana
        this.setResizable(true);
        this.setVisible(true);
    }

}
