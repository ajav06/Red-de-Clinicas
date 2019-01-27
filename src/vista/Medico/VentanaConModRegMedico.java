package vista.Medico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Date;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class VentanaConModRegMedico extends javax.swing.JFrame{

	private JTextField textField_Cedula;
	private JTextField textField_Nombre;
	private JDateChooser textField_FechaN;
	private JLabel lblEmail;
	private JTextField textField_Email;
	private JLabel lblNmeroCelular;
	private JTextField textField_TlfCelular;
	private JLabel lblEspecialidad;
	private JButton btnRegistrar;
	private JButton btnSalir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblApellido;
	private JTextField textField_Apellido;
	private JLabel lblTlfCasa;
	private JTextField textField_TlfCasa;
	private JPanel panel_1;
	private JLabel lblEstado;
	private JComboBox comboBox_LunesMat;
	private JComboBox comboBox_MartesMat;
	private JComboBox comboBox_MiercolesMat;
	private JComboBox comboBox_JuevesMat;
	private JComboBox comboBox_ViernesMat;
	private JComboBox comboBox_LunesVesp;
	private JComboBox comboBox_MartesVesp;
	private JComboBox comboBox_MiercolesVesp;
	private JComboBox comboBox_JuevesVesp;
	private JComboBox comboBox_ViernesVesp;
	private JComboBox comboBox_Estado;
	private JComboBox cB_Especialidad;
	private JComboBox comboBox_edoCivil;
	private JTextPane textPane_Direccion;
	

	/**
	 * Create the application.
	 */
	public VentanaConModRegMedico(DefaultComboBoxModel clinicas, DefaultComboBoxModel especialidades) {
		super();
		setTitle("Actualizar Médico");
		initialize();
		setSize(711, 713);
		cB_Especialidad.setModel(especialidades);
		comboBox_LunesMat.setModel(clinicas);
		comboBox_LunesVesp.setModel(clinicas);
		comboBox_MartesMat.setModel(clinicas);
		comboBox_MartesVesp.setModel(clinicas);
		comboBox_MiercolesMat.setModel(clinicas);
		comboBox_MiercolesVesp.setModel(clinicas);
		comboBox_JuevesMat.setModel(clinicas);
		comboBox_JuevesVesp.setModel(clinicas);
		comboBox_ViernesMat.setModel(clinicas);
		comboBox_ViernesVesp.setModel(clinicas);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
		setBounds(100, 100, 579, 351);
		getContentPane().setForeground(Color.BLUE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		btnRegistrar = new JButton("Registrar");
		
		btnSalir = new JButton("Salir");
		
		btnModificar = new JButton("Modificar");
		
		btnEliminar = new JButton("Eliminar");
		
		JLabel lblDatosDelMdico = new JLabel("Actualizar Médico");
		lblDatosDelMdico.setForeground(Color.BLUE);
		lblDatosDelMdico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del M\u00E9dico", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ubicaci\u00F3n del M\u00E9dico", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Horario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEliminar)
							.addPreferredGap(ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDatosDelMdico)
							.addGap(200))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDatosDelMdico)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblMatutino = new JLabel("Matutino:");
		
		JLabel lblVespertino = new JLabel("Vespertino:");
		
		comboBox_LunesMat = new JComboBox();
		
		comboBox_MartesMat = new JComboBox();
		
		comboBox_MiercolesMat = new JComboBox();
		
		comboBox_JuevesMat = new JComboBox();
		
		comboBox_ViernesMat = new JComboBox();
		
		comboBox_LunesVesp = new JComboBox();
		
		comboBox_MartesVesp = new JComboBox();
		
		comboBox_MiercolesVesp = new JComboBox();
		
		comboBox_JuevesVesp = new JComboBox();
		
		comboBox_ViernesVesp = new JComboBox();
		
		JLabel lblLunMarMier = new JLabel("Lun                    Mar                     Mier                     Jue                         Vie");
		lblLunMarMier.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatutino)
						.addComponent(lblVespertino))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(comboBox_LunesMat, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_MartesMat, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_MiercolesMat, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_JuevesMat, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_ViernesMat, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(comboBox_LunesVesp, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_MartesVesp, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_MiercolesVesp, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_JuevesVesp, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_ViernesVesp, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addComponent(lblLunMarMier)
					.addGap(58))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatutino)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_LunesMat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_MartesMat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_MiercolesMat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_JuevesMat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_ViernesMat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_LunesVesp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblVespertino))
						.addComponent(comboBox_MartesVesp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_MiercolesVesp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_JuevesVesp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_ViernesVesp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLunMarMier)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		lblEstado = new JLabel("Estado:");
		
		comboBox_Estado = new JComboBox();
		comboBox_Estado.setModel(new DefaultComboBoxModel(new String[] {"Amazonas", "Anzoátegui", "Apure", "Aragua", "Barinas", "Bolívar", "Carabobo", "Cojedes", "Delta Amacuro", "Distrito Capital", "Falcón", "Guárico", "Lara", "Mérida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "Táchira", "Trujillo", "Vargas", "Yaracuy", "Zulia"}));
		
		JLabel lblDireccin = new JLabel("Dirección:");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccin)
						.addComponent(lblEstado))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addComponent(comboBox_Estado, 0, 513, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBox_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccin)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		textPane_Direccion = new JTextPane();
		scrollPane.setViewportView(textPane_Direccion);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblCedula = new JLabel("Cédula:");
		
		textField_Cedula = new JTextField();
		textField_Cedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		
		textField_FechaN = new JDateChooser();
		
		lblEspecialidad = new JLabel("Especialidad:");
		
		cB_Especialidad = new JComboBox();
		cB_Especialidad.setModel(new DefaultComboBoxModel(new String[] {"Urólogo", "Neurólogo", "Perro Loco"}));
		
		JButton btnEditarEspecialidades = new JButton("Consultar Especialidades");
		
		lblEmail = new JLabel("E-Mail:");
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		
		lblNmeroCelular = new JLabel("Tlf. Celular:");
		
		textField_TlfCelular = new JTextField();
		textField_TlfCelular.setColumns(10);
		
		lblTlfCasa = new JLabel("Tlf. Casa:");
		
		textField_TlfCasa = new JTextField();
		textField_TlfCasa.setColumns(10);
		
		JLabel lblEdoCivil = new JLabel("Edo. Civil:");
		
		comboBox_edoCivil = new JComboBox();
		comboBox_edoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Comprometido/a", "Casado/a", "Divorciado/a", "Viudo/a"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNmeroCelular)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_TlfCelular, 210, 210, 210))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEmail)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_Email, 238, 238, 238))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFechaDeNacimiento)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCedula)
								.addComponent(lblApellido))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_Apellido, 247, 247, 247)
								.addComponent(textField_Cedula, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(7)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_Nombre, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblTlfCasa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_TlfCasa, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEditarEspecialidades, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEspecialidad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cB_Especialidad, 0, 215, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEdoCivil)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_edoCivil, 0, 241, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCedula)
						.addComponent(textField_Cedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre)
						.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(textField_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdoCivil)
						.addComponent(comboBox_edoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEspecialidad)
							.addComponent(cB_Especialidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(textField_FechaN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblFechaDeNacimiento)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnEditarEspecialidades, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEmail)
							.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroCelular)
						.addComponent(textField_TlfCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTlfCasa)
						.addComponent(textField_TlfCasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void blanquearCampos() {
		textField_Cedula.setText(null);
		cB_Especialidad.setSelectedIndex(0);
		textField_Nombre.setText(null);
		textField_Apellido.setText(null);
		textField_FechaN.setDate(null);
		comboBox_edoCivil.setSelectedIndex(0);
		comboBox_Estado.setSelectedIndex(0);
		textPane_Direccion.setText(null);
		textField_Email.setText(null);
		textField_TlfCasa.setText(null);
		textField_TlfCelular.setText(null);
	}
	
	public void llenarCampos(String ced, String cod_espec, String nombres, String apellidos, Date fecha_n,
			char edo_c, String estado, String direccion, String tlf_casa, String tlf_movil, String email) {
		textField_Cedula.setText(ced);
		cB_Especialidad.setSelectedIndex(Integer.parseInt(cod_espec));
		textField_Nombre.setText(nombres);
		textField_Apellido.setText(apellidos);
		textField_FechaN.setDate(fecha_n);
		cargarEdoCivil(edo_c);
		comboBox_Estado.setSelectedItem(estado);
		textPane_Direccion.setText(direccion);
		textField_TlfCasa.setText(tlf_casa);
		textField_TlfCelular.setText(tlf_movil);
		textField_Email.setText(email);
	}
	
	public void cargarEdoCivil(char edo_c) {
		switch (edo_c) {
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
	
	public void addListener(ActionListener actionListener) {
		btnRegistrar.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnSalir.addActionListener(actionListener);
	}

	public void interfazRegistro() {
		btnEliminar.setEnabled(false);;
		btnModificar.setEnabled(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
	}
	
	public void interfazConsulta() {
		btnRegistrar.setEnabled(false);
		btnRegistrar.setVisible(false);
		textField_Cedula.setEditable(false);
	}
	
	public boolean chequearLlenos() { //Chequea y verifica que todos los campos estén actualmente llenos.
		return (textField_Cedula.getText().equals("") ||
				textField_Nombre.getText().equals("") || textField_Apellido.getText().equals("") ||
				textField_FechaN.getDate().toString().equals("") || textPane_Direccion.getText().equals("") ||
				textField_TlfCasa.getText().equals("") || textField_TlfCelular.getText().equals("") ||
				textField_Email.getText().equals(""));
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public String getCedula() {
		return textField_Cedula.getText();
	}
	
	public String getEspecialidad() {
		return String.valueOf(cB_Especialidad.getSelectedIndex());
	}
	
	public String getNombre() {
		return textField_Nombre.getText();
	}
	
	public String getApellido() {
		return textField_Apellido.getText();
	}
		
	public Date getFechaN() {
		return textField_FechaN.getDate();
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
	
	public String getEstado() {
		return comboBox_Estado.getSelectedItem().toString();
	}
	
	public String getDireccion() {
		return textPane_Direccion.getText();
	}
	
		public String getTlfCasa() {
		return textField_TlfCasa.getText();
	}
	
	public String getTlfCelular() {
		return textField_TlfCelular.getText();
	}
	
	public String getEmail() {
		return textField_Email.getText();
	}

	public void salir() {
		setVisible(false);
		dispose();
	}
}