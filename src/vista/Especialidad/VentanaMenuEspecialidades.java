//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Especialidad;
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
public class VentanaMenuEspecialidades extends javax.swing.JFrame
{
	private JButton btnGEspecialidades;
	private JButton btnReactivar;
	
	public VentanaMenuEspecialidades() {
		super();
		getContentPane().setBackground(new Color(64, 224, 208));
		initGUI();
		setSize(329, 268);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initGUI() {
		try {
			setTitle("Menu Especialidades");
			JLabel lblEspe = new JLabel("Menu de Especialidades");
			lblEspe.setHorizontalAlignment(SwingConstants.CENTER);
			lblEspe.setForeground(Color.BLUE);
			lblEspe.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 139, 139));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Gestionar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(37)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGap(20)
								.addComponent(lblEspe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblEspe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(23))
			);
			
			btnGEspecialidades = new JButton("Gestionar Especialidades");
			btnGEspecialidades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGEspecialidades.setBackground(new Color(70, 130, 180));
			
			btnReactivar = new JButton("Reactivar Especialidades");
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
							.addComponent(btnGEspecialidades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
						.addGap(24))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(26)
						.addComponent(btnGEspecialidades, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
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
		btnGEspecialidades.addActionListener(actionListener);
		btnReactivar.addActionListener(actionListener);
		
	}

}
