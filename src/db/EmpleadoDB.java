package db;

import excepciones.DatosIncorrectosEX;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oovv.Empleado;
import oovv.Empleo;
import util.Archivos;
import util.DNI;

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
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.NUEVO_EMPLEADO.script()));
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

    /**
     * Obtiene un empleado de la base de datos.
     *
     * @param dni el DNI del empleado que se quiere obtener
     * @return Un objeto Empleado con todos los datos obtenidos de la base de
     * datos o null si no existe el empleado
     * @throws SQLException Si existe algún problema a la hora de conectar con
     * la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     * @throws excepciones.DatosIncorrectosEX Si los datos que se han pasado no
     * son validos
     */
    public static Empleado getEmpleado(String dni) throws SQLException, IOException, DatosIncorrectosEX {
        if (!DNI.esDNI(dni)) {
            throw new DatosIncorrectosEX("El dni debe tener 8 números y 1 letra");
        }
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.OBTENER_EMPLEADO.script()));
        st.setString(1, dni);
        ResultSet rs = st.executeQuery();
        rs.next();
        Empleado empleado;
        if (rs.getRow() == 1) {
            empleado = new Empleado(rs.getString("nombre"), rs.getString("apellidos"), dni, rs.getString("telefono"), rs.getDouble("sueldo"), Empleo.valueOf(rs.getString("tipo")));
        } else {
            empleado = null;
        }
        rs.close();
        st.close();
        conector.cierraConector();
        return empleado;
    }
}
