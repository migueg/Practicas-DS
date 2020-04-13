/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Salpicadero.SalpicaderoObjetivo;
import Monitorizacion.GestorMonitores;
import java.awt.Color;

/**
 *
 * @author juanfrandm98
 */
public class PanelMonitorizacion extends javax.swing.JFrame {

    /**
     * Creates new form PanelMonitorizacion
     */
    public PanelMonitorizacion() {
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

        etiqTitulo = new javax.swing.JLabel();
        etiqTitulo1 = new javax.swing.JLabel();
        botonAceite = new javax.swing.JButton();
        botonGeneral = new javax.swing.JButton();
        botonFrenos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiqAceite = new javax.swing.JLabel();
        etiqFrenos = new javax.swing.JLabel();
        etiqGeneral = new javax.swing.JLabel();
        etiqTitulo2 = new javax.swing.JLabel();
        botonRepostar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        etiqGasolina = new javax.swing.JLabel();

        etiqTitulo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        etiqTitulo.setText("Salpicadero");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiqTitulo1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        etiqTitulo1.setText("Revisiones");

        botonAceite.setText("Revisar");
        botonAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceiteActionPerformed(evt);
            }
        });

        botonGeneral.setText("Revisar");
        botonGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGeneralActionPerformed(evt);
            }
        });

        botonFrenos.setText("Revisar");
        botonFrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrenosActionPerformed(evt);
            }
        });

        jLabel1.setText("Aceite:");

        jLabel2.setText("Frenos:");

        jLabel3.setText("General:");

        etiqAceite.setText("OK");

        etiqFrenos.setText("OK");

        etiqGeneral.setText("OK");

        etiqTitulo2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        etiqTitulo2.setText("Combustible");

        botonRepostar.setText("Repostar");
        botonRepostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRepostarActionPerformed(evt);
            }
        });

        jLabel4.setText("Combustible:");

        etiqGasolina.setText("100%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonFrenos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqGeneral)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiqFrenos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiqAceite)
                                .addGap(139, 139, 139)
                                .addComponent(botonRepostar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiqGasolina)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(etiqTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiqTitulo2)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqTitulo1)
                    .addComponent(etiqTitulo2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(etiqAceite)
                    .addComponent(botonRepostar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(etiqGasolina))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFrenos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(etiqFrenos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(etiqGeneral))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceiteActionPerformed
        salpicadero.revisarAceite();
    }//GEN-LAST:event_botonAceiteActionPerformed

    private void botonGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGeneralActionPerformed
        salpicadero.revisarGeneral();
    }//GEN-LAST:event_botonGeneralActionPerformed

    private void botonFrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFrenosActionPerformed
        salpicadero.revisarFrenos();
    }//GEN-LAST:event_botonFrenosActionPerformed

    private void botonRepostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRepostarActionPerformed
        gestor.repostar();
    }//GEN-LAST:event_botonRepostarActionPerformed

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
            java.util.logging.Logger.getLogger(PanelMonitorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelMonitorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelMonitorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelMonitorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelMonitorizacion().setVisible(true);
            }
        });
    }
    
    public void setSalpicadero( SalpicaderoObjetivo salpicadero ) {
        this.salpicadero = salpicadero;
    }
    
    public void setGestor( GestorMonitores gestor ) {
        this.gestor = gestor;
    }
    
    public void setMotorApagado( boolean apagado ) {     
        this.apagado = apagado;
    }
    
    public void setCapacidadGasolina( double capacidadGasolina ) {
        this.capacidadGasolina = capacidadGasolina;
    }
    
    public void comprobarPosibilidadRevision() {
        
        if( apagado == true && rpm == 0.0 )
            activarBotones( true );
        else
            activarBotones( false );
        
    }
        
    private void activarBotones( boolean estado ) {
        botonAceite.setEnabled( estado );
        botonFrenos.setEnabled( estado );
        botonGeneral.setEnabled( estado );
        botonRepostar.setEnabled( estado );
    }
    
    public void comprobarAceite( boolean necesita ) {
        
        if( necesita ) {
            etiqAceite.setText( "Revisión necesaria" );
            etiqAceite.setForeground( Color.red );
        } else {
            etiqAceite.setText( "OK" );
            etiqAceite.setForeground( Color.green );
        }
        
    }
    
    public void comprobarFrenos( boolean necesita ) {
        
        if( necesita ) {
            etiqFrenos.setText( "Revisión necesaria" );
            etiqFrenos.setForeground( Color.red );
        } else {
            etiqFrenos.setText( "OK" );
            etiqFrenos.setForeground( Color.green );
        }
        
    }
    
    public void comprobarGeneral( boolean necesita ) {
        
        if( necesita ) {
            etiqGeneral.setText( "Revisión necesaria" );
            etiqGeneral.setForeground( Color.red );
        } else {
            etiqGeneral.setText( "OK" );
            etiqGeneral.setForeground(Color.green );
        }
        
    }
    
    public void actualizarRevoluciones( double rpm ) {
        this.rpm = rpm;
    }
    
    public void actualizarGasolina( double cantidadGasolina ) {
        
        int porcentaje = (int) ( cantidadGasolina * 100 / capacidadGasolina );
        
        etiqGasolina.setText( Integer.toString( porcentaje ) + "%" );
        colorGasolina( porcentaje );
        
    }
    
    public void colorGasolina( int porcentaje ) {
        
        if( porcentaje >= 50 )
            etiqGasolina.setForeground( Color.green );
        else if( porcentaje >= 25 && porcentaje < 50 )
            etiqGasolina.setForeground( Color.yellow );
        else if( porcentaje >= 10 && porcentaje < 25 )
            etiqGasolina.setForeground( Color.orange );
        else
            etiqGasolina.setForeground( Color.red );
        
    }
    
    // Salpicadero
    SalpicaderoObjetivo salpicadero;
    GestorMonitores gestor;
    private boolean apagado = true;
    private double rpm = 0.0;
    private double capacidadGasolina;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceite;
    private javax.swing.JButton botonFrenos;
    private javax.swing.JButton botonGeneral;
    private javax.swing.JButton botonRepostar;
    private javax.swing.JLabel etiqAceite;
    private javax.swing.JLabel etiqFrenos;
    private javax.swing.JLabel etiqGasolina;
    private javax.swing.JLabel etiqGeneral;
    private javax.swing.JLabel etiqTitulo;
    private javax.swing.JLabel etiqTitulo1;
    private javax.swing.JLabel etiqTitulo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}