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
    private String url;
    private String descripcion;
    private int coste;

    private int plusVida;
    private int vida;

    public Armadura(String nombre, int plusVida, int vida, String descripcion, int coste, String url ) {
        this.nombre = nombre;
        this.tipo = "armadura";
        this.plusVida = plusVida;
        this.vida = vida;
        this.descripcion = descripcion;
        this.coste = coste;
        this.url = url;
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


    public String getDescripcion() { return descripcion; }
    public int getCoste() { return coste; }
    public String getUrl() { return url; }

}