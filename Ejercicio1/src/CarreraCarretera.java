/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanfrandm98
 */
public class CarreraCarretera extends Carrera {
    
    public CarreraCarretera() {
        super( TipoBicicleta.CARRETERA, 10 );
    }

    @Override 
    public void run(){
        int n = this.abandonarCarrera();
        System.out.print("Bicicletas que abandonan: ");
        System.out.print(n);
        

    }
}
