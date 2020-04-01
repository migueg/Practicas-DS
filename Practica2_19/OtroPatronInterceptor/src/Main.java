public class Main {

	public static void main( String[] args ) {
		
		Objetivo objetivo = new Objetivo();
		GestorFiltros gestor = new GestorFiltros( objetivo );
		Cliente cliente = new Cliente( objetivo );
		
		cliente.setGestor( gestor );
		cliente.aniadeFiltro( new FiltroCalcularVelocidad() );
		cliente.aniadeFiltro( new FiltroRepercutirRozamiento() );
		
		objetivo.setVisible( true );
		
		cliente.run();
		
	}
	
}