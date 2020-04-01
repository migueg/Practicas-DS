
public class FiltroCalcularVelocidad implements Filtro {

	private double incremento = 0;
	private double ultimaVelocidad = 1000;
	private final double VELOCIDADMAXIMA = 742; // Para que no supere los 280 km/h
	
	public double ejecutar( double peticion, EstadoMotor estado ) {
		if( estado == EstadoMotor.ACELERANDO )
			incremento = 3;
		else if( estado == EstadoMotor.FRENANDO )
			incremento = -3;
		else if( estado == EstadoMotor.MANTENER ) {
			incremento = 1;		
			ultimaVelocidad = peticion;
		} else if( estado == EstadoMotor.APAGADO ) {
			ultimaVelocidad = 1000;
			incremento = 0;
		} else if( estado == EstadoMotor.REINICIAR ) {
			if( peticion < ultimaVelocidad )
				incremento = 2;
			else
				incremento = -2;
		} else
			incremento = 0;
		
		double nuevaVelocidad = peticion + incremento;
		
		if( nuevaVelocidad > VELOCIDADMAXIMA )
			nuevaVelocidad = VELOCIDADMAXIMA;
		else if( nuevaVelocidad < 0 )
			nuevaVelocidad = 0;
		
		if( estado == EstadoMotor.REINICIAR )
			if( ( nuevaVelocidad > ultimaVelocidad && incremento > 0 ) ||
				( nuevaVelocidad < ultimaVelocidad && incremento < 0 ) )
				nuevaVelocidad = ultimaVelocidad + 10;
		
		System.out.println( "Nueva velocidad: " + nuevaVelocidad );
		
		return nuevaVelocidad;
	}
	
}
