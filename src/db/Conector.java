/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.*;
import java.sql.*;
import java.util.Iterator;

/**
 *
 * @author alumno1718
 */
public class Conector {

    private static final String url = "jdbc:sqlite:veterinario.db";
    private static PreparedStatement st;

    /**
     * Configura el conector y la base de datos. En caso de que no exista el
     * fichero de la base de datos SQLite, crea el archivo y la estructura de la
     * base de datos correspondiente.
     *
     * @return Devuelve el conector con los parámetros de conexión
     * @throws java.sql.SQLException
     * @throws IOException
     */
    public static Connection getConexion() throws SQLException, IOException {
        File db = new File("veterinario.db");
        if (!db.exists()) {
            db.createNewFile();
            configuraDB();
        }
        return DriverManager.getConnection(url);
    }

    /**
     * Lee un fichero de script y devuelve el contenido
     *
     * @param script el nombre del script. Tiene que ser uno de los scripts que
     * se encuentran en la enumeración
     * @see db.Scripts
     * @return El contenido del fichero del script
     * @throws FileNotFoundException Si el fichero no existe
     */
    static String leerScript(String script) throws FileNotFoundException {
        String contenido = "";
        File archivo = new File(script);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El script especificado no existe");
        }
        BufferedReader br = new BufferedReader(new FileReader("sql/" + script));
        for (Iterator iterator = br.lines().iterator(); iterator.hasNext();) {
            contenido += iterator.next() + "\n";
        }
        return contenido;
    }

    static void cierraConexion(Statement st, ResultSet rs, Connection con) throws SQLException {
        if (st != null) {
            st.close();
        }
        if (rs != null) {
            rs.close();
        }
        if (con != null) {
            con.close();
        }
    }

    /**
     * Configura el fichero de la base de datos con la estructura de datos
     * diseñada
     *
     * @throws SQLException Si da un error a la hora de ejecutar el script
     * @throws IOException Si el fichero de la base de datos tiene algún tipo de
     * error
     */
    private static void configuraDB() throws SQLException, IOException {
        Connection conexion = getConexion();
        st = conexion.prepareStatement("");
        st.executeUpdate(Scripts.CREA_DB.script());
        cierraConexion(st, null, conexion);
    }

}
