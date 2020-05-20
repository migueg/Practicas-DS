/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.util.ArrayList;

/**
 *
 * @author juanfrandm98
 */
public class Jugador {
    
    private String username;
    private String password;
    private Personaje personaje;
    private int record;
    private int combateActual;
    private int oro;
    private Arma equipada;
    private Armadura  armadura;
    private Accesorio accesorio;
    
    private ArrayList<Arma> armas =  new ArrayList();
    private ArrayList<Armadura> armaduras =  new ArrayList();
    private ArrayList<Accesorio> accesorios = new ArrayList();
    
    public Jugador( String username, String password ) {
        this.username = username;
        this.password = password;
       
        record = 0;
        combateActual = 0;
        oro = 1000;
        
        this.armadura = new Armadura( "Ropa vieja", 5, 50, "Suficiente para tapar tus partes", 20 );
        this.equipada = new Arma( "Cachiporra", 5, 50, "Arma inútil, pero es mejor que nada", 20 );
        this.accesorio = new Accesorio( "Amuleto de la suerte", 1, 1, "Talismán que guardas desde pequeño", 10 );
       
    }
    
    public String getUsername() { return username; }
    
    public String getPassword() { return password; }
     
    public String getNombrePersonaje() {
        System.out.println("JJ");
        return this.personaje.getNombre();
    }
    
    public int getVida(){
        return this.personaje.getPV();
    }
    
    public int getDaño(){
        return this.personaje.getPA();
    }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public void setPersonaje( Personaje personaje ) {
        this.personaje = personaje.getBase();
    }
    
    public ArrayList<Arma> getArmas(){
        return armas;
    }

    public Arma getEquipada() {
        return equipada;
    }

    public void setEquipada(Arma equipada) {
        this.equipada = equipada;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public ArrayList<Armadura> getArmaduras() {
        System.out.println("2222");
        return armaduras;
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras = armaduras;
    }
    
    public int getOro() { return oro; }
    
    public void restarOro( int oro ) { this.oro -=oro; }
    
    public void addArma( Arma nueva ) { armas.add( nueva ); }
    public void addArmadura( Armadura nueva ) { armaduras.add( nueva ); }
    public void addAccesorio( Accesorio nuevo ) { accesorios.add( nuevo ); }
    
}
