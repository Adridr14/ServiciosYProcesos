import java.awt.Color;

/**
 * Modela un Semaforo
 */
public class Semaforo {

    private Color c;

    /**
     * Constructor de la clase Semaforo
     */
    public Semaforo() {
        c = Color.red;
    }

    /**
     * Obtener el color del semáforo
     */
    public Color getColor() {
        return c;
    }

    /**
     * Actualizar color del semaforo
     */
    public void avanzar() {
        if (getColor() == Color.RED) {
            setColor(Color.ORANGE);
        } else if (getColor() == Color.ORANGE) {
            setColor(Color.GREEN);
        } else if (getColor() == Color.GREEN) {
            setColor(Color.red);
        }
    }





    /**
     * Cambiar el color
     */
    public void setColor(Color c) {
        this.c = c;
    }

    /**
     *
     */
    public String toString() {
        return c.toString();
    }

}
