package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaActualizarClinica {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActualizarClinica window = new VentanaActualizarClinica();
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
	public VentanaActualizarClinica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelDatosClin = new JPanel();
		panelDatosClin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblActualizarClinica = new JLabel("Actualizar Clinica");
		lblActualizarClinica.setForeground(Color.BLUE);
		lblActualizarClinica.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblActualizarClinica.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnActualizar = new JButton("Actualizar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(lblActualizarClinica))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(panelDatosClin, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(btnActualizar)
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(79))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblActualizarClinica)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDatosClin, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActualizar)
						.addComponent(btnCancelar))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		
		JLabel lblUbicacion = new JLabel("Ubicacion :");
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		GroupLayout gl_panelDatosClin = new GroupLayout(panelDatosClin);
		gl_panelDatosClin.setHorizontalGroup(
			gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosClin.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblNombre)
						.addComponent(lblEstado)
						.addComponent(lblCiudad)
						.addComponent(lblUbicacion)
						.addComponent(lblTelefono)
						.addComponent(lblCorreo))
					.addGap(23)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField_6, Alignment.LEADING)
						.addComponent(textField_5, Alignment.LEADING)
						.addComponent(textField_4, Alignment.LEADING)
						.addComponent(textField_3, Alignment.LEADING)
						.addComponent(textField_2, Alignment.LEADING)
						.addComponent(textField_1, Alignment.LEADING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panelDatosClin.setVerticalGroup(
			gl_panelDatosClin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosClin.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCiudad))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUbicacion))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addGap(18)
					.addGroup(gl_panelDatosClin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCorreo))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panelDatosClin.setLayout(gl_panelDatosClin);
		frame.getContentPane().setLayout(groupLayout);
	}
}
