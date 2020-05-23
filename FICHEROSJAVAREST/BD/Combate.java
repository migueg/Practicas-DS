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
public class Combate {
    
    private Monstruo enemigo;
    private Personaje personaje;
    private EstadoCombate estado;
    private int pvJugador;
    private int pvEnemigo;
    private int ultDanio;
    private String ultMov;
    
    public Combate( Monstruo enemigo, Personaje personaje, boolean first ) {
        if( !first ) {
            this.enemigo = enemigo;
            this.personaje = personaje;
            this.estado = EstadoCombate.ENCURSO;
            this.pvJugador = personaje.getPV();
            this.pvEnemigo = enemigo.getPuntosVida();
        } else {
            this.estado = EstadoCombate.GANADO;
        }
    }
    
    public int turno( Movimiento movimiento ) {
        
        String tipoConBonus = movimiento.getTipoConBonus();
        int danio = movimiento.getPotencia();
        
        if( tipoConBonus.equals( enemigo.getTipo() ) )
            danio += movimiento.getBonus();
        
        pvEnemigo -= danio;
        
        if( pvEnemigo <= 0 )
            estado = EstadoCombate.GANADO;
        
        if( estado == EstadoCombate.ENCURSO ) {
            
            Movimiento movimientoRival = enemigo.movimientoAleatorio();
            tipoConBonus = movimientoRival.getTipoConBonus();
            danio = movimientoRival.getPotencia();
            
            if( tipoConBonus.equals( personaje.getClase() ) );
                danio += movimientoRival.getBonus();
                
            pvJugador -= danio;
            
            if( pvJugador <= 0 )
                estado = EstadoCombate.PERDIDO;
            
            ultDanio = danio;
            ultMov = movimientoRival.getNombre();
            
            return danio;
        } else {
            return 0;
        }
        
    }
    
    public Monstruo getEnemigo() { return enemigo; }
    public EstadoCombate getEstado() { return estado; }
    public int getPvEnemigo() { return pvEnemigo; }
    public int getPvJugador() { return pvJugador; }
    public int getUltDanio() { return ultDanio; }
    public String getUltMov() { return ultMov; }
    
}
