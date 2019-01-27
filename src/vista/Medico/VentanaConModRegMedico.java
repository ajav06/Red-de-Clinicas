package vista.Medico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
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

	/**
	 * Create the application.
	 */
	public VentanaConModRegMedico() {
		super();
		setTitle("Actualizar Médico");
		initialize();
		setSize(711, 713);
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
		
		JComboBox comboBox_LunesMat = new JComboBox();
		
		JComboBox comboBox_MartesMat = new JComboBox();
		
		JComboBox comboBox_MiercolesMat = new JComboBox();
		
		JComboBox comboBox_JuevesMat = new JComboBox();
		
		JComboBox comboBox_ViernesMat = new JComboBox();
		
		JComboBox comboBox_LunesVesp = new JComboBox();
		
		JComboBox comboBox_MartesVesp = new JComboBox();
		
		JComboBox comboBox_MiercolesVesp = new JComboBox();
		
		JComboBox comboBox_JuevesVesp = new JComboBox();
		
		JComboBox comboBox_ViernesVesp = new JComboBox();
		
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
		
		JComboBox comboBox_Estado = new JComboBox();
		
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
		
		JTextPane textPane_Direccion = new JTextPane();
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
		
		JComboBox cB_Especialidad = new JComboBox();
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCedula)
							.addGap(18)
							.addComponent(textField_Cedula, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNmeroCelular)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_TlfCelular))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblEmail)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_Email))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblFechaDeNacimiento)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))
							.addGap(23)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblTlfCasa)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_TlfCasa, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnEditarEspecialidades, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblApellido)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_Apellido))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEspecialidad)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cB_Especialidad, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCedula)
						.addComponent(textField_Cedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblApellido)
							.addComponent(textField_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNombre))
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
							.addComponent(textField_Email)))
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
		textField_Nombre.setText(null);
		textField_FechaN.setDate(null);
		textField_Email.setText(null);
		textField_TlfCasa.setText(null);
		textField_TlfCelular.setText(null);
	}
	
	public void llenarCampos(String cedula, String nombre, Date fechan, String email, String tlfcasa, String tlfcelu, String codespec, String almamater, int annogrado, String[] horariomat, String[] horariovesp, boolean estudia) {
		textField_Cedula.setText(cedula);
		textField_Nombre.setText(nombre);
		textField_FechaN.setDate(fechan);
		textField_Email.setText(email);
		textField_TlfCasa.setText(tlfcasa);
		textField_TlfCelular.setText(tlfcelu);
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
		return (textField_Cedula.getText().equals("") || textField_TlfCelular.getText().equals("") ||
				textField_Nombre.getText().equals("") || textField_FechaN.getDate().toString().equals("") || 
				textField_Email.getText().equals("") || textField_TlfCasa.getText().equals("")
				);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public String getCedula() {
		return textField_Cedula.getText();
	}
	
	public String getNombre() {
		return textField_Nombre.getText();
	}
	
	public Date getFechaN() {
		return textField_FechaN.getDate();
	}
	
	public String getEmail() {
		return textField_Email.getText();
	}
	
	public String getTlfCasa() {
		return textField_TlfCasa.getText();
	}
	
	public String getTlfCelular() {
		return textField_TlfCelular.getText();
	}
	
	public String getEspecialidad() {
		return "Proximamente"; 
	}

	public void salir() {
		setVisible(false);
		dispose();
	}
}