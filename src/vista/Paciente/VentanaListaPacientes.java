package vista.Paciente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import bean.JTextFieldValidator;
import javax.swing.JButton;

public class VentanaListaPacientes extends javax.swing.JFrame{
	private JTextFieldValidator textField_Ced;
	private JButton btnIncliur;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JTable tblPacientes;
	private JButton btnVover;
	private JButton btnRefrescar;
	
	public VentanaListaPacientes() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		setSize(540, 609);
	}
	
	private void initGUI() {
		try {
			setTitle("Lista Pacientes");
			JLabel lblListaPacientes = new JLabel("Lista Pacientes");
			lblListaPacientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaPacientes.setForeground(Color.BLUE);
			lblListaPacientes.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			btnVover = new JButton("Volver");
			
			btnRefrescar = new JButton("Refrescar");
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(113)
						.addComponent(lblListaPacientes, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addGap(114))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnRefrescar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(288)
								.addComponent(btnVover, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
						.addGap(30))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblListaPacientes, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnVover, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
								.addGap(10))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnRefrescar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			
			JLabel label = new JLabel("Cedula : ");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			
			textField_Ced = new JTextFieldValidator(50, JTextFieldValidator.CUALQUIER_CARACTER);
			textField_Ced.setColumns(10);
			
			btnIncliur = new JButton("Incluir");
			btnIncliur.setBackground(Color.LIGHT_GRAY);
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setBackground(new Color(0, 102, 51));
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBackground(new Color(204, 51, 51));
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBackground(Color.DARK_GRAY);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
								.addGap(2))
							.addComponent(btnIncliur, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addGap(49)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addGap(24))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(20)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
									.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
									.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(17))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(17)
								.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
								.addGap(18)))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addComponent(btnIncliur, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addGap(12))
			);
			panel.setLayout(gl_panel);
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
						.addContainerGap())
			);
			
			tblPacientes = new JTable();
			scrollPane.setViewportView(tblPacientes);
			panel_1.setLayout(gl_panel_1);
			getContentPane().setLayout(groupLayout);
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void addListener(ActionListener actionListener) {
		btnActualizar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnIncliur.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
		btnVover.addActionListener(actionListener);
		btnRefrescar.addActionListener(actionListener);
	}
	
	public void setResultados(AbstractTableModel abstractTableModel) {
		this.tblPacientes.setModel(abstractTableModel);
	}
	
	public String getCedula() {
		return this.textField_Ced.getText();
	}

	public void setTextField_Ced(String cedula) {
		this.textField_Ced.setText(cedula);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public JTable getTblPacientes() {
		return tblPacientes;
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	public void vaciarCedula() {
		textField_Ced.setText(null);
	}
}
