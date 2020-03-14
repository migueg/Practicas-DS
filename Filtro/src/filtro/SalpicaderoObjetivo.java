package filtro;

import javax.swing.JPanel;
public class SalpicaderoObjetivo extends JPanel {
        static final double RADIO = 0.15;
	private EstadoMotor estadoMotor;
	private double velocidadAngular;
	private double velocidadLineal;
	private double distanciaRecorrida;
        Velocimetro velocimetro;
        CuentaKilometros cuentaKilometros;
        CuentaRevoluciones cuentaRevoluciones;
        

	public void ejecutar(double revoluciones , EstadoMotor estadoMotor) {
		// TODO - implement SalpicaderoObjetivo.ejecutar
		velocidadLineal = 2*Math.PI*RADIO * revoluciones * (60/100);
                velocidadAngular = revoluciones;
                distanciaRecorrida += velocidadLineal;
                
	}

	public void getVelocidadAngular() {
		// TODO - implement SalpicaderoObjetivo.getVelocidadAngular
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param velocidadAngular
	 */
	public void setVelocidadAngular(int velocidadAngular) {
		this.velocidadAngular = velocidadAngular;
	}

	public void getVelocidadLineal() {
		// TODO - implement SalpicaderoObjetivo.getVelocidadLineal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param velocidadLineal
	 */
	public void setVelocidadLineal(int velocidadLineal) {
		this.velocidadLineal = velocidadLineal;
	}

	public void getDistanciaRecorrida() {
		// TODO - implement SalpicaderoObjetivo.getDistanciaRecorrida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param distanciaRecorrida
	 */
	public void setDistanciaRecorrida(int distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public void getAttribute() {
		// TODO - implement SalpicaderoObjetivo.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement SalpicaderoObjetivo.setAttribute
		throw new UnsupportedOperationException();
	}

}