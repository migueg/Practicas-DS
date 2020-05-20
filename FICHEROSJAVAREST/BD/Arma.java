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
    private String descripcion;
    
    private int plusDaño;
    private int vida;
     private int coste;

  
    
     public Arma (String nombre , int daño , int vida, String descripcion, int coste ){
        this.nombreArma = nombre;
        this.tipo = "arma";
        this.plusDaño = daño;
        this.vida = vida;
        this.descripcion = descripcion;
        this.coste = coste;
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
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }
}
