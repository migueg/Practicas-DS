/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitorizacion;
import Salpicadero.*;
import java.util.Random;

/**
 *
 * @author juanfrandm98
 */
public class GestorGasolina {
    
    // Capacidad máxima del tanque de gasolina
    private final double capacidad = 10;
    // Capacidad actual del tanque
    private double cantidadGasolina;
    // Revoluciones acumuladas desde el último 
    private double revolucionesAcumuladas;
    // Salpicadero
    private SalpicaderoObjetivo salpicadero;
    
    public GestorGasolina( SalpicaderoObjetivo salpicadero ) {
        
        Random r = new Random();
        cantidadGasolina = 1 + ( 10 - 1 ) * r.nextDouble();
                
        this.salpicadero = salpicadero;
        
    }
    
    private double calcularGasto( double rpm ) {
        return rpm * rpm * 5 * 0.000000001;
    }
    
    public void gastoGasolina( double rpm ) {
        
        double gasto = calcularGasto( rpm );
        revolucionesAcumuladas += rpm * 0.006;
        
        if( cantidadGasolina - gasto <= 0 ) {
            
            cantidadGasolina = 0;
            
            salpicadero.tieneGasolina( false );
            
        } else 
            cantidadGasolina -= gasto;
        
    }
    
    public void repostar() {
        cantidadGasolina = capacidad;
        revolucionesAcumuladas = 0;
        salpicadero.tieneGasolina( true );
    }
    
    public double getCantidadGasolina() {
        return cantidadGasolina;
    }
    
    public double getCapacidad() {
        return capacidad;
    }
    
    public double getRevolucionesAcumuladas() {
        return revolucionesAcumuladas;
    }
    
}
