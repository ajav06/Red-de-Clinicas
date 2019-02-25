//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Consulta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class VentanaRegistrarClinica extends javax.swing.JFrame
{
	
	private JTextField textFieldCedulaP;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JButton btnLimpiar;
	private JDateChooser fecha;
	private JComboBox comboBox_Clinica;
	private JComboBox comboBox_medicos;
	private JComboBox comboBoxServicio;
	private JTextField textFieldDiagnostico;
	private JTextField textFieldTratamiento;
	private JTextField textField_Motivo;
	/**
	 * Launch the application.
	 */
	public VentanaRegistrarClinica(DefaultComboBoxModel clinicas, DefaultComboBoxModel medicos,DefaultComboBoxModel servicios) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clinicas.removeElementAt(0);
		initialize(clinicas, medicos,servicios);
		blanquearCampos();
		//setSize(420,449);
	}

	private void initialize(DefaultComboBoxModel clinicas, DefaultComboBoxModel medicos,DefaultComboBoxModel servicios) {
		setBounds(100, 100, 733, 546);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblEnunciado = new JLabel("Registrar Consulta");
		lblEnunciado.setForeground(Color.BLUE);
		lblEnunciado.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panDC = new JPanel();
		panDC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Consulta", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(130)
					.addComponent(btnRegistrar)
					.addPreferredGap(ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(115))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(207)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(316, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(271))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpiar)
						.addComponent(btnRegistrar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addGap(34))
		);
		
		JLabel lblNombre = new JLabel("Clinica :");
		
		JLabel lblCedulaP = new JLabel("Cedula: ");
		
		JLabel lblEstado = new JLabel("Fecha :");
		
		JLabel lblMedico = new JLabel("Medico :");
		
		JLabel lblMotivo = new JLabel("Motivo :");
		
		JLabel lblDiagnostico = new JLabel("Diagnostico :");
		
		fecha = new JDateChooser();
		
		
		textFieldCedulaP = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
		textFieldCedulaP.setColumns(10);
		
		comboBox_Clinica = new JComboBox();
		
		JLabel lblTratamiento = new JLabel("Tratamiento:");
		
		textFieldDiagnostico = new JTextField();
		textFieldDiagnostico.setColumns(10);
		
		textFieldTratamiento = new JTextField();
		textFieldTratamiento.setColumns(10);
		
		comboBox_medicos = new JComboBox();
		
		textField_Motivo = new JTextField();
		textField_Motivo.setColumns(10);
		
		JLabel lblServicio = new JLabel("Servicio:");
		
		comboBoxServicio = new JComboBox();
		
		
		
		GroupLayout gl_panDC = new GroupLayout(panDC);
		gl_panDC.setHorizontalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panDC.createSequentialGroup()
									.addComponent(textFieldDiagnostico, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldTratamiento, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
								.addGroup(gl_panDC.createSequentialGroup()
									.addGroup(gl_panDC.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panDC.createSequentialGroup()
											.addComponent(lblMotivo)
											.addGap(19))
										.addGroup(gl_panDC.createSequentialGroup()
											.addGroup(gl_panDC.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblEstado)
												.addComponent(lblCedulaP))
											.addGap(18)))
									.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panDC.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panDC.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textFieldCedulaP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(fecha, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panDC.createSequentialGroup()
													.addComponent(lblServicio)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBoxServicio, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panDC.createSequentialGroup()
													.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNombre)
														.addComponent(lblMedico))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
														.addComponent(comboBox_medicos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(comboBox_Clinica, 0, 276, Short.MAX_VALUE)))))
										.addComponent(textField_Motivo))
									.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
							.addContainerGap())
						.addGroup(gl_panDC.createSequentialGroup()
							.addGap(107)
							.addComponent(lblDiagnostico)
							.addPreferredGap(ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
							.addComponent(lblTratamiento, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(123))))
		);
		gl_panDC.setVerticalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGroup(gl_panDC.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(comboBox_Clinica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMedico)
								.addComponent(comboBox_medicos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panDC.createSequentialGroup()
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldCedulaP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCedulaP))
							.addGap(18)))
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(fecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado)))
						.addGroup(gl_panDC.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServicio))))
					.addGap(30)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMotivo)
						.addComponent(textField_Motivo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiagnostico)
						.addComponent(lblTratamiento))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDiagnostico, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(textFieldTratamiento, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addContainerGap())
		);
		panDC.setLayout(gl_panDC);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
					.addGap(83))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		comboBox_Clinica.setModel(clinicas);
		comboBox_medicos.setModel(medicos);
		comboBoxServicio.setModel(servicios);
	}
	public void blanquearCampos() 
	{	
		textFieldCedulaP.setText(null);	
		fecha.setDate(null);
		textFieldDiagnostico.setText(null);
		textFieldTratamiento.setText(null);
		comboBox_Clinica.setSelectedIndex(0);
		
	}
	public void llenarCampos(String cli, String med,String ser) {
		comboBox_Clinica.setSelectedItem(cli);
		comboBox_medicos.setSelectedItem(med);
		comboBoxServicio.setSelectedItem(ser);

	}
	
	
	public void addListener(ActionListener actionListener) {
		btnRegistrar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);	
		btnLimpiar.addActionListener(actionListener);
	}
	
	public String getCedulaP() {
		return textFieldCedulaP.getText();
	}
	
	public String getFecha() {
		return String.valueOf(fecha.getDate());
	}
	
	public String  getClinica() {
		return String.valueOf(comboBox_Clinica.getSelectedItem());
	}
	public String  getMedico() {
		return String.valueOf(comboBox_medicos.getSelectedItem());
	}
	public String  getServicio() {
		return String.valueOf(comboBoxServicio.getSelectedIndex());
	}
	public String getMotivo() {
		return textField_Motivo.getText();
	}

	public String getDiagnostico() {
		return textFieldDiagnostico.getText();
	}
	
	public String getTratamiento() {
		return textFieldTratamiento.getText();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void salir() {
		this.setVisible(false);
		this.dispose();
	}
	
}
