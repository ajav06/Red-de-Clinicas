package vista.Servicio;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import bean.JTextFieldValidator;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class VentanaListadoServicios extends JFrame{
	private JTable tblServicios;
	private JButton btnBuscar;
	private JButton btnIncluir;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnRefrescar;
	private JButton btnVolver;
	private JComboBox comboBox_filtro;
	private JTextFieldValidator textField_codigo;
	
	public VentanaListadoServicios(DefaultComboBoxModel especialidades) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		comboBox_filtro.setModel(especialidades);
		setSize(540, 609);
	}

	private void initGUI() {
		try {
			setTitle("Lista Servicios");
			JLabel lblListaServicios = new JLabel("Lista Servicios");
			lblListaServicios.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaServicios.setForeground(Color.BLUE);
			lblListaServicios.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			
			btnRefrescar = new JButton("Refrescar");
			
			btnVolver = new JButton("Volver");
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 463, Short.MAX_VALUE)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 334, Short.MAX_VALUE)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addContainerGap())
			);
			
			tblServicios = new JTable();
			scrollPane.setViewportView(tblServicios);
			panel.setLayout(gl_panel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			textField_codigo = new JTextFieldValidator(50, 'Z');
			textField_codigo.setText("Introduzca Código del Servicio o Nombre");
			textField_codigo.setHorizontalAlignment(SwingConstants.CENTER);
			textField_codigo.setColumns(10);
			
			comboBox_filtro = new JComboBox();
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBackground(Color.DARK_GRAY);
			
			btnIncluir = new JButton("Incluir");
			btnIncluir.setBackground(Color.LIGHT_GRAY);
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setBackground(new Color(0, 102, 51));
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBackground(new Color(204, 51, 51));
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 463, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(textField_codigo, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(comboBox_filtro, 0, 132, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGap(0, 96, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_codigo, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
							.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addComponent(comboBox_filtro, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addGap(17)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
						.addGap(9))
			);
			panel_1.setLayout(gl_panel_1);
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(82)
								.addComponent(lblListaServicios, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
								.addGap(84))
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnRefrescar, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addGap(288)
								.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
						.addGap(30))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblListaServicios, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnRefrescar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
								.addGap(1))
							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGap(9))
			);
			getContentPane().setLayout(groupLayout);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void setResultados(AbstractTableModel abstractTableModel) {
		tblServicios.setModel(abstractTableModel);
	}
	
	public JTable getTblServicios() {
		return tblServicios;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void limpiarCodigo() {
		textField_codigo.setText("");
	}
	
	public void addListener(ActionListener actionListener) {
		btnActualizar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnIncluir.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		btnRefrescar.addActionListener(actionListener);
	}
	
	public int getEspecialidad() {
		return comboBox_filtro.getSelectedIndex();
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	public String getCodigo() {
		return textField_codigo.getText();	
	}
}
