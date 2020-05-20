/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

/**
 *
 * @author juanfrandm98
 */
public class ObjetoTienda {
    
    private String nombre;
    private int bonusAtaque;
    private int bonusVida;
    private int coste;
    private String descripcion;
    private int dineroTotal;
    
    // CONSTRUCTOR
    public ObjetoTienda(){}
    
    // GETTERS
    public String getNombre() { return nombre; }
    public int getBonusAtaque() { return bonusAtaque; }
    public int getBonusVida() { return bonusVida; }
    public int getCoste() { return coste; }
    public String getDescripcion() { return descripcion; }
    public int getDineroTotal() { return dineroTotal; }
    
    // SETTERS
    public void setNombre( String nombre ) { this.nombre = nombre; }
    public void setBonusAtaque( int bonusAtaque ) { this.bonusAtaque = bonusAtaque; }
    public void setBonusVida( int bonusVida ) { this.bonusVida = bonusVida; }
    public void setCoste( int coste ) { this.coste = coste; }
    public void setDescripcion( String descripcion ) { this.descripcion = descripcion; }
    public void setDineroTotal( int dineroTotal ) { this.dineroTotal = dineroTotal; }
    
}
