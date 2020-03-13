package filtro;

public interface Filtro {

	double incrementoVelocidad = 0;

	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	double ejecutar(double revoluciones, EstadoMotor estadoMotor);

}