import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelGasolina extends JPanel implements Runnable, ActionListener {

	private Thread hebra;
	private Objetivo objetivo;
	
	private JPanel panel;
	private JLabel etiqCantidad, etiqEstado;
	private JButton botonRepostar;
	
	ImageIcon ImgDanger = new ImageIcon( "img/danger.jpg" );
	ImageIcon ImgOK     = new ImageIcon( "img/yes.png" );
	ImageIcon ImgNo     = new ImageIcon( "img/no.jpg" );
	
	public PanelGasolina( Objetivo objetivo ) {
		// Asignar Objetivo
		this.objetivo = objetivo;
		hebra = new Thread( this, "Panel Gasolina" );
		
		// Creación del panel
		panel = new JPanel();
		this.setLayout( new FlowLayout() );
		
		// Creación del botón
		botonRepostar = new JButton( "Repostar" );
		botonRepostar.addActionListener( this );
		
		// Creación de las etiquetas
		etiqCantidad = new JLabel();
		etiqEstado = new JLabel();
		
		// Preparar panel
		panel.add( etiqCantidad );
		panel.add( etiqEstado );
		panel.add( botonRepostar );
	}
	
	@Override
	public void actionPerformed( ActionEvent event ) {
		
		hebra = new Thread( this, "PanelGasolina" );
		
		objetivo.repostarGasolina();
		actualizarEtiquetas( objetivo.getRPM() );
	}
	
	public void actualizarEtiquetas( double cantidadGasolina ) {
		if( cantidadGasolina > 7.5 ) {
			etiqCantidad.setText( "Gasolina: XXXX" );
			etiqEstado.setIcon( ImgOK );
		} else if( cantidadGasolina > 5 && cantidadGasolina <= 7.5 ) {
			etiqCantidad.setText( "Gasolina: XXX_" );
			etiqEstado.setIcon( ImgOK );
		} else if( cantidadGasolina > 2.5 && cantidadGasolina <= 5 ) {
			etiqCantidad.setText( "Gasolina: XX__" );
			etiqEstado.setIcon( ImgOK );
		} else if( cantidadGasolina > 0 && cantidadGasolina <= 2.5 ) {
			etiqCantidad.setText( "Gasolina: X___" );
			etiqEstado.setIcon( ImgDanger );
		} else {
			etiqCantidad.setText( "Gasolina: ____" );
			etiqEstado.setIcon( ImgNo );
		}
		
		System.out.println( "Gas:" + cantidadGasolina );
	}
	
	public void permitirRepostar() {
		if( objetivo.getEstado() == EstadoMotor.APAGADO &&
			objetivo.getVelocidadLineal() == 0 &&
			objetivo.getCantidadGasolina() < objetivo.getMAXGAS() )
			botonRepostar.setEnabled(true);
		else
			botonRepostar.setEnabled(false);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void run() {
		
	}
	
}
