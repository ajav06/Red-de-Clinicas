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


public class VentanaPaciente extends javax.swing.JFrame{
	private JTextFieldValidator textField_NroHist;
	private JTextFieldValidator textField_NroSeguro;
	private JTextFieldValidator textField_Ced;
	private JTextFieldValidator textField_Nomb;
	private JTextFieldValidator textField_Apelli;
	private JDateChooser fechaNac;
	private JButton btnBuscarHist;
	private JComboBox comboBox_edoCivil;
	private JComboBox comboBox_Estado;
	private JTextFieldValidator textField_Celular;
	private JTextFieldValidator textField_Casa;
	private JTextFieldValidator textField_Email;
	private JTextArea textArea_Direccion;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnVolver;
	private JButton btnEliminar;
	private JButton btnHistorial;
	private JComboBox comboBox_Seguro;
	private JComboBox comboBox_NombSeguros;
	private JButton btnConsultar;
	
	public VentanaPaciente(DefaultComboBoxModel seguros) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI(seguros);
		blanquearCampos();
		setSize(583, 569);
	}
	
	private void initGUI(DefaultComboBoxModel seguros) {
		try {
			getContentPane().setForeground(Color.BLUE);
			setTitle("Registrar Paciente");
			
			JLabel lblRegistrarP = new JLabel("Gestionar Paciente");
			lblRegistrarP.setForeground(Color.BLUE);
			lblRegistrarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			lblRegistrarP.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panel_DPer = new JPanel();
			panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNroHist = new JLabel("Nro. Historial :");
			
			textField_NroHist = new JTextFieldValidator(6,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroHist.setEditable(false);
			textField_NroHist.setColumns(10);
			
			JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
			
			textField_NroSeguro = new JTextFieldValidator(6,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroSeguro.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("\u00BFPosee Seguro Medico? :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Seguro = new JComboBox();
			comboBox_Seguro.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
			comboBox_Seguro.setMaximumRowCount(2);
			
			btnBuscarHist = new JButton("Buscar");
			
			btnHistorial = new JButton("Nuevo");
			
			comboBox_NombSeguros = new JComboBox();
			comboBox_NombSeguros.setModel(seguros);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre del Seguro :");
			
			btnConsultar = new JButton("Consultar");
			GroupLayout gl_panel_DPer = new GroupLayout(panel_DPer);
			gl_panel_DPer.setHorizontalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(8)))
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBuscarHist, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
						.addGap(9)
						.addComponent(btnHistorial, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(2)
								.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGap(15)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(comboBox_Seguro, 0, 50, Short.MAX_VALUE))
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox_NombSeguros, 0, 120, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_panel_DPer.setVerticalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBuscarHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnHistorial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox_Seguro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnConsultar))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(comboBox_NombSeguros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(6)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(18))
			);
			panel_DPer.setLayout(gl_panel_DPer);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel label = new JLabel("Nombres :");
			label.setHorizontalAlignment(SwingConstants.TRAILING);
			
			JLabel label_1 = new JLabel("Cedula : ");
			label_1.setHorizontalAlignment(SwingConstants.TRAILING);
			
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
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			
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
			
			textField_Celular = new JTextFieldValidator(11,JTextFieldValidator.SOLO_NUMEROS);
			textField_Celular.setColumns(10);
			
			JLabel lblTlfCasa = new JLabel("Tlf. Casa :");
			
			textField_Casa = new JTextFieldValidator(11,JTextFieldValidator.SOLO_NUMEROS);
			textField_Casa.setColumns(10);
			
			textField_Email = new JTextFieldValidator(30,JTextFieldValidator.CUALQUIER_CARACTER);
			textField_Email.setColumns(10);
			
			JLabel label_4 = new JLabel("E-mail :");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(label, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
													.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
												.addGap(37))
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(comboBox_edoCivil, 0, 117, Short.MAX_VALUE)
											.addComponent(textField_Nomb, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
											.addComponent(textField_Ced, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
										.addGap(44))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(22)
										.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel.createSequentialGroup()
												.addGap(10)
												.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
											.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
											.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
										.addGap(18)))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
									.addComponent(fechaNac, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(comboBox_Estado, 0, 146, Short.MAX_VALUE)
											.addComponent(textField_Email, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblTlfCelular, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(26)
								.addComponent(textField_Celular, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
								.addGap(56)
								.addComponent(lblTlfCasa, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
								.addGap(31)
								.addComponent(textField_Casa, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(19)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(1)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(fechaNac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(27)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(7)
										.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(5)
										.addComponent(textField_Email))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGap(2))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_Nomb, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(comboBox_edoCivil, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblDireccion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox_Estado, Alignment.LEADING))
								.addGap(4)))
						.addGap(4)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addGap(11)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblTlfCelular, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(textField_Celular))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(textField_Casa))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblTlfCasa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
								.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
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
		textField_Ced.setText(null);
		textField_NroHist.setText(null);
		textField_NroSeguro.setText(null);
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
	
	public void llenarCampos(String numH, String ced, String nom, String apell,
			String casa, String email, String celular, String dir, String edo, Date fecha, 
			char edoC, boolean sgu) {
		textField_Ced.setText(ced);
		textField_NroHist.setText(numH.substring(2, numH.length()));
		textField_Nomb.setText(nom);
		textField_Apelli.setText(apell);
		textField_Casa.setText(casa);
		textField_Email.setText(email);
		textField_Celular.setText(celular);
		textArea_Direccion.setText(dir);
		comboBox_Estado.setSelectedItem(edo);
		fechaNac.setDate(fecha);
		setEdoC(edoC);
		setSeguro(sgu);
		
	}
	
	public void llenarSeguro(int numS, int segu) {
		textField_NroSeguro.setText(Integer.toString(numS));
		comboBox_NombSeguros.setSelectedIndex(segu);
		
	}
	
	public void addListener(ActionListener actionListener) {
		btnIncluir.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		btnBuscarHist.addActionListener(actionListener);
		btnHistorial.addActionListener(actionListener);
		btnConsultar.addActionListener(actionListener);
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
	
	public void setCodSeguro(int seg) {
		comboBox_NombSeguros.setSelectedIndex(seg);
	}
	
	public int getCodSeguro() {
		return comboBox_NombSeguros.getSelectedIndex();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	public void interfazRegistro() {
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnBuscarHist.setVisible(false);
		btnConsultar.setVisible(false);
	}
	
	public void interfazModificar() {
		btnIncluir.setVisible(false);
		textField_Ced.setEditable(false);
		fechaNac.setEnabled(false);
		textField_NroHist.setEditable(false);
		btnEliminar.setVisible(false);
		btnHistorial.setVisible(false);
		btnConsultar.setVisible(false);
	}
	
	public void interfazEliminar() {
		btnModificar.setVisible(false);
		btnIncluir.setVisible(false);
		textField_Ced.setEditable(false);
		fechaNac.setEnabled(false);
		textField_NroHist.setEditable(false);
		btnHistorial.setVisible(false);
		btnBuscarHist.setVisible(false);
	}
	
	public void interfazConsultar() {
		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);
		btnIncluir.setVisible(false);
		textField_Ced.setEditable(false);
		fechaNac.setEnabled(false);
		textField_NroHist.setEditable(false);
		btnHistorial.setVisible(false);
		btnBuscarHist.setVisible(false);
	}
	
	public boolean validarCamposLlenos() {
		if(textField_Ced.getText().equals(null) || textField_NroHist.getText().equals(null) || textField_NroSeguro.getText().equals(null) ||
				textField_Nomb.getText().equals(null) || textField_Apelli.getText().equals(null) || textField_Casa.getText().equals(null) || 
				textField_Email.getText().equals(null) || textField_Celular.getText().equals(null) || textArea_Direccion.getText().equals(null) || 
				fechaNac.getDate().equals(null))
			return true;
		else
			return false;
	}
	
	public boolean validarCedula() {
		if(textField_Ced.getText().length()<7)
			return true;
		else
			return false;
	}
}
