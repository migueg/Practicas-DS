
public class GestorFiltros {

	private CadenaFiltros filtros;
	
	public GestorFiltros( Objetivo objetivo ) {
		filtros = new CadenaFiltros( objetivo );
	}
	
	public void addFiltro( Filtro filtro ) {
		filtros.addFiltro( filtro );
	}
	
	public void peticionFiltro( double peticion ) {
		filtros.ejecutar( peticion );
	}
	
}
