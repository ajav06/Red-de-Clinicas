package vista;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends javax.swing.JFrame{
	private JButton btnClinicas;
	private JButton btnEspecialidades;
	private JButton btnMedicos;
	private JButton btnPaciente;
	
	public VentanaPrincipal() {
		super();
		getContentPane().setBackground(new Color(64, 224, 208));
		initGUI();
		setSize(329, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		try {
			setTitle("Pantalla Principal");
			JLabel lblInicio_1 = new JLabel("Inicio");
			lblInicio_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblInicio_1.setForeground(Color.BLUE);
			lblInicio_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 139, 139));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Gestionar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(99)
								.addComponent(lblInicio_1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addGap(65))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(37)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
						.addGap(34))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblInicio_1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
						.addGap(39))
			);
			
			btnClinicas = new JButton("Clinica");
			btnClinicas.setBackground(new Color(70, 130, 180));
			
			btnEspecialidades = new JButton("Especialidades");
			btnEspecialidades.setBackground(new Color(70, 130, 180));
			
			btnMedicos = new JButton("Medicos");
			btnMedicos.setBackground(new Color(70, 130, 180));
			
			btnPaciente = new JButton("Pacientes");
			btnPaciente.setBackground(new Color(70, 130, 180));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(62)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnClinicas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
							.addComponent(btnEspecialidades, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
							.addComponent(btnMedicos, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
							.addComponent(btnPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(55))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnClinicas, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnEspecialidades, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnMedicos, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(20))
			);
			panel.setLayout(gl_panel);
			getContentPane().setLayout(groupLayout);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void addListener(ActionListener actionListener) {
		btnClinicas.addActionListener(actionListener);
		btnEspecialidades.addActionListener(actionListener);
		btnMedicos.addActionListener(actionListener);
		btnPaciente.addActionListener(actionListener);
	}
}
