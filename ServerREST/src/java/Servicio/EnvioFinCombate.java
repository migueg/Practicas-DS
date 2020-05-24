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
public class EnvioFinCombate {
    
    private String resultado;
    private int recompensa;
    private int oro;
    private int combateActual;
    private int record;
    private boolean algoRoto;
    
    public EnvioFinCombate(){}
    
    // Setters
    public void setResultado( String resultado ) { this.resultado = resultado; }
    public void setRecompensa( int recompensa ) { this.recompensa = recompensa; }
    public void setOro( int oro ) { this.oro = oro; }
    public void setCombateActual( int combateActual ) { this.combateActual = combateActual; }
    public void setRecord( int record ) { this.record = record; }
    public void setAlgoRoto( boolean algoRoto ) { this.algoRoto = algoRoto; }
    
    // Getters
    public String getResultado() { return resultado; }
    public int getRecompensa() { return recompensa; }
    public int getOro() { return oro; }
    public int getCombateActual() { return combateActual; }
    public int getRecord() { return record; }
    public boolean getAlgoRoto() { return algoRoto; }
    
}
