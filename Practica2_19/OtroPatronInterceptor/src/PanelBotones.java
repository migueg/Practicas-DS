import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBotones extends JPanel implements Runnable, ActionListener {

	private Thread hebra;
	private ButtonGroup botonesMovimiento;
	private JToggleButton botonEncendido, botonAcelerar, botonFrenar;
	private JButton botonReiniciar;
	private JCheckBox botonMantener;
	private Objetivo objetivo;
	private JPanel principal, derecho, inferior;
	
	ImageIcon ImgOn = new ImageIcon("img/on.jpeg");
	ImageIcon ImgOff = new ImageIcon( "img/off.jpg" );
	
	public PanelBotones( Objetivo objetivo ) {
		// Asignar Objetivo
		this.objetivo = objetivo;
		hebra = new Thread( this, "Panel Botones" );
		
		// Crear panel
		
		// Crear botones
		botonEncendido = new JToggleButton( ImgOff );
		botonEncendido.addActionListener( this );
		botonAcelerar  = new JToggleButton( "Acelerador" );
		botonAcelerar.addActionListener( this );
		botonFrenar    = new JToggleButton( "Freno" );
		botonFrenar.addActionListener( this );
		botonMantener  = new JCheckBox( "Mantener" );
		botonMantener.addActionListener( this );
		botonReiniciar = new JButton( "Reiniciar" );
		botonReiniciar.addActionListener( this );
		botonesMovimiento = new ButtonGroup();
		
		// Unir botones
		botonesMovimiento.add( botonAcelerar );
		botonesMovimiento.add( botonFrenar );
		
		this.setLayout( new BorderLayout() );
		
		principal = new JPanel();
		principal.setLayout( new BorderLayout() );
		derecho = new JPanel();
		derecho.setLayout( new BorderLayout() );
		inferior = new JPanel();
		inferior.setLayout( new BorderLayout() );
		
		derecho.add( botonAcelerar, BorderLayout.EAST );
		derecho.add( botonFrenar, BorderLayout.WEST );
		
		inferior.add( botonMantener, BorderLayout.WEST );
		inferior.add( botonReiniciar, BorderLayout.EAST );
		
		principal.add( botonEncendido, BorderLayout.WEST );
		principal.add( derecho, BorderLayout.EAST );
		principal.add( inferior, BorderLayout.SOUTH );
		
		// Estado inicial de los botones
		botonAcelerar.setEnabled(false);
		botonFrenar.setEnabled(false);
		botonReiniciar.setEnabled(false);
		botonMantener.setEnabled(false);
	}
	
	@Override
	public void actionPerformed( ActionEvent event ) {
		
		hebra = new Thread( this, "PanelBotones" );
		
		if( event.getSource() == botonEncendido ) {
			// Si encendemos el motor, podemos acelerar, frenar o apagarlo
			if( objetivo.getEstado() == EstadoMotor.APAGADO ) {
				objetivo.setEstado( EstadoMotor.ENCENDIDO );
				botonEncendido.setIcon( ImgOn );
				botonAcelerar.setEnabled( true );
				botonFrenar.setEnabled( true );
				botonMantener.setSelected( false );
				botonReiniciar.setSelected( false );
			} else {
				// Si apagamos el motor, solo podremos encenderlo
				objetivo.setEstado( EstadoMotor.APAGADO );
				botonEncendido.setIcon( ImgOff );
				botonAcelerar.setEnabled( false );
				botonFrenar.setEnabled( false );
				botonMantener.setSelected( false );
				botonReiniciar.setEnabled( false );
				botonReiniciar.setSelected( false );
			}
		} else if( event.getSource() == botonAcelerar ) {
			if( objetivo.getCantidadGasolina() > 0 ) {
				if( objetivo.getEstado() == EstadoMotor.ACELERANDO ) {
					objetivo.setEstado( EstadoMotor.ENCENDIDO );
				} else 
					objetivo.setEstado( EstadoMotor.ACELERANDO );
			} else
				objetivo.setEstado( EstadoMotor.ENCENDIDO );
			
			botonMantener.setSelected( false );
			botonReiniciar.setSelected( false );
		} else if( event.getSource() == botonFrenar ) {
			if( objetivo.getEstado() == EstadoMotor.FRENANDO ) {
				objetivo.setEstado( EstadoMotor.ENCENDIDO );
			} else
				objetivo.setEstado( EstadoMotor.FRENANDO );
			
			botonMantener.setSelected( false );
			botonReiniciar.setSelected( false );
		} else if( event.getSource() == botonMantener ) {
			if( objetivo.getCantidadGasolina() > 0 ) {
				if( botonMantener.isSelected() ) {
					objetivo.setEstado( EstadoMotor.MANTENER );
				} else
					objetivo.setEstado( EstadoMotor.ENCENDIDO );
			} else
				objetivo.setEstado( EstadoMotor.ENCENDIDO );
			
			botonAcelerar.setSelected( false );
			botonFrenar.setSelected( false );
			botonReiniciar.setEnabled( true );
			botonReiniciar.setSelected( false );
		} else if( event.getSource() == botonReiniciar ) {
			if( objetivo.getCantidadGasolina() > 0 )
				objetivo.setEstado( EstadoMotor.REINICIAR );
			else
				objetivo.setEstado( EstadoMotor.ENCENDIDO );
		}
	}
	
	public JPanel getPanel() {
		return principal;
	}
	
	public void permitirMantener( double rpm ) {
		if( rpm == 0 )
			botonMantener.setEnabled( false );
		else
			botonMantener.setEnabled( true );
	}
	
	@Override
	public void run() {
		
	}
}
