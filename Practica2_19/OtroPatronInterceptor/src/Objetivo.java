import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class Objetivo extends JFrame implements Runnable{

	// Parámetros del motor
	private double cuentakilometros;
	private double velocidadLineal;
	private double rpm;
	private EstadoMotor estado;
	
	// Gasolina
	private double cantidadGasolina;
	private final double MAXGAS = 10;
	
	// Revisiones
	private long rpmAceite;
	private long rpmFreno;
	private long rpmGeneral;
	
	private Thread hebra;
	DecimalFormat df = new DecimalFormat( "#.##" );
	
	// Interfaz
	private JPanel panel;
	private JPanel etiquetas;
	private JLabel etiqKM;
	private JLabel etiqVelLin;
	private JLabel etiqRPM;
	
	// Interfaz externa
	private PanelBotones botones;
	private Velocimetro velocimetro;
	private PanelGasolina gasolina;
	private PanelRevisiones revisiones;
	
	public Objetivo() {
		hebra = new Thread( this, "Motor" );
		setTitle( "Motor" );
		setSize( 600, 400 );
		setLocation( 600, 200 );
		
		cuentakilometros = 0;
		velocidadLineal = 0;
		rpm = 0;
		estado = EstadoMotor.APAGADO;
		
		repostarGasolina();
		revisarAceite();
		revisarFreno();
		revisarGeneral();
		
		panel = new JPanel();
		panel.setLayout( new BorderLayout() );
		getContentPane().add(panel);
		
		botones = new PanelBotones( this );
		botones.setVisible( true );
		
		velocimetro = new Velocimetro( this );
		velocimetro.setVisible( true );
		
		gasolina = new PanelGasolina( this );
		gasolina.setVisible(true);
		
		revisiones = new PanelRevisiones( this );
		revisiones.setVisible( true );
		
		etiqKM = new JLabel();
		etiqVelLin = new JLabel();
		etiqRPM = new JLabel();
		
		etiquetas = new JPanel();
		etiquetas.setLayout( new GridLayout( 3,1 ) );
		
		etiquetas.add( etiqRPM );
		etiquetas.add( etiqVelLin );
		etiquetas.add( etiqKM );
		
		cambiaEtiquetas();
		generaPanel();
		
		this.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit(0);
			}
		});
	}
	
	public void cambiaEtiquetas() {
		etiqKM.setText( df.format(cuentakilometros) + " km recorridos" );
		etiqVelLin.setText( "Velocidad Lineal: " + (int)velocidadLineal + " km/h" );
		etiqRPM.setText( rpm + "rpm" );
	}
	
	public void generaPanel() {
		panel.add( gasolina.getPanel(), BorderLayout.EAST );
		panel.add( etiquetas, BorderLayout.NORTH );
		panel.add( botones.getPanel(), BorderLayout.SOUTH );
		panel.add( revisiones.getPanel(), BorderLayout.WEST );
	}
	
	public void calculaRpm( double peticion ) {
		rpm = peticion;
		
		double rpd = rpm / 600;
		
		rpmAceite += rpd;
		rpmFreno += rpd;
		rpmGeneral += rpd;
		
		revisiones.actualizarEtiquetas(rpmAceite, rpmFreno, rpmGeneral);
	}
	
	public void calculaKM( ) {
		cuentakilometros += velocidadLineal/36000;
	}
	
	public void calculaLineal( ) {
		velocidadLineal = 2 * Math.PI * rpm * 0.06;
	}
	
	public void calculaGasolina() {
		if( cantidadGasolina - ( rpm * rpm * 5 * 0.000000001) <= 0 ) {
			cantidadGasolina = 0;
			if( estado != EstadoMotor.APAGADO)
				estado = EstadoMotor.ENCENDIDO;
		} else
			cantidadGasolina -= ( rpm * rpm * 5 * 0.000000001);
		
		gasolina.actualizarEtiquetas( cantidadGasolina );
	}
	
	public void repostarGasolina() {
		cantidadGasolina = MAXGAS;
	}
	
	public void ejecutar( double peticion ) {
		calculaRpm( peticion );
		calculaLineal();
		calculaKM();
		calculaGasolina();
		
		cambiaEtiquetas();
		botones.permitirMantener( rpm );
		velocimetro.setVelocidad( velocidadLineal );
		calculaGasolina();
		gasolina.permitirRepostar();
		revisiones.permitirRevisiones();
	}
	
	public void revisarAceite() {
		rpmAceite = 0;
	}
	
	public void revisarFreno() {
		rpmFreno = 0;
	}
	
	public void revisarGeneral() {
		revisarAceite();
		revisarFreno();
		rpmGeneral = 0;
	}
	
	public EstadoMotor getEstado() {
		return estado;
	}
	
	public void setEstado( EstadoMotor estado ) {
		this.estado = estado;
	}
	
	public double getRPM() {
		return rpm;
	}
	
	public long getRpmAceite() {
		return rpmAceite;
	}
	
	public long getRpmFreno() {
		return rpmFreno;
	}
	
	public long getRpmGeneral() {
		return rpmGeneral;
	}
	
	public double getVelocidadLineal() {
		return velocidadLineal;
	}
	
	public double getCantidadGasolina() {
		return cantidadGasolina;
	}
	
	public double getMAXGAS() {
		return MAXGAS;
	}
	
	@Override
	public void run() {
		
	}
	
}
