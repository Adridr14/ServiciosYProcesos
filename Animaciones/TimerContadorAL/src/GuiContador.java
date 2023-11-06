import javax.swing.JFrame;


public class GuiContador extends JFrame
{

    private PanelContador pnlContador;
    
    /**
     * Constructor  
     */
    public GuiContador( )
    {
        crearGui();
        mostrarGui();

    }
    private void crearGui()
    {
        pnlContador = new PanelContador();
        this.getContentPane().add(pnlContador);
       
    }

    private void mostrarGui()
    {

        this.setTitle("Contador ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(PanelContador.ANCHO, PanelContador.ALTO);
        this.setLocationRelativeTo(null);
        this.setResizable(true);        
        this.setVisible(true);      
 
    }
    
    


    public static void main(String[] args)
    {
         new GuiContador();
        
       
    }

}