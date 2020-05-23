/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author juanfrandm98
 */
public class Monstruo {
    
    private String nombre;
    private String url;
    private String tipo;
    private int puntosVida;
    private int puntosAtaque;
    private int recompensa;
    private ArrayList<Movimiento> movimientos;
    
    public Monstruo( String nombre, String tipo, int puntosVida, int puntosAtaque, int recompensa, String url ) {
        this.nombre = nombre;
        this.url = url;
        this.tipo = tipo;
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
        this.recompensa = recompensa;
        this.movimientos = new ArrayList();
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getUrl() { return url; }
    public String getTipo() { return tipo; }
    public int getPuntosVida() { return puntosVida; }
    public int getPuntosAtaque() { return puntosAtaque; }
    public int getRecompensa() { return recompensa; }
    
    public void addMovimiento( Movimiento movimiento ) {
        movimientos.add( movimiento );
    }
    
    public Movimiento movimientoAleatorio() {
        
        Random random = new Random();
        return movimientos.get( random.nextInt( movimientos.size() ) );
        
    }
    
}
