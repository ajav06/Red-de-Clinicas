package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VentanaEliminarClinica {

	private JFrame frame;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldEstado;
	private JTextField textFieldCiudad;
	private JTextField textFieldUbicacion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarClinica window = new VentanaEliminarClinica();
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
	public VentanaEliminarClinica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JLabel lblEliminarClinica = new JLabel("Eliminar Clinica");
		lblEliminarClinica.setForeground(Color.BLUE);
		lblEliminarClinica.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEliminarClinica.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnEliminar = new JButton("Eliminar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(134, Short.MAX_VALUE)
					.addComponent(lblEliminarClinica)
					.addGap(112))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addComponent(btnEliminar)
					.addGap(79)
					.addComponent(btnCancelar)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEliminarClinica)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnCancelar))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		textFieldEstado = new JTextField();
		textFieldEstado.setEditable(false);
		textFieldEstado.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setEditable(false);
		textFieldCiudad.setColumns(10);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setEditable(false);
		textFieldUbicacion.setColumns(10);
		
		JLabel lblUbicacion = new JLabel("Ubicacion :");
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblNombre)
						.addComponent(lblEstado)
						.addComponent(lblCiudad)
						.addComponent(lblUbicacion)
						.addComponent(lblTelefono)
						.addComponent(lblCorreo))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldCorreo)
						.addComponent(textFieldTelefono)
						.addComponent(textFieldUbicacion)
						.addComponent(textFieldCiudad)
						.addComponent(textFieldEstado)
						.addComponent(textFieldNombre)
						.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
					.addGap(25))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCiudad)
						.addComponent(textFieldCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUbicacion))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
