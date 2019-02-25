//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Clinica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaListaServiciosClinica extends JFrame {

	private JPanel contentPane;
	private JTable tblServicios;
	private JTextField txtPrecioServicio;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnBuscar;
	public JComboBox cbDescServicio;
	private JComboBox cbTipo;
	public boolean tipoInterfaz;


	/**
	 * Create the frame.
	 */
	public VentanaListaServiciosClinica(String nombclini) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblServiciosOfrecidosPor = new JLabel("Servicios Ofrecidos por la Clínica ");
		lblServiciosOfrecidosPor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblServiciosOfrecidosPor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombre)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServiciosOfrecidosPor)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblServicio = new JLabel("Servicio:");
		
		cbDescServicio = new JComboBox();
		
		JLabel lblPrecio = new JLabel("Precio:");
		
		txtPrecioServicio = new JTextField();
		txtPrecioServicio.setColumns(10);
		
		btnIncluir = new JButton("Incluir");
		btnModificar = new JButton("Modificar");
		btnSalir = new JButton("Salir");
		btnLimpiar = new JButton("Limpiar");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblServicio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbDescServicio, 0, 412, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblPrecio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPrecioServicio, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLimpiar)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServicio)
						.addComponent(cbDescServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio)
						.addComponent(txtPrecioServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnSalir)
						.addComponent(btnModificar)
						.addComponent(btnLimpiar))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tblServicios = new JTable();
		scrollPane.setViewportView(tblServicios);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Intervención", "Consulta"}));
		
		btnBuscar = new JButton("Buscar");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTipo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbTipo, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(cbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		tipoInterfaz = false;
		lblNombre.setText(nombclini);
	}
	
	public void setResultados(AbstractTableModel abstractTableModel) {
		tblServicios.setModel(abstractTableModel);
	}
	
	public JTable getTblServicios() {
		return tblServicios;
	}

	public void addListener(ActionListener actionListener)
	{
		btnBuscar.addActionListener(actionListener);
		btnIncluir.addActionListener(actionListener);
		btnLimpiar.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnSalir.addActionListener(actionListener);
						
	}

	public void salir() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void interfazModificar() {
		btnIncluir.setEnabled(false);
		btnModificar.setEnabled(true);
		cbDescServicio.setEnabled(false);
		tipoInterfaz = true;
		cbDescServicio.setSelectedItem(String.valueOf(tblServicios.getModel().getValueAt(tblServicios.getSelectedRow(), 2)));
	}
	
	public void limpiar() {
		btnIncluir.setEnabled(true);
		cbDescServicio.setEnabled(true);
		txtPrecioServicio.setText("");
		cbDescServicio.setSelectedIndex(0);
		tipoInterfaz = false;
		cbTipo.setSelectedIndex(0);
	}
	
	public char tipoFiltrado() {
		char t = 'x';
		switch(cbTipo.getSelectedIndex()) {
		case 1:
			t = 'i';
			break;
		case 2:
			t = 'c';
			break;
		}
		return t;
	}
	
	public boolean camposLlenos() {
		if (txtPrecioServicio.getText()==null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String codSeleccionado() {
		return String.valueOf(tblServicios.getSelectedRow());
	}
	
	public String codServicioSeleccionado() {
		return String.valueOf(cbDescServicio.getSelectedIndex());
	}
	
	public void setPrecio(float precio) {
		this.txtPrecioServicio.setText(String.valueOf(precio));
	}
	
	public float getPrecio() {
		return Float.valueOf(this.txtPrecioServicio.getText());
	}
	
	public float obtenerPrecioSeleccionado() {
		return Float.valueOf(String.valueOf(tblServicios.getModel().getValueAt(tblServicios.getSelectedRow(), 3)));
	}
	
	public boolean seleccionado() {
		if (tblServicios.getSelectedRow()==-1){
			return false;
		}
		return true;
	}
}
