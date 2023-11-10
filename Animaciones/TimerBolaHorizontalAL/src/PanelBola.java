import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class PanelBola extends JPanel implements ActionListener {
	public final static int MILISEGUNDOS = 70; 
	public final static int ANCHO = 400; // ancho del panel
	public final static int ALTO = 300; // alto del panel
	private final static int POSX1 = 350; // posición x de la línea 1 (la
											// vertical)
	private final static int POSY1 = 0; // posición y de la línea 1 (la
										// vertical)
	private final static int POSX2 = 0; // posición x de la línea 1 (la
										// horizontal)
	private final static int POSY2 = 250; // posición y de la línea 1 (la
											// horizontal)
	public final static int DIAMETRO = 30;
	private int x; // coordenada x de la bola
	private int y; // coordenada y de la bola
	private Timer timer;
	private boolean derecha; // indica si la bola va hacia la derecha o hacia la
								// izquierda

	
	/**
	 * Constructor 
	 */
	public PanelBola()
	{
		this.setBackground(Color.black);
		// establecer tamaño del panel
		this.setPreferredSize(new Dimension(ANCHO, ALTO));
		// establecer posición inicial de la bola
		x = 0;
		y = POSY2 - DIAMETRO;
		timer= new Timer(50,this);
		derecha = true;
		// completar
		timer.start();
		
		
		 

	}

	/**
     *   Este método se ejecuta cada vez que el panel necesita ser dibujado
     *       
     */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.green);
		g.drawLine(POSX1, POSY1, POSX1, POSY1 + ALTO); // dibujar línea vertical
		g.drawLine(POSX2, POSY2, POSX2 + ANCHO, POSY2); // dibujar línea horizontal
		// dibujar la bola
		g.setColor(Color.red);
		g.fillOval(x, y, DIAMETRO, DIAMETRO);

	}



	/**
	 * actualizar adecuadamente la posición de la bola
	 */
	private void actualizar()
	{
		if (derecha){
			if (x==POSX1-DIAMETRO){derecha=false;}
			else {x+=5;}
		}else {
			if (x<=0){derecha=true;}
			else {x-=5;}
		}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		actualizar();
		repaint();

	}
}
