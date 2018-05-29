/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

/**
 *
 * @author Alvaro
 */
public class Archivos {

    /**
     * Lee un script y devuelve el contenido
     *
     * @param script el nombre del script. Tiene que ser uno de los scripts que
     * se encuentran en la enumeración
     * @see db.Scripts
     * @return El contenido del fichero del script
     * @throws FileNotFoundException Si el script no existe
     */
    public static String leerScript(String script) throws FileNotFoundException {
        return leerArchivo("sql/" + script);
    }

    /**
     * Lee un fichero y devuelve el contenido
     *
     * @param nomarchivo el nombre del archivo.
     * @return El contenido del fichero
     * @throws FileNotFoundException Si el fichero no existe
     */
    public static String leerArchivo(String nomarchivo) throws FileNotFoundException {
        File archivo = new File(nomarchivo);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo especificado no existe");
        }
        BufferedReader br = new BufferedReader(new FileReader(nomarchivo));
        StringBuilder sb = new StringBuilder();
        for (Iterator iterator = br.lines().iterator(); iterator.hasNext();) {
            sb.append(iterator.next());
            sb.append("\n");
        }
        return sb.toString();
    }
}
