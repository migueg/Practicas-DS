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
public interface Filtro {

        static final double MAXIMO = 5000;
        
	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	double ejecutar( double revoluciones, EstadoMotor estadoMotor );
        

}