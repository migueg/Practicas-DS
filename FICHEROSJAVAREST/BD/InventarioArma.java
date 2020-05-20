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

 
    private String personaje;
    private int vida;
    private int daño;
    
    private String tipo;
    
    private String nombreArma;
    private int vidaArma;
    private int dañoArma;
    
    private String nombreArmadura;
    private int  plusVida;
    private int vidaArmadura;
    
    public InventarioArma(){}

    public String getNombreArmadura() {
        return nombreArmadura;
    }

    public void setNombreArmadura(String nombreArmadura) {
        this.nombreArmadura = nombreArmadura;
    }

    public int getPlusVida() {
        return plusVida;
    }

    public void setPlusVida(int plusVida) {
        this.plusVida = plusVida;
    }

    public int getVidaArmadura() {
        return vidaArmadura;
    }

    public void setVidaArmadura(int vidaArmadura) {
        this.vidaArmadura = vidaArmadura;
    }

    
    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
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
