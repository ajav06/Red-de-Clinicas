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

public class VentanaEliminarPaciente extends javax.swing.JFrame{
	private JTextField textField_Ced;
	private JTextField textField_FechaN;
	private JTextField textField_Nomb;
	private JTextField textField_Apelli;
	private JTextField textField_NroHist;
	private JTextField textField_NroSeguro;
	public VentanaEliminarPaciente () {
		getContentPane().setForeground(Color.BLUE);
		
		JLabel lblEliminarP = new JLabel("Eliminar Paciente");
		lblEliminarP.setForeground(Color.BLUE);
		lblEliminarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblEliminarP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_DMed = new JPanel();
		panel_DMed.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblCed = new JLabel("Cedula : ");
		
		JLabel lblFechaN = new JLabel("Fecha Nac. :");
		
		textField_Ced = new JTextField();
		textField_Ced.setEditable(false);
		textField_Ced.setColumns(10);
		
		textField_FechaN = new JTextField();
		textField_FechaN.setEditable(false);
		textField_FechaN.setColumns(10);
		
		JLabel lblNomb = new JLabel("Nombres :");
		
		textField_Nomb = new JTextField();
		textField_Nomb.setEditable(false);
		textField_Nomb.setColumns(10);
		
		JLabel lblApelli = new JLabel("Apellidos :");
		
		textField_Apelli = new JTextField();
		textField_Apelli.setEditable(false);
		textField_Apelli.setColumns(10);
		GroupLayout gl_panel_DMed = new GroupLayout(panel_DMed);
		gl_panel_DMed.setHorizontalGroup(
			gl_panel_DMed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DMed.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNomb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_DMed.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel_DMed.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(textField_Nomb, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(44)
					.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_DMed.createSequentialGroup()
							.addGap(12)
							.addComponent(lblApelli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel_DMed.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_DMed.setVerticalGroup(
			gl_panel_DMed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DMed.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addGap(6)
								.addComponent(lblFechaN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addGap(6)
								.addComponent(lblCed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Ced)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_DMed.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addGap(6)
								.addComponent(lblNomb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Nomb))
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_Apelli)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addGap(6)
								.addComponent(lblApelli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(17))
		);
		panel_DMed.setLayout(gl_panel_DMed);
		
		JPanel panel_DPer = new JPanel();
		panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNroHist = new JLabel("Nro. Historial :");
		
		textField_NroHist = new JTextField();
		textField_NroHist.setEditable(false);
		textField_NroHist.setColumns(10);
		
		JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
		
		textField_NroSeguro = new JTextField();
		textField_NroSeguro.setEditable(false);
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
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(18))
		);
		
		JTextPane textPane_AntFam = new JTextPane();
		textPane_AntFam.setEditable(false);
		scrollPane_2.setViewportView(textPane_AntFam);
		
		JTextPane textPane_AntPer = new JTextPane();
		textPane_AntPer.setEditable(false);
		scrollPane_1.setViewportView(textPane_AntPer);
		panel_DPer.setLayout(gl_panel_DPer);
		
		JButton btnCancelar = new JButton("No");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		JButton btnAceptar = new JButton("Si");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnAceptar.setBackground(Color.GREEN);
		
		JLabel lblseguroQueDesea = new JLabel("\u00BFSeguro que desea Eliminarlo?");
		lblseguroQueDesea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_DMed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
							.addGap(43)
							.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addComponent(lblEliminarP, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
							.addGap(92))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(lblseguroQueDesea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(125)))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEliminarP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(panel_DMed, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblseguroQueDesea, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);
		

	}
}
