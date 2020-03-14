package filtro;
import java.util.ArrayList;
        
public class CadenaFiltros {
        
        private ArrayList listaFiltros;
        private SalpicaderoObjetivo salpicadero;
        
        public CadenaFiltros(){
           Filtro velocidad = new CalcularVelocidad();
           Filtro revoluciones = new RepercutirRozamiento();
           
            listaFiltros = new ArrayList();
           
            listaFiltros.add(velocidad);
            listaFiltros.add(revoluciones);
           
           
           
        }
	public void ejecutar() {
		// TODO - implement CadenaFiltros.ejecutar
		throw new UnsupportedOperationException();
	}

}