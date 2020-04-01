
public class Cliente extends Thread {

	private GestorFiltros gestor;
	private Objetivo objetivo;
	
	public Cliente( Objetivo objetivo ) {
		this.objetivo = objetivo;
	}
	
	public void enviarPeticion( double peticion ) {
		gestor.peticionFiltro( peticion );
	}
	
	public void setGestor( GestorFiltros gestor ) {
		this.gestor = gestor;
	}
	
	public void aniadeFiltro( Filtro filtro ) {
		gestor.addFiltro( filtro );
	}
	
	@Override
	public void run() {
		while( true ) {
			try {
				enviarPeticion( objetivo.getRPM() );
				sleep(100);
			} catch( java.lang.InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}
	
}
