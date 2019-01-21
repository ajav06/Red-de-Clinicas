package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
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

public class VentanaListaClinicas extends javax.swing.JFrame {

	private JFrame frame;
	private JTextField textFieldCodigo;
	private JButton btnIncliur;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JTable tblPacientes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListaClinicas window = new VentanaListaClinicas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaListaClinicas() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(540, 591);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblListaClinicas = new JLabel("Lista de Clinicas");
		lblListaClinicas.setForeground(Color.BLUE);
		lblListaClinicas.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblListaClinicas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelLista = new JPanel();
		panelLista.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(lblListaClinicas))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelLista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelBuscar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblListaClinicas)
					.addGap(18)
					.addComponent(panelBuscar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panelLista, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList listClinicas = new JList();
		GroupLayout gl_panelLista = new GroupLayout(panelLista);
		gl_panelLista.setHorizontalGroup(
			gl_panelLista.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLista.createSequentialGroup()
					.addContainerGap()
					.addComponent(listClinicas, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelLista.setVerticalGroup(
			gl_panelLista.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLista.createSequentialGroup()
					.addContainerGap()
					.addComponent(listClinicas, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelLista.setLayout(gl_panelLista);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncliur.setBackground(Color.LIGHT_GRAY);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(0, 102, 51));
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(204, 51, 51));
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		JButton btnBuscar = new JButton("New button");
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
					.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelBuscar.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(16)
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar, 0, 0, Short.MAX_VALUE))
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelBuscar.setVerticalGroup(
			gl_panelBuscar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBuscar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBuscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo)
						.addComponent(btnBuscar)
						.addComponent(btnActualizar))
					.addGap(15)
					.addGroup(gl_panelBuscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(btnEliminar))
					.addContainerGap())
		);
		panelBuscar.setLayout(gl_panelBuscar);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void addListener(ActionListener actionListener) {
		btnActualizar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnIncliur.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
		
	}
		public String getCodigo()
		{
			return textFieldCodigo.getText();
		}

		public void setTextFieldCodigo(String codigo) {
			this.textFieldCodigo.setText(codigo);
		}
	
		
		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(this, mensaje);
		}
	}

