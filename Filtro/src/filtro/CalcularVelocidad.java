package filtro;

public class CalcularVelocidad implements Filtro {
    	public double incrementoVelocidad ;

	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	public double ejecutar(double revoluciones, EstadoMotor estadoMotor) {
		// TODO - implement CalcularVelocidad.ejecutar
		if(estadoMotor == EstadoMotor.apagado){
                    incrementoVelocidad = 0;
                }else if(estadoMotor == EstadoMotor.encendido){
                    incrementoVelocidad = 0;
                }else if (estadoMotor == EstadoMotor.acelerado){
                    if(revoluciones < MAXIMO){
                         incrementoVelocidad = 100;

                    }
                }else if (estadoMotor == EstadoMotor.frenado){
                    incrementoVelocidad = -100;
                }
                
                return incrementoVelocidad;
	}

}