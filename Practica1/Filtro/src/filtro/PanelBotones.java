/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filtro;

/**
 *
 * @author juanfrandm98
 */
public class PanelBotones extends javax.swing.JFrame {

    /** Creates new form OtroPanelBotones */
    public PanelBotones() {
        initComponents();
        
        estado = EstadoMotor.APAGADO;
        botonAcelerar.setEnabled(false);
        botonFrenar.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqEstado = new javax.swing.JLabel();
        botonEncender = new javax.swing.JButton();
        botonAcelerar = new javax.swing.JToggleButton();
        botonFrenar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        etiqEstado.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        etiqEstado.setText("APAGADO");

        botonEncender.setText("Encender");
        botonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncenderActionPerformed(evt);
            }
        });

        botonAcelerar.setText("Acelerar");
        botonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAcelerarActionPerformed(evt);
            }
        });

        botonFrenar.setText("Frenar");
        botonFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqEstado)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAcelerar)))
                .addGap(18, 18, 18)
                .addComponent(botonFrenar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(etiqEstado)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAcelerar)
                    .addComponent(botonFrenar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private EstadoMotor estado;
    private SalpicaderoObjetivo salpicadero;
    
    public EstadoMotor getEstado() { return estado; }
    
    public void aniadirSalpicadero( SalpicaderoObjetivo salpicadero ) {
        this.salpicadero = salpicadero;
    }
    
    private void botonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncenderActionPerformed
        
        if( estado == EstadoMotor.APAGADO ) {
            
            // Cambiamos el estado
            estado = EstadoMotor.ENCENDIDO;
            
            // Activamos los pedales
            botonAcelerar.setEnabled( true );
            botonFrenar.setEnabled( true );
            
            // Modificamos el botón de Encender
            botonEncender.setText( "Apagar" );
            
        } else {
            
            // Cambiamos el estado
            botonEncender.setText( "Encender" );
            estado = EstadoMotor.APAGADO;
            
            // Desactivamos los pedales
            botonAcelerar.setEnabled( false );
            botonFrenar.setEnabled( false );
            botonAcelerar.setSelected(false);
            botonFrenar.setSelected(false);
            
            // Reiniciamos el cuentakilómetros
            salpicadero.reiniciarKM();
            
            // Modificamos el botón de Encender
            botonEncender.setText( "Encender" );
            
        }
        
        etiqEstado.setText( estado.toString() );
        
    }//GEN-LAST:event_botonEncenderActionPerformed

    private void botonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAcelerarActionPerformed

        if( estado == EstadoMotor.ACELERANDO )
            estado = EstadoMotor.ENCENDIDO;         
        else {
            estado = EstadoMotor.ACELERANDO;
            botonFrenar.setSelected( false );
        }
        
        etiqEstado.setText( estado.toString() );
            }//GEN-LAST:event_botonAcelerarActionPerformed

    private void botonFrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFrenarActionPerformed

        if( estado == EstadoMotor.FRENANDO )
            estado = EstadoMotor.ENCENDIDO;
        else {
            estado = EstadoMotor.FRENANDO;
            botonAcelerar.setSelected( false );
        }
        
        etiqEstado.setText( estado.toString() );
            }//GEN-LAST:event_botonFrenarActionPerformed

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
            java.util.logging.Logger.getLogger(PanelBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelBotones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonAcelerar;
    private javax.swing.JButton botonEncender;
    private javax.swing.JToggleButton botonFrenar;
    private javax.swing.JLabel etiqEstado;
    // End of variables declaration//GEN-END:variables

}