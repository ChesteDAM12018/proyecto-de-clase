/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.DatosTrabajador;

/**
 *
 * @author ruben
 */
public class DatosTrabLOG implements ActionListener{

    private DatosTrabajador ventana;

    public DatosTrabLOG(Frame parent) {
        ventana = new DatosTrabajador(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(parent);
        ventana.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Validar":
                ventana.dispose();
                break;
            case "Cancelar":
                ventana.dispose();
                break;
        }
    }
    
}
