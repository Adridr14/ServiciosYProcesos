
/**
 *  
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;

public class GuiTextoBotones extends JFrame
{
    private PanelTextoRunnableBotones pnlTexto;
    private JButton btnIniciar,btnParar;
    /**
     * Constructor de la clase GuiTexto
     */
    public GuiTextoBotones(int ancho, int alto)
    {
       
        pnlTexto = new PanelTextoRunnableBotones(ancho, alto);
        this.add(pnlTexto);

        btnIniciar=new JButton("Iniciar");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlTexto.iniciarAnimacion();
            }
        });
        btnParar=new JButton("Pausar");
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlTexto.pararAnimacion();
            }
        });

        this.setTitle("Texto que se va moviendo horizontalmente y cambia de color");
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // centrar la ventana
        this.setResizable(true);
        this.setVisible(true);
    }

}
