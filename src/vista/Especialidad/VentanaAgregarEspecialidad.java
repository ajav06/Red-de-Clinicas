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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VentanaAgregarEspecialidad extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Cod;
	private JTextField textField_Nom;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JTextArea textArea_Des;
	
	
	
	
	
	public VentanaAgregarEspecialidad() {
		super();
		initGUI();
		blanquearCampos();
		
		
	}
	
	
	
	
	private void initGUI() {
				try {
					setTitle("Registrar Especialidad");
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 540, 533);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					
					JLabel lblResgistrarEspecialidad = new JLabel("Resgistrar Especialidad");
					lblResgistrarEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
					lblResgistrarEspecialidad.setForeground(Color.BLUE);
					lblResgistrarEspecialidad.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
					
					JPanel panel = new JPanel();
					panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Especialidad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					
					btnIncluir = new JButton("Incluir");
					
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					
					btnVolver = new JButton("Volver");
					btnVolver.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					GroupLayout gl_contentPane = new GroupLayout(contentPane);
					gl_contentPane.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(109)
										.addComponent(lblResgistrarEspecialidad))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(38)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(btnModificar)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
											.addComponent(panel, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(39, Short.MAX_VALUE))
					);
					gl_contentPane.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblResgistrarEspecialidad)
								.addGap(26)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
					);
					
					JLabel lblCodigo = new JLabel("Codigo:");
					
					textField_Cod = new JTextField();
					textField_Cod.setColumns(10);
					
					JLabel lblNombre = new JLabel("Nombre:");
					
					textField_Nom = new JTextField();
					textField_Nom.setColumns(10);
					
					JLabel lblDescripcion = new JLabel("Descripcion:");
					
					JScrollPane scrollPane = new JScrollPane();
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(14)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCodigo)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_Nom, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_Cod, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
								.addContainerGap())
					);
					gl_panel.setVerticalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(25)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblCodigo)
									.addComponent(textField_Cod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNombre)
									.addComponent(textField_Nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(39)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDescripcion)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
								.addContainerGap())
					);
					
					textArea_Des = new JTextArea();
					textArea_Des.setText((String) null);
					scrollPane.setViewportView(textArea_Des);
					panel.setLayout(gl_panel);
					contentPane.setLayout(gl_contentPane);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
	public void setCodigo(String cod) {
		
		this.textField_Cod.setText(cod);
		
	}
	
	public String getCodigo() {
		
		return textField_Cod.getText();
		
	}
	
	public void setNombre(String nom) {
		
		this.textField_Nom.setText(nom);
		
	}
	
			
	public String getNombre() {
		
		return textField_Nom.getText();
	}
	
	
	public void setDescripcion(String des) {
		
		this.textArea_Des.setText(des);
	}
	
	public String getDescripcion() {
	
	return textArea_Des.getText();
		}

 public void blanquearCampos() {

	 textField_Cod.setText(null);
	 textField_Nom.setText(null);
	 
 }
 public void addListener(ActionListener actionListener) {
	 
	 btnModificar.addActionListener(actionListener);
	 btnIncluir.addActionListener(actionListener);
	 btnEliminar.addActionListener(actionListener);
	 btnVolver.addActionListener(actionListener);
	
 }
 
 public void llenarCampos(String cod,String nom,String des) {
		textField_Cod.setText(cod);
		textField_Nom.setText(nom);
		textArea_Des.setText(des);	
		
		}
	
	
 public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	
	
	public void interfazRegistro() {
		textField_Cod.setEnabled(false);
		btnEliminar.setEnabled(false);;
		btnModificar.setEnabled(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
	}
	
	public void interfazModificar() {
		btnIncluir.setEnabled(false);
		btnIncluir.setVisible(false);
		textField_Cod.setEditable(false);
		btnEliminar.setEnabled(false);
		btnEliminar.setVisible(false);
	}
	
	public void interfazEliminar() {
		btnIncluir.setEnabled(false);
		btnModificar.setEnabled(false);
		btnModificar.setVisible(false);
		btnIncluir.setVisible(false);
		textField_Cod.setEditable(false);
	}
	
	
	
	
	
	
	
	public boolean chequearLlenos() { //Chequea y verifica que todos los campos estén actualmente llenos.
		return (textField_Cod.getText().equals("") ||
				textField_Nom.getText().equals("") || 
				textArea_Des.getText().equals("") );
	}
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.           MAIN GENERATED BY THE JFRAME
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarEspecialidad frame = new VentanaAgregarEspecialidad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 */
	
	
	
	
	
	
	
	
	
	
	

