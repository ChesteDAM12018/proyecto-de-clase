/*

 */
package util;

import javax.swing.JOptionPane;

/**
 *
 * @author Nico Tena
 * @version 1.0
 */
public class Msj {

    /**
     * Lanza un mensaje de error al usuario
     *
     * @param mensaje el texto que se va a mostrar
     */
    public static void msjError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Lanza un mensaje de información al usuario
     *
     * @param mensaje el texto que se va a mostrar
     */
    public static void msjInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Lanza un mensaje de advertencia al usuario
     *
     * @param mensaje el texto que se va a mostrar
     */
    public static void msjAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.WARNING_MESSAGE);
    }
}
