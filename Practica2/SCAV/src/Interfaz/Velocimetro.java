/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Salpicadero.SalpicaderoObjetivo;

/**
 *
 * @author juanfrandm98
 */
public class Velocimetro extends JFrame implements Runnable {
    
    private JPanel panel;
    private Graphics fondo;
    private SalpicaderoObjetivo salpicadero;
    private double velocidad;
    
    public Velocimetro( SalpicaderoObjetivo salpicadero ) {
        
        // Asignamos el salpicadero
        this.salpicadero = salpicadero;
        
        panel = new JPanel();
        panel.setLayout( new BorderLayout() );
        getContentPane().add( panel );
        setSize( 400, 400 );
        
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
		System.exit(0);
            }
	});
        
    }
    
    public void paint( Graphics fondo ) {
        
        super.paint( fondo );
        
        fondo.setColor( Color.black );
        fondo.drawOval( 100,  150,  150,  150);
        fondo.setColor( Color.black);
        fondo.drawString( "0",  110,  290 );
        fondo.drawString( "20", 90,  270 );
        fondo.drawString( "40", 80,  240 );
        fondo.drawString( "60", 80,  210 );
        fondo.drawString( "80", 90,  180 );
        fondo.drawString( "100", 110,  160 );
        fondo.drawString( "120", 140,  148 );
        fondo.drawString( "140", 170,  145 );
        fondo.drawString( "160", 200,  150 );
        fondo.drawString( "180", 230,  168 );
        fondo.drawString( "200", 250,  190 );
        fondo.drawString( "220", 255,  222 );
        fondo.drawString( "240", 250,  250 );
        fondo.drawString( "260", 240,  280 );
        fondo.drawString( "280", 220, 300 );

        fondo.setColor( Color.red );
        int r = (int)( 320 - velocidad );
        fondo.fillArc( 100,  150,  150,  150,  ( 225 - (int)velocidad ),  2 );
        
    }
    
    public void setVelocidad( double velocidad ) {
        this.velocidad = velocidad;
        super.repaint();
    }

    @Override
    public void run() {
        
    }
    
}
