package oovv;

import excepciones.DatosIncorrectosEX;
import util.DNI;

public class Empleado extends Persona{

    private double sueldo;
    private Empleo empleo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, String DNI, String telefono, double sueldo) throws DatosIncorrectosEX {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.sueldo = sueldo;
        
    }

    public Empleado(String nombre, String apellidos, String dni, String telefono, double sueldo, Empleo empleo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = dni;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.empleo = empleo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Empleo getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = Empleo.valueOf(nombre);
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setEmpleo(Empleo empleo) {
        this.empleo = empleo;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

}
