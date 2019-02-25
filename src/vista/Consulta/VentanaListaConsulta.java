//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Consulta;
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

import bean.JTextFieldValidator;
import vista.Clinica.VentanaListaClinica;

import javax.swing.ImageIcon;
public class VentanaListaConsulta extends javax.swing.JFrame 
{
	
	private JTextField textFieldCedulaP;
	private JButton btnIncluir;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JTable tblConsultas;
	private JButton btnActuListado;
	private JButton btnConsultar;

			/**
	 * Create the application.
	 */
	public VentanaListaConsulta() {
		super();
		setTitle("Listado de Consultas");
		initialize();
		setSize(540,558);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Listado de Consultas");
		setAutoRequestFocus(false);
		setBounds(100, 100, 540, 591);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblListaConsultas = new JLabel("Lista de Consultas");
		lblListaConsultas.setForeground(Color.BLUE);
		lblListaConsultas.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblListaConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelLista = new JPanel();
		panelLista.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnActuListado = new JButton("");
		btnActuListado.setIcon(new ImageIcon(VentanaListaClinica.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(453)
							.addComponent(btnActuListado, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(154)
								.addComponent(lblListaConsultas))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(32)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(panelLista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
									.addComponent(panelBuscar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblListaConsultas)
					.addGap(18)
					.addComponent(panelBuscar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnActuListado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelLista, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panelLista.add(scrollPane);
		
		tblConsultas = new JTable();
		tblConsultas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula del Paciente","Clinica", "Fecha", "Medico"
			}
		));
		scrollPane.setViewportView(tblConsultas);
		
		textFieldCedulaP = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
		textFieldCedulaP.setColumns(10);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(0, 102, 51));
		
		JLabel lblCedulaP = new JLabel("Cedula del Paciente :");
		
		btnBuscar = new JButton("...");
			btnBuscar.setBackground(Color.DARK_GRAY);
			
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			btnConsultar = new JButton("Consultar");
			GroupLayout gl_panelBuscar = new GroupLayout(panelBuscar);
			gl_panelBuscar.setHorizontalGroup(
				gl_panelBuscar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelBuscar.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBuscar.createSequentialGroup()
								.addComponent(lblCedulaP)
								.addGap(16)
								.addComponent(textFieldCedulaP, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING)
							.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panelBuscar.setVerticalGroup(
				gl_panelBuscar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelBuscar.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldCedulaP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCedulaP)
							.addComponent(btnActualizar)
							.addComponent(btnBuscar))
						.addGap(15)
						.addGroup(gl_panelBuscar.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnConsultar))
						.addContainerGap())
			);
			panelBuscar.setLayout(gl_panelBuscar);
			getContentPane().setLayout(groupLayout);
		}
		public void addListener(ActionListener actionListener) {
			btnActualizar.addActionListener(actionListener);
			btnIncluir.addActionListener(actionListener);
			btnBuscar.addActionListener(actionListener);
			btnActuListado.addActionListener(actionListener);
			btnConsultar.addActionListener(actionListener);
		}
		
		public void setResultados(AbstractTableModel abstractTableModel) {
			tblConsultas.setModel(abstractTableModel);
		}
		
		public JTable getTblConsultas() {
			return tblConsultas;
		}

		
		public String getCedulaP()
		{
			return textFieldCedulaP.getText();
		}
	
		public void setTextFieldNombre(String nombre) {
			this.textFieldCedulaP.setText(nombre);
		}
	

		public void salir() {
			this.setVisible(false);
			this.dispose();
		}
		
		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(this, mensaje);
		}
}
