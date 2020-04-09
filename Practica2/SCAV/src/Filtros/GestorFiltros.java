/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;
import Salpicadero.SalpicaderoObjetivo;

/**
 *
 * @author juanfrandm98
 */
public class GestorFiltros {

	private CadenaFiltros filtros;
        
        public GestorFiltros( SalpicaderoObjetivo salpicadero ) {
            filtros = new CadenaFiltros( salpicadero );
        }
        
        public void addFiltro( Filtro filtro ) {
            filtros.addFiltro( filtro );
        }
        
        public void peticionFiltro( double peticion ) {
            filtros.ejecutar();
        }

}