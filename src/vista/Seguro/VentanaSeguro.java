package vista.Seguro;

import javax.swing.JFrame;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import bean.JTextFieldValidator;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaSeguro extends javax.swing.JFrame{
	private JTextFieldValidator textField_Codigo;
	private JTextFieldValidator textField_Nombre;
	private JTextFieldValidator textField_Descripcion;
	private JTable tblSeguros;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	
	public VentanaSeguro() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		blanquearCampos();
		setSize(451, 542);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Seguro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblGestionarSeguro = new JLabel("Gestionar Seguros");
		lblGestionarSeguro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarSeguro.setForeground(Color.BLUE);
		lblGestionarSeguro.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de Seguros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnIncluir = new JButton("Incluir");
		
		btnModificar = new JButton("Modificar");
		
		btnEliminar = new JButton("Eliminar");
		
		btnVolver = new JButton("Volver");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(lblGestionarSeguro, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addGap(62)
									.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))))
					.addGap(31))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionarSeguro, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
						.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addGap(20))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblSeguros = new JTable();
		scrollPane.setViewportView(tblSeguros);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_Codigo = new JTextFieldValidator(10, JTextFieldValidator.SOLO_NUMEROS);
		textField_Codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_Nombre = new JTextFieldValidator(50, JTextFieldValidator.LETRAS_Y_ESPACIOS);
		textField_Nombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		
		textField_Descripcion = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
		textField_Descripcion.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_Codigo, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_Nombre, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDescripcion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_Descripcion, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)))
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_Codigo))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_Nombre))
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblDescripcion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField_Descripcion))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
	
	public void initGUI() {
		try {
			setTitle("Registrar Seguro");
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void blanquearCampos() {
		this.textField_Codigo.setText(null);
		this.textField_Descripcion.setText(null);
		this.textField_Nombre.setText(null);
	}
	
	public void llenarDatos(String n, String d) {
		this.textField_Nombre.setText(n);
		this.textField_Descripcion.setText(d);
	}
	
	public void addListener(ActionListener actionListener) {
		btnEliminar.addActionListener(actionListener);
		btnIncluir.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		
	}
	
	public int getCodigo() {
		return Integer.parseInt(this.textField_Codigo.getText());
	}
	
	public String getNombre() {
		return this.textField_Nombre.getText();
	}
	
	public String getDescripcion() {
		return this.textField_Descripcion.getText();
	}
	
	public void setResultados(AbstractTableModel abstractTableModel) {
		this.tblSeguros.setModel(abstractTableModel);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
