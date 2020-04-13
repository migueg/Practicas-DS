/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salpicadero;

import Interfaz.*;
import Monitorizacion.GestorMonitores;

/**
 *
 * @author juanfrandm98
 */
public class SalpicaderoObjetivo {
      
        PanelBotones panelBotones;
        PanelSalpicadero panelSalpicadero;
        GestorMonitores gestorMonitores;
        Velocimetro velocimetro;
        
        public SalpicaderoObjetivo() {
            panelBotones = new PanelBotones();
            panelSalpicadero = new PanelSalpicadero();
            velocimetro = new Velocimetro( this );
            
            panelBotones.aniadirSalpicadero(this);
            panelSalpicadero.aniadirSalpicadero(this);
            
            gestorMonitores = new GestorMonitores( this );
            
            panelBotones.setVisible(true);
            panelSalpicadero.setVisible(true);
            velocimetro.setVisible( true );
        }
        
	public double getVelocidadAngular() {
            return panelSalpicadero.getVelocidadAngular();
	}
        
        public EstadoMotor getEstado() {
            return panelBotones.getEstado();
        }
        
        public void reiniciarKM() {
            panelSalpicadero.reiniciarKM();
        }
        
        public void ejecutar( double revoluciones , EstadoMotor estadoMotor ) {
		
                panelSalpicadero.setVelocidadAngular(revoluciones );
                velocimetro.setVelocidad( getVelocidadAngular() );
                gestorMonitores.actualizarRevoluciones( revoluciones );
                
	}
        
        public void revisarAceite() {
            gestorMonitores.revisarAceite();
        }
        
        public void revisarFrenos() {
            gestorMonitores.revisarFrenos();
        }
        
        public void revisarGeneral() {
            gestorMonitores.revisarGeneral();
        }
        
        public void tieneGasolina( boolean estado ) {
            panelBotones.tieneGasolina( estado );
        }
        
        public boolean getApagado() {
            return panelBotones.getApagado();
        }
        
}
