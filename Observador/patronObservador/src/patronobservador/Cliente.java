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

        SujetoObservable sujeto = new SujetoObservable();
        
        BotonCambio botonCambio= new BotonCambio();
        botonCambio.setSujetoObservable(sujeto);
        sujeto.addObserver( botonCambio );
        botonCambio.setVisible(true);
        //PantallaTemperatura pantallaTemperatura;
        //GraficaTemperatura graficaTemperatura;
        
        Thread t = new Thread( sujeto );
        t.start();
    }
    
}
