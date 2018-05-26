/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

/**
 *
 * @author alumno1718
 */
public class Cliente {

    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(String DNI, String nombre, String apellidos, String direccion, String telefono, String correo) {
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
