package vista.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
//import com.toedter.calendar.JDateChooser;
//import bean.*;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JTextField;


public class VentanaAgreagarClinica {

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
					VentanaAgreagarClinica window = new VentanaAgreagarClinica();
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
	public VentanaAgreagarClinica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblEnunciado = new JLabel("Registrar Clinica");
		lblEnunciado.setForeground(Color.BLUE);
		lblEnunciado.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panDC = new JPanel();
		panDC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnRegistar = new JButton("Registar");
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(28)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(127)
					.addComponent(btnRegistar)
					.addGap(77)
					.addComponent(btnCancelar)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistar)
						.addComponent(btnCancelar))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		
		JLabel lblUbicacion = new JLabel("Ubicacion :");
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
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
		GroupLayout gl_panDC = new GroupLayout(panDC);
		gl_panDC.setHorizontalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblCorreo)
							.addGap(18)
							.addComponent(textField_6))
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblCiudad)
							.addGap(18)
							.addComponent(textField_3))
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblEstado)
							.addGap(18)
							.addComponent(textField_2))
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panDC.createSequentialGroup()
							.addComponent(lblTelefono)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_5))
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblUbicacion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_panDC.setVerticalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCiudad)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblUbicacion)
							.addGap(18)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefono)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCorreo)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panDC.setLayout(gl_panDC);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
