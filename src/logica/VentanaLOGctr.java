/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.time.Clock.system;
import javax.swing.JOptionPane;
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

    public VentanaLOGctr(Frame parent) {
        this.parent = parent;
        ventana = new Ventanactr(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "añadir":
                if (ventana.getControl().equals("cliente")) {
                    cliDatos = new DatosClienteLOG(parent);
                }
                if (ventana.getControl().equals("trabajador")) {
                    datosTrab = new DatosEmpleadoLOG(parent);
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

    }

}
