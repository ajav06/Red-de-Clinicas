package vista.Paciente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import bean.*;
import javax.swing.JTextArea;
import javax.swing.JFrame;


public class VentanaAgregarPaciente extends javax.swing.JFrame{
	private JTextFieldValidator textField_NroHist;
	private JTextFieldValidator textField_NroSeguro;
	private JTextFieldValidator textField_Ced;
	private JTextFieldValidator textField_Nomb;
	private JTextFieldValidator textField_Apelli;
	private JTextArea textArea_AntFam;
	private JTextArea textArea_AntPer;
	private JDateChooser fechaNac;
	private JButton btnCancelar;
	private JButton btnGuardar;
	
	public VentanaAgregarPaciente() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		blanquearCampos();
		setSize(540, 553);
	}
	
	private void initGUI() {
		try {
			getContentPane().setForeground(Color.BLUE);
			setTitle("Registrar Paciente");
			
			JLabel lblRegistrarP = new JLabel("Registrar Paciente");
			lblRegistrarP.setForeground(Color.BLUE);
			lblRegistrarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			lblRegistrarP.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panel_DPer = new JPanel();
			panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNroHist = new JLabel("Nro. Historial :");
			
			textField_NroHist = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroHist.setColumns(10);
			
			JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
			
			textField_NroSeguro = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroSeguro.setColumns(10);
			
			JLabel lblAntecedentesPersonales = new JLabel("Antecedentes Personales: ");
			
			JLabel lblAntecedentesFamiliares = new JLabel("Antecedentes Familiares: ");
			
			JScrollPane scrollPane_1 = new JScrollPane();
			
			JScrollPane scrollPane_2 = new JScrollPane();
			GroupLayout gl_panel_DPer = new GroupLayout(panel_DPer);
			gl_panel_DPer.setHorizontalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
							.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
							.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
						.addGap(35)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(69))
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
							.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_DPer.setVerticalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
						.addGap(18))
			);
			
			textArea_AntFam = new JTextArea();
			scrollPane_2.setViewportView(textArea_AntFam);
			
			textArea_AntPer = new JTextArea();
			scrollPane_1.setViewportView(textArea_AntPer);
			panel_DPer.setLayout(gl_panel_DPer);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setForeground(Color.BLACK);
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnGuardar.setBackground(Color.GREEN);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel label = new JLabel("Nombres :");
			
			JLabel label_1 = new JLabel("Cedula : ");
			
			textField_Ced = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
			textField_Ced.setColumns(10);
			
			textField_Nomb = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Nomb.setColumns(10);
			
			JLabel label_2 = new JLabel("Fecha Nac. :");
			
			JLabel label_3 = new JLabel("Apellidos :");
			
			textField_Apelli = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Apelli.setColumns(10);
			
			fechaNac = new JDateChooser();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addComponent(textField_Nomb, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
						.addGap(44)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(12)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(fechaNac, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
							.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(19)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(textField_Ced)))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(19)
								.addComponent(fechaNac, GroupLayout.PREFERRED_SIZE, 12, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Nomb)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Apelli))
						.addGap(17))
			);
			panel.setLayout(gl_panel);
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(102)
						.addComponent(lblRegistrarP, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addGap(120))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
						.addGap(20))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
						.addGap(20))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(47)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addGap(43)
						.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addGap(36))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(11)
						.addComponent(lblRegistrarP, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addGap(28)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addGap(26)
						.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(1)
								.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
						.addGap(22))
			);
			getContentPane().setLayout(groupLayout);
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public void blanquearCampos() {
		textField_NroHist.setText(null);
		textField_NroSeguro.setText(null);
		textField_Ced.setText(null);
		textField_Nomb.setText(null);
		textField_Apelli.setText(null);
		textArea_AntFam.setText(null);
		textArea_AntPer.setText(null);
		fechaNac.setDate(null);
	}
	
	public void addListener(ActionListener actionListener) {
		btnGuardar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);		
	}
	
	public String getCedula() {
		return textField_Ced.getText();
	}
	
	public String getNombre() {
		return textField_Nomb.getText();
	}
	
	public String  getApellido() {
		return textField_Apelli.getText();
	}
	
	public Date getFechaNac() {
		return fechaNac.getDate();
	}
	
	public int getNroHist() {
		return Integer.parseInt(textField_NroHist.getText());
	}
	
	public int getNroSgro() {
		return Integer.parseInt(textField_NroSeguro.getText());
	}
	
	public String getAntFam() {
		return textArea_AntFam.getText();
	}
	
	public String getAntPer() {
		return textArea_AntPer.getText();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
