package vista;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;


public class VentanaAgregarPaciente extends javax.swing.JFrame{
	private JTextField textField_NroHist;
	private JTextField textField_NroSeguro;
	private JTextField textField_Ced;
	private JTextField textField_Nomb;
	private JTextField textField_Apelli;
	private JTextField textField_FechaN;
	public VentanaAgregarPaciente() {
		getContentPane().setForeground(Color.BLUE);
		
		JLabel lblRegistrarP = new JLabel("Registrar Paciente");
		lblRegistrarP.setForeground(Color.BLUE);
		lblRegistrarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblRegistrarP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_DPer = new JPanel();
		panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNroHist = new JLabel("Nro. Historial :");
		
		textField_NroHist = new JTextField();
		textField_NroHist.setColumns(10);
		
		JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
		
		textField_NroSeguro = new JTextField();
		textField_NroSeguro.setColumns(10);
		
		JLabel lblAntecedentesPersonales = new JLabel("Antecedentes Personales: ");
		
		JLabel lblAntecedentesFamiliares = new JLabel("Antecedentes Familiares: ");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_DPer = new GroupLayout(panel_DPer);
		gl_panel_DPer.setHorizontalGroup(
			gl_panel_DPer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DPer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_DPer.createSequentialGroup()
							.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
						.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(35)
					.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_DPer.createSequentialGroup()
							.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addGap(69))
						.addGroup(gl_panel_DPer.createSequentialGroup()
							.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
						.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_DPer.setVerticalGroup(
			gl_panel_DPer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DPer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addGap(18))
		);
		
		JTextPane textPane_AntFam = new JTextPane();
		scrollPane_2.setViewportView(textPane_AntFam);
		
		JTextPane textPane_AntPer = new JTextPane();
		scrollPane_1.setViewportView(textPane_AntPer);
		panel_DPer.setLayout(gl_panel_DPer);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnGuardar.setBackground(Color.GREEN);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label = new JLabel("Nombres :");
		
		JLabel label_1 = new JLabel("Cedula : ");
		
		textField_Ced = new JTextField();
		textField_Ced.setColumns(10);
		
		textField_Nomb = new JTextField();
		textField_Nomb.setColumns(10);
		
		JLabel label_2 = new JLabel("Fecha Nac. :");
		
		JLabel label_3 = new JLabel("Apellidos :");
		
		textField_Apelli = new JTextField();
		textField_Apelli.setColumns(10);
		
		textField_FechaN = new JTextField();
		textField_FechaN.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(textField_Nomb, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField_Ced))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField_Nomb)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField_Apelli))
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(lblRegistrarP, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
							.addGap(100))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
									.addGap(43)
									.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
									.addGap(16))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblRegistrarP, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);
		

	}
}
