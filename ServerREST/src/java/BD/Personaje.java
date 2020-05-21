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
public class Personaje {
     
    private String codigo;
    private String nombre;
    private int PV;
    private int PA;

    public Personaje( String codigo, String nombre, int PV, int PA ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.PV = PV;
        this.PA = PA;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
      

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }
    
    public void modificarPA(int v){
        this.PA += v;
    }
    
    public void modificarPV(int v){
        this.PV += v;
    }

    public Personaje getBase() {
        return new Personaje( codigo, nombre, PV, PA );
    }
    
}
