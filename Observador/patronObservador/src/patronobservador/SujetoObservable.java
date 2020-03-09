/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronobservador;

import java.util.Random;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanfrandm98
 */
public class SujetoObservable extends Observable implements Runnable {
    
    private float temperatura;
    private float tmin, tmax;
    
    public float getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura( float temperatura ) {
        System.out.println( "SUJETO - Cambio de temperatura: " + this.temperatura
                            + " -> " + temperatura + ".\n" );
        this.temperatura = temperatura;
        setChanged();
        notifyObservers( this.temperatura );
    }
    
    private void setMinYMax() {
        tmin = -50;
        tmax = 100;
    }
    
    @Override
    public void run() {
        
        Random r = new Random();
        setMinYMax();
        
        while( true ) {
          
            try {
                setTemperatura( tmin + r.nextFloat() * ( tmax - tmin ) );
                Thread.sleep( 2000 );
            } catch (InterruptedException ex) {
                Logger.getLogger(SujetoObservable.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
