package filtro;

import javax.swing.JPanel;
public class SalpicaderoObjetivo {
      
        PanelBotones panelBotones;
        PanelSalpicadero panelSalpicadero;
        
        public SalpicaderoObjetivo() {
            panelBotones = new PanelBotones();
            panelSalpicadero = new PanelSalpicadero();
            
            panelBotones.aniadirSalpicadero(this);
            panelSalpicadero.aniadirSalpicadero(this);
            
            panelBotones.setVisible(true);
            panelSalpicadero.setVisible(true);
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