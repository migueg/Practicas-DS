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
public class Accesorio {
    
    private String nombreAccesorio;
    private String tipo;
    private int bonusAtaque;
    private int bonusVida;
    private String descripcion;
    private int coste;
    
    public Accesorio( String nombreAccesorio, int bonusAtaque, int bonusVida, String descripcion, int coste ) {
        
        this.nombreAccesorio = nombreAccesorio;
        this.tipo = "accesorio";
        this.bonusAtaque = bonusAtaque;
        this.bonusVida = bonusVida;
        this.descripcion = descripcion;
        this.coste = coste;
        
    }
    
    public String getNombreAccesorio() { return nombreAccesorio; }
    public String getTipo() { return tipo; }
    public int getBonusAtaque() { return bonusAtaque; }
    public int getBonusVida() { return bonusVida; }
    public String getDescripcion() { return descripcion; }
    public int getCoste() { return coste; }
    
}
