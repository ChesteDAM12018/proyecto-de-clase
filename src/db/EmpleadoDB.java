package db;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oovv.Cliente;
import oovv.Empleado;
import util.Archivos;

/**
 *
 * @author alumno1718
 */
public class EmpleadoDB {

    /**
     * Añade el empleado pasado como parámetro a la base de datos.
     *
     * @param empleado el empleado con sus datos.
     * @throws SQLException Si alguno de los campos del cliente no cumple las
     * condiciones de la base de datos o si existe algún problema a la hora de
     * conectar con la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     */
    public static void añadeEmpleado(Empleado empleado) throws SQLException, IOException {
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.NUEVO_CLIENTE.script()));
        st.setString(1, empleado.getDNI());
        st.setString(2, empleado.getNombre());
        st.setString(3, empleado.getApellidos());
        st.setString(4, empleado.getTelefono());
        st.setDouble(5, empleado.getSueldo());
        st.setString(6, empleado.getEmpleo().getEmpleo());
        st.executeUpdate();
        st.close();
        conector.cierraConector();
    }
}
