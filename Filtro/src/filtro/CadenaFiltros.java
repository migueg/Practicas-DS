package filtro;
import java.util.ArrayList;
        
public class CadenaFiltros {
        
        private ArrayList<Filtro> listaFiltros;
        private SalpicaderoObjetivo salpicadero;
        
        /*
        public CadenaFiltros(){
            
           Filtro velocidad = new CalcularVelocidad();
           Filtro revoluciones = new RepercutirRozamiento();
           
           listaFiltros = new ArrayList();
           
           listaFiltros.add(velocidad);
           listaFiltros.add(revoluciones);
  
        }*/
        
        public CadenaFiltros( SalpicaderoObjetivo salpicadero ) {
            
            listaFiltros = new ArrayList();
            this.salpicadero = salpicadero;
            
        }
        
        public void addFiltro( Filtro filtro ) {
            
            listaFiltros.add( filtro );
            
        }
        
	public void ejecutar() {
		
            double nuevaVelocidad = salpicadero.getVelocidadAngular();
            
            for( Filtro filtro : listaFiltros )
                nuevaVelocidad = filtro.ejecutar( nuevaVelocidad, salpicadero.getEstado() );
            
            salpicadero.ejecutar( nuevaVelocidad, salpicadero.getEstado() );
            
	}

}