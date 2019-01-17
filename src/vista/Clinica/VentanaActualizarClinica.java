package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaActualizarClinica {

	private JFrame frame;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldEstado;
	private JTextField textFieldCiudad;
	private JTextField textFieldUbicacion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JButton btnCancelar;
	private JButton btnActualizar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActualizarClinica window = new VentanaActualizarClinica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaActualizarClinica() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panelDatosClin = new JPanel();
		panelDatosClin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblActualizarClinica = new JLabel("Actualizar Clinica");
		lblActualizarClinica.setForeground(Color.BLUE);
		lblActualizarClinica.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblActualizarClinica.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnActualizar = new JButton("Actualizar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(lblActualizarClinica))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(panelDatosClin, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(btnActualizar)
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(79))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblActualizarClinica)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDatosClin, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActualizar)
						.addComponent(btnCancelar))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setColumns(10);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		
		JLabel lblUbicacion = new JLabel("Ubicacion :");
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		GroupLayout gl_panelDatosClin = new GroupLayout(panelDatosClin);
		gl_panelDatosClin.setHorizontalGroup(
			gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosClin.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblNombre)
						.addComponent(lblEstado)
						.addComponent(lblCiudad)
						.addComponent(lblUbicacion)
						.addComponent(lblTelefono)
						.addComponent(lblCorreo))
					.addGap(23)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textFieldCorreo, Alignment.LEADING)
						.addComponent(textFieldTelefono, Alignment.LEADING)
						.addComponent(textFieldUbicacion, Alignment.LEADING)
						.addComponent(textFieldCiudad, Alignment.LEADING)
						.addComponent(textFieldEstado, Alignment.LEADING)
						.addComponent(textFieldNombre, Alignment.LEADING)
						.addComponent(textFieldCodigo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panelDatosClin.setVerticalGroup(
			gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosClin.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCiudad))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUbicacion))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCorreo))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panelDatosClin.setLayout(gl_panelDatosClin);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void blanquearCampos() {
		textFieldCodigo.setText(null);
		textFieldNombre.setText(null);
		textFieldEstado.setText(null);
		textFieldCiudad.setText(null);
		textFieldUbicacion.setText(null);
		textFieldTelefono.setText(null);
		textFieldCorreo.setText(null);
	
	}
	public void llenarCampos(String cod,String nom,String est, String ciu, String ubi, String tel, String cor) {
		textFieldCodigo.setText(cod);
		textFieldNombre.setText(nom);
		textFieldCiudad.setText(est);
		textFieldEstado.setText(ciu);
		textFieldUbicacion.setText(ubi);
		textFieldTelefono.setText(tel);
		textFieldCorreo.setText(cor);
		
	}
	
	public void setCodigo(String cod) {
		textFieldCodigo.setText(cod);
	}
	
	public void setNombre(String nom) {
		textFieldNombre.setText(nom);
	}
	
	public void setEstado(String est) {
		textFieldEstado.setText(est);
	}
	
	public void setCiudad(String ciu){
		textFieldCiudad.setText(ciu);	
	}
	
	public void setUbicacion(String ubi) {
		textFieldUbicacion.setText(ubi);
	}
	
	public void setTelefono(String tel) {
		textFieldTelefono.setText(tel);
	}
	
	public void setCorreo(String cor) {
		textFieldCorreo.setText(cor);
	}
	
	public String getCodigo() {
		return textFieldCodigo.getText();
	}
	
	public String getNombre() {
		return textFieldNombre.getText();
	}
	
	public String  getEstado() {
		return textFieldEstado.getText();
	}
	
	public String getCiudad() {
		return textFieldCiudad.getText();
	}
	
	public String getUbicacion() {
		return textFieldUbicacion.getText();
	}
	
	public String getTelefono() {
		return textFieldTelefono.getText();
	}
	
	public String getCorreo() {
		return textFieldCorreo.getText();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
