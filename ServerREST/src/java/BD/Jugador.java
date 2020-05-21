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
    
    private int indexofHerramienta(String tipo , String nombre){
        boolean paro = false;
        int index = -1;
        if(tipo.equals("arma")){
            for(int i = 0; i < armas.size() && !paro; i++){
                if(armas.get(i).getNombreArma().equals(nombre)){
                    paro = true;
                    index= i;
                }
            }
        }else if(tipo.equals("armadura")){
              for(int i = 0; i < armaduras.size() && !paro; i++){
                if(armaduras.get(i).getNombre().equals(nombre)){
                    paro = true;
                    index= i;
                }
              }
        }
        
        return index;
    }
    public Jugador( String username, String password ) {
        this.username = username;
        this.password = password;
       
        record = 0;
        combateActual = 0;
        oro = 1000;
        
        this.armadura = new Armadura( "Ropa vieja", 5, 50, "Suficiente para tapar tus partes", 20 );
        this.equipada = new Arma( "Cachiporra", 5, 50, "Arma inútil, pero es mejor que nada", 20 );
        this.accesorio = new Accesorio( "Amuleto de la suerte", 1, 1, "Talismán que guardas desde pequeño", 10 );
        
        this.armas.add(new Arma("arco",5,100 ,"arma",10000));
        this.armaduras.add(new Armadura("brazalete",10,100,"armadura",10000));
        
    }
    
    public String getUsername() { return username; }
    
    public String getPassword() { return password; }
     
    public String getNombrePersonaje() {
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
    public void equipar(String tipo , String nombre){
        
        int index = this.indexofHerramienta(tipo, nombre);
        
        if(index != -1){
            if(tipo.equals("arma")){
                Arma antigua = this.equipada;
                this.personaje.modificarPA(-(antigua.getPlusDaño()));
                Arma nueva = armas.get(index);
                this.personaje.modificarPA(nueva.getPlusDaño());
                armas.remove(index);
                armas.add(antigua);
                
                this.equipada = nueva;
            }else if(tipo.equals("armadura")){
                Armadura antigua = this.armadura;
                this.personaje.modificarPV(-(antigua.getPlusVida()));
                Armadura nueva = armaduras.get(index);
                this.personaje.modificarPA(nueva.getPlusVida());
                armaduras.remove(index);
                armaduras.add(antigua);
                
                this.armadura = nueva;
            }
        }
    }
    
    
}
