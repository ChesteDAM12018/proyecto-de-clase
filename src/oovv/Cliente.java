package oovv;

import excepciones.DatosIncorrectosEX;

public class Cliente extends Persona{

    private String direccion;
    private String correo;

    public Cliente() {
    }

    public Cliente(String DNI, String nombre, String apellidos, String direccion,
            String telefono, String correo) throws DatosIncorrectosEX {
        if (!util.DNI.esDNI(DNI)) {
            throw new DatosIncorrectosEX("El DNI introducido no es un DNI válido");
        }
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

}
