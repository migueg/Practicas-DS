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
public class ObjetoCompra {
    
    private String username;
    private String nombre;
    private String tipo;
    
    public ObjetoCompra(){}
    
    // GETTERS
    public String getUsername() { return username; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    
    // SETTERS
    public void setUsername( String username ) { this.username = username; }
    public void setNombre( String nombre ) { this.nombre = nombre; }
    public void setTipo( String tipo ) { this.tipo = tipo; }
    
}
