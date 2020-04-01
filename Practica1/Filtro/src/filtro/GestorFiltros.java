package filtro;

public class GestorFiltros {

	private CadenaFiltros filtros;
        
        public GestorFiltros( SalpicaderoObjetivo salpicadero ) {
            filtros = new CadenaFiltros( salpicadero );
        }
        
        public void addFiltro( Filtro filtro ) {
            filtros.addFiltro( filtro );
        }
        
        public void peticionFiltro( double peticion ) {
            filtros.ejecutar();
        }

}