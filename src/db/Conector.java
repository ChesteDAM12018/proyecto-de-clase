/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Archivos;

/**
 *
 * @author alumno1718
 */
public class Conector {

    private static Connection conexion;
    private static final String urlpruebas = "jdbc:sqlite:veterinario.db";
    private static final String urlfinal = "jdbc:mysql://sargantanacode.es:3306/damcheste?serverTimezone=UTC";
    private static final String usuario = "damcheste";
    private static final String contraseña = "@lumn0";

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
                File db = new File("veterinario.db");
                if (!db.exists()) {
                    db.createNewFile();
                    this.conexion = DriverManager.getConnection(this.urlpruebas);
                    this.configuraDB();
                } else {
                    this.conexion = DriverManager.getConnection(this.urlpruebas);
                }
                break;
            case FINAL:
                this.conexion = DriverManager.getConnection(this.urlfinal, this.usuario, this.contraseña);
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
        PreparedStatement st = this.conexion.prepareStatement(Archivos.leerScript(Scripts.CREA_DB.script()));
        st.executeUpdate();
        st.close();
    }

}
