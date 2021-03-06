//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import bean.*;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class VentanaAgreagarClinica extends javax.swing.JFrame {

	private JTextField textFieldNomre;
	private JTextField textFieldCodigo;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JButton btnLimpiar;
	private JComboBox comboBox_Estado;
	/**
	 * Launch the application.
	 */
	public VentanaAgreagarClinica(String codigo) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		blanquearCampos();
		textFieldCodigo.setText(codigo);
		textFieldCodigo.setEnabled(false);
		//setSize(420,449);
	}

	private void initialize() {
		setBounds(100, 100, 420, 471);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblEnunciado = new JLabel("Registrar Clinica");
		lblEnunciado.setForeground(Color.BLUE);
		lblEnunciado.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panDC = new JPanel();
		panDC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnRegistrar.setBackground(Color.GREEN);
		btnRegistrar.setForeground(Color.BLACK);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.BLACK);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnLimpiar.setBackground(Color.BLUE);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(69)
					.addComponent(btnRegistrar)
					.addGap(79)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(19)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(155)
					.addComponent(btnCancelar)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistrar)
						.addComponent(btnLimpiar))
					.addGap(11)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblDireccion = new JLabel("Direccion :");
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		
		textFieldNomre = new JTextField();
		textFieldNomre.setColumns(10);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new  JTextFieldValidator(11, JTextFieldValidator.SOLO_NUMEROS);
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		
		comboBox_Estado = new JComboBox();
		comboBox_Estado.setModel(new DefaultComboBoxModel(new String[] {"Amazonas", "Anzoátegui", "Apure", "Aragua", "Barinas", "Bolívar", "Carabobo", "Cojedes", "Delta Amacuro", "Distrito Capital", "Falcón", "Guárico", "Lara", "Mérida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "Táchira", "Trujillo", "Vargas", "Yaracuy", "Zulia"}));
		
		
		
		GroupLayout gl_panDC = new GroupLayout(panDC);
		gl_panDC.setHorizontalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblNombre)
						.addComponent(lblEstado)
						.addComponent(lblDireccion)
						.addComponent(lblTelefono)
						.addComponent(lblCorreo))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox_Estado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textFieldCorreo)
						.addComponent(textFieldTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textFieldDireccion)
						.addComponent(textFieldNomre)
						.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
		);
		gl_panDC.setVerticalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNomre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBox_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCorreo)
						.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		panDC.setLayout(gl_panDC);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	public void blanquearCampos() 
	{		
		textFieldNomre.setText(null);
		textFieldDireccion.setText(null);
		textFieldCorreo.setText(null);
		textFieldTelefono.setText(null);
		comboBox_Estado.setSelectedIndex(0);
	}
	
	public void addListener(ActionListener actionListener) {
		btnRegistrar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);	
		btnLimpiar.addActionListener(actionListener);
	}
	
	public String getCodigo() {
		return textFieldCodigo.getText();
	}
	
	public String getNombre() {
		return textFieldNomre.getText();
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
