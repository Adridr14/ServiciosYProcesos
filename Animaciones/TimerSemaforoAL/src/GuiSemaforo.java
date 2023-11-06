
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
 

public class GuiSemaforo  extends JFrame
{
    private JButton btnIniciarParar;
    
    private PanelSemaforo  panelSemaforo;
    private Semaforo semaforo; // el modelo

    /**
     * Constructor  
     */
    public GuiSemaforo()
    {
        this.semaforo = new Semaforo();
        crearGui();
        mostrarGui();

    }

    /**
     *   
     */
    private void crearGui()
    {
        this.setTitle("Uso de un timer para simular  un semáforo ");
        JPanel pnlSur = new JPanel();
        pnlSur.setBorder(new TitledBorder("Iniciar Semaforo / Parar Semáforo"));

        btnIniciarParar = new JButton("Iniciar");
      
        pnlSur.add(btnIniciarParar);
        this.add(pnlSur, BorderLayout.SOUTH);

        panelSemaforo = new PanelSemaforo();
        this.add(panelSemaforo, BorderLayout.CENTER);
        btnIniciarParar.addActionListener(panelSemaforo);

        

    }

    /**
     *   
     */
    private void mostrarGui()
    {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }

    /**
     * el panel es una clase interna
     */

    private class PanelSemaforo extends JPanel implements ActionListener {
        private final int DELAY = 400;
        private Timer timer;
        private int x;
        private int y;
       
        /**
         * Constructor 
         */
        public PanelSemaforo()
        {
        	// TO-DO: crea el timer
            timer=new Timer(500,this);
            this.x=0;
            this.y=0;

        }
        /**
         *  
         * Se ejecuta cada vez que el panel necesita ser dibujado
         *      
         */
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            setBackground(Color.black);
            // TO-DO: Pinta el rectángulo correspondiente del semáforo y actualiza su color.
            g.setColor(semaforo.getColor());
            g.fillRect(x,y,400,panelSemaforo.getHeight()/3);

        }
        private void actualizar(){
            if(y<200){
                y+=100;
            }else { y=0;}
        }
     
     
        /**
         *  este método se ejecutará cuando el timer genere un evento y cuando se haga
         *  click en el botón de inicio y en el de parada
         */
        public void actionPerformed(ActionEvent ev)
		{
            //Si pulso sobre el botón tengo que comprobar si el timer está corriendo para pararlo
            //y cambiar el texto del botón, o si no está arrancado para ponerlo en marcha.
            if (ev.getSource() == btnIniciarParar) {
                if (timer.isRunning()){
                    timer.stop();
                    btnIniciarParar.setText("Iniciar");
                }else {
                    timer.start();
                    btnIniciarParar.setText("Detener");
                }
            }else{

            }
            semaforo.avanzar();
            this.actualizar();
            this.repaint();
            //TO-DO: Actualiza coordenadas y "re-pinta" el panel.
        	

			
		}
        
        
        
        

    }
    
    public static void main(String[] args)
    {
        new GuiSemaforo();
 
    }
}