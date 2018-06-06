/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import db.EmpleadoDB;
import excepciones.DatosIncorrectosEX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import vista.VentanaP;

/**
 *
 * @author ruben
 */
public class VentanaLOG implements ActionListener {

    private VentanaP ventana;
    private VentanaLOGctr ctl;
    private String dni;

    public VentanaLOG() {
        ventana = new VentanaP();
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "Validar":
                    dni = ventana.getDni();
                    if (EmpleadoDB.getEmpleado(dni) != null) {
                        ctl = new VentanaLOGctr(ventana);
                    } else {
                        ventana.error("El DNI no corresponde con el de ningún empleado");
                    }
                    System.out.println(dni);
                    break;
                case "Cancelar":
                    System.exit(0);
                    break;
            }
        } catch (SQLException sQLException) {
        } catch (IOException iOException) {
        } catch (DatosIncorrectosEX ex) {
            ventana.error(ex.getMessage());
        }
    }

}
