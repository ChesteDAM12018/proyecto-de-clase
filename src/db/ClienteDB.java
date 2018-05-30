package db;

import excepciones.DatosIncorrectosEX;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oovv.Cliente;
import util.Archivos;
import util.DNI;

/**
 * Clase que controla las funciones de la base de datos a nivel clientes.
 * <b>Clase no funcional, requiere que la clase Cliente exista.</b>
 *
 * @see oovv.Cliente
 * @version 1.0
 * @author Nico Tena
 */
public class ClienteDB {

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
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.NUEVO_CLIENTE.script()));
        st.setString(1, cliente.getDNI());
        st.setString(2, cliente.getNombre());
        st.setString(3, cliente.getApellidos());
        st.setString(4, cliente.getTelefono());
        st.setString(5, cliente.getDireccion());
        st.setString(6, cliente.getCorreo());
        st.executeUpdate();
        st.close();
        conector.cierraConector();
    }

    /**
     * Obtiene un cliente de la base de datos.
     *
     * @param dni el DNI del cliente que se quiere obtener
     * @return Un objeto Cliente con todos los datos obtenidos de la base de
     * datos o null si no existe el cliente
     * @throws SQLException Si existe algún problema a la hora de conectar con
     * la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     * @throws excepciones.DatosIncorrectosEX Si los datos que ha dado la base
     * de datos son incorrectos
     */
    public static Cliente getCliente(String dni) throws SQLException, IOException, DatosIncorrectosEX {
        if (!DNI.esDNI(dni)) {
            throw new DatosIncorrectosEX("El dni debe tener 8 números y 1 letra");
        }
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.OBTENER_CLIENTE.script()));
        st.setString(1, dni);
        ResultSet rs = st.executeQuery();
        rs.next();
        Cliente cliente;
        if (rs.getRow() == 1) {
            cliente = new Cliente(dni, rs.getString("nombre"), rs.getString("apellidos"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"));
        } else {
            cliente = null;
        }
        rs.close();
        st.close();
        conector.cierraConector();
        return cliente;
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
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.MODIFICA_CLIENTE.script()));
        st.setString(1, clientemod.getNombre());
        st.setString(2, clientemod.getApellidos());
        st.setString(3, clientemod.getTelefono());
        st.setString(4, clientemod.getDireccion());
        st.setString(5, clientemod.getCorreo());
        st.setString(6, clientemod.getDNI());
        st.executeUpdate();
        st.close();
        conector.cierraConector();
    }

    /**
     * Obtiene una lista de todos los clientes registrados en la base de datos.
     *
     * @return Una lista de todos los clientes.
     * @throws SQLException Si existe algún problema a la hora de conectar con
     * la base de datos.
     * @throws IOException Si existe algún problema con el fichero de la base de
     * datos
     * @throws excepciones.DatosIncorrectosEX
     */
    public static List<Cliente> getClientes() throws SQLException, IOException, DatosIncorrectosEX {
        Conector conector = new Conector(BasesDeDatos.PRUEBAS);
        PreparedStatement st = conector.getConexion().prepareStatement(Archivos.leerScript(Scripts.OBTENER_CLIENTES.script()));
        ResultSet rs = st.executeQuery();
        List<Cliente> losClientes = new ArrayList<>();
        while (rs.next()) {
            losClientes.add(new Cliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo")));
        }
        rs.close();
        st.close();
        conector.cierraConector();
        return losClientes;
    }

}
