/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.util.ArrayList;

/**
 *
 * @author juanfrandm98
 */
public class Personaje {
     
    private String codigo;
    private String nombre;
    private String url;
    private int PV;
    private int PA;
    private ArrayList<Movimiento> movimientos;

    public Personaje( String codigo, String nombre, int PV, int PA, String url ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.PV = PV;
        this.PA = PA;
        this.url = url;
        this.movimientos = new ArrayList();
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
        return new Personaje( codigo, nombre, PV, PA, url );
    }
    
    public String getUrl() { return url; }
    
    public void addMovimiento( Movimiento movimiento ) {
        movimientos.add( movimiento );
    }
    
    public ArrayList<Movimiento> getMovimientos() { return movimientos; }
    
    public String getClase() {
        
        switch( codigo ) {
            case "GRR0":
                return "guerrero";
            case "ARQ1":
                return "arquero";
            default:
                return "mago";
        }
        
    }
    
    public ArrayList<String> getNombresMovimientos() {
        ArrayList<String> movs = new ArrayList();
        
        for( Movimiento m : movimientos )
            movs.add( m.getNombre() );
        
        return movs;
    }
    
}
