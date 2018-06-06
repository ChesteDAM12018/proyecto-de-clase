/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.DatosDNI;

/**
 *
 * @author ruben
 */
public class DatosDniLOG implements ActionListener {

    private DatosDNI ventana;
    private VentanaLOGctr ctl;
    private String dni;

    public DatosDniLOG() {
        ventana = new DatosDNI();
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Validar":
                    dni = ventana.getDni();
            //        ctl = new VentanaLOGctr(ventana);
                    System.out.println(dni);
                    System.exit(0);
                break;
            case "Cancelar":
                    System.exit(0);
                break;
        }
    }

}
