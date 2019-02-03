package vista.Especialidad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaListaEspecialidad extends JFrame {

	private JPanel contentPane;
	private JTextField textField_codigonombre;
	private JTable tableEspecialidad;
	private JButton btnModificar;
	private JButton btnSalir;
	private JButton btnBuscar;
	
	
	

public VentanaListaEspecialidad() {
	
	super();
	initGUI();
	blanquearCampos();
	}
	private void initGUI() {
		
				try {setTitle("Lista Especialidad");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 540, 533);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				
				JLabel lblListadoEspecialidad = new JLabel("Lista Especialidad");
				lblListadoEspecialidad.setForeground(Color.BLUE);
				lblListadoEspecialidad.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
				
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Buscar Especialidad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				JScrollPane scrollPane = new JScrollPane();
				
				 btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(38, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(145, Short.MAX_VALUE)
							.addComponent(lblListadoEspecialidad)
							.addGap(123))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblListadoEspecialidad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
				);
				
				tableEspecialidad = new JTable();
				tableEspecialidad.setFillsViewportHeight(true);
				tableEspecialidad.setRowSelectionAllowed(false);
				tableEspecialidad.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Codigo", "Nombre", "Descripcion"
					}
				));
				
				
				
				
				
				
				
				scrollPane.setViewportView(tableEspecialidad);
				
				textField_codigonombre = new JTextField();
				textField_codigonombre.setColumns(10);
				
				btnBuscar = new JButton("Buscar");
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(textField_codigonombre, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnBuscar)
							.addContainerGap(65, Short.MAX_VALUE))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_codigonombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
							.addContainerGap(36, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
				contentPane.setLayout(gl_contentPane);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
	
	
	
	public void addListener(ActionListener actionListener) {
		 btnModificar.addActionListener(actionListener);
		 btnSalir.addActionListener(actionListener);
		 btnBuscar.addActionListener(actionListener);		
			
	}
	
	public void setResultados(AbstractTableModel abstractTableModel) {
		
		tableEspecialidad.setModel(abstractTableModel);
		
	}

	public JTable gettableEspecialidad() {
		
		return tableEspecialidad;
	}
	
	public String getcodigonombre() {
		
		return textField_codigonombre.getText();
		
	}
	
	public void setcodigonombre(String codigonombre) {
		
		this.textField_codigonombre.setText(codigonombre);
		
		
	}
	
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	
	
	 public void blanquearCampos() {

		 textField_codigonombre.setText(null);
				 
	 }
	 public void salir() {
			setVisible(false);
			dispose();
		}
	
	
	
	
	
	
	//fin listaespecialidad
	
}
