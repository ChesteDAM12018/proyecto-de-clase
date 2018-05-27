package excepciones;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public class DatosIncorrectosEX extends Exception {

    /**
     * Creates a new instance of <code>DatosIncorrectosEX</code> without detail
     * message.
     */
    public DatosIncorrectosEX() {
    }

    /**
     * Constructs an instance of <code>DatosIncorrectosEX</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DatosIncorrectosEX(String msg) {
        super(msg);
    }
}
