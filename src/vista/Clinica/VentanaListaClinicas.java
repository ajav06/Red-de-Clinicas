package vista.Clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

public class VentanaListaClinicas {

	private JFrame frame;
	private JTextField textField;

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
		
		JList list = new JList();
		
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
								.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
					.addGap(19)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		
		JButton btnActualizar = new JButton("Actualizar");
		
		JButton btnEliminar = new JButton("Eliminar");
		
		JLabel lblCodigo = new JLabel("Codigo :");
		
		JButton btnNewButton = new JButton("New button");
		GroupLayout gl_panelBuscar = new GroupLayout(panelBuscar);
		gl_panelBuscar.setHorizontalGroup(
			gl_panelBuscar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBuscar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBuscar.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelBuscar.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(16)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, 0, 0, Short.MAX_VALUE))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo)
						.addComponent(btnNewButton)
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
}
