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

	private JButton btnConsultas;

	private JButton btnCitasMedico;
	private JButton btnReportes;
	private JButton btnSalir;

	
	public VentanaPrincipal() {
		super();
		getContentPane().setBackground(new Color(64, 224, 208));
		initGUI();

		setSize(296, 549);
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
						.addGap(103)
						.addComponent(lblInicio_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addGap(86))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(37)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(51, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblInicio_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(57, Short.MAX_VALUE))
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
			
		btnConsultas = new JButton("Consultas");
		btnConsultas.setBackground(new Color(70, 130, 180));
			

			btnCitasMedico = new JButton("Citas Medico");
			btnCitasMedico.setBackground(new Color(70, 130, 180));
			
			btnReportes = new JButton("Reportes");
			btnReportes.setBackground(new Color(70, 130, 180));
			
			btnSalir = new JButton("Salir");
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setBackground(Color.RED);

			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(32)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnReportes, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCitasMedico, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnSeguros, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPaciente, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnClinicas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnEspecialidades, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnMedicos, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
									.addComponent(btnConsultas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnSeguros, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPaciente, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnClinicas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEspecialidades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnMedicos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))
						.addGap(140))
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
						.addGap(18)
						.addComponent(btnConsultas)
						.addGap(18)
						.addComponent(btnCitasMedico)
						.addGap(18)
						.addComponent(btnReportes)
						.addGap(18)
						.addComponent(btnSalir)
						.addContainerGap(23, Short.MAX_VALUE))
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
		btnConsultas.addActionListener(actionListener);
		btnCitasMedico.addActionListener(actionListener);
		btnSalir.addActionListener(actionListener);
		btnReportes.addActionListener(actionListener);
	}
	
	public void salir() {
		this.setVisible(false);
		this.dispose();
	}
}
