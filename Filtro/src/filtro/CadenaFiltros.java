package filtro;
import java.util.ArrayList;
        
public class CadenaFiltros {
        
        private ArrayList listaFiltros;
        private SalpicaderoObjetivo salpicadero;
        
        public CadenaFiltros(){
           Filtro velocidad = new CalcularVelocidad();
           Filtro revoluciones = new RepercutirRozamiento();
           
           ArrayList listaFiltros = new ArrayList();
           
           
           
           
        }
	public void ejecutar() {
		// TODO - implement CadenaFiltros.ejecutar
		throw new UnsupportedOperationException();
	}

}