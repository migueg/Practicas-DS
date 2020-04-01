import java.awt.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;

public class PanelRevisiones extends JPanel implements Runnable, ActionListener {

	private Thread hebra;
	private Objetivo objetivo;
	
	private JPanel panel;
	private JLabel etiqAceite, etiqFreno, etiqRevision;
	private JButton botonAceite, botonFreno, botonRevision;
	
	private ImageIcon ImgDanger = new ImageIcon( "img/danger.jpg" );
	private ImageIcon ImgOK     = new ImageIcon( "img/yes.png" );
	
	private long maxAceite = 500;
	private long maxFreno = 1000;
	private long maxRevision = 1500;
	
	public PanelRevisiones( Objetivo objetivo ) {
		// Asignar objetivo
		this.objetivo = objetivo;
		hebra = new Thread( this, "Panel Revisiones" );
		
		// Creación del panel
		panel = new JPanel();
		panel.setLayout( new GridLayout( 3, 2 ) );
		setSize( 150, 300 );
		
		// Creacion de las etiquetas
		etiqAceite = new JLabel();
		etiqFreno = new JLabel();
		etiqRevision = new JLabel();
		
		// Creacion de los botones
		botonAceite = new JButton( "Revisión Aceite" );
		botonFreno = new JButton( "Revisión Frenos" );
		botonRevision = new JButton( "Revisión General" );
		
		// ActionListeners
		botonAceite.addActionListener( this );
		botonFreno.addActionListener( this );
		botonRevision.addActionListener( this );
		
		// Generar panel
		panel.add( botonAceite );
		panel.add( etiqAceite );
		panel.add( botonFreno );
		panel.add( etiqFreno );
		panel.add( botonRevision );
		panel.add( etiqRevision );
	}
	
	@Override
	public void actionPerformed( ActionEvent event ) {
		
		hebra = new Thread( this, "PanelRevisiones" );
		
		if( event.getSource() == botonAceite )
			objetivo.revisarAceite();
		else if( event.getSource() == botonFreno )
			objetivo.revisarFreno();
		else if( event.getSource() == botonRevision ) {
			objetivo.revisarGeneral();
		}
	}
	
	public void actualizarEtiquetas( long rpmAceite, long rpmFreno, long rpmGeneral ) {
		if( rpmAceite > maxAceite )
			etiqAceite.setIcon( ImgDanger );
		else
			etiqAceite.setIcon( ImgOK );
		
		if( rpmFreno > maxFreno )
			etiqFreno.setIcon( ImgDanger );
		else
			etiqFreno.setIcon(ImgOK);
		
		if( rpmGeneral > (long) maxRevision )
			etiqRevision.setIcon( ImgDanger );
		else
			etiqRevision.setIcon(ImgOK);
	}
	
	public void permitirRevisiones() {
		if( objetivo.getEstado() == EstadoMotor.APAGADO &&
				objetivo.getVelocidadLineal() == 0 ) {
			botonAceite.setEnabled(true);
			botonFreno.setEnabled(true);
			botonRevision.setEnabled(true);
		} else {
			botonAceite.setEnabled(false);
			botonFreno.setEnabled(false);
			botonRevision.setEnabled(false);
		}
		
		System.out.println( objetivo.getRpmAceite() + " / " + maxAceite );
		System.out.println( objetivo.getRpmFreno() + " / " + maxFreno );
		System.out.println( objetivo.getRpmGeneral() + " / " + maxRevision );
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void run() {
		
	}
	
}
