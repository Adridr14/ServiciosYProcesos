import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;


import javax.swing.JPanel;
import javax.swing.Timer;


public class PanelContador extends JPanel implements EventListener, MouseListener, ActionListener {
    public final static int ANCHO = 400;  // ancho del panel
    public final static int ALTO = 300;  // alto del panel
    private final static int DELAY = 500;  // retardo del timer, cada cuánto genera un evento ActionEvent
    private final static int POS_X = ANCHO / 3;  // posición x del contador
    private final static int POS_Y = ALTO / 3;   // posición y del contador
    private int x;
    private int y;
    private int contador;
    private Timer timer;
    private boolean limit;

    

    /**
     * Constructor 
     */
    public PanelContador() 
    {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        x = POS_X;
        y = POS_Y;        
        contador = 0;
        // a completar
        timer=new Timer(DELAY, this);
        timer.start();
        this.addMouseListener(this);
        this.limit=false;
        
        
        
    }

    /**
     *   
     *       
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.black);
         // a completar
        g.setColor(Color.YELLOW);
      if (!timer.isRunning()){
          g.drawString("Click en el panel para iniciar/continuar animacion",20,10);
      }else {
          g.drawString("Click en el panel para detener animacion",20,10);
      }

      g.setFont(new Font("Verdana",Font.BOLD,36));

        g.drawString(String.valueOf(contador),50,60);
        

    }
 
    public void actionPerfomed(ActionEvent arg0){
        actualizar();
        repaint();
    }
    private void actualizar(){
        if (contador==10){
            limit=true;
        }else if (contador==0){
            limit=false;
        }
        if (limit){
            contador--;
        } else  {
            contador++;
        }
    }
    
    

    public void mousePressed(MouseEvent e) {  };

    public void mouseReleased(MouseEvent e)  {  };

    public void mouseClicked(MouseEvent e)
    {
    	// a completar
        if (this.timer.isRunning()){
            this.timer.stop();
        }else {
            this.timer.start();
        }this.repaint();
    	
    }; 

    public void mouseEntered(MouseEvent e) {  }; 

    public void mouseExited(MouseEvent e) {  };

    @Override
    public void actionPerformed(ActionEvent e) {
        actualizar();
        repaint();

    }

}
