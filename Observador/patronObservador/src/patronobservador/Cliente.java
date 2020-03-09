/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronobservador;

/**
 *
 * @author juanfrandm98
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SujetoObservable sujeto;
        //PantallaTemperatura pantallaTemperatura;
        //BotonCambio botonCambio;
        //GraficaTemperatura graficaTemperatura;
        
        sujeto = new SujetoObservable();
        sujeto.start();
        
        //pantallaTemperatura = new PantallaTemperatura();
        //botonCambio = new BotonCambio();
        //graficaTemperatura = new GraficaTemperatura();
        
        //sujeto.agregarObservador( pantallaTemperatura );
        //sujeto.agregarObservador( botonCambio );
        //sujeto.agregarObservador( graficaTemperatura );
        
    }
    
}
