/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanfrandm98
 */

import java.util.ArrayList;

public class FactoriaCarretera {
    private int numBiciletas;
   
    
    public FactoriaCarretera(int n){
        numBiciletas = n;
        
        
    }
    
    public ArrayList<Bicicleta> crearBiciletas (){
        ArrayList<Bicicleta> auxiliar =  new ArrayList<>();
        
        for(int i = 0 ; i < numBiciletas ; i++){
            BicicletaCarretera bici = new BicicletaCarretera();
            auxiliar.add(bici);
            
        }
        
        
        return auxiliar;
    }
    
    public void crearCarrera(){
        ArrayList<Bicicleta> auxiliar  = this.crearBiciletas();
        
        CarreraCarretera c = new CarreraCarretera(auxiliar);
    }
}
