package vista.Servicio;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import bean.JTextFieldValidator;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaServicio extends JFrame{
	private JTextFieldValidator textField_Descripcion;
	private JTextFieldValidator textField_Nombre;
	private JTextFieldValidator textFieldCodigo;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JComboBox comboBox_Especialidad;
	private JComboBox comboBox_Tipo;
	private JLabel lblTipo;
	
	public VentanaServicio(String codigo, DefaultComboBoxModel especialidades) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		comboBox_Especialidad.setModel(especialidades);
		setSize(419, 391);
		textFieldCodigo.setText(codigo);
		textFieldCodigo.setEnabled(false);
	}

	private void initGUI() {
		try {
			setTitle("Gestionar Servicio");
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Servicio", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblCdigo = new JLabel("C\u00F3digo :");
			
			JLabel label_1 = new JLabel("Nombre :");
			
			JLabel lblEspecialidad = new JLabel("Especialidad :");
			
			JLabel lblDescripcin = new JLabel("Descripci\u00F3n :");
			
			comboBox_Especialidad = new JComboBox();
			
			textField_Descripcion = new JTextFieldValidator(50, JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Descripcion.setText((String) null);
			textField_Descripcion.setColumns(10);
			
			textField_Nombre = new JTextFieldValidator(30, JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Nombre.setText((String) null);
			textField_Nombre.setColumns(10);
			
			textFieldCodigo = new JTextFieldValidator(10, JTextFieldValidator.SOLO_NUMEROS);
			
			comboBox_Tipo = new JComboBox();
			comboBox_Tipo.setModel(new DefaultComboBoxModel(new String[] {"Consulta", "Intervencion"}));
			comboBox_Tipo.setToolTipText("");
			
			lblTipo = new JLabel("Tipo :");
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox_Tipo, 0, 242, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addComponent(lblCdigo, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
										.addGap(28))
									.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
										.addGap(35))
									.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addComponent(lblDescripcin, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblEspecialidad, GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_Nombre, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
									.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
									.addComponent(textField_Descripcion, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
									.addComponent(comboBox_Especialidad, 0, 242, Short.MAX_VALUE))))
						.addGap(19))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblCdigo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(7)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(1)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
								.addGap(2))
							.addComponent(textField_Nombre, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDescripcin)
							.addComponent(textField_Descripcion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblEspecialidad, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addComponent(comboBox_Especialidad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_Tipo, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(15))
			);
			panel.setLayout(gl_panel);
			
			btnIncluir = new JButton("Incluir");
			
			btnVolver = new JButton("Volver");
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			btnEliminar = new JButton("Eliminar");
			
			JLabel label_2 = new JLabel("Gestionar Paciente");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.BLUE);
			label_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addGap(27))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
								.addGap(6)
								.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
						.addGap(14))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
							.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGap(14))
			);
			getContentPane().setLayout(groupLayout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addListener(ActionListener actionListener) {
		btnModificar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnIncluir.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}
	
	public void llenarCampos(String codigo, String nombre,
			String descripcion, int especilidad, char tipo) {
		textFieldCodigo.setText(codigo);
		textField_Nombre.setText(nombre);
		textField_Descripcion.setText(descripcion);
		comboBox_Especialidad.setSelectedIndex(especilidad);
		if(tipo=='c')
			comboBox_Tipo.setSelectedIndex(0);
		else
			comboBox_Tipo.setSelectedIndex(1);
	}
	
	public void vaciarCampos() {
		textFieldCodigo.setText(null);
		textField_Nombre.setText(null);
		textField_Descripcion.setText(null);
		comboBox_Especialidad.setSelectedIndex(0);
	}

	public String getTextField_Descripcion() {
		return textField_Descripcion.getText();
	}

	public String getTextField_Nombre() {
		return textField_Nombre.getText();
	}

	public String getTextFieldCodigo() {
		return textFieldCodigo.getText();
	}

	public int getComboBox_Especialidad() {
		return comboBox_Especialidad.getSelectedIndex();
	}
	
	public char getComboBox_Tipo() {
		if (comboBox_Tipo.getSelectedIndex()==0)
			return 'c';
		else
			return 'i';
	}
	
	public boolean validarCampos() {
		if (textField_Descripcion.getText()==null && textField_Nombre.getText()==null && textFieldCodigo.getText()==null)
			return false;
		else
			return true;
	}
	
	public void interfazIncluir() {
		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);
	}
	
	public void interfazModificar() {
		btnIncluir.setVisible(false);
		btnEliminar.setVisible(false);
	}
	
	public void interfazEliminar() {
		btnIncluir.setVisible(false);
		btnModificar.setVisible(false);
		textField_Descripcion.setEditable(false);
		textField_Nombre.setEditable(false);
		comboBox_Especialidad.setEditable(false);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void setTextFieldCodigo(String codigo) {
		textFieldCodigo.setText(codigo);
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
}
