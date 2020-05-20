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
public class Armadura {
        
    private String nombre;
    private String tipo;
    //private String rutaImagen;
    
    private int plusVida;
    private int vida;

    public Armadura(String nombre, String tipo, int plusVida, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.plusVida = plusVida;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPlusVida() {
        return plusVida;
    }

    public void setPlusVida(int plusVida) {
        this.plusVida = plusVida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    

  
    
}
