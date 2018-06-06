package db;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Archivos;

/**
 * Clase para conectar a la base de datos
 *
 * @author Nico Tena, Alvaro
 */
public class Conector {

    private Connection conexion;
    private static final String JDBC_URLPRUEBAS = "jdbc:sqlite:veterinario.db";
    private static final String JDBC_URLFINAL = "jdbc:mysql://sargantanacode.es:3306/damcheste?serverTimezone=UTC";
    private static final String JDBC_USUARIO = "damcheste";
    private static final String JDBC_CONTRASEÑA = "@lumn0";

    /**
     * Crea el conector. En caso de que no exista el fichero de la base de datos
     * SQLite, crea el archivo y la estructura de la base de datos
     * correspondiente.
     *
     * @param base Indica si e ha de crear el conector de pruebas o el final
     * @throws java.sql.SQLException
     * @throws IOException
     */
    public Conector(BasesDeDatos base) throws SQLException, IOException {
        switch (base) {
            case PRUEBAS:
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
                }
                Boolean faltadb = !(new File("veterinario.db").exists());
                this.conexion = DriverManager.getConnection(Conector.JDBC_URLPRUEBAS);
                if (faltadb) {
                    this.configuraDB();
                }
                break;
            case FINAL:
                this.conexion = DriverManager.getConnection(Conector.JDBC_URLFINAL, Conector.JDBC_USUARIO, Conector.JDBC_CONTRASEÑA);
        }
    }

    /**
     * Getter para la conexion que se crea al crear el conector
     *
     * @return Una conexion de la clase Connection
     */
    public Connection getConexion() {
        return this.conexion;
    }

    /**
     * Cierra la conexion que se crea al crear el objeto
     *
     * @throws SQLException Si da error al cerrar la conexion
     */
    public void cierraConector() throws SQLException {
        this.conexion.close();
    }

    /**
     * Configura el fichero de la base de datos con la estructura de datos
     * diseñada
     *
     * @throws SQLException Si da un error a la hora de ejecutar el script
     * @throws IOException Si el fichero de la base de datos tiene algún tipo de
     * error
     */
    private void configuraDB() throws SQLException, IOException {
        Statement st = this.conexion.createStatement();
        st.executeUpdate(Archivos.leerScript(Scripts.CREAR_DB));
        st.close();
    }

}
