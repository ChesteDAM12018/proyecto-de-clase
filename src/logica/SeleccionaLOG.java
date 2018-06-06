/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.DatosIncorrectosEX;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import oovv.Cliente;
import oovv.Empleado;
import vista.Selecciona;

/**
 *
 * @author alumno1718
 */
public class SeleccionaLOG implements ActionListener {

    private Selecciona ventana;
   
    private boolean esCliente;
            
    public SeleccionaLOG(Frame parent, boolean esCliente) throws SQLException, DatosIncorrectosEX, IOException {
        this.esCliente = esCliente;
        if (esCliente) {
            ventana.esCliente();
        } else {
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
                if(esCliente){
                    
                    new DatosClienteLOG(ventana, ventana.getClienteSeleccionado());
                }else{
                    
                    new DatosEmpleadoLOG(ventana, ventana.getEmpleadoSeleccionado());
                }
                    
                break;
        }
    }

}
