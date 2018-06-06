/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import db.ClienteDB;
import db.EmpleadoDB;
import excepciones.DatosIncorrectosEX;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oovv.Cliente;
import oovv.Empleado;
import vista.Selecciona;
import vista.Ventanactr;

/**
 *
 * @author ruben
 */
public class VentanaLOGctr implements ActionListener {

    private Ventanactr ventana;
    private DatosClienteLOG cliDatos;
    private SeleccionaLOG mod;
    private DatosEmpleadoLOG datosTrab;
    private String nelimina;
    private Frame parent;

    public VentanaLOGctr() {
        ventana = new Ventanactr(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "añadir":
                    if (ventana.getControl().equals("cliente")) {
                        cliDatos = new DatosClienteLOG(parent);
                        Cliente cliente = cliDatos.getCliente();
                        if (cliente != null) {
                            ClienteDB.añadeCliente(cliente);
                        }
                    }
                    if (ventana.getControl().equals("trabajador")) {
                        datosTrab = new DatosEmpleadoLOG(parent);
                        Empleado empleado = datosTrab.getEmpleado();
                        if (empleado != null) {
                            EmpleadoDB.añadeEmpleado(empleado);
                        }
                    }
                    
                    break;
                case "modificar":
                    if (ventana.getControl().equals("cliente")) {
                        mod = new SeleccionaLOG(parent, true);
                    }
                    if (ventana.getControl().equals("trabajador")) {
                        mod = new SeleccionaLOG(parent, false);
                    }
                    
                    break;
                case "eliminar":
                    if (ventana.getControl().equals("cliente")) {
                        nelimina = JOptionPane.showInputDialog(ventana, "Introduce el nombre del cliente a eliminar");
                    }
                    if (ventana.getControl().equals("trabajador")) {
                        nelimina = JOptionPane.showInputDialog(ventana, "Introduce el nombre del trabajador a eliminar");
                    }
                    break;
                case "listar":
                    
                    break;
                case "atras":
                    ventana.dispose();
                    break;
            }
        } catch (SQLException sQLException) {
        } catch (IOException iOException) {
        } catch (HeadlessException headlessException) {
        } catch (DatosIncorrectosEX ex) {
            Logger.getLogger(VentanaLOGctr.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
