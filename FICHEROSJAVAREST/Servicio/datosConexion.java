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
public class datosConexion {
    
    private String username;
    private String password;
    
    public datosConexion(){}
    
    public void setUsername( String username ) {
        this.username = username;
    }
    
    public void serPassword( String password ) {
        this.password = password;
    }
    
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    
}