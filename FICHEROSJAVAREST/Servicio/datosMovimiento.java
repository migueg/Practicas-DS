/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author Usuario
 */
public class datosMovimiento {
    private String nombre;
    private int potencia;
    private String tipoConBonus;
    private int bonus;
    private int nivel;
    private String monstruo;

    public datosMovimiento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipoConBonus() {
        return tipoConBonus;
    }

    public void setTipoConBonus(String tipoConBonus) {
        this.tipoConBonus = tipoConBonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(String monstruo) {
        this.monstruo = monstruo;
    }
    
    
}
