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
    private Combate combate;
    
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
        }else if( tipo.equals( "accesorio" ) ) {
            for( int i = 0; i < accesorios.size() && !paro; i++ ) {
                if( accesorios.get(i).getNombreAccesorio().equals( nombre ) ) {
                    paro = true;
                    index = i;
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
        
        this.armadura = new Armadura( "Ropa vieja", 5, 50, "Suficiente para tapar tus partes", 20, "https://i.pinimg.com/originals/28/da/a3/28daa3663498c909d99715cc1eaced8b.jpg" );
        this.equipada = new Arma( "Cachiporra", 5, 50, "Arma inútil, pero es mejor que nada", 20, "https://raicesdeperaleda.com/recursos/diccionario/af9190fc88e3c83936ef77ab9b16822e.jpg" );
        this.accesorio = new Accesorio( "Amuleto de la suerte", 1, 1, "Talismán que guardas desde pequeño", 10, "https://images-na.ssl-images-amazon.com/images/I/61YZjlF2U8L._AC_UX395_.jpg" );
        
        this.armas.add(new Arma( "Arco sencillo", 10, 100, "Arco ideal para los que quieren aprender", 40, "https://w7.pngwing.com/pngs/472/879/png-transparent-longbow-larp-bows-bow-and-arrow-recurve-bow-arrow-bow-weapon-bow-and-arrow.png"));
        this.armaduras.add(new Armadura( "Armadura de cuero", 20, 100, "Armadura de piel básica", 60, "https://www.eltallerdelarosa.com/636-large_default/armadura-dragon.jpg" ));
        
        this.combate = new Combate( null, null, true );
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
    
    public ArrayList<Accesorio> getAccesorios() { return accesorios; }
    public void setAccesorios( ArrayList<Accesorio> accesorios ) { 
        this.accesorios = accesorios;
    }
    
    public Accesorio getAccesorio() { return accesorio; }
    public void setAccesorio( Accesorio accesorio ) { this.accesorio = accesorio; }
    
    public int getOro() { return oro; }
    
    public String getFotoPersonaje() { return personaje.getUrl(); }

    public void restarOro( int oro ) { this.oro -=oro; }
    
    public void addArma( Arma nueva ) { armas.add( nueva ); }
    public void addArmadura( Armadura nueva ) { armaduras.add( nueva ); }
    public void addAccesorio( Accesorio nuevo ) { accesorios.add( nuevo ); }
    public void equipar(String tipo , String nombre){
        
        int index = this.indexofHerramienta(tipo, nombre);
        
        if(index != -1){
            if(tipo.equals("arma")){
                Arma antigua = this.equipada;
                Arma nueva = armas.get(index);
                
                if( antigua != nueva ) {
                    this.personaje.modificarPA(-(antigua.getPlusDaño()));
                    this.personaje.modificarPA(nueva.getPlusDaño());
                    armas.remove(index);
                    armas.add(antigua);

                    this.equipada = nueva;
                }
            }else if(tipo.equals("armadura")){
                Armadura antigua = this.armadura;
                Armadura nueva = armaduras.get(index);
                
                if( antigua != nueva ) {
                    this.personaje.modificarPV(-(antigua.getPlusVida()));
                    this.personaje.modificarPA(nueva.getPlusVida());
                    armaduras.remove(index);
                    armaduras.add(antigua);

                    this.armadura = nueva;
                }
            } else if( tipo.equals( "accesorio" ) ) {
                Accesorio antiguo = this.accesorio;
                Accesorio nuevo = accesorios.get( index );
                
                if( antiguo != nuevo ) {
                    this.personaje.modificarPA( -antiguo.getBonusAtaque() );
                    this.personaje.modificarPV( -antiguo.getBonusVida() );
                    this.accesorio = nuevo;
                    accesorios.remove( index );
                    accesorios.add( antiguo );
                    this.personaje.modificarPA( accesorio.getBonusAtaque() );
                    this.personaje.modificarPV( accesorio.getBonusVida() );
                }
            }
        }
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
    
    public Personaje getPersonaje() { return personaje; }
    
    public ArrayList<String> getMovimientos() {
        return personaje.getNombresMovimientos();
    }
    
    public Combate getCombate() { return combate; }
    public void setCombate( Combate combate ) { this.combate = combate; }
    public int getCombateActual() { return combateActual; }
    
}
