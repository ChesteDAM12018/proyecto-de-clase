/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Selecciona;

/**
 *
 * @author alumno1718
 */
public class SeleccionaLOG implements ActionListener{

    private Selecciona ventana;
    private Frame parent;

    public SeleccionaLOG(Frame parent,boolean esCliente) {
        if(esCliente=true){
            ventana.esCliente();
        }else{
            ventana.esEmpleado();
        }
        ventana = new Selecciona(parent, true);
        ventana.setOyente(this);
        ventana.setLocationRelativeTo(parent);
        ventana.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Buscar":
                String busqueda = ventana.getBusqueda();
                break;
            case "Cancelar":
                ventana.dispose();
                break;
            case "Seleccionar":
                
                break;
        }
    }
    
}
