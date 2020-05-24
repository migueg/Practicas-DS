/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

import BD.Accesorio;
import BD.Arma;
import BD.Armadura;
import BD.Combate;
import BD.EstadoCombate;
import BD.InventarioArma;
import BD.Jugador;
import BD.Monstruo;
import BD.Movimiento;
import BD.Personaje;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Random;
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

/**
 *
 * @author juanfrandm98
 */
@Path("rolgame")
public class Servicio {
    
    private static ArrayList<Jugador> jugadores = new ArrayList();              // Lista de jugadores
    private static ArrayList<Personaje> personajes = new ArrayList();           // Lista de personajes jugables
    private static ArrayList<Arma> armas = new ArrayList();                     // Lista de armas
    private static ArrayList<Armadura> armaduras = new ArrayList();             // Lista de armaduras
    private static ArrayList<Accesorio> accesorios = new ArrayList();           // Lista de accesorios
    private static ArrayList<Movimiento> movimientos = new ArrayList();         // Lista de movimientos (ataques)
    private static ArrayList<Monstruo> monstruosNivel1 = new ArrayList();       // Lista de monstruos fáciles
    private static ArrayList<Monstruo> monstruosNivel2 = new ArrayList();       // Lista de monstruos difíciles
    
    static {
        jugadores.add( new Jugador( "juanfrandm98", "jfdm" ) );
        jugadores.add( new Jugador("administrador", "admin"));
        jugadores.add(new Jugador("migue" ,"migue"));
        
        jugadores.get(2).setRecord(200);
        
        personajes.add( new Personaje( "GRR0", "Guerrero", 40, 4, "https://image.freepik.com/vector-gratis/ilustracion-dibujos-animados-guerrero-vikingo_14588-144.jpg" ) );
        personajes.add( new Personaje( "ARQ1", "Arquero", 30, 6, "https://w7.pngwing.com/pngs/387/276/png-transparent-cartoon-longbow-drawing-archer-legendary-creature-bow-cartoon.png" ) );
        personajes.add( new Personaje( "MAG2", "Mago", 35, 3, "https://i0.pngocean.com/files/908/588/1003/chibi-magician-anime-drawing-dark-magician.jpg" ) );
        jugadores.get(2).setPersonaje(personajes.get(0));
        armas.add( new Arma( "Cachiporra", 5, 50, "Arma inútil, pero es mejor que nada", 20, "https://raicesdeperaleda.com/recursos/diccionario/af9190fc88e3c83936ef77ab9b16822e.jpg" ) );
        armas.add( new Arma( "Espada de cobre", 12, 100, "Espada de metal algo roma", 60, "https://dragonquest.fandom.com/es/wiki/Espada_de_Cobre?file=Espada_de_cobre.png" ) );
        armas.add( new Arma( "Varita de olivo", 8, 100, "Varita que crea llamas con el poder del aceite", 50, "https://lh3.googleusercontent.com/proxy/7Ufi4jyEfUHjhenOjjP6MMP8V_JBB7NO50l9M0YIpapWCvDYRpb1jz1cAxp8e-HaND88n7cbDLrXkdqITr_l0TMKuJKHD8PPrK01dv0RSSGaBkN4qK8KwE6Fsph-vw" ) );
        armas.add( new Arma( "Arco sencillo", 10, 100, "Arco ideal para los que quieren aprender", 40, "https://w7.pngwing.com/pngs/472/879/png-transparent-longbow-larp-bows-bow-and-arrow-recurve-bow-arrow-bow-weapon-bow-and-arrow.png" ) );

        armaduras.add( new Armadura( "Ropa vieja", 5, 50, "Suficiente para tapar tus partes", 20, "https://i.pinimg.com/originals/28/da/a3/28daa3663498c909d99715cc1eaced8b.jpg" ) );
        armaduras.add( new Armadura( "Armadura de cuero", 20, 100, "Armadura de piel básica", 60, "https://www.eltallerdelarosa.com/636-large_default/armadura-dragon.jpg" ) );
        armaduras.add( new Armadura( "Armadura de hierro", 30, 100, "Armadura de metal resistente", 120, "https://previews.123rf.com/images/vitaliygaydukov/vitaliygaydukov1705/vitaliygaydukov170500020/81168807-armadura-de-cadena-de-hierro-sobre-fondo-blanco-aislado-ilustraci%C3%B3n-3d.jpg" ) );

        accesorios.add( new Accesorio( "Amuleto de la suerte", 1, 1, "Talismán que guardas desde pequeño", 10, "https://images-na.ssl-images-amazon.com/images/I/61YZjlF2U8L._AC_UX395_.jpg" ) );
        accesorios.add( new Accesorio( "Anillo verde", 0, 10, "Anillo que te hace sentir más vivo", 80, "https://beautifulpromiserings.com/wp-content/uploads/2014/01/Emerald-Heart-Shaped-Ring-Green-Cubic-Zirconia.jpg" ) );
        accesorios.add( new Accesorio( "Anillo rojo", 5, 0, "Anillo que te hace sentir más fuerte", 80, "https://di2ponv0v5otw.cloudfront.net/posts/2020/01/13/5e1d0c4808d2c25532d3a458/m_5e1d0c522cc51523773cb525.jpg" ) );
        accesorios.add( new Accesorio( "Biblia", 3, 8, "Libro que te inspira en la batalla", 100, "https://www.christiantruthcenter.com/wp-content/uploads/2016/10/Bible-is-not-the-Word-1024x1024.jpg" ) );

        // Movimientos para los personajes
        movimientos.add( new Movimiento( "Ataque básico", 5, "ninguno", 0 ) );      // 0 - Ataque básico
        movimientos.add( new Movimiento( "Golpe contundente", 8, "animal", 2 ) );   // 1 - Golpe contundente
        movimientos.add( new Movimiento( "Embestida", 8, "material", 2 ) );         // 2 - Embestida
        movimientos.add( new Movimiento( "Conjuro ígneo", 8, "material", 2 ) );     // 3 - Conjuro ígneo
        movimientos.add( new Movimiento( "Conjuro luminoso", 8, "demonio", 2 ) );   // 4 - Conjuro luminoso
        movimientos.add( new Movimiento( "Flechazo oscuro", 8, "demonio", 2 ) );    // 5 - Flechazo oscuro
        movimientos.add( new Movimiento( "Tiro de caza", 8, "animal", 2 ) );        // 6 - Tiro de caza
        
        // Movimientos para los monstruos
        movimientos.add( new Movimiento( "Mordisco", 7, "mago", 2 ) );              // 7 - Mordisco
        movimientos.add( new Movimiento( "Placaje", 7, "arquero", 2 ) );            // 8 - Placaje
        movimientos.add( new Movimiento( "Lanzamiento", 7, "guerrero", 2 ) );       // 9 - Lanzamiento
        movimientos.add( new Movimiento( "Susto", 7, "guerrero", 2 ) );             // 10 - Susto
        movimientos.add( new Movimiento( "Llamarada", 10, "arquero", 3 ) );         // 11 - Llamarada
        movimientos.add( new Movimiento( "Superpuñetazo", 11, "mago", 3 ) );        // 12 - Superpuñetazo
        movimientos.add( new Movimiento( "Golpe sombrío", 13, "ninguno", 0 ) );     // 13 - Golpe sombrío
        
        // Añadir ataques a personajes
        personajes.get(0).addMovimiento( movimientos.get(0) );
        personajes.get(0).addMovimiento( movimientos.get(1) );
        personajes.get(0).addMovimiento( movimientos.get(2) );
        personajes.get(1).addMovimiento( movimientos.get(0) );
        personajes.get(1).addMovimiento( movimientos.get(3) );
        personajes.get(1).addMovimiento( movimientos.get(4) );
        personajes.get(2).addMovimiento( movimientos.get(0) );
        personajes.get(2).addMovimiento( movimientos.get(5) );
        personajes.get(2).addMovimiento( movimientos.get(6) );
        
        // Creación monstruos fáciles
        monstruosNivel1.add( new Monstruo( "Murciélago", "animal", 15, 2, 3, "https://i0.pngocean.com/files/430/195/778/bat-drawing-cartoon-royalty-free-clip-art-bat.jpg" ) );
        monstruosNivel1.add( new Monstruo( "Vaca", "animal", 20, 1, 1, "https://w7.pngwing.com/pngs/276/357/png-transparent-beef-cattle-calf-free-content-white-cow-s-white-head-cartoon.png" ) );
        monstruosNivel1.add( new Monstruo( "Pedrolo", "material", 25, 0, 5, "https://media.istockphoto.com/vectors/crazy-stone-character-cartoon-style-vector-id882102002" ) );
        monstruosNivel1.add( new Monstruo( "Fantasma", "demonio", 13, 5, 3, "https://i.pinimg.com/736x/1d/15/2f/1d152f20e0ec63179132a47c0dde3069.jpg" ) );
        monstruosNivel1.add( new Monstruo( "Diablillo", "demonio", 18, 2, 5, "https://cdn5.dibujos.net/dibujos/pintados/201043/3a209491639c9e8fe046189e0209966b.png" ) );
        
        // Ataques para monstruos fáciles
        monstruosNivel1.get(0).addMovimiento( movimientos.get(0) );
        monstruosNivel1.get(0).addMovimiento( movimientos.get(7) );
        monstruosNivel1.get(1).addMovimiento( movimientos.get(0) );
        monstruosNivel1.get(1).addMovimiento( movimientos.get(8) );
        monstruosNivel1.get(2).addMovimiento( movimientos.get(0) );
        monstruosNivel1.get(2).addMovimiento( movimientos.get(8) );
        monstruosNivel1.get(3).addMovimiento( movimientos.get(0) );
        monstruosNivel1.get(3).addMovimiento( movimientos.get(10) );
        monstruosNivel1.get(4).addMovimiento( movimientos.get(0) );
        monstruosNivel1.get(4).addMovimiento( movimientos.get(9) );
        
        // Creación monstruos difíciles
        monstruosNivel2.add( new Monstruo( "Dragón alado", "animal", 40, 5, 30, "https://image.freepik.com/vector-gratis/dragon-rojo-dibujos-animados-sobre-fondo-blanco_29190-4722.jpg" ) );
        monstruosNivel2.add( new Monstruo( "Golem", "material", 50, 4, 30,  "https://vignette.wikia.nocookie.net/villains/images/d/d8/Golemdq.png/revision/latest?cb=20130408202459" ) );
        monstruosNivel2.add( new Monstruo( "Demonio guerrero", "demonio", 35, 7, 50, "https://i0.pngocean.com/files/570/576/840/devil-deviantart-drawing-witchcraft-demon-devil.jpg" ) );
        
        // Ataques para monstruos difíciles
        monstruosNivel2.get(0).addMovimiento( movimientos.get(0) );
        monstruosNivel2.get(0).addMovimiento( movimientos.get(11) );
        monstruosNivel2.get(1).addMovimiento( movimientos.get(0) );
        monstruosNivel2.get(1).addMovimiento( movimientos.get(12) );
        monstruosNivel2.get(2).addMovimiento( movimientos.get(0) );
        monstruosNivel2.get(2).addMovimiento( movimientos.get(13) );
        
        jugadores.get(0).setPersonaje(personajes.get(2));
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
    
    private int indexofMovimiento( String movimiento ) {
        int index = -1;
        
        for( int i = 0; i < movimientos.size(); i++ )
            if( movimientos.get(i).getNombre().equals( movimiento ) )
                return i;
        
        return index;
    }
    private Personaje getPersonaje(String nombre){
        Personaje p = null;
        
        for(Personaje per : personajes){
            if(per.getNombre().equals(nombre))
                p = new Personaje( per );
        }
        
        return p;
    }
    
    private int indexofMonstruo(String nombre , int nivel){
        int index = -1;
        boolean paro = false;
        if(nivel == 1){
            for(int i = 0 ; i < monstruosNivel1.size()  && !paro; i++ ){
                if(monstruosNivel1.get(i).getNombre().equals(nombre)){
                    index = i;
                    paro = true;
                }
            }
        }
        
         if(nivel == 2){
            for(int i = 0 ; i < monstruosNivel2.size()  && !paro; i++ ){
                if(monstruosNivel2.get(i).getNombre().equals(nombre)){
                    index = i;
                    paro = true;
                }
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
    @Path("personaje/{index}")
    public datosPersonaje getPerson(@PathParam("index") String index){
        int indice = Integer.parseInt(index);
        datosPersonaje d = new datosPersonaje();
        Personaje p = this.personajes.get(indice);
        System.out.println(indice);
        d.setCodigo(p.getCodigo());
        d.setNombre(p.getNombre());
        d.setPA(p.getPA());
        d.setPV(p.getPV());
        d.setUrl(p.getUrl());
        
        return d;
    }
    @GET
    @Produces({"application/json"})
     @Path("ranking")
    public ArrayList<ranking>  getRanking(){
        ArrayList<ranking> lista = new ArrayList();
        ArrayList<Jugador> aux = new ArrayList();
        aux = this.jugadores;
      
        
        Jugador tmp ;
         for(int i = 1 ; i < aux.size() ; i++){
              for(int j = aux.size()-1 ; j >= i ; j--){
                    if(aux.get(j).getRecord()> aux.get(j-1).getRecord()){
                        tmp = aux.get(j);
                        aux.set(j, aux.get(j-1));
                        aux.set(j-1, tmp);
                    }else if(aux.get(j).getRecord() == aux.get(j-1).getRecord()){
                        if(aux.get(j).getOro()> aux.get(j-1).getOro()){
                            tmp = aux.get(j);
                            aux.set(j, aux.get(j-1));
                            aux.set(j-1, tmp);
                        }
                    }
              }
         }
        
       
        for( int i = 0 ; i < aux.size(); i++ ){
           ranking r = new ranking();
           if(!(aux.get(i).getUsername().equals("administrador"))){
                r.setUsername(aux.get(i).getUsername());
                r.setRecord(aux.get(i).getRecord());
                r.setOro(aux.get(i).getOro());
           
                lista.add(r);
           }
         
        }
        return lista;
    }

    @GET 
    @Produces({"application/json"})
    @Path("personajes")
    public ArrayList<jsonResponse> getPersonajes (){
        ArrayList<jsonResponse> respuestas = new ArrayList();
        
        for(Personaje p : personajes ){
            jsonResponse r = new jsonResponse();
            r.setResultado(p.getNombre());
            respuestas.add(r);
        }
        return respuestas;
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
        ArrayList<Accesorio> accesorios = j.getAccesorios();
        
        //Obtengo el material equipado
        Arma equipada = j.getEquipada();
        Armadura armadura = j.getArmadura();
        Accesorio accesorio = j.getAccesorio();
        //La posicion 0, 1 y 2 serán el arma, la armadura y el accesorio
        //equipados
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
        
        InventarioArma invAcc = new InventarioArma();
        invAcc.setTipo( accesorio.getTipo() );
        invAcc.setNombreAccesorio( accesorio.getNombreAccesorio());
        invAcc.setAtaqueAccesorio( accesorio.getBonusAtaque() );
        invAcc.setVidaAccesorio( accesorio.getBonusVida() );
        inventario.add(invAcc);
         
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
        
        System.out.println( "AA" );
        for( int i = 0; i < accesorios.size(); i++ ) {
            InventarioArma nuevo = new InventarioArma();
            nuevo.setTipo( accesorios.get(i).getTipo() );
            nuevo.setNombreAccesorio( accesorios.get(i).getNombreAccesorio() );
            nuevo.setAtaqueAccesorio( accesorios.get(i).getBonusAtaque() );
            nuevo.setVidaAccesorio( accesorios.get(i).getBonusVida() );
            
            inventario.add(nuevo);
        }
         
         return inventario;
         
    }
    
    @GET 
    @Produces({"application/json"})
    @Path("monstruos")
    public ArrayList<datosMonstruo> getMonstruos(){
        ArrayList<datosMonstruo> lista = new ArrayList();
        
        for(Monstruo m : monstruosNivel1 ){
            datosMonstruo d = new datosMonstruo();
            d.setNivel(1);
            d.setUrl(m.getUrl());
            d.setNombre(m.getNombre());
            d.setTipo(m.getTipo());
            d.setPuntosVida(m.getPuntosVida());
            d.setPuntosAtaque(m.getPuntosAtaque());
            d.setRecompensa(m.getRecompensa());
            d.setMovimientos(m.getnumMovimientos());
            
            lista.add(d);
        }
        
        for(Monstruo m : monstruosNivel2 ){
            datosMonstruo d = new datosMonstruo();
            d.setNivel(2);
            d.setUrl(m.getUrl());
            d.setNombre(m.getNombre());
            d.setTipo(m.getTipo());
            d.setPuntosVida(m.getPuntosVida());
            d.setPuntosAtaque(m.getPuntosAtaque());
            d.setRecompensa(m.getRecompensa());
            d.setMovimientos(m.getnumMovimientos());
            
            lista.add(d);
        }
        return lista;
    }
    
    @POST
    @Path("addMonstruo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addMonstruo(datosMonstruo d){
        if(d.getNivel() == 1){
           this.monstruosNivel1.add(new Monstruo(d.getNombre(),d.getTipo(),d.getPuntosVida(),d.getPuntosAtaque(),d.getRecompensa(),d.getUrl()));
           return "OK";
        }
         if(d.getNivel() == 2){
           this.monstruosNivel2.add(new Monstruo(d.getNombre(),d.getTipo(),d.getPuntosVida(),d.getPuntosAtaque(),d.getRecompensa(),d.getUrl()));
           return "OK";
        }
         
         return "Error";
    }
    
    @POST
    @Path("addMove")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addMovimiento(datosMovimiento d){
        Monstruo m ;
        String mensaje = "Error";
        switch(d.getNivel()){
            case 1:
               m = monstruosNivel1.get(this.indexofMonstruo(d.getMonstruo(), 1));
               m.addMovimiento(new Movimiento(d.getNombre(),d.getPotencia(),d.getTipoConBonus(),d.getBonus()));
               mensaje = "OK";
               break;
            case 2:
               m = monstruosNivel2.get(this.indexofMonstruo(d.getMonstruo(), 1));
               m.addMovimiento(new Movimiento(d.getNombre(),d.getPotencia(),d.getTipoConBonus(),d.getBonus()));
               mensaje = "OK";
               break;
                
        }
        return mensaje;
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
    public String registro( datosRegistro jugador ) {
        Jugador jg ;
      
        for ( Jugador j : jugadores ){
            if( j.getUsername().equals(jugador.getUsername())){
                return "El usuario ya existe en la plataforma.";
            }
                
        }
         
        jg = new Jugador(jugador.getUsername(),jugador.getPassword());
        jg.setPersonaje(this.getPersonaje(jugador.getPersonaje()));
        jg.modificarPuntos();
        this.jugadores.add(jg);
           
        return "OK";
    }
    
    @POST
    @Path("registroApp")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public jsonResponse registroApp( datosConexion datos ) {
        
        System.out.println( "Usuario quiere registrarse con username: " + datos.getUsername() );
        
        boolean existe = false;
        jsonResponse js = new jsonResponse();
        
        for( Jugador j : jugadores )
            if( j.getUsername().equals( datos.getUsername() ) ) {
                System.out.println( "El nombre ya está cogido." );
                existe = true;
            }
        
        if( existe ) {
            js.setResultado( "El usuario ya existe en la plataforma." );
        } else {
            Jugador j = new Jugador( datos.getUsername(), datos.getPassword() );
            this.jugadores.add(j);
            js.setResultado( "OK" );
        }
           
        return js;
    }
    
    @POST
    @Path("selectClass")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public jsonResponse selectClass( DatosSeleccionClase js ) {
        
        System.out.println( "Jugador " + js.getUsername() + " selecciona su clase: " + js.getClase() );
        
        Jugador jugador = jugadores.get( indexofJugador( js.getUsername() ) );
        
        jugador.setPersonaje( getPersonaje( js.getClase() ) );
        jugador.modificarPuntos();
        
        jsonResponse respuesta = new jsonResponse();
        respuesta.setResultado( "OK" );
        return respuesta;
        
    }
    
    private void equipar( datosEquipo d ) {
        System.out.println("ME LLEGA:");
        System.out.println(d.getUsername());
        Jugador j = jugadores.get(this.indexofJugador(d.getUsername()));

        j.equipar(d.getTipo(), d.getNombre());
    }
    
    @PUT
    @Path("equipar")
    @Consumes({"application/json"})
    public void cambiarArma(datosEquipo d){
        equipar(d);
    }
    
    @PUT
    @Path("equiparConf")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public jsonResponse cambiarEquipo( datosEquipo d ) {
        equipar(d);
        jsonResponse js = new jsonResponse();
        js.setResultado("OK");
        return js;
    }
    
    private int calcularSemilla() {

        int semilla = 0;

        Calendar fecha = Calendar.getInstance();

        semilla += fecha.get( Calendar.DAY_OF_MONTH );
        semilla += fecha.get( Calendar.MONTH );
        semilla += fecha.get( Calendar.YEAR );

        return semilla;

    }
    
    @PUT 
    @Consumes({"application/json"})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("oro")
    public String modificarOro(datosPremio p){
        int index = this.indexofJugador(p.getUsername());
        if(index != -1){
            this.jugadores.get(index).modificarOro(p.getCantidad());
            return "OK";
        }
        
        return "No existe el jugador";
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("fotoClase/{user}")
    public String fotoClase( @PathParam("user") String user ) {
        Jugador jugador = this.jugadores.get( indexofJugador( user ) );
        return jugador.getFotoPersonaje();
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
        armaTienda.setUrl( armaSeleccionada.getUrl() );
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
        armaduraTienda.setUrl( armaduraSeleccionada.getUrl() );
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
        accesorioTienda.setUrl( accesorioSeleccionado.getUrl() );
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
        } else if( tipo.equals( "accesorio" ) ) {
            for( int i = 0; i < accesorios.size() && !paro; i++ ) {
                if( accesorios.get(i).getNombreAccesorio().equals( nombre ) ) {
                    paro = true;
                    index = i;
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
                Arma arma = new Arma( armas.get(posicion) );
                if( puedoComprar( arma.getCoste(), jugador.getOro() ) ) {
                    jugador.restarOro( arma.getCoste() );
                    jugador.addArma( arma );
                    js.setResultado( "Compra realizada." );
                } else {
                    js.setResultado( "Oro insuficiente." );
                }
                break;
            case "armadura":
                Armadura armadura = new Armadura( armaduras.get(posicion) );
                if( puedoComprar( armadura.getCoste(), jugador.getOro() ) ) {
                    jugador.restarOro( armadura.getCoste() );
                    jugador.addArmadura( armadura );
                    js.setResultado( "Compra realizada." );
                } else {
                    js.setResultado( "Oro insuficiente." );
                }
                break;
            default:
                Accesorio accesorio = new Accesorio( accesorios.get(posicion) );
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
    
    private Combate iniciarCombate( Jugador jugador ) {
        
        Random random = new Random();
        Monstruo mon;
        
        if( jugador.getCombateActual() >= 7 )
            mon = monstruosNivel2.get( random.nextInt( monstruosNivel2.size() ) );
        else
            mon = monstruosNivel1.get( random.nextInt( monstruosNivel1.size() ) );
        
        return new Combate( mon, jugador.getPersonaje(), false );
        
    }
    
    @GET
    @Produces({"application/json"})
    @Path("inicioCombate/{user}")
    public ArrayList<jsonResponse> inicioCombate( @PathParam("user") String user ) {
        
        Jugador j = this.jugadores.get( indexofJugador( user ) );
        
        if( j.getCombate().getEstado() == EstadoCombate.ENCURSO ) {
            System.out.println( "Jugador " + user + " quiere continuar con el combate." );
        } else {
            System.out.println( "Jugador " + user + " quiere iniciar un nuevo combate." );
            j.setCombate( iniciarCombate( j ) );
        }
        
        ArrayList<String> movs = j.getMovimientos();
        ArrayList<jsonResponse> envio = new ArrayList();
        
        System.out.println( "Tiene " + movs.size() + " movimientos." );
        
        for( String s : movs ) {
            jsonResponse nuevo = new jsonResponse();
            nuevo.setResultado( s );
            envio.add(nuevo);
        }
        
        return envio;
        
    }
    
    @GET
    @Produces({"application/json"})
    @Path("estadoCombate/{user}")
    public EnvioEstadoCombate getEstadoCombate( @PathParam("user") String user ) {
        
        System.out.println( "Jugador " + user + " pide los datos del combate." );
        
        EnvioEstadoCombate estado = new EnvioEstadoCombate();
        
        Jugador j = this.jugadores.get( indexofJugador( user ) );
        Combate combate = j.getCombate();
        
        estado.setEstado( combate.getEstado().toString() );
        estado.setEnemigo( combate.getEnemigo().getNombre() );
        estado.setUrl( combate.getEnemigo().getUrl() );
        estado.setPvEnemigo( combate.getPvEnemigo() );
        estado.setPvJugador( combate.getPvJugador() );
        estado.setDanioRecibido( combate.getUltDanio() );
        estado.setMovimientoRecibido( combate.getUltMov() );
        estado.setRecompensa( combate.getEnemigo().getRecompensa() );
        
        return estado;
        
    }
    
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("turno")
    public EnvioEstadoCombate nuevoTurno( Turno turno ) {
        
        System.out.println( "Turno de " + turno.getUsername() );
        
        EnvioEstadoCombate estado = new EnvioEstadoCombate();
        
        Jugador j = this.jugadores.get( indexofJugador( turno.getUsername() ) );
        Combate combate = j.getCombate();
        Movimiento movimiento = this.movimientos.get( indexofMovimiento( turno.getMovimiento() ) );
        
        int danio = combate.turno( movimiento );
        
        if( combate.getEstado() != EstadoCombate.ENCURSO )
            j.resultadosCombate();
        
        estado.setEstado( combate.getEstado().toString() );
        estado.setEnemigo( combate.getEnemigo().getNombre() );
        estado.setUrl( combate.getEnemigo().getUrl() );
        estado.setPvEnemigo( combate.getPvEnemigo() );
        estado.setPvJugador( combate.getPvJugador() );
        estado.setDanioRecibido( danio );
        estado.setMovimientoRecibido( combate.getUltMov() );
        estado.setRecompensa( combate.getEnemigo().getRecompensa() );
        
        return estado;
        
    }
    
    @GET
    @Produces({"application/json"})
    @Path("resultado/{user}")
    public EnvioFinCombate getResultadoCombate( @PathParam("user") String user ) {
        
        System.out.println( "Jugador " + user + " consulta el estado de su último combate." );
        
        EnvioFinCombate envio = new EnvioFinCombate();
        Jugador j = this.jugadores.get( indexofJugador( user ) );
        
        envio.setResultado( j.getCombate().getEstado().toString() );
        envio.setOro( j.getOro() );
        envio.setCombateActual( j.getCombateActual() );
        envio.setRecord( j.getRecord() );
        envio.setAlgoRoto( j.getCombate().getAlgoRoto() );
        
        switch( envio.getResultado() ) {
            case "GANADO":
                envio.setRecompensa( j.getCombate().getEnemigo().getRecompensa() );
                break;
            default:
                envio.setRecompensa( j.getOro() );
                break;
        }
        
        return envio;
        
    }
    
    @PUT    
    @Produces({"application/json"})
    @Path("giveup/{user}")
    public jsonResponse rendirse (@PathParam("user") String user ){
        
        System.out.println( "Jugador " + user + " se rinde." );
        
        Jugador j = this.jugadores.get( indexofJugador( user ) );
        j.getCombate().setEstado( EstadoCombate.RENDIDO );
        j.resultadosCombate();
        
        jsonResponse js = new jsonResponse();
        js.setResultado("OK");
        
        return js;
        
    }
    
    @GET
    @Produces({"application/json"})
    @Path("perfil/{user}")
    public DatosPerfil obtienePerfil( @PathParam("user") String user ) {
        
        Jugador j = jugadores.get( indexofJugador( user ) );
        DatosPerfil datos = new DatosPerfil();
        
        datos.setPersonaje( j.getPersonaje().getNombre() );
        datos.setRecord( j.getRecord() );
        datos.setCombateActual( j.getCombateActual() );
        datos.setOro( j.getOro() );
        
        return datos;
        
    }
    
    @POST
    @Consumes({"application/json"}) 
    @Produces({"application/json"})
    @Path("changepass")
    public jsonResponse cambioContrasenia( DatosCambioContrasenia datos ) {
        
        jsonResponse js = new jsonResponse();
        Jugador j = jugadores.get( indexofJugador( datos.getUsername() ) );
        
        if( !j.getPassword().equals(datos.getOldpass()) ) {
            js.setResultado( "Contraseña actual incorrecta" );
        } else {
            if ( datos.getOldpass().equals( datos.getNewpass() ) ) {
                js.setResultado( "La nueva contraseña no puede ser igual que la vieja" );
            } else {
                j.setPassword( datos.getNewpass() );
                js.setResultado( "OK" );
            }
        }
        
        return js;
    }
}
