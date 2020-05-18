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
    
    public Personaje getBase() {
        return new Personaje( codigo, nombre, PV, PA );
    }
    
}
