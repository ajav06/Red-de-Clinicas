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
import com.toedter.calendar.JDateChooser;
import bean.*;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;


public class VentanaAgreagarClinica extends javax.swing.JFrame {

	private JTextField textFieldNomre;
	private JTextField textFieldCodigo;
	private JTextField textFieldEstado;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	/**
	 * Launch the application.
	 */
	public VentanaAgreagarClinica(String codigo) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		blanquearCampos();
		textFieldCodigo.setText(codigo);
		textFieldCodigo.setEnabled(false);
	}

	private void initialize() {
		setBounds(100, 100, 498, 459);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblEnunciado = new JLabel("Registrar Clinica");
		lblEnunciado.setForeground(Color.BLUE);
		lblEnunciado.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panDC = new JPanel();
		panDC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Clinica", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnRegistrar.setBackground(Color.GREEN);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(28)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(127)
					.addComponent(btnRegistrar)
					.addGap(74)
					.addComponent(btnCancelar)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnunciado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panDC, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistrar)
						.addComponent(btnCancelar))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		JLabel lblNombre = new JLabel("Nombre :");
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblDireccion = new JLabel("Direccion :");
		
		JLabel lblTelefono = new JLabel("Telefono :");
		
		JLabel lblCorreo = new JLabel("Correo :");
		
		textFieldNomre = new JTextField();
		textFieldNomre.setColumns(10);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		
		
		
		GroupLayout gl_panDC = new GroupLayout(panDC);
		gl_panDC.setHorizontalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panDC.createSequentialGroup()
							.addComponent(lblCorreo)
							.addGap(18)
							.addComponent(textFieldCorreo, 265, 265, 265))
						.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panDC.createSequentialGroup()
								.addComponent(lblTelefono)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textFieldTelefono, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
							.addGroup(gl_panDC.createSequentialGroup()
								.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_panDC.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_panDC.createParallelGroup(Alignment.LEADING)
											.addGroup(Alignment.TRAILING, gl_panDC.createSequentialGroup()
												.addComponent(lblCodigo)
												.addGap(18))
											.addGroup(gl_panDC.createSequentialGroup()
												.addComponent(lblNombre)
												.addGap(7)))
										.addGroup(gl_panDC.createSequentialGroup()
											.addComponent(lblEstado)
											.addGap(12)))
									.addGroup(gl_panDC.createSequentialGroup()
										.addComponent(lblDireccion)
										.addGap(7)))
								.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldDireccion, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
									.addGroup(Alignment.TRAILING, gl_panDC.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldEstado)
										.addComponent(textFieldNomre)
										.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))))
					.addGap(62))
		);
		gl_panDC.setVerticalGroup(
			gl_panDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panDC.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNomre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panDC.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefono)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panDC.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44))
		);
		panDC.setLayout(gl_panDC);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	public void blanquearCampos() 
	{		
		textFieldNomre.setText(null);
		textFieldEstado.setText(null);
		textFieldDireccion.setText(null);
		textFieldCorreo.setText(null);
		textFieldTelefono.setText(null);
	
	}
	
	public void addListener(ActionListener actionListener) {
		btnRegistrar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);		
	}
	
	public String getCodigo() {
		return textFieldCodigo.getText();
	}
	
	public String getNombre() {
		return textFieldNomre.getText();
	}
	
	public String  getEstado() {
		return textFieldEstado.getText();
	}
	
	public String getDireccion() {
		return textFieldDireccion.getText();
	}
	
	
	
	public String getTelefono() {
		return textFieldTelefono.getText();
	}
	
	public String getCorreo() {
		return textFieldCorreo.getText();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	
}
