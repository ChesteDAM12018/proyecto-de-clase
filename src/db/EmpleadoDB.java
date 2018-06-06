package db;

import excepciones.DatosIncorrectosEX;
import excepciones.DniIncorrectoEX;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oovv.Empleado;
import oovv.Empleo;
import util.Archivos;
import util.DNI;

/**
 * Clase que controla las funciones de la base de datos a nivel empleados.
 * <b>Clase no funcional, requiere que la clase Empleado exista.</b>
 *
 * @see oovv.Empleado
 * @version 1.0
 * @author Alvaro
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
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.NUEVO_EMPLEADO));
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
    public static Empleado getEmpleado(String dni) throws SQLException, IOException, DatosIncorrectosEX, DniIncorrectoEX {
        if (!DNI.esDNI(dni)) {
            throw new DniIncorrectoEX("El dni debe tener 8 números y 1 letra");
        }
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.OBTENER_EMPLEADO));
        st.setString(1, dni);
        ResultSet rs = st.executeQuery();
        Empleado empleado;
        if (rs.next()) {
            empleado = new Empleado(rs.getString("nombre"), rs.getString("apellidos"), dni, rs.getString("telefono"), rs.getDouble("sueldo"), Empleo.valueOf(rs.getString("tipo")));
        } else {
            empleado = null;
        }
        rs.close();
        st.close();
        conector.cierraConector();
        return empleado;
    }

    /**
     * Modifica los datos del cliente en la base de datos.
     *
     * @param empleadomod cliente con los datos a modificar.
     * @throws SQLException Si existe algún error a la hora de actualizar los
     * datos en la base de datos
     * @throws java.io.IOException
     */
    public static void modificaEmpleado(Empleado empleadomod) throws SQLException, IOException {
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.MODIFICA_EMPLEADO));
        st.setString(1, empleadomod.getNombre());
        st.setString(2, empleadomod.getApellidos());
        st.setString(3, empleadomod.getTelefono());
        st.setDouble(4, empleadomod.getSueldo());
        st.setString(5, empleadomod.getEmpleo().getEmpleo());
        st.setString(6, empleadomod.getDNI());
        st.executeUpdate();
        st.close();
        conector.cierraConector();
    }

    /**
     * Obtiene una lista de todos los empleados registrados en la base de datos.
     *
     * @return Una lista de todos los empleados.
     * @throws SQLException Si existe algún problema a la hora de conectar con
     * la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     * @throws excepciones.DatosIncorrectosEX Si los datos recibidos de la base
     * de datos no son validos
     */
    public static List<Empleado> getEmpleados() throws SQLException, IOException, DatosIncorrectosEX {
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.OBTENER_EMPLEADOS));
        ResultSet rs = st.executeQuery();
        List<Empleado> losEmpleados = new ArrayList<>();
        while (rs.next()) {
            losEmpleados.add(new Empleado(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("telefono"), rs.getDouble("sueldo"), Empleo.valueOf(rs.getString("tipo"))));
        }
        rs.close();
        st.close();
        conector.cierraConector();
        return losEmpleados;
    }
}
