
import java.util.ArrayList;

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
    private TipoBicicleta tipo;
    private int porcentajeAbandono;
    
    public Carrera( TipoBicicleta tipo, int porcentajeAbandono ) {
        bicicletas = new ArrayList();
        this.tipo = tipo;
        this.porcentajeAbandono = porcentajeAbandono;
    }
    
    public void aniadirBicicleta( Bicicleta bicicleta ) {
        
        int nuevoIdentificador = bicicletas.size() - 1;
        bicicleta.setIdentificador( nuevoIdentificador );
        
        bicicletas.add( bicicleta );
        
    }
    public int abandonarCarrera(){
        int abandonan = (this.porcentajeAbandono * bicicletas.size())/100;
        for(int i = 0 ; i < abandonan ; i++){
            bicicletas.remove(i);
        }
        return abandonan;
    }
    
    
    
}
