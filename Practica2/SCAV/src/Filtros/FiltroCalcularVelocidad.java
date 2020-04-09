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
public class FiltroCalcularVelocidad implements Filtro {
    
    	public double incrementoVelocidad ;
        private final double VELOCIDADMAXIMA = 742; // Para que no supere los 280 km/h

	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	public double ejecutar( double revoluciones, EstadoMotor estadoMotor ) {

            if(estadoMotor == EstadoMotor.APAGADO){
                
                incrementoVelocidad = 0;
                
            }else if(estadoMotor == EstadoMotor.ENCENDIDO){
                
                incrementoVelocidad = 0;
                
            }else if (estadoMotor == EstadoMotor.ACELERANDO){
                
                incrementoVelocidad = 3;
                
            }else if (estadoMotor == EstadoMotor.FRENANDO){
                
                incrementoVelocidad = -3;
                
            }
            
            double nuevasRevoluciones = revoluciones + incrementoVelocidad;
            
            if( nuevasRevoluciones < 0 )
                nuevasRevoluciones = 0;
            
            System.out.println( "Filtro Velocidad: " + revoluciones + " -> " +
                                nuevasRevoluciones + "." );
            
            if( nuevasRevoluciones > VELOCIDADMAXIMA ) {
                nuevasRevoluciones -= 5;
                System.out.println( "Filtro Rozamiento: " + revoluciones +
                                    " -> " + nuevasRevoluciones + "." );
            }

            return nuevasRevoluciones;
            
	}

}
