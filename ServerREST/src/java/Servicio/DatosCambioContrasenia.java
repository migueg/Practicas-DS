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
public class DatosCambioContrasenia {
    
    private String username;
    private String oldpass;
    private String newpass;
    
    public DatosCambioContrasenia(){}
    
    // Setters
    public void setUsername( String username ) { this.username = username; }
    public void setOldpass( String oldpass ) { this.oldpass = oldpass; }
    public void setNewpass( String newpass ) { this.newpass = newpass; }
    
    // Getters
    public String getUsername() { return username; }
    public String getOldpass() { return oldpass; }
    public String getNewpass() { return newpass; }
    
}
