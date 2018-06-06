package util;

import excepciones.DniIncorrectoEX;

/**
 * Clase para funciones relacionadas con el dni
 *
 * @author Alvaro
 */
public class DNI {

    /**
     * Letras posibles del dni en el orden adecuado para usarlas
     */
    private static final Character[] DNI_LETRAS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    /**
     * Comprueba si un dni es valido o no
     *
     * @param dni El dni que se quiere validar
     * @return Verdadero si es valido falso si no es valido
     */
    public static boolean esDNI(String dni) throws DniIncorrectoEX {

        if (!dni.matches("(?i)[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]") && calcularLetra(Integer.parseInt(dni.substring(0, 8))).equals(dni.charAt(8))) {
            throw new DniIncorrectoEX("El DNI deben ser 8 cifras y una letra");

        } else {
            return true;
        }

    }

    /**
     * Devuelve la letra que corresponde a ese numero
     *
     * @param numero El numero del que se quiere calcular la letra, es un numero
     * entre 0 y 99999999
     * @throws IllegalArgumentException Cuando el numero no esta entre 0 y
     * 99999999
     * @return La letra que corresponde a ese numero
     */
    public static Character calcularLetra(Integer numero) throws IllegalArgumentException {
        if (numero > 0 && numero < 99999999) {
            return DNI_LETRAS[numero % 23];
        } else {
            throw new IllegalArgumentException("No se puede calcular laletra de ese numero");
        }
    }
}
