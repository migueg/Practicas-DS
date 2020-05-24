/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

/**
 *
 * @author juanfrandm98
 */
public class DatosPerfil {
    
    private String personaje;
    private int record;
    private int combateActual;
    private int oro;
    
    public DatosPerfil() {}
    
    // Setters
    public void setPersonaje( String personaje ) { this.personaje = personaje; }
    public void setRecord( int record ) { this.record = record; }
    public void setCombateActual( int combateActual ) { this.combateActual = combateActual; }
    public void setOro( int oro ) { this.oro = oro; }
    
    // Getters
    public String getPersonaje() { return personaje; }
    public int getRecord() { return record; }
    public int getCcambombateActual() { return combateActual; }
    public int getOro() { return oro; }
    
}
