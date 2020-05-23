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
public class Turno {
    
    private String username;
    private String movimiento;
    
    public Turno(){}
    
    // Setters
    public void setUsername( String username ) { this.username = username; }
    public void setMovimiento( String movimiento ) { this.movimiento = movimiento; }
    
    // Getters
    public String getUsername() { return username; }
    public String getMovimiento() { return movimiento; }
    
}
