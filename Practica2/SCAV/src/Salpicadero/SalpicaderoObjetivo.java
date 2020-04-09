/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salpicadero;
import Interfaz.*;
import Interfaz.PanelSalpicadero;

/**
 *
 * @author juanfrandm98
 */
public class SalpicaderoObjetivo {
      
        PanelBotones panelBotones;
        PanelSalpicadero panelSalpicadero;
        
        public SalpicaderoObjetivo() {
            panelBotones = new PanelBotones();
            panelSalpicadero = new PanelSalpicadero();
            
            panelBotones.aniadirSalpicadero(this);
            panelSalpicadero.aniadirSalpicadero(this);
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
                
	}
        
}
