/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

/**
 *
 * @author juanfrandm98
 */
public class Movimiento {
    
    private String nombre;
    private int potencia;
    private String tipoConBonus;
    private int bonus;
    
    public Movimiento( String nombre, int potencia, String tipoConBonus, int bonus ) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipoConBonus = tipoConBonus;
        this.bonus = bonus;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public int getPotencia() { return potencia; }
    public String getTipoConBonus() { return tipoConBonus; }
    public int getBonus() { return bonus; }
    
}
