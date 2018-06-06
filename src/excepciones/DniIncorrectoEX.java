/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author MAPACHEPRO
 */
public class DniIncorrectoEX extends Exception {

    /**
     * Creates a new instance of <code>DniIncorrectoEX</code> without detail
     * message.
     */
    public DniIncorrectoEX() {
    }

    /**
     * Constructs an instance of <code>DniIncorrectoEX</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DniIncorrectoEX(String msg) {
        super(msg);
    }
}
