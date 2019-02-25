//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Clinica;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class VentanaListaClinica extends javax.swing.JFrame {
	
	private JTextField textFieldNombre;
	private JButton btnIncluir;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JTable tblClinicas;
	private JButton btnActuListado;

			/**
	 * Create the application.
	 */
	public VentanaListaClinica() {
		super();
		setTitle("Listado de Clínicas");
		initialize();
		setSize(540,591);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Listado de Clínicas");
		setAutoRequestFocus(false);
		setBounds(100, 100, 540, 591);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblListaClinicas = new JLabel("Lista de Clinicas");
		lblListaClinicas.setForeground(Color.BLUE);
		lblListaClinicas.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblListaClinicas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelLista = new JPanel();
		panelLista.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnActuListado = new JButton("");
		btnActuListado.setIcon(new ImageIcon(VentanaListaClinica.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnActuListado, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(154)
								.addComponent(lblListaClinicas))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(32)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(panelLista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
									.addComponent(panelBuscar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblListaClinicas)
					.addGap(18)
					.addComponent(panelBuscar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnActuListado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelLista, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panelLista.add(scrollPane);
		
		tblClinicas = new JTable();
		tblClinicas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo","Nombre", "Estado", "Direccion", "Telefono", "Correo"
			}
		));
		scrollPane.setViewportView(tblClinicas);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(0, 102, 51));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(204, 51, 51));
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		btnBuscar = new JButton("...");
			btnBuscar.setBackground(Color.DARK_GRAY);
			
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			GroupLayout gl_panelBuscar = new GroupLayout(panelBuscar);
			gl_panelBuscar.setHorizontalGroup(
				gl_panelBuscar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelBuscar.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBuscar.createSequentialGroup()
								.addComponent(lblNombre)
								.addGap(16)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panelBuscar.setVerticalGroup(
				gl_panelBuscar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelBuscar.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNombre)
							.addComponent(btnActualizar)
							.addComponent(btnBuscar))
						.addGap(15)
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnEliminar))
						.addContainerGap())
			);
			panelBuscar.setLayout(gl_panelBuscar);
			getContentPane().setLayout(groupLayout);
		}
		public void addListener(ActionListener actionListener) {
			btnActualizar.addActionListener(actionListener);
			btnEliminar.addActionListener(actionListener);
			btnIncluir.addActionListener(actionListener);
			btnBuscar.addActionListener(actionListener);
			btnActuListado.addActionListener(actionListener);
			
		}
		
		public void setResultados(AbstractTableModel abstractTableModel) {
			tblClinicas.setModel(abstractTableModel);
		}
		
		public JTable getTblClinicas() {
			return tblClinicas;
		}

		
		public String getNombre()
		{
			return textFieldNombre.getText();
		}
	
		public void setTextFieldNombre(String nombre) {
			this.textFieldNombre.setText(nombre);
		}
		public JTable getTblClinica() {
			return tblClinicas;
		}

		public void salir() {
			this.setVisible(false);
			this.dispose();
		}
		
		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(this, mensaje);
		}
}
