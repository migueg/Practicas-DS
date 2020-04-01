/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanfrandm98
 */
public class FactoriaMontana implements FactoriaCarreraYBicicleta {
    
    public Carrera crearCarrera() {
        return new CarreraMontana();
    }
    
    public Bicicleta crearBicicleta() {
        return new BicicletaMontana();
    }
    
}
