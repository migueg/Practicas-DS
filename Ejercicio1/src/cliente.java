/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */

import java.util.Scanner;

public class cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        FactoriaCarretera fc = new FactoriaCarretera();
        FactoriaMontana fm = new FactoriaMontana();
        
        Carrera cm = fm.crearCarrera();
        Carrera cc = fc.crearCarrera();
       
        Scanner s = new Scanner (System.in);
        
        System.out.print("Introdice el numero de bicicletas:");
          
        int n = s.nextInt();
        
        System.out.print("\n");
        Bicicleta bc;
        Bicicleta bm; 
      
          for(int i = 0 ; i < n ; i++){
              bc = fc.crearBicicleta();
              cc.aniadirBicicleta(bc);
              bm = fm.crearBicicleta();
              cm.aniadirBicicleta(bm);
          }
         
         long retardo = 60000;
         cm.start();
         cc.start();
         
         Thread.sleep(retardo);
         if(cm.isAlive() && cc.isAlive()){
             cm.stop();
             cc.stop();
         }
         
         
         
    }
    
}
