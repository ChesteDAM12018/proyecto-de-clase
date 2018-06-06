/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.DatosIncorrectosEX;
import excepciones.DniIncorrectoEX;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import oovv.Empleado;
import util.DNI;
import vista.DatosEmpleado;
import vista.Selecciona;

/**
 *
 * @author ruben
 */
public class DatosEmpleadoLOG implements ActionListener {
    
    private DatosEmpleado ventana;
    private Empleado empleado;
    private boolean estadoVentana;
    
    public DatosEmpleadoLOG(Frame parent) {
        estadoVentana = true;
        ventana = new DatosEmpleado(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(parent);
        ventana.setVisible(true);
    }
    
    DatosEmpleadoLOG(JDialog parent, Empleado empleadoSeleccionado) {
        estadoVentana = false;
        this.empleado = empleadoSeleccionado;
        ventana = new DatosEmpleado(parent, true);
        ventana.setValores(empleadoSeleccionado);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(parent);
        ventana.setVisible(true);
    }
    
    public Empleado getEmpleado() {
        if (empleado != null) {
            return empleado;
        } else {
            return null;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "Validar":
                    if (estadoVentana) {
                        String nombre = ventana.getNombre();
                        String apellidos = ventana.getApellidos();
                        String dni = ventana.getDNI();
                        double sueldo = ventana.getSueldo();
                        String empleo = ventana.getEmpleo();
                        // LocalDate contrato = ventana.getCOntrato();
                        String telefono = ventana.gettelefono();
                        
                        boolean dniCorrecto = DNI.esDNI(dni);
                        
                        if (nombre != null && apellidos != null && empleo != null && dniCorrecto && sueldo > 0 && telefono != null) {
                            empleado = new Empleado(nombre, apellidos, dni, telefono, sueldo);
                            empleado.setEmpleo(empleo);
                        }
                    } else {
                        empleado.setNombre(ventana.getNombre());
                        empleado.setApellidos(ventana.getApellidos());
                        empleado.setDNI(ventana.getDNI());
                        empleado.setSueldo(ventana.getSueldo());
                        empleado.setTelefono(ventana.gettelefono());
                        boolean dniCorrecto = DNI.esDNI(ventana.getDNI());
                        if (dniCorrecto) {
                            empleado.setDNI(ventana.getDNI());
                        }
                        empleado.setEmpleo(ventana.getEmpleo());
                        
                    }
                    ventana.dispose();
                    break;
                case "Cancelar":
                    ventana.dispose();
                    break;
            }
        } catch (DniIncorrectoEX dniIncorrectoEX) {
            JOptionPane.showMessageDialog(ventana, dniIncorrectoEX.getMessage());
        } catch (DatosIncorrectosEX datosIncorrectosEX) {
            JOptionPane.showMessageDialog(ventana, "No pueden haber campos vacios");
            
        }
    }
    
}
