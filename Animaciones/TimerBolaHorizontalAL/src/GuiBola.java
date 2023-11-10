
/**
 *  
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GuiBola extends JFrame
{

    private PanelBolaHilos pnlBola;
    private JButton btnIniciar,btnParar;
    
    /**
     * Constructor  
     */
    public GuiBola( )
    {
        crearGui();
        mostrarGui();

    }
    private void crearGui()
    {
        pnlBola = new PanelBolaHilos();
        this.getContentPane().add(pnlBola);
        btnIniciar=new JButton("Iniciar");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBola.iniciarAnimacion();
            }
        });
        btnParar=new JButton("Parar");
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBola.pararAnimacion();
            }
        });
       
    }

    private void mostrarGui()
    {

        this.setTitle("Bola movimiento horizontal con hilos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(200, 100);
        this.setResizable(true);  
        this.pack();
        this.setVisible(true);    
        this.add(btnIniciar);
        this.add(btnParar);
 
    }
    
    


    public static void main(String[] args)
    {
         new GuiBola();
        
       
    }

}