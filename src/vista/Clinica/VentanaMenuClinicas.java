package vista.Clinica;
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
import java.awt.event.ActionEvent;

public class VentanaMenuClinicas extends javax.swing.JFrame{
	private JButton btnGClinicas;
	private JButton btnReactivar;
	
	public VentanaMenuClinicas() {
		super();
		getContentPane().setBackground(new Color(64, 224, 208));
		initGUI();
		setSize(329, 268);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		try {
			setTitle("Pantalla Principal");
			JLabel lblInicio_1 = new JLabel("Menu de Clinicas");
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
						.addGap(37)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addGap(26)
						.addComponent(lblInicio_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(21))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblInicio_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(23))
			);
			
			btnGClinicas = new JButton("Gestionar Clinicas");
			btnGClinicas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGClinicas.setBackground(new Color(70, 130, 180));
			
			btnReactivar = new JButton("Reactivar Clinicas");
			btnReactivar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnReactivar.setBackground(new Color(70, 130, 180));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnReactivar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addComponent(btnGClinicas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
						.addGap(24))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(26)
						.addComponent(btnGClinicas, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addGap(29)
						.addComponent(btnReactivar, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addGap(43))
			);
			panel.setLayout(gl_panel);
			getContentPane().setLayout(groupLayout);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void addListener(ActionListener actionListener) {
		btnGClinicas.addActionListener(actionListener);
		btnReactivar.addActionListener(actionListener);
		
	}

}
