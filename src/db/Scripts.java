/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 * @author Nico Tena
 * Enumeración con los posibles scripts que pueden lanzarse a la base de datos
 */
public enum Scripts {

    CREA_DB("creacion.sql"),
    NUEVO_CLIENTE("nuevocliente.sql"),
    MODIFICA_CLIENTE("modificacliente.sql"),
    OBTENER_CLIENTE("obtenercliente.sql"), 
    OBTENER_CLIENTES("listaclientes.sql"),
    NUEVO_EMPLEADO("nuevoempleado.sql");
    private final String fichero;

    private Scripts(String fichero) {
        this.fichero = fichero;
    }

    /**
     * Método que obtiene el nombre del fichero del script seleccionado en la
     * enumeración
     *
     * @return nombre del fichero
     */
    public String script() {
        return fichero;
    }

}
