
public class FiltroRepercutirRozamiento implements Filtro {

	private final double ROZAMIENTO = 1;
	
	public double ejecutar( double peticion, EstadoMotor estado ) {
		if( peticion > 0 )
			peticion -= ROZAMIENTO;
		
		System.out.println( "Tras rozamiento: " + peticion );
		
		return peticion;
	}
	
}
