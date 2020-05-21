/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.Calendar;
import com.eclipsesource.json.JsonObject;

import BD.Jugador;
import BD.Personaje;
import BD.InventarioArma;
import BD.Arma;
import BD.Armadura;
import BD.Accesorio;

/**
 *
 * @author juanfrandm98
 */
@Path("rolgame")
public class Servicio {
    
    private static ArrayList<Jugador> jugadores = new ArrayList();
    private static ArrayList<Personaje> personajes = new ArrayList();
     private static ArrayList<Arma> armas = new ArrayList();
    private static ArrayList<Armadura> armaduras = new ArrayList();
    private static ArrayList<Accesorio> accesorios = new ArrayList();
    static {
        jugadores.add( new Jugador( "juanfrandm98", "jfdm" ) );
        jugadores.add( new Jugador("administrador", "admin"));
        
        
        personajes.add( new Personaje( "GRR0", "Guerrero", 50, 5 ) );
        personajes.add( new Personaje( "ARQ1", "Arquero", 40, 10 ) );
        personajes.add( new Personaje( "MAG2", "Mago", 45, 7 ) );
        
        jugadores.get(0).setPersonaje(personajes.get(0));
        armas.add( new Arma( "Cachiporra", 5, 50, "Arma inútil, pero es mejor que nada", 20 ) );
        armas.add( new Arma( "Espada de cobre", 12, 100, "Espada de metal algo roma", 60 ) );
        armas.add( new Arma( "Varita de olivo", 8, 100, "Varita que crea llamas con el poder del aceite", 50 ) );
        armas.add( new Arma( "Arco sencillo", 10, 100, "Arco ideal para los que quieren aprender", 40 ) );

        armaduras.add( new Armadura( "Ropa vieja", 5, 50, "Suficiente para tapar tus partes", 20 ) );
        armaduras.add( new Armadura( "Armadura de cuero", 20, 100, "Armadura de piel básica", 60 ) );
        armaduras.add( new Armadura( "Armadura de hierro", 30, 100, "Armadura de metal resistente", 120 ) );

        accesorios.add( new Accesorio( "Amuleto de la suerte", 1, 1, "Talismán que guardas desde pequeño", 10 ) );
        accesorios.add( new Accesorio( "Anillo verde", 0, 10, "Anillo que te hace sentir más vivo", 80 ) );
        accesorios.add( new Accesorio( "Anillo rojo", 5, 0, "Anillo que te hace sentir más fuerte", 80 ) );
        accesorios.add( new Accesorio( "Biblia", 3, 8, "Libro que te inspira en la batalla", 100 ) );

        jugadores.get(0).setPersonaje(personajes.get(0));
    }
    
  
    private int indexofJugador(String user){
        int index = -1;
        boolean paro = false;
               

        for(int  i = 0; i < jugadores.size() && !paro; i++){ 
            if(this.jugadores.get(i).getUsername().equals(user)){
                index = i;
                paro = true;
            }
        }
       
        return index;
    }
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String compruebaConexion() {
        return "Servidor levantado";
    }

    @GET
    @Produces({"application/json"})
    @Path("inventario/{user}")
    public ArrayList<InventarioArma> inventario( @PathParam("user") String user){
        ArrayList<InventarioArma> inventario = new ArrayList();
        System.out.println(user);
         Jugador j = this.jugadores.get(indexofJugador(user));
         System.out.println((indexofJugador(user)));
         
        // Obtengo el inventario
        ArrayList<Arma> armas = j.getArmas();
        ArrayList<Armadura> armaduras = j.getArmaduras();
        
        //Obtengo el material equipado
        Arma equipada = j.getEquipada();
        Armadura armadura = j.getArmadura();
        //La posicion 0 y 1 del json serán el arma y armadura por defecto
        InventarioArma actual = new InventarioArma();
        actual.setPersonaje(j.getNombrePersonaje());
        actual.setDaño(j.getDaño());
        actual.setVida(j.getVida());
        actual.setDañoArma(equipada.getPlusDaño());
        actual.setNombreArma(equipada.getNombreArma());
        actual.setTipo(equipada.getTipo());
        actual.setVidaArma(equipada.getVida());
        
        inventario.add(actual);
        InventarioArma a = new InventarioArma();
        a.setNombreArmadura(armadura.getNombre());
        a.setVidaArmadura(armadura.getVida());
        a.setPlusVida(armadura.getPlusVida());
        a.setTipo(armadura.getTipo());
        
        inventario.add(a);
         
        for(int i = 0; i < armas.size(); i++){
            System.out.println("GG");
            InventarioArma nuevo = new InventarioArma();
            nuevo.setPersonaje(j.getNombrePersonaje());
            nuevo.setDaño(j.getDaño());
            nuevo.setVida(j.getVida());
            nuevo.setDañoArma(armas.get(i).getPlusDaño());
            nuevo.setNombreArma(armas.get(i).getNombreArma());
            nuevo.setTipo(armas.get(i).getTipo());
            nuevo.setVidaArma(armas.get(i).getVida());
            
       
            
            inventario.add(nuevo);
         }
        
        System.out.println("HH");
        for(int i = 0; i < armaduras.size(); i++){
            InventarioArma nuevo = new InventarioArma();
            nuevo.setTipo(armaduras.get(i).getTipo());
            nuevo.setNombreArmadura(armaduras.get(i).getNombre());
            nuevo.setVidaArmadura(armaduras.get(i).getVida());
            nuevo.setPlusVida(armaduras.get(i).getPlusVida());

            inventario.add(nuevo);
        }
        
         
         return inventario;
         
    }
    
    
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login( datosConexion datos ) {
        
        System.out.println("Me ha llegado cosas.");
        
        for ( Jugador j : jugadores ){
            if( (j.getUsername().equals(datos.getUsername())) &&
                (j.getPassword().equals(datos.getPassword())) )
                return "OK";
        }
        
        return "Los datos introducidos no son correctos.";
    }
    
    @POST
    @Path("loginjs")
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    public jsonResponse loginjs( datosConexion datos ) {
        
        System.out.println("Dispositivo móvil solicita login." );
        jsonResponse js = new jsonResponse();
        js.setResultado( "Los datos introducidos no son correctos." );
        
        for( Jugador j : jugadores ) {
            if( j.getUsername().equals( datos.getUsername() ) &&
                j.getPassword().equals( datos.getPassword() ) ) {
                System.out.println( "Login correcto: " + datos.getUsername() );
                js.setResultado("OK");
                return js;
            }
        }
        
        System.out.println( "Login incorrecto: " + datos.getUsername() );
        return js;
    }
    
    @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String registro( Jugador jugador ) {
        
        for ( Jugador j : jugadores )
            if( j.getUsername() == jugador.getUsername() )
                return "El usuario ya existe en la plataforma.";
        
        return "OK";
    }
    
    @POST
    @Path("selectClass")
    @Consumes(MediaType.TEXT_PLAIN)
    public void selectClass( JsonObject js ) {
        
        Jugador jugador;
        
        String username = js.get( "username" ).toString();
        String clase = js.get( "class" ).toString();
        int pos;
        
        for ( Jugador j : jugadores )
            if( j.getUsername() == username ) {
                
            switch( clase ) {
                case "GRR":
                    pos = 0;
                    break;
                case "ARQ":
                    pos = 1;
                    break;
                default:
                    pos = 2;
                    break;
            }      
        
            j.setPersonaje( personajes.get(pos) );
            
        }
        
    }
    
    @PUT
    @Path("equipar")
    @Consumes({"application/json"})
    public void cambiarArma(datosEquipo d){
        System.out.println("ME LLEGA:");
        System.out.println(d.getUsername());
        Jugador j = jugadores.get(this.indexofJugador(d.getUsername()));

        j.equipar(d.getTipo(), d.getNombre());
    }
    
       private int calcularSemilla() {

        int semilla = 0;

        Calendar fecha = Calendar.getInstance();

        semilla += fecha.get( Calendar.DAY_OF_MONTH );
        semilla += fecha.get( Calendar.MONTH );
        semilla += fecha.get( Calendar.YEAR );

        return semilla;

    }

    @GET  
    @Produces({"application/json"})
    @Path("shop/{user}")
    public ArrayList<ObjetoTienda> tienda( @PathParam("user") String user ) {
        
        System.out.println( user + " quiere consultar la tienda." );

        ArrayList<ObjetoTienda> objetos = new ArrayList();

        Jugador jugador = this.jugadores.get( indexofJugador( user ) );
        int oro = jugador.getOro();
        int semilla = calcularSemilla();

        // SELECCIÓN DEL ARMA DE LA TIENDA
        Arma armaSeleccionada = armas.get( semilla % armas.size() );
        ObjetoTienda armaTienda = new ObjetoTienda();
        armaTienda.setNombre( armaSeleccionada.getNombreArma() );
        armaTienda.setTipo( armaSeleccionada.getTipo() );
        armaTienda.setBonusAtaque( armaSeleccionada.getPlusDaño() );
        armaTienda.setBonusVida(0);
        armaTienda.setCoste( armaSeleccionada.getCoste() );
        armaTienda.setDescripcion( armaSeleccionada.getDescripcion() );
        armaTienda.setDineroTotal( oro );
        objetos.add( armaTienda );

        // SELECCIÓN DE LA ARMADURA DE LA TIENDA
        Armadura armaduraSeleccionada = armaduras.get( semilla % armaduras.size() );
        ObjetoTienda armaduraTienda = new ObjetoTienda();
        armaduraTienda.setNombre( armaduraSeleccionada.getNombre() );
        armaduraTienda.setTipo( armaduraSeleccionada.getTipo() );
        armaduraTienda.setBonusAtaque(0);
        armaduraTienda.setBonusVida( armaduraSeleccionada.getPlusVida() );
        armaduraTienda.setCoste( armaduraSeleccionada.getCoste() );
        armaduraTienda.setDescripcion( armaduraSeleccionada.getDescripcion() );
        armaduraTienda.setDineroTotal( oro );
        objetos.add( armaduraTienda );

        // SELECCIÓN DEL ACCESORIO DE LA TIENDA
        Accesorio accesorioSeleccionado = accesorios.get( semilla % accesorios.size() );
        ObjetoTienda accesorioTienda = new ObjetoTienda();
        accesorioTienda.setNombre( accesorioSeleccionado.getNombreAccesorio() );
        accesorioTienda.setTipo( accesorioSeleccionado.getTipo() );
        accesorioTienda.setBonusAtaque( accesorioSeleccionado.getBonusAtaque() );
        accesorioTienda.setBonusVida( accesorioSeleccionado.getBonusVida() );
        accesorioTienda.setCoste( accesorioSeleccionado.getCoste() );
        accesorioTienda.setDescripcion( accesorioSeleccionado.getDescripcion() );
        accesorioTienda.setDineroTotal( oro );
        objetos.add( accesorioTienda );
        
        System.out.println( user + " recibe la tienda." );

        return objetos;

    }

    private boolean puedoComprar( int coste, int dinero ) {
        return coste <= dinero;
    }

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

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("buy")
    public jsonResponse comprarObjeto( ObjetoCompra compra ) {

        Jugador jugador = this.jugadores.get( indexofJugador( compra.getUsername() ) );
        int posicion = indexofHerramienta( compra.getTipo(), compra.getNombre() );

        jsonResponse js = new jsonResponse();

        switch( compra.getTipo() ) {
            case "arma":
                Arma arma = armas.get(posicion);
                if( puedoComprar( arma.getCoste(), jugador.getOro() ) ) {
                    jugador.restarOro( arma.getCoste() );
                    jugador.addArma( arma );
                    js.setResultado( "Compra realizada." );
                } else {
                    js.setResultado( "Oro insuficiente." );
                }
                break;
            case "armadura":
                Armadura armadura = armaduras.get(posicion);
                if( puedoComprar( armadura.getCoste(), jugador.getOro() ) ) {
                    jugador.restarOro( armadura.getCoste() );
                    jugador.addArmadura( armadura );
                    js.setResultado( "Compra realizada." );
                } else {
                    js.setResultado( "Oro insuficiente." );
                }
                break;
            default:
                Accesorio accesorio = accesorios.get(posicion);
                if( puedoComprar( accesorio.getCoste(), jugador.getOro() ) ) {
                    jugador.restarOro( accesorio.getCoste() );
                    jugador.addAccesorio( accesorio );
                    js.setResultado( "Compra realizada." );
                } else {
                    js.setResultado( "Oro insuficiente." );
                }
                break;

        }

        return js;
    }
}
