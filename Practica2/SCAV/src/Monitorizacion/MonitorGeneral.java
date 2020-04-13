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
public class MonitorGeneral extends Monitor {
    
    public MonitorGeneral() {
        super(1500);
    }
    
    public String getComponente() {
        return "General";
    }
    
}
