
package filtro;
public class RepercutirRozamiento implements Filtro {
        
        private int rozamiento = 50;
	/**
	 * 
	 * @param revoluciones
	 * @param estadoMotor
	 */
	public double ejecutar(double revoluciones, EstadoMotor estadoMotor) {
		// TODO - implement RepercutirRazonamiento.ejecutar
		rozamiento--;
                double nuevarevol;
                
                if(revoluciones > rozamiento){
                    nuevarevol = revoluciones - rozamiento;

                }else{
                    nuevarevol = revoluciones--;
                }
                
                return nuevarevol;
	}

}