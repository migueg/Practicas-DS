/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SalpicaderoObjetivo salpicadero = new SalpicaderoObjetivo();
        GestorFiltros gestor = new GestorFiltros( salpicadero );
        Cliente cliente = new Cliente( salpicadero, gestor );
        
        cliente.aniadeFiltro( new FiltroCalcularVelocidad() );
        cliente.aniadeFiltro( new FiltroRepercutirRozamiento() );
        
        cliente.run();
        
    }
    
}
