package oovv;

import excepciones.DatosIncorrectosEX;
import util.DNI;

public class Empleado {

    private String nombre;
    private String apellidos;
    private String DNI;
    private String telefono;
    private double sueldo;
    private Empleo empleo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, String DNI, String telefono,
            double sueldo, Empleo empleo) throws DatosIncorrectosEX {
        DNI DNIValido = new DNI();
        if (!DNIValido.esDNI(this.DNI)) {
            throw new DatosIncorrectosEX("El DNI introducido no es un DNI válido");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
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

}
