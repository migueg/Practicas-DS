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
public class Jugador {
    
    private String username;
    private String password;
    private Personaje personaje;
    private ArrayList<Arma> armas;
    private ArrayList<Armadura> armaduras;
    private ArrayList<Accesorio> accesorio;
    private int record;
    private int combateActual;
    private int oro;
    
    public Jugador( String username, String password ) {
        this.username = username;
        this.password = password;
        
        record = 0;
        combateActual = 0;
        oro = 0;
    }
    
    public String getUsername() { return username; }
    
    public String getPassword() { return password; }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public void setPersonaje( Personaje personaje ) {
        this.personaje = personaje.getBase();
    }
    
}
