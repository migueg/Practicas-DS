/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronobservador;

import java.util.Random;

/**
 *
 * @author juanfrandm98
 */
public class SujetoObservable extends Observable {
    
    private int temperatura, tmin, tmax;
    
    public int getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura( int temperatura ) {
        System.out.println( "SUJETO - Cambio de temperatura: " + this.temperatura
                            + " -> " + temperatura + ".\n" );
        this.temperatura = temperatura;
        notificarObservadores();
    }
    
    private void setMinYMax() {
        Random r = new Random();
        
        tmin = -50 + r.nextInt(99);
        tmax = tmin + r.nextInt( 50 - tmin );
    }
    
    @Override
    public void run() {
        
        Random r = new Random();
        setMinYMax();
        
        while( true ) {
            
            try {
                setTemperatura( tmin + r.nextInt( tmax - tmin ) );
                sleep(2000);
            } catch( java.lang.InterruptedException e ) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
