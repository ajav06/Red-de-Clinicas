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

public class VentanaConsultarConsulta extends javax.swing.JFrame{
	private JTextField textFieldFecha;
	private JTextField textFieldCedulaP;
	private JTextField textFieldDiagnostico;
	private JTextField textFieldTratamiento;
	private JTextField textField_Motivo;
	private JTextField textField_Clinica;
	private JTextField textField_Medico;
	private JComboBox comboBoxServicio;
	/**
	 * Launch the application.
	 */
	public VentanaConsultarConsulta(DefaultComboBoxModel servicios) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize(servicios);
		
		//setSize(420,449);
	}

	private void initialize(DefaultComboBoxModel servicios) {
		setBounds(100, 100, 733, 463);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblEnunciado = new JLabel("Registrar Consulta");
		lblEnunciado.setForeground(Color.BLUE);
		lblEnunciado.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panDC = new JPanel();
		panDC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Consulta", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(207)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(216, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
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
		
		textFieldCedulaP = new JTextField();
		textFieldCedulaP.setEnabled(false);
		textFieldCedulaP.setColumns(10);
		
		JLabel lblTratamiento = new JLabel("Tratamiento:");
		
		textFieldDiagnostico = new JTextField();
		textFieldDiagnostico.setEnabled(false);
		textFieldDiagnostico.setColumns(10);
		
		textFieldTratamiento = new JTextField();
		textFieldTratamiento.setEnabled(false);
		textFieldTratamiento.setColumns(10);
		
		textField_Motivo = new JTextField();
		textField_Motivo.setEnabled(false);
		textField_Motivo.setColumns(10);
		
		textField_Clinica = new JTextField();
		textField_Clinica.setEnabled(false);
		textField_Clinica.setColumns(10);
		
		textField_Medico = new JTextField();
		textField_Medico.setEnabled(false);
		textField_Medico.setColumns(10);
		
		JLabel lblServicio = new JLabel("Servicio:");
		
		comboBoxServicio = new JComboBox();
		comboBoxServicio.setEnabled(false);
		
		
		
		GroupLayout gl_panDC = new GroupLayout(panDC);
		gl_panDC.setHorizontalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblEstado)
							.addGap(342))
						.addGroup(gl_panDC.createSequentialGroup()
							.addGap(107)
							.addComponent(lblDiagnostico)
							.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
							.addComponent(lblTratamiento, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(87))
						.addGroup(gl_panDC.createSequentialGroup()
							.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panDC.createSequentialGroup()
									.addComponent(textFieldDiagnostico, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
									.addGap(41)
									.addComponent(textFieldTratamiento))
								.addGroup(gl_panDC.createSequentialGroup()
									.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMotivo)
										.addComponent(lblCedulaP))
									.addGap(18)
									.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panDC.createSequentialGroup()
											.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textFieldFecha)
												.addComponent(textFieldCedulaP, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNombre)
												.addComponent(lblMedico)
												.addComponent(lblServicio))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_Medico, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
												.addComponent(textField_Clinica, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
												.addComponent(comboBoxServicio, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(textField_Motivo))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(24))
		);
		gl_panDC.setVerticalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCedulaP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre)
						.addComponent(lblCedulaP)
						.addComponent(textField_Clinica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panDC.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMedico)
								.addComponent(textField_Medico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblServicio)
								.addComponent(comboBoxServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(16)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMotivo)
						.addComponent(textField_Motivo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiagnostico)
						.addComponent(lblTratamiento))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldTratamiento, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
						.addComponent(textFieldDiagnostico, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
					.addContainerGap())
		);
		panDC.setLayout(gl_panDC);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 687, Short.MAX_VALUE)
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		comboBoxServicio.setModel(servicios);
	}
	
	public void llenarCampos(String cep,String cli,String fec, String med,int ser, String mot, String dia,String tra) {
		textFieldCedulaP.setText(cep);
		textField_Clinica.setText(cli);
		textFieldFecha.setText(fec);
		textField_Medico.setText(med);
		comboBoxServicio.setSelectedIndex(ser);
		textField_Motivo.setText(mot);
		textFieldDiagnostico.setText(dia);
		textFieldTratamiento.setText(tra);
		
	}
	
	public String getCedulaP() {
		return textFieldCedulaP.getText();
	}
	
	public String getFecha() {
		return textFieldFecha.getText();
	}
	
	public String  getClinica() {
		return textField_Clinica.getText();
	}
	public String  getMedico() {
		return textField_Medico.getText();
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
