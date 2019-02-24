package vista.Medico;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
	private ZoneId zonedId = ZoneId.of( "America/Caracas" );
	private LocalDate today = LocalDate.now( zonedId );
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel lblNombre;
	private JButton btnConsultarPaciente;
	
	public VentanaCitasMedico() throws ParseException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		blanquearCampos();
		dateChooser.setDate(formatter.parse(dtf.format(today)));
		dateChooser_1.setDate(formatter.parse(dtf.format(today)));
		setSize(500,648);
	}

	private void initGUI() {
		try {
			setTitle("Citas Médico");
			JLabel lblCitasMdico = new JLabel("Citas M\u00E9dico");
			lblCitasMdico.setHorizontalAlignment(SwingConstants.CENTER);
			lblCitasMdico.setForeground(Color.BLUE);
			lblCitasMdico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Panel B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista Citas Pacientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			btnRefrescar = new JButton("Vaciar");
			
			btnVolver = new JButton("Volver");
			
			lblNombre = new JLabel("");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setForeground(new Color(0, 100, 0));
			lblNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			
			btnConsultarPaciente = new JButton("Ver Inf. Paciente");
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnRefrescar, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnConsultarPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(155)
						.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(163)
						.addComponent(lblCitasMdico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(170))
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCitasMdico, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
									.addComponent(btnRefrescar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
								.addGap(18))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(18)
								.addComponent(btnConsultarPaciente, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			
			textField_Cedula = new JTextField();
			textField_Cedula.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Cedula.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			
			comboBox_Filtro = new JComboBox();
			comboBox_Filtro.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el Tipo de Citas", "Consultas", "Intervenciones"}));
			
			btnFiltrar = new JButton("Filtrar");
			
			dateChooser = new JDateChooser();
			
			dateChooser_1 = new JDateChooser();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addGap(56)
								.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(comboBox_Filtro, Alignment.LEADING, 0, 239, Short.MAX_VALUE)
									.addComponent(textField_Cedula, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
									.addComponent(btnFiltrar, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(2)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(textField_Cedula))
							.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(comboBox_Filtro))
							.addComponent(btnFiltrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(20))
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
		btnVolver.addActionListener(actionListener);
		btnRefrescar.addActionListener(actionListener);
		btnFiltrar.addActionListener(actionListener);
		btnConsultarPaciente.addActionListener(actionListener);
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
	
	public void blanquearCampos() throws ParseException {
		textField_Cedula.setText(null);
		dateChooser.setDate(formatter.parse(dtf.format(today)));
		dateChooser_1.setDate(formatter.parse(dtf.format(today)));
		comboBox_Filtro.setSelectedIndex(0);
		textField_Cedula.setEditable(true);
	}
	
	public String getTextField_Cedula() {
		return textField_Cedula.getText();
	}
	
	public int getFiltro() {
		return comboBox_Filtro.getSelectedIndex();
	}
	
	public Date getFechaIni() {
		return dateChooser.getDate();
	}
	
	public Date getFechaFin() {
		return dateChooser_1.getDate();
	}
	
	public void bloquearCed() {
		textField_Cedula.setEditable(false);
	}
	
	public void setLabelNombre(String nom) {
		lblNombre.setText(nom);
	}
	
	public JTable getTblCitas() {
		return tblCitas;
	}
}
