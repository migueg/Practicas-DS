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

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

import BD.Jugador;
import BD.Personaje;

/**
 *
 * @author juanfrandm98
 */
@Path("rolgame")
public class Servicio {
    
    private static ArrayList<Jugador> jugadores = new ArrayList();
    private static ArrayList<Personaje> personajes = new ArrayList();
    
    static {
        jugadores.add( new Jugador( "juanfrandm98", "jfdm" ) );
        
        personajes.add( new Personaje( "GRR0", "Guerrero", 50, 5 ) );
        personajes.add( new Personaje( "ARQ1", "Arquero", 40, 10 ) );
        personajes.add( new Personaje( "MAG2", "Mago", 45, 7 ) );
    }
    
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String compruebaConexion() {
        return "Servidor levantado";
    }
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login( JsonObject js ) {
        
        for ( Jugador j : jugadores ){
            if( j.getUsername().equals(js.get("username").toString()) &&
                j.getPassword().equals(js.get("password").toString()) )
                return "OK";
        }
        
        return "Los datos introducidos no son correctos.";
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
    
}
