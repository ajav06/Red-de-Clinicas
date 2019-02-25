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
public class VentanaActualizarConsulta  extends javax.swing.JFrame{

	private JTextField textFieldCedulaP;
	private JButton btnCancelar;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JTextField textFieldFecha;
	private JComboBox comboBox_Clinica;
	private JComboBox comboBox_medicos;
	private JComboBox comboBoxServicio;
	private JTextField textFieldDiagnostico;
	private JTextField textFieldTratamiento;
	private JTextField textField_Motivo;
	/**
	 * Launch the application.
	 */
	public VentanaActualizarConsulta(DefaultComboBoxModel clinicas, DefaultComboBoxModel medicos,DefaultComboBoxModel servicios) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clinicas.removeElementAt(0);
		initialize(clinicas, medicos,servicios);
		blanquearCampos();
		//setSize(420,449);
	}

	private void initialize(DefaultComboBoxModel clinicas, DefaultComboBoxModel medicos,DefaultComboBoxModel servicios){
		setBounds(100, 100, 759, 546);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblEnunciado = new JLabel("Actualizar Consulta");
		lblEnunciado.setForeground(Color.BLUE);
		lblEnunciado.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panDC = new JPanel();
		panDC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Consulta", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnActualizar.setBackground(Color.GREEN);
		btnActualizar.setForeground(Color.BLACK);
		
		btnActualizar.addActionListener(new ActionListener() {
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
					.addComponent(btnActualizar)
					.addPreferredGap(ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(115))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(207)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(236, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(271))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 723, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(btnActualizar))
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
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEnabled(false);
		textFieldFecha.setColumns(10);
		
		
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
					.addContainerGap()
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCedulaP)
						.addComponent(lblEstado)
						.addComponent(lblMotivo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldDiagnostico, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panDC.createSequentialGroup()
									.addGap(104)
									.addComponent(lblDiagnostico)))
							.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panDC.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTratamiento, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panDC.createSequentialGroup()
									.addGap(26)
									.addComponent(textFieldTratamiento, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)))
							.addGap(30))
						.addComponent(textField_Motivo, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGroup(gl_panDC.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldFecha, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(textFieldCedulaP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
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
										.addComponent(comboBox_Clinica, 0, 279, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)))
					.addContainerGap())
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
								.addComponent(lblCedulaP)
								.addComponent(textFieldCedulaP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panDC.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServicio))))
					.addGap(30)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMotivo)
						.addComponent(textField_Motivo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panDC.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTratamiento)
						.addComponent(lblDiagnostico))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDiagnostico, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(textFieldTratamiento, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addContainerGap())
		);
		panDC.setLayout(gl_panDC);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
		textFieldFecha.setText(null);
		textFieldDiagnostico.setText(null);
		textFieldTratamiento.setText(null);
		comboBox_Clinica.setSelectedIndex(0);
		
	}
	public void llenarCampos(String cep,String cli,String fec, String med,int ser, String mot, String dia,String tra) {
		textFieldCedulaP.setText(cep);
		comboBox_Clinica.setSelectedItem(cli);
		textFieldFecha.setText(fec);
		comboBox_medicos.setSelectedItem(med);
		comboBoxServicio.setSelectedIndex(ser);
		textField_Motivo.setText(mot);
		textFieldDiagnostico.setText(dia);
		textFieldTratamiento.setText(tra);
		
		
		
	}
	
	public void addListener(ActionListener actionListener) {
		btnActualizar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);	
		btnLimpiar.addActionListener(actionListener);
	}
	
	public String getCedulaP() {
		return textFieldCedulaP.getText();
	}
	
	public String getFecha() {
		return textFieldFecha.getText();
		
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
