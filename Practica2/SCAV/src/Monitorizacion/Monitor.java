/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitorizacion;

/**
 *
 * @author juanfrandm98
 */
public abstract class Monitor {
    
    // Revoluciones acumuladas desde la última revisión
    private long revolucionesAcumuladas;
    // Revoluciones recomendadas a partir de las cuales debe revisarse un
    // componente
    private long revolucionesParaRevision;
    
    public Monitor( long revolucionesParaRevision ) {
        
        revolucionesAcumuladas = 0;
        this.revolucionesParaRevision = revolucionesParaRevision;
        
    }
    
    public void actualizarRevoluciones( double revoluciones ) {
        
        double ultimoCiclo = revoluciones / 600;
        revolucionesAcumuladas += ultimoCiclo;
        
        System.out.println( getComponente() + ": " + revolucionesAcumuladas +
                            "/" + revolucionesParaRevision);
        
    }
    
    public boolean comprobarRevision() {
        
        if( revolucionesAcumuladas >= revolucionesParaRevision )
            return true;
        else
            return false;
        
    }
    
    public void revisar() {
        
        revolucionesAcumuladas = 0;
        System.out.println( getComponente() + ": revisado con éxito!" );
        
    }
    
    abstract String getComponente();
    
}
