package oovv;

import excepciones.DatosIncorrectosEX;
import util.DNI;

public class Cliente {

    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(String DNI, String nombre, String apellidos, String direccion,
            String telefono, String correo) throws DatosIncorrectosEX {
        DNI DNIValido = new DNI();
        if (!DNIValido.esDNI(this.DNI)) {
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
