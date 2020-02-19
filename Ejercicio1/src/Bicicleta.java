/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanfrandm98
 */
public abstract class Bicicleta {
    
    private int identificador;
    private TipoBicicleta tipo;
    
    public Bicicleta( TipoBicicleta tipo ) {
        this.tipo = tipo;
    }
    
    public void setIdentificador( int identificador ) {
        this.identificador = identificador;
    }
    
    public int getIdentificador() {
        return identificador;
    }
    
}
