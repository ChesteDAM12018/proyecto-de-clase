/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Nico Tena
 */
public class DNI {

    public static boolean esDNI(String dni) {
        if (dni.length() != 9) {
            return false;
        }
        String[] elDni = dni.split("");
        int c;
        for (int i = 0; i < elDni.length - 1; i++) {
            try {
                Integer.parseInt(elDni[i]);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}
