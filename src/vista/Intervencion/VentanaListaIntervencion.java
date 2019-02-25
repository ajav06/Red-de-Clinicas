//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Intervencion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaListaIntervencion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Ced;
	private JTable tableIntervencion;
	private JButton btnSalir;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnIncluir;
	private JButton btnCargar;

	
	
	
	
	
public VentanaListaIntervencion() {
	super();
	initGUI();
	blanquearCampos();
		}
	
	
	
	
	private void initGUI() {
				try {
					setTitle("Lista Intervencion");
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setBounds(100, 100, 540, 533);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblListaIntervencion = new JLabel("Lista intervencion");
					lblListaIntervencion.setForeground(Color.BLUE);
					lblListaIntervencion.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
					lblListaIntervencion.setBounds(166, 11, 217, 30);
					contentPane.add(lblListaIntervencion);
					
				    btnCargar = new JButton("Refrescar");
					btnCargar.setIcon(new ImageIcon(VentanaListaIntervencion.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
					btnCargar.setBounds(448, 126, 30, 25);
					contentPane.add(btnCargar);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(42, 157, 436, 290);
					contentPane.add(scrollPane);
					
					tableIntervencion = new JTable();
							
								
									
					
					scrollPane.setColumnHeaderView(tableIntervencion);
					
					JPanel panel = new JPanel();
					panel.setBorder(new LineBorder(new Color(0, 0, 0)));
					panel.setBounds(42, 47, 436, 76);
					contentPane.add(panel);
					
				 btnIncluir = new JButton("Incluir");
					
					JLabel lblCedula = new JLabel("Cedula:");
					
					textField_Ced = new JTextField();
					textField_Ced.setText((String) null);
					textField_Ced.setColumns(10);
					
					btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					
					btnActualizar = new JButton("Actualizar");
					btnActualizar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					btnActualizar.setBackground(Color.GREEN);
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addGap(19)
								.addComponent(lblCedula)
								.addGap(18)
								.addComponent(textField_Ced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnIncluir, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnActualizar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
								.addGap(18))
					);
					gl_panel.setVerticalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_Ced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCedula)
									.addComponent(btnBuscar)
									.addComponent(btnActualizar))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnIncluir)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					panel.setLayout(gl_panel);
					
					btnSalir = new JButton("Salir");
					btnSalir.setBounds(401, 453, 77, 41);
					contentPane.add(btnSalir);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	public void addListener(ActionListener actionListener) {
		 btnIncluir.addActionListener(actionListener);
		 btnActualizar.addActionListener(actionListener);
		 btnSalir.addActionListener(actionListener);
		 btnBuscar.addActionListener(actionListener);	
		 
	     btnCargar.addActionListener(actionListener);
	}
	
	
public void setResultados(AbstractTableModel abstractTableModel) {
		
		tableIntervencion.setModel(abstractTableModel);
		
	}

	public JTable gettableIntervencion() {
		
		return tableIntervencion;
	}
	
	public String getcedula() {
		
		return textField_Ced.getText();
		
	}
	
	public void setcedula(String ced) {
		
		this.textField_Ced.setText(ced);
		
		
	}
	
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	
	
	 public void blanquearCampos() {

		 textField_Ced.setText(null);
				 
	 }
	 public void salir() {
			setVisible(false);
			dispose();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//fin lista	
	
}
