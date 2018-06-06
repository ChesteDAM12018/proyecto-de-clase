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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import oovv.Cliente;
import util.DNI;
import vista.DatosCliente;
import vista.Selecciona;

/**
 *
 * @author ruben
 */
public class DatosClienteLOG implements ActionListener {

    private DatosCliente ventana;
    private Cliente cliente;

    public DatosClienteLOG(Frame parent) {

        ventana = new DatosCliente(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);
    }

    public DatosClienteLOG(JDialog parent, Cliente clienteSeleccionado) {
        
        ventana = new DatosCliente(parent, true);
        ventana.setValores(clienteSeleccionado);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);
        
        
    }

    public Cliente getCliente() {
        if (cliente != null) {
            return cliente;
        } else {
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "validar":
                    String nombre = ventana.getnombre();
                    String apellidos = ventana.getapellidos();
                    String telefono = ventana.gettelefono();
                    String direccion = ventana.getdireccion();
                    String dni = ventana.getdni();
                    String correo = ventana.getcorreo();
                    boolean dniCorrecto = DNI.esDNI(dni);
                    if (nombre != null && apellidos != null && telefono != null && direccion != null && correo != null && dniCorrecto) {
                        cliente = new Cliente(dni, nombre, apellidos, direccion, telefono, correo);
                    }
                    ventana.dispose();
                    break;
                case "cancelar":

                    ventana.dispose();
                    break;
            }
        } catch (DatosIncorrectosEX datosIncorrectosEX) {
            JOptionPane.showMessageDialog(ventana, "No puede haber campos vacios");
        } catch (DniIncorrectoEX ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage());
        }
    }

}
