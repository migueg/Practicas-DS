/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronobservador;

import java.util.ArrayList;

/**
 *
 * @author juanfrandm98
 */
public abstract class Observable extends Thread {
    
    private ArrayList<Observador> observadores;
    
    public Observable() {
        observadores = new ArrayList();
    }
    
    public void agregarObservador( Observador observador ) {
        observadores.add( observador );
    }
    
    public void eliminarObservador( Observador observador ) {
        observadores.remove( observador );
    }
    
    public void notificarObservadores() {
        for( Observador observador : observadores )
            observador.actualizar();
    }
    
}
