
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanfrandm98
 */
public abstract class Carrera extends Thread {
    
    private ArrayList<Bicicleta> bicicletas;
    private int porcentajeAbandono;
    
    public Carrera( int porcentajeAbandono ) {
        bicicletas = new ArrayList();
        this.porcentajeAbandono = porcentajeAbandono;
    }
    
    public void aniadirBicicleta( Bicicleta bicicleta ) {
        
        int nuevoIdentificador = bicicletas.size();
        bicicleta.setIdentificador( nuevoIdentificador );
        
        bicicletas.add( bicicleta );
        
    }
    public int abandonarCarrera(){
        
        int abandonan = (this.porcentajeAbandono * bicicletas.size())/100;
        
        for(int i = 0 ; i < abandonan ; i++){
            
            int siguiente = (int) (Math.random() * bicicletas.size() );
            bicicletas.remove( siguiente );
            
        }
        
        return abandonan;
    }
    
    @Override
    public void run() {
        
        String mensaje = "Iniciando carrera de " + printTipo() + " con bicicletas:";
        
        for( Bicicleta b : bicicletas )
            mensaje += " " + b.getIdentificador();
        
        System.out.println( mensaje );
        
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int numAbandonos = abandonarCarrera();
        
        System.out.println( "Carrera " + printTipo() + " - han abandonado " + numAbandonos + " bicicletas." );
        
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mensaje = "Carrera de " + printTipo() + " terminada con bicicletas:";
        
        for( Bicicleta b : bicicletas )
            mensaje += " " + b.getIdentificador();
        
        System.out.println( mensaje );
        
    }
    
    public abstract String printTipo();
    
}
