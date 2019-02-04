package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaEliminarClinica extends javax.swing.JFrame {

	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JComboBox comboBox_Estado;

	
	public VentanaEliminarClinica() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		//setSize(450, 426);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 424);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JLabel lblEliminarClinica = new JLabel("Eliminar Clinica");
		lblEliminarClinica.setForeground(Color.BLUE);
		lblEliminarClinica.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEliminarClinica.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnEliminar.setBackground(Color.GREEN);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(lblEliminarClinica))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(btnEliminar)
							.addGap(81)
							.addComponent(btnCancelar)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblEliminarClinica)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnCancelar))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblDireccion = new JLabel("Direccion :");
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setColumns(10);
		
		comboBox_Estado = new JComboBox();
		comboBox_Estado.setModel(new DefaultComboBoxModel(new String[] {"Amazonas", "Anzoátegui", "Apure", "Aragua", "Barinas", "Bolívar", "Carabobo", "Cojedes", "Delta Amacuro", "Distrito Capital", "Falcón", "Guárico", "Lara", "Mérida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "Táchira", "Trujillo", "Vargas", "Yaracuy", "Zulia"}));
		comboBox_Estado.setEnabled(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblNombre)
						.addComponent(lblEstado)
						.addComponent(lblDireccion)
						.addComponent(lblCorreo)
						.addComponent(lblTelefono))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox_Estado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textFieldTelefono, 242, 242, Short.MAX_VALUE)
						.addComponent(textFieldDireccion)
						.addComponent(textFieldNombre)
						.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
						.addComponent(textFieldCorreo))
					.addGap(25))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBox_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
	public void blanquearCampos() {
		textFieldCodigo.setText(null);
		textFieldNombre.setText(null);
		comboBox_Estado.setSelectedIndex(0);;;
		textFieldDireccion.setText(null);
		textFieldTelefono.setText(null);
		textFieldCorreo.setText(null);
	
	}
	public void llenarCampos(String cod,String nom,String est, String dir, String tel, String cor) {
		textFieldCodigo.setText(cod);
		textFieldNombre.setText(nom);
		textFieldDireccion.setText(est);
		comboBox_Estado.setSelectedItem(est);
		textFieldTelefono.setText(tel);
		textFieldCorreo.setText(cor);
		
	}
	public void addListener(ActionListener actionListener) {
		btnEliminar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);		
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
