/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.*;
import java.sql.*;
import util.Archivos;

/**
 *
 * @author alumno1718
 */
public class Conector {

    private static Connection conexion;

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
                File db = new File("veterinario.db");
                if (!db.exists()) {
                    db.createNewFile();
                    this.configuraDB();
                }
                this.conexion = DriverManager.getConnection("jdbc:sqlite:veterinario.db");
            case FINAL:
                this.conexion = DriverManager.getConnection("jdbc:mysql://sargantanacode.es:3306/damcheste?serverTimezone=UTC", "damcheste", "@lumn0");
        }
    }

    public Connection getConexion() {
        return this.conexion;
    }

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
        PreparedStatement st = this.conexion.prepareStatement("");
        st.executeUpdate(Archivos.leerScript(Scripts.CREA_DB.script()));
        st.close();
    }

}
