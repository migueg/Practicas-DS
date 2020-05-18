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
public class Arma {

    
    private String nombreArma;
    private String tipo;
    //private String rutaImagen;
    
    private int plusDaño;
    private int vida;
    
    
    public Arma (String nombre , String tipo , int daño , int vida){
        this.nombreArma = nombre;
        this.tipo = tipo;
        this.plusDaño = daño;
        this.vida = vida;
    }
    
    public String getNombreArma() {
        return nombreArma;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPlusDaño() {
        return plusDaño;
    }

    public int getVida() {
        return vida;
    }
    
  
}
