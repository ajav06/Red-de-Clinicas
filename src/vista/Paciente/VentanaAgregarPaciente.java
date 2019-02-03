package vista.Paciente;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class VentanaAgregarPaciente extends javax.swing.JFrame{
	private JTextFieldValidator textField_NroHist;
	private JTextFieldValidator textField_NroSeguro;
	private JTextFieldValidator textField_Ced;
	private JTextFieldValidator textField_Nomb;
	private JTextFieldValidator textField_Apelli;
	private JDateChooser fechaNac;
	private JButton btnBuscarHist;
	private JComboBox comboBox_edoCivil;
	private JComboBox comboBox_Estado;
	private JTextField textField_Celular;
	private JTextField textField_Casa;
	private JTextField textField_Email;
	private JTextArea textArea_Direccion;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnVolver;
	private JButton btnEliminar;
	private JButton btnHistorial;
	private JComboBox comboBox_Seguro;
	
	public VentanaAgregarPaciente() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		blanquearCampos();
		setSize(583, 569);
	}
	
	private void initGUI() {
		try {
			getContentPane().setForeground(Color.BLUE);
			setTitle("Registrar Paciente");
			
			JLabel lblRegistrarP = new JLabel("Registrar Paciente");
			lblRegistrarP.setForeground(Color.BLUE);
			lblRegistrarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			lblRegistrarP.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panel_DPer = new JPanel();
			panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNroHist = new JLabel("Nro. Historial :");
			
			textField_NroHist = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroHist.setColumns(10);
			
			JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
			
			textField_NroSeguro = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroSeguro.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("\u00BFPosee Seguro Medico? :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Seguro = new JComboBox();
			comboBox_Seguro.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
			comboBox_Seguro.setMaximumRowCount(2);
			
			btnBuscarHist = new JButton("Buscar");
			
			btnHistorial = new JButton("Nuevo");
			GroupLayout gl_panel_DPer = new GroupLayout(panel_DPer);
			gl_panel_DPer.setHorizontalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
								.addGap(8)))
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBuscarHist, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHistorial, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addComponent(comboBox_Seguro, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel_DPer.setVerticalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addComponent(comboBox_Seguro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscarHist)
							.addComponent(btnHistorial))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
						.addGap(150))
			);
			panel_DPer.setLayout(gl_panel_DPer);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel label = new JLabel("Nombres :");
			
			JLabel label_1 = new JLabel("Cedula : ");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			
			textField_Ced = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
			textField_Ced.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(textField_Ced.getText().length()>=2)
						textField_NroHist.setText(textField_Ced.getText().substring(2, textField_Ced.getText().length()));
				}
			});
			textField_Ced.setColumns(10);
			
			textField_Nomb = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Nomb.setColumns(10);
			
			JLabel label_2 = new JLabel("Fecha Nac. :");
			
			JLabel label_3 = new JLabel("Apellidos :");
			
			textField_Apelli = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Apelli.setColumns(10);
			
			fechaNac = new JDateChooser();
			
			JLabel lblNewLabel_1 = new JLabel("Edo. Civil :");
			
			comboBox_edoCivil = new JComboBox();
			comboBox_edoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Comprometido/a", "Casado/a", "Divorciado/a", "Viudo/a"}));
			
			JLabel lblEstado = new JLabel("Estado :");
			
			comboBox_Estado = new JComboBox();
			comboBox_Estado.setModel(new DefaultComboBoxModel(new String[] {"Amazonas", "Anzo\u00C3\u00A1tegui", "Apure", "Aragua", "Barinas", "Bol\u00C3\u00ADvar", "Carabobo", "Cojedes", "Delta Amacuro", "Distrito Capital", "Falc\u00C3\u00B3n", "Gu\u00C3\u00A1rico", "Lara", "M\u00C3\u00A9rida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "T\u00C3\u00A1chira", "Trujillo", "Vargas", "Yaracuy", "Zulia"}));
			
			JLabel lblDireccion = new JLabel("Direccion :");
			
			JScrollPane scrollPane = new JScrollPane();
			
			JLabel lblTlfCelular = new JLabel("Tlf. Celular :");
			
			textField_Celular = new JTextField();
			textField_Celular.setColumns(10);
			
			JLabel lblTlfCasa = new JLabel("Tlf. Casa :");
			
			textField_Casa = new JTextField();
			textField_Casa.setColumns(10);
			
			textField_Email = new JTextField();
			textField_Email.setColumns(10);
			
			JLabel label_4 = new JLabel("E-mail :");
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
													.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
													.addComponent(label, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
													.addComponent(textField_Nomb, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblNewLabel_1)
												.addGap(27)
												.addComponent(comboBox_edoCivil, 0, 113, Short.MAX_VALUE)))
										.addGap(44))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblDireccion)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
											.addGroup(gl_panel.createSequentialGroup()
												.addGap(12)
												.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(fechaNac, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
											.addComponent(textField_Apelli, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(22)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblEstado))
										.addGap(24)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(comboBox_Estado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_Email, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblTlfCelular)
								.addGap(18)
								.addComponent(textField_Celular, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(57)
								.addComponent(lblTlfCasa)
								.addGap(18)
								.addComponent(textField_Casa, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
									.addComponent(label_2))
								.addComponent(textField_Ced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(label_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
								.addComponent(label))
							.addComponent(textField_Nomb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
								.addComponent(label_3))
							.addComponent(textField_Apelli, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(comboBox_edoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(3)
										.addComponent(label_4))
									.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(18)
										.addComponent(lblDireccion))
									.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(comboBox_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblEstado))))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTlfCelular)
							.addComponent(textField_Celular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTlfCasa)
							.addComponent(textField_Casa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			
			textArea_Direccion = new JTextArea();
			scrollPane.setViewportView(textArea_Direccion);
			panel.setLayout(gl_panel);
			
			btnIncluir = new JButton("Incluir");
			
			btnModificar = new JButton("Modificar");
			
			btnEliminar = new JButton("Eliminar");
			
			btnVolver = new JButton("Volver");
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(115)
						.addComponent(lblRegistrarP, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addGap(107))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
								.addGap(140)
								.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
							.addComponent(panel_DPer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
							.addComponent(panel, 0, 0, Short.MAX_VALUE))
						.addGap(24))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblRegistrarP, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addGap(28)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_DPer, GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addComponent(btnVolver, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
						.addGap(24))
			);
			getContentPane().setLayout(groupLayout);
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public void blanquearCampos() {
		textField_NroHist.setText(null);
		textField_NroSeguro.setText(null);
		textField_Ced.setText(null);
		textField_Nomb.setText(null);
		textField_Apelli.setText(null);
		textField_Casa.setText(null);
		textField_Email.setText(null);
		textField_Celular.setText(null);
		textArea_Direccion.setText(null);
		comboBox_edoCivil.setSelectedIndex(0);
		comboBox_Estado.setSelectedIndex(0);
		comboBox_Seguro.setSelectedIndex(0);
		fechaNac.setDate(null);
	}
	
	public void llenarCampos(String numH, String numS, String ced, String nom, String apell,
			String casa, String email, String celular, String dir, String edo, Date fecha) {
		textField_Ced.setText(ced);
		textField_NroHist.setText(numH.substring(2, numH.length()));
		textField_NroSeguro.setText(numS.substring(0, 5));
		textField_Nomb.setText(nom);
		textField_Apelli.setText(apell);
		textField_Casa.setText(casa);
		textField_Email.setText(email);
		textField_Celular.setText(celular);
		textArea_Direccion.setText(dir);
		comboBox_Estado.setSelectedItem(edo);
		fechaNac.setDate(fecha);
	}
	
	public void addListener(ActionListener actionListener) {
		btnIncluir.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		btnBuscarHist.addActionListener(actionListener);
		btnHistorial.addActionListener(actionListener);
	}
	
	public void setCedula(String ced) {
		this.textField_Ced.setText(ced);
	}
	
	public String getCedula() {
		return textField_Ced.getText();
	}
	
	public String getNombre() {
		return textField_Nomb.getText();
	}
	
	public String  getApellido() {
		return textField_Apelli.getText();
	}
	
	public Date getFechaNac() {
		return fechaNac.getDate();
	}
	
	public int getNroHist() {
		return Integer.parseInt(textField_NroHist.getText());
	}
	
	public int getNroSgro() {
		return Integer.parseInt(textField_NroSeguro.getText());
	}
	
	public String getTlfCelular() {
		return textField_Celular.getText();
	}
	
	public String getTlfCasa() {
		return textField_Casa.getText();
	}
	
	public String getEmail() {
		return textField_Email.getText();
	}
	
	public String getEstado() {
		return comboBox_Estado.getSelectedItem().toString();
	}
	
	public String getDiresccion() {
		return textArea_Direccion.getText();
	}
	
	public boolean getSeguro() {
		switch (comboBox_Seguro.getSelectedIndex()) {
		case 0:
			return true;
		case 1:
			return false;
		}
		return false;
	}
	
	public void setSeguro(boolean ase) {
		if(ase==true)
			comboBox_Seguro.setSelectedIndex(0);
		else
			comboBox_Seguro.setSelectedIndex(1);
	}
	
	public char getEdoC() {
		switch (comboBox_edoCivil.getSelectedIndex()) {
		case 0:
			return 'S';
			
		case 1:
			return 'C';
			
		case 2:
			return 'A';
			
		case 3:
			return 'D';
			
		case 4:
			return 'V';
		}
		return 'S';
	}
	
	public void setEdoC(char edo) {
		switch (edo) {
		case 'S':
			comboBox_edoCivil.setSelectedIndex(0);
			break;
			
		case 'C':
			comboBox_edoCivil.setSelectedIndex(1);
			break;
			
		case 'A':
			comboBox_edoCivil.setSelectedIndex(2);
			break;
			
		case 'D':
			comboBox_edoCivil.setSelectedIndex(3);
			break;
			
		case 'V':
			comboBox_edoCivil.setSelectedIndex(4);
			break;
		}
	}
	
	public void setNroHistorial() {
		textField_NroHist.setText(textField_Ced.getText().substring(2, textField_Ced.getText().length()));
	}
	
	public void setNroSeguro() {
		textField_NroSeguro.setText(textField_Ced.getText().substring(0, 5));
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	public void interfazRegistro() {
		btnEliminar.setEnabled(false);;
		btnModificar.setEnabled(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnBuscarHist.setVisible(false);
	}
	
	public void interfazModificar() {
		btnIncluir.setEnabled(false);
		btnIncluir.setVisible(false);
		textField_Ced.setEditable(false);
		fechaNac.setEnabled(false);
		textField_NroHist.setEditable(false);
		btnEliminar.setEnabled(false);
		btnEliminar.setVisible(false);
		btnHistorial.setVisible(false);
	}
	
	public void interfazEliminar() {
		btnIncluir.setEnabled(false);
		btnModificar.setEnabled(false);
		btnModificar.setVisible(false);
		btnIncluir.setVisible(false);
		textField_Ced.setEditable(false);
		fechaNac.setEnabled(false);
		textField_NroHist.setEditable(false);
		btnHistorial.setVisible(false);
	}
}
