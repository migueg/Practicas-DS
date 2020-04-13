/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitorizacion;
import Salpicadero.*;

/**
 *
 * @author juanfrandm98
 */
public class GestorGasolina {
    
    // Capacidad máxima del tanque de gasolina
    private final double capacidad = 10;
    // Capacidad actual del tanque
    private double cantidadGasolina;
    // Salpicadero
    private SalpicaderoObjetivo salpicadero;
    // Gestor de monitorizacion
    private GestorMonitores gestor;
    
    public GestorGasolina( GestorMonitores gestor, SalpicaderoObjetivo salpicadero ) {
        
        cantidadGasolina = capacidad;
        this.salpicadero = salpicadero;
        this.gestor = gestor;
        
    }
    
    private double calcularGasto( double rpm ) {
        return rpm * rpm * 50 * 0.000000001;
    }
    
    public void gastoGasolina( double rpm ) {
        
        double gasto = calcularGasto( rpm );
        
        if( cantidadGasolina - gasto <= 0 ) {
            
            cantidadGasolina = 0;
            
            //if( salpicadero.getEstado() != EstadoMotor.APAGADO )
                //salpicadero.sinGasolina( true );
            
        } else 
            cantidadGasolina -= gasto;
        
    }
    
    public void repostar() {
        cantidadGasolina = capacidad;
        //salpicadero.sinGasolina( false );
    }
    
    public double getCantidadGasolina() {
        return cantidadGasolina;
    }
    
    public double getCapacidad() {
        return capacidad;
    }
    
}
