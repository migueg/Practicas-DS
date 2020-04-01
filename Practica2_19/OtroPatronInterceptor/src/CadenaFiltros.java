import java.util.ArrayList;

public class CadenaFiltros {
	
	private ArrayList<Filtro> filtros;
	private Objetivo objetivo;
	
	// PROGRAMAR SETINCREMENTO DE FILTROCALCULARVELOCIDAD
	
	public CadenaFiltros( Objetivo objetivo ) {
		filtros = new ArrayList();
		this.objetivo = objetivo;
	}
	
	public void addFiltro( Filtro filtro ) {
		filtros.add( filtro );
	}
	
	public void ejecutar( double peticion ) {
		double nuevaVelocidad = peticion;
		System.out.println( "Petición recibida" );
		
		for( Filtro filtro : filtros ) 
			nuevaVelocidad = filtro.ejecutar( nuevaVelocidad, objetivo.getEstado() );
		
		objetivo.ejecutar( nuevaVelocidad );
	}

}
