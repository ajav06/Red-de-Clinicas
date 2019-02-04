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
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaPrincipal extends javax.swing.JFrame{
	private JButton btnClinicas;
	private JButton btnEspecialidades;
	private JButton btnMedicos;
	private JButton btnPaciente;
	private JButton btnSeguros;
	
	public VentanaPrincipal() {
		super();
		getContentPane().setBackground(new Color(64, 224, 208));
		initGUI();
		setSize(329, 377);
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
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addGap(102)
						.addComponent(lblInicio_1, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addGap(87))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(37)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(25))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblInicio_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(58, Short.MAX_VALUE))
			);
			
			btnClinicas = new JButton("Clinica");
			btnClinicas.setBackground(new Color(70, 130, 180));
			
			btnEspecialidades = new JButton("Especialidades");
			btnEspecialidades.setBackground(new Color(70, 130, 180));
			
			btnMedicos = new JButton("Medicos");
			btnMedicos.setBackground(new Color(70, 130, 180));
			
			btnPaciente = new JButton("Pacientes");
			btnPaciente.setBackground(new Color(70, 130, 180));
			
			btnSeguros = new JButton("Seguros");
			btnSeguros.setBackground(new Color(70, 130, 180));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(62)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnSeguros, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnPaciente, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnMedicos, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnEspecialidades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
											.addComponent(btnClinicas, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
										.addGap(55))))))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnClinicas)
						.addGap(18)
						.addComponent(btnEspecialidades)
						.addGap(18)
						.addComponent(btnMedicos)
						.addGap(18)
						.addComponent(btnPaciente)
						.addGap(18)
						.addComponent(btnSeguros)
						.addContainerGap(48, Short.MAX_VALUE))
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
		btnSeguros.addActionListener(actionListener);
	}
}
