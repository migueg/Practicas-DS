/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanfrandm98
 */
public class Cliente extends Thread {
    
    private GestorFiltros gestor;
    private SalpicaderoObjetivo salpicadero;
    
    public Cliente( SalpicaderoObjetivo salpicadero, GestorFiltros gestor ) {
        
        this.salpicadero = salpicadero;
        this.gestor = gestor;
        
    }
    
    public void aniadeFiltro( Filtro filtro ) {
        gestor.addFiltro( filtro );
    }
    
    public void enviarPeticion( double peticion ) {
        gestor.peticionFiltro( peticion );
    }
    
    @Override
    public void run() {
        while(true){
            enviarPeticion( salpicadero.getVelocidadAngular() );
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
