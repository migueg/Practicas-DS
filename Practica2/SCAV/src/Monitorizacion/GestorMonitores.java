/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitorizacion;
import Salpicadero.*;
import Interfaz.PanelMonitorizacion;

/**
 *
 * @author juanfrandm98
 */
public class GestorMonitores {
    
    // Monitores específicos
    private MonitorAceite monitorAceite;
    private MonitorFrenos monitorFrenos;
    // Monitor general
    private MonitorGeneral monitorGeneral;
    // Gestor de Gasolina
    private GestorGasolina gestorGasolina;
    // SalpicaderoObjetivo
    private SalpicaderoObjetivo salpicadero;
    // Interfaz
    private PanelMonitorizacion panelMonitorizacion;
    
    public GestorMonitores( SalpicaderoObjetivo salpicadero ) {
        
        monitorAceite = new MonitorAceite();
        monitorFrenos = new MonitorFrenos();
        monitorGeneral = new MonitorGeneral();
        gestorGasolina = new GestorGasolina( this, salpicadero );
        
        this.salpicadero = salpicadero;
        
        panelMonitorizacion = new PanelMonitorizacion();
        panelMonitorizacion.setGestor( this );
        panelMonitorizacion.setSalpicadero(salpicadero);
        panelMonitorizacion.setCapacidadGasolina( gestorGasolina.getCapacidad() );
        panelMonitorizacion.setVisible(true);
        
    }
    
    public void revisarFrenos() {
        monitorFrenos.revisar();
    }
    
    public void revisarAceite() {
        monitorAceite.revisar();
    }
    
    public void revisarGeneral() {
        monitorAceite.revisar();
        monitorFrenos.revisar();
        monitorGeneral.revisar();
    }
    
    public void actualizarRevoluciones( double revoluciones ) {
        monitorAceite.actualizarRevoluciones(revoluciones);
        monitorFrenos.actualizarRevoluciones(revoluciones);
        monitorGeneral.actualizarRevoluciones(revoluciones);
        gestorGasolina.gastoGasolina(revoluciones);
        
        panelMonitorizacion.comprobarAceite( monitorAceite.comprobarRevision() );
        panelMonitorizacion.comprobarFrenos( monitorFrenos.comprobarRevision() );
        panelMonitorizacion.comprobarGeneral( monitorGeneral.comprobarRevision() );
        panelMonitorizacion.actualizarRevoluciones(revoluciones);
        panelMonitorizacion.actualizarGasolina( gestorGasolina.getCantidadGasolina() );
        panelMonitorizacion.comprobarPosibilidadRevision();
    }
    
    public void setMotorApagado( boolean apagado ) {
        panelMonitorizacion.setMotorApagado(apagado);
    }
    
    public void repostar() {
        gestorGasolina.repostar();
    }
    
}
