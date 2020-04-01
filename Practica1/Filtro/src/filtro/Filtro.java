package filtro;

public interface Filtro {

        static final double MAXIMO = 5000;
        
	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	double ejecutar( double revoluciones, EstadoMotor estadoMotor );
        

}