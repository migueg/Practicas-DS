/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;
import Salpicadero.EstadoMotor; 

/**
 *
 * @author juanfrandm98
 */
public class FiltroRepercutirRozamiento implements Filtro {
        
        private final int ROZAMIENTO = 1;
        
	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	public double ejecutar( double revoluciones, EstadoMotor estadoMotor ) {
            
            double nuevasRevoluciones = revoluciones;
            
            if( nuevasRevoluciones - ROZAMIENTO > 0 )
                nuevasRevoluciones -= ROZAMIENTO;
            else
                nuevasRevoluciones = 0;

            System.out.println( "Filtro Rozamiento: " + revoluciones + " -> " +
                                nuevasRevoluciones + "." );
            
            return nuevasRevoluciones;
            
	}

}
