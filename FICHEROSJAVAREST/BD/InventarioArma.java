/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class InventarioArma {
    private String nombreJugador;
    private String vida;
    private String nombreArma;
    private String tipo;
    private int vidaArma;
    private int dañoArma;
    
    public InventarioArma(){}
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVidaArma() {
        return vidaArma;
    }

    public void setVidaArma(int vidaArma) {
        this.vidaArma = vidaArma;
    }

    public int getDañoArma() {
        return dañoArma;
    }

    public void setDañoArma(int dañoArma) {
        this.dañoArma = dañoArma;
    }
 
  
}
