package vista.Medico;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class VentanaCitasMedico extends javax.swing.JFrame{
	private JTable tblCitas;
	private JTextField textField_Cedula;
	private JButton btnRefrescar;
	private JButton btnVolver;
	private JButton btnBuscar;
	private JButton btnFiltrar;
	private JComboBox comboBox_Filtro;
	
	public VentanaCitasMedico() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		blanquearCampos();
		setSize(500,598);
	}

	private void initGUI() {
		try {
			JLabel lblCitasMdico = new JLabel("Citas M\u00E9dico");
			lblCitasMdico.setHorizontalAlignment(SwingConstants.CENTER);
			lblCitasMdico.setForeground(Color.BLUE);
			lblCitasMdico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Panel B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(null);
			
			btnRefrescar = new JButton("Refrescar");
			
			btnVolver = new JButton("Volver");
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(163)
						.addComponent(lblCitasMdico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(170))
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(btnRefrescar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
								.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCitasMdico, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRefrescar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			
			textField_Cedula = new JTextField();
			textField_Cedula.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Cedula.setText("Introduzca c\u00C3\u00A9dula de identidad o nombre");
			textField_Cedula.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			
			comboBox_Filtro = new JComboBox();
			comboBox_Filtro.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el Tipo de Citas", "Consultas", "Intervenciones"}));
			
			btnFiltrar = new JButton("Filtrar");
			
			JDateChooser dateChooser = new JDateChooser();
			
			JDateChooser dateChooser_1 = new JDateChooser();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
								.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(comboBox_Filtro, Alignment.LEADING, 0, 239, Short.MAX_VALUE)
									.addComponent(textField_Cedula, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnFiltrar, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(2)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_Cedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_Filtro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnFiltrar))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(20, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
			);
			
			tblCitas = new JTable();
			scrollPane.setViewportView(tblCitas);
			panel_1.setLayout(gl_panel_1);
			getContentPane().setLayout(groupLayout);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addListener(ActionListener actionListener) {
		btnBuscar.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
		btnRefrescar.addActionListener(actionListener);
		btnFiltrar.addActionListener(actionListener);
	}
	
	public void salir() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void setResultados(AbstractTableModel abstractTableModel) {
		tblCitas.setModel(abstractTableModel);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	private void blanquearCampos() {
		// TODO Auto-generated method stub
		
	}
}
