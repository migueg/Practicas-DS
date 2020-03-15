
package filtro;
public class FiltroRepercutirRozamiento implements Filtro {
        
        private final int ROZAMIENTO = 1;
        
	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	public double ejecutar( double revoluciones, EstadoMotor estadoMotor ) {
            
            double nuevasRevoluciones = revoluciones;
            
            if( nuevasRevoluciones - ROZAMIENTO > 0 )
                nuevasRevoluciones -= ROZAMIENTO;
            else
                nuevasRevoluciones = 0;

            System.out.println( "Filtro Rozamiento: " + revoluciones + " -> " +
                                nuevasRevoluciones + "." );
            
            return nuevasRevoluciones;
            
	}

}