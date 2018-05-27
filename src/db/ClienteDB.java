package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oovv.Cliente;
import util.DNI;

/**
 * Clase que controla las funciones de la base de datos a nivel clientes.
 * <b>Clase no funcional, requiere que la clase Cliente exista.</b>
 *
 * @see oovv.Cliente
 * @version 1.0
 * @author Nico Tena
 */
public class ClienteDB extends Conector {

    private static PreparedStatement st;
    private static ResultSet rs;
    private static Connection conexion;

    /**
     * Añade el cliente pasado como parámetro a la base de datos.
     *
     * @param cliente el cliente con sus datos.
     * @throws SQLException Si alguno de los campos del cliente no cumple las
     * condiciones de la base de datos o si existe algún problema a la hora de
     * conectar con la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     */
    public static void añadeCliente(Cliente cliente) throws SQLException, IOException {
        conexion = Conector.getConexion();
        st = conexion.prepareStatement(Scripts.NUEVO_CLIENTE.script());
        st.setString(1, cliente.getDNI());
        st.setString(2, cliente.getNombre());
        st.setString(3, cliente.getApellidos());
        st.setString(4, cliente.getTelefono());
        st.setString(5, cliente.getDireccion());
        st.setString(6, cliente.getCorreo());
        st.executeUpdate();
        cierraConexion(st, rs, conexion);
    }

    /**
     * Obtiene un cliente de la base de datos.
     *
     * @param dni el DNI del cliente que se quiere obtener
     * @return Un objeto Cliente con todos los datos obtenidos de la base de
     * datos.
     * @throws SQLException Si existe algún problema a la hora de conectar con
     * la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     */
    public static Cliente getCliente(String dni) throws SQLException, IOException {
        if (!DNI.esDNI(dni)) {
            throw new SQLException("El dni debe tener 8 números y 1 letra");
        }
        conexion = getConexion();
        st = conexion.prepareStatement(Scripts.OBTENER_CLIENTE.script());
        st.setString(1, dni);
        rs = st.executeQuery();
        rs.next();
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        return new Cliente(dni, nombre, apellidos, direccion, telefono, correo);
    }

    /**
     * Modifica los datos del cliente en la base de datos.
     *
     * @param clientemod cliente con los datos modificados.
     * @throws SQLException Si existe algún error a la hora de actualizar los
     * datos en la base de datos
     * @throws java.io.IOException
     */
    public static void modificaCliente(Cliente clientemod) throws SQLException, IOException {
        conexion = getConexion();
        st = conexion.prepareStatement(Scripts.MODIFICA_CLIENTE.script());
        st.setString(1, clientemod.getNombre());
        st.setString(2, clientemod.getApellidos());
        st.setString(3, clientemod.getTelefono());
        st.setString(4, clientemod.getDireccion());
        st.setString(5, clientemod.getCorreo());
        st.executeUpdate();
        cierraConexion(st, rs, conexion);
    }

    /**
     * Obtiene una lista de todos los clientes registrados en la base de datos.
     *
     * @return Una lista de todos los clientes.
     * @throws SQLException Si existe algún problema a la hora de conectar con
     * la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     */
    public static List<Cliente> getClientes() throws SQLException, IOException {
        List<Cliente> losClientes = new ArrayList<>();
        conexion = getConexion();
        st = conexion.prepareStatement(Scripts.OBTENER_CLIENTES.script());
        rs = st.executeQuery();
        while (rs.next()) {
            Cliente c;
            String dni = rs.getString("dni");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String direccion = rs.getString("direccion");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");
            c = new Cliente(dni, nombre, apellidos, direccion, telefono, correo);
            losClientes.add(c);
        }
        return losClientes;
    }

}
