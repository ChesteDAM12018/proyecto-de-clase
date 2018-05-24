package db;

import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Clase que permite realizar todas las acciones que requieran de una base de
 * datos, ya sea insertar datos eliminar datos obtener datos
 *
 * @author Nico Tena
 * @version 1.0
 */
public class Conector {

    private Connection conector;
    private ResultSet rs;
    private Statement st;
    private final String url;

    /**
     * Conector principal que define el archivo de la base de datos y configura
     * las conexiones.
     *
     * @throws java.sql.SQLException Si hay un problema a la hora de conectar o
     * desconectar con la base de datos.
     * @throws java.io.IOException Si hay un problema a la hora de abrir o
     * modificar el fichero que contiene la base de datos.
     */
    public Conector() throws SQLException, IOException {
        File db = new File("veterinario.db");
        if (!db.exists()) {
            generaDB(db);
        }
        url = "jdbc:sqlite:veterinario.db";
    }

    /**
     * Abre la conexión a la base de datos
     */
    private void conecta() throws SQLException {
        conector = DriverManager.getConnection(url);
    }

    /**
     * Cierra la conexion a la base de datos y limpia los objetos usados
     */
    private void desconecta() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
    }

    /**
     * Si el fichero .db no existe, se genera uno nuevo con todas las tablas
     * generadas
     *
     * @param db el fichero que contiene la base de datos
     */
    private void generaDB(File db) throws SQLException, IOException {
        String consulta = "";
        conecta();
        db.createNewFile();
        st = conector.createStatement();
        /**
         * Insertar código sql para la generación de las tablas
         */
        st.execute(consulta);
        desconecta();
    }
}
