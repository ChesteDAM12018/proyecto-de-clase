/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionListener;
import logica.DatosLog;
import logica.DatosTrabLOG;

/**
 *
 * @author ruben
 */
public class DatosTrabajador extends javax.swing.JDialog {

    /**
     * Creates new form DatosTrabajador
     */
    public DatosTrabajador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSueldo = new javax.swing.JTextField();
        jContrato = new javax.swing.JTextField();
        jDNI = new javax.swing.JTextField();
        jTeléfono = new javax.swing.JTextField();
        jTipo = new javax.swing.JTextField();
        bNombre = new javax.swing.JLabel();
        bApellidos = new javax.swing.JLabel();
        bDNI = new javax.swing.JLabel();
        bTeléfono = new javax.swing.JLabel();
        bTipo = new javax.swing.JLabel();
        bSueldo = new javax.swing.JLabel();
        bContrato = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        jApellidos = new javax.swing.JTextField();
        ValidarB = new javax.swing.JButton();
        CancelarB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSueldo.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N

        jContrato.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N

        jDNI.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N

        jTeléfono.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N

        jTipo.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N

        bNombre.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bNombre.setText("Nombre");

        bApellidos.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bApellidos.setText("Apellidos");

        bDNI.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bDNI.setText("DNI");

        bTeléfono.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bTeléfono.setText("Teléfono");

        bTipo.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bTipo.setText("Tipo");

        bSueldo.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bSueldo.setText("Sueldo");

        bContrato.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        bContrato.setText("Expiracion de contrato");

        jNombre.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        jNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNombreActionPerformed(evt);
            }
        });

        jApellidos.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N

        ValidarB.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        ValidarB.setText("Validar");

        CancelarB.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        CancelarB.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ValidarB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(CancelarB))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bNombre)
                            .addComponent(bApellidos)
                            .addComponent(bDNI)
                            .addComponent(bSueldo)
                            .addComponent(bTeléfono)
                            .addComponent(bTipo)
                            .addComponent(bContrato))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTeléfono, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jDNI)
                            .addComponent(jApellidos)
                            .addComponent(jNombre)
                            .addComponent(jTipo)
                            .addComponent(jSueldo)
                            .addComponent(jContrato))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bNombre))
                    .addComponent(jNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bApellidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bDNI))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bTeléfono))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bTipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bSueldo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bContrato)
                    .addComponent(jContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValidarB)
                    .addComponent(CancelarB))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNombreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatosTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DatosTrabajador dialog = new DatosTrabajador(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarB;
    private javax.swing.JButton ValidarB;
    private javax.swing.JLabel bApellidos;
    private javax.swing.JLabel bContrato;
    private javax.swing.JLabel bDNI;
    private javax.swing.JLabel bNombre;
    private javax.swing.JLabel bSueldo;
    private javax.swing.JLabel bTeléfono;
    private javax.swing.JLabel bTipo;
    private javax.swing.JTextField jApellidos;
    private javax.swing.JTextField jContrato;
    private javax.swing.JTextField jDNI;
    private javax.swing.JTextField jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jSueldo;
    private javax.swing.JTextField jTeléfono;
    private javax.swing.JTextField jTipo;
    // End of variables declaration//GEN-END:variables
    
    public String getNombre() {
        return jNombre.getText();

    }

    public String getApellidos() {
        return jApellidos.getText();
    }

    public String getDNI() {
        return jDNI.getText();
    }

    public String getTipo() {
        return jTipo.getText();
    }

    public int gettelefono() {
        return Integer.parseInt(jTeléfono.getText());
    }

    public String getSueldo() {
        return jSueldo.getText();
    }
    
    public String getCOntrato() {
        return jContrato.getText();
    }

    public void setOyente(DatosTrabLOG oyente) {
        ValidarB.addActionListener(oyente);
        CancelarB.addActionListener(oyente);
    }

}


