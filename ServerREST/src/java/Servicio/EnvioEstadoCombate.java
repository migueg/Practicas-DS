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
public class EnvioEstadoCombate {
    
    private String estado;
    private String enemigo;
    private String url;
    private int pvEnemigo;
    private int pvJugador;
    private int danioRecibido;
    private String movimientoRecibido;
    private int recompensa;
    
    public EnvioEstadoCombate() {}
    
    // Setters
    public void setEstado( String estado ) { this.estado = estado; }
    public void setEnemigo( String enemigo ) { this.enemigo = enemigo; }
    public void setUrl( String url ) { this.url = url; }
    public void setPvEnemigo( int pvEnemigo ) { this.pvEnemigo = pvEnemigo; }
    public void setPvJugador( int pvJugador ) { this.pvJugador = pvJugador; }
    public void setDanioRecibido( int danioRecibido ) { this.danioRecibido = danioRecibido; }
    public void setMovimientoRecibido( String movimientoRecibido ) { this.movimientoRecibido = movimientoRecibido; }
    public void setRecompensa( int recompensa ) { this.recompensa = recompensa; }
    
    // Getters
    public String getEstado() { return estado; }
    public String getEnemigo() { return enemigo; }
    public String getUrl() { return url; }
    public int getPvEnemigo() { return pvEnemigo; }
    public int getPvJugador() { return pvJugador; }
    public int getDanioRecibido() { return danioRecibido; }
    public String getMovimientoRecibido() { return movimientoRecibido; }
    public int getRecompensa() { return recompensa; }
    
}
