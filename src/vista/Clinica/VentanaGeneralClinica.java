//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Clinica;
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

public class VentanaGeneralClinica  extends javax.swing.JFrame  {
	private JTable tblClinicas;
	private JButton btnActivar;
	private JButton btnCancelar;

			/**
	 * Create the application.
	 */
	public VentanaGeneralClinica(){
		super();
	//	setTitle("Listado de Clínicas");
		initialize();
	setSize(540,507);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JLabel lblListaClinicas = new JLabel("Lista de Clinicas");
		lblListaClinicas.setForeground(Color.BLUE);
		lblListaClinicas.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblListaClinicas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblClinicas = new JTable();
		tblClinicas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo","Nombre", "Estado", "Direccion", "Telefono", "Correo"
			}
		));
		scrollPane.setViewportView(tblClinicas);
		
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
							.addComponent(lblListaClinicas))
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
					.addComponent(lblListaClinicas)
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
			tblClinicas.setModel(abstractTableModel);
		}
		
		public JTable getTblClinicas() {
			return tblClinicas;
		}

		public void addListener(ActionListener actionListener)
		{
			btnActivar.addActionListener(actionListener);
			btnCancelar.addActionListener(actionListener);
							
		}
	
		public JTable getTblClinica() {
			return tblClinicas;
		}

		public void salir() {
			this.setVisible(false);
			this.dispose();
		}
		
		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(this, mensaje);
		}

}
