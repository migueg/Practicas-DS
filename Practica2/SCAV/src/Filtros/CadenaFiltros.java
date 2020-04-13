/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;
import Salpicadero.SalpicaderoObjetivo;
import java.util.ArrayList;

/**
 *
 * @author juanfrandm98
 */
public class CadenaFiltros {
        
        private ArrayList<Filtro> listaFiltros;
        private SalpicaderoObjetivo salpicadero;
        
        /*
        public CadenaFiltros(){
            
           Filtro velocidad = new CalcularVelocidad();
           Filtro revoluciones = new RepercutirRozamiento();
           
           listaFiltros = new ArrayList();
           
           listaFiltros.add(velocidad);
           listaFiltros.add(revoluciones);
  
        }*/
        
        public CadenaFiltros( SalpicaderoObjetivo salpicadero ) {
            
            listaFiltros = new ArrayList();
            this.salpicadero = salpicadero;
            
        }
        
        public void addFiltro( Filtro filtro ) {
            
            listaFiltros.add( filtro );
            
        }
        
	public void ejecutar( double peticion ) {
            
            for( Filtro filtro : listaFiltros )
                peticion = filtro.ejecutar( peticion, salpicadero.getEstado() );
            
            salpicadero.ejecutar( peticion, salpicadero.getEstado() );
            
	}

}
