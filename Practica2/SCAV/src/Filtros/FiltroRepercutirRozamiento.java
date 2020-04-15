/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;
import Salpicadero.EstadoMotor; 
import Salpicadero.EstadoMotor;

/**
 *
 * @author juanfrandm98
 */
public class FiltroRepercutirRozamiento implements Filtro {
        
        private final int ROZAMIENTO = 1;
        
	public double ejecutar( double revoluciones, EstadoMotor estadoMotor ) {
            if(estadoMotor != EstadoMotor.MANTENIENDO){
                 double nuevasRevoluciones = revoluciones;
            
            if( nuevasRevoluciones - ROZAMIENTO > 0 )
                nuevasRevoluciones -= ROZAMIENTO;
            else
                nuevasRevoluciones = 0;

            System.out.println( "Filtro Rozamiento: " + revoluciones + " -> " +
                                nuevasRevoluciones + "." );
            
               return nuevasRevoluciones;
            }else{
                return revoluciones;
            }
           
            
	}

}
