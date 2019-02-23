package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import bean.JTextFieldValidator;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaActualizarClinica extends javax.swing.JFrame{

	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JButton btnCancelar;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JButton btnConsultarServicios;
	private JComboBox comboBox_Estado;

	/**
	 * Create the application.
	 */
	public VentanaActualizarClinica() {
		setTitle("Actualizar Clinica");
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 471, 504);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JPanel panelDatosClin = new JPanel();
		panelDatosClin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblActualizarClinica = new JLabel("Actualizar Clinica");
		lblActualizarClinica.setForeground(Color.BLUE);
		lblActualizarClinica.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblActualizarClinica.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnActualizar.setBackground(Color.GREEN);
		btnActualizar.setForeground(Color.BLACK);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnLimpiar.setBackground(Color.BLUE);
		btnLimpiar.setForeground(Color.BLACK);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(lblActualizarClinica))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnActualizar)
									.addGap(77)
									.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(83)
									.addComponent(btnCancelar))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(panelDatosClin, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblActualizarClinica)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDatosClin, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActualizar)
						.addComponent(btnLimpiar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addGap(27))
		);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextFieldValidator(8, JTextFieldValidator.SOLO_NUMEROS);
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblDireccion = new JLabel("Direccion :");
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		
		comboBox_Estado = new JComboBox();
		comboBox_Estado.setModel(new DefaultComboBoxModel(new String[] {"Amazonas", "Anzoátegui", "Apure", "Aragua", "Barinas", "Bolívar", "Carabobo", "Cojedes", "Delta Amacuro", "Distrito Capital", "Falcón", "Guárico", "Lara", "Mérida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "Táchira", "Trujillo", "Vargas", "Yaracuy", "Zulia"}));
		
		JLabel lblServiciosOfrecidos = new JLabel("Servicios Ofrecidos:");
		
		btnConsultarServicios = new JButton("Consultar");
		btnConsultarServicios.setForeground(Color.WHITE);
		btnConsultarServicios.setBackground(Color.DARK_GRAY);
		GroupLayout gl_panelDatosClin = new GroupLayout(panelDatosClin);
		gl_panelDatosClin.setHorizontalGroup(
			gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosClin.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelDatosClin.createSequentialGroup()
							.addComponent(lblServiciosOfrecidos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarServicios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelDatosClin.createSequentialGroup()
							.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigo)
								.addComponent(lblNombre)
								.addComponent(lblEstado)
								.addComponent(lblDireccion)
								.addComponent(lblTelefono)
								.addComponent(lblCorreo))
							.addGap(26)
							.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldCorreo, 228, 228, Short.MAX_VALUE)
								.addComponent(textFieldTelefono, 228, 228, Short.MAX_VALUE)
								.addComponent(textFieldDireccion)
								.addComponent(textFieldNombre)
								.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
								.addComponent(comboBox_Estado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(30))
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
						.addComponent(lblEstado)
						.addComponent(comboBox_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccion))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServiciosOfrecidos)
						.addComponent(btnConsultarServicios))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panelDatosClin.setLayout(gl_panelDatosClin);
		getContentPane().setLayout(groupLayout);
	}
	public void blanquearCampos() {
		textFieldNombre.setText(null);
		comboBox_Estado.setSelectedIndex(0);
		textFieldDireccion.setText(null);
		textFieldTelefono.setText(null);
		textFieldCorreo.setText(null);
	
	}
	public void llenarCampos(String cod,String nom,String est, String dir, String tel, String cor) {
		textFieldCodigo.setText(cod);
		textFieldNombre.setText(nom);
		comboBox_Estado.setSelectedItem(est);
		textFieldDireccion.setText(dir);
		textFieldTelefono.setText(tel);
		textFieldCorreo.setText(cor);
		
	}
	
	public void addListener(ActionListener actionListener) {
		btnActualizar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
		btnLimpiar.addActionListener(actionListener);
		btnConsultarServicios.addActionListener(actionListener);
	}
	
	public void setCodigo(String cod) {
		textFieldCodigo.setText(cod);
	}
	
	public void setNombre(String nom) {
		textFieldNombre.setText(nom);
	}
	
	public void setEstado(String est) {
		comboBox_Estado.setSelectedItem(est);
	}
	
	public void setDireccion(String ciu){
		textFieldDireccion.setText(ciu);	
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
		return String.valueOf(comboBox_Estado.getSelectedItem());
	}
	
	public String getDireccion() {
		return textFieldDireccion.getText();
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
	public void salir() {
		this.setVisible(false);
		this.dispose();
	}
}
