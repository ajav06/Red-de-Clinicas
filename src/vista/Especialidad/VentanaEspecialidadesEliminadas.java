package vista.Especialidad;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
public class VentanaEspecialidadesEliminadas extends javax.swing.JFrame  
{
	private JTable tblEspecialidades;
	private JButton btnActivar;
	private JButton btnCancelar;

			/**
	 * Create the application.
	 */
	public VentanaEspecialidadesEliminadas(){
		super();
	//	setTitle("Listado de Clínicas");
		initialize();
	setSize(540,507);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JLabel lblListaEspecialidades = new JLabel("Lista Especialidades");
		lblListaEspecialidades.setForeground(Color.BLUE);
		lblListaEspecialidades.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblListaEspecialidades.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblEspecialidades = new JTable();
		tblEspecialidades.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion"
			}
		));
		scrollPane.setViewportView(tblEspecialidades);
		
		btnActivar = new JButton("Activar");
		btnActivar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnActivar.setBackground(Color.GREEN);
		btnActivar.setForeground(Color.BLACK);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(lblListaEspecialidades))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(btnActivar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(118)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblListaEspecialidades)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActivar)
						.addComponent(btnCancelar))
					.addGap(102))
		);
			getContentPane().setLayout(groupLayout);
		}
		
		
		public void setResultados(AbstractTableModel abstractTableModel) {
			tblEspecialidades.setModel(abstractTableModel);
		}

		public void addListener(ActionListener actionListener)
		{
			btnActivar.addActionListener(actionListener);
			btnCancelar.addActionListener(actionListener);
							
		}
	
		public JTable getTblEspecialidades() {
			return tblEspecialidades;
		}

		public void salir() {
			this.setVisible(false);
			this.dispose();
		}
		
		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(this, mensaje);
		}

}
