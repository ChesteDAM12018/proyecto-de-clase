/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.DatosClientev;

/**
 *
 * @author ruben
 */
public class DatosLog implements ActionListener {

    private DatosClientev ventana;
    private Frame parent;

    public DatosLog(Frame parent) {
        this.parent = parent;
        ventana = new DatosClientev(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "validar":
                
                ventana.dispose();
                break;
            case "cancelar":
                
                ventana.dispose();
                break;
        }
    }

}
