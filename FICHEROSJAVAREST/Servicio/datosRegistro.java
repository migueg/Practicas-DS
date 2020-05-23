/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author Usuario
 */
public class datosRegistro {
    private String username;
    private String password;
    private String personaje;
    
    public datosRegistro(){}
    
    public void setUsername( String username ) {
        this.username = username;
    }
    
    public void serPassword( String password ) {
        this.password = password;
    }
    
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
    
}
