package vista;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import bean.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class VentanaActualizarPaciente extends javax.swing.JFrame{
	private JTextFieldValidator textField_NroHist;
	private JTextFieldValidator textField_NroSeguro;
	private JTextFieldValidator textField_Ced;
	private JTextFieldValidator textField_Nomb;
	private JTextFieldValidator textField_Apelli;
	private JTextArea textArea_AntFam;
	private JTextArea textArea_AntPer;
	private JDateChooser fechaNac;
	private JButton btnCancelar;
	private JButton btnAceptar;
	
	public VentanaActualizarPaciente() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setForeground(Color.BLUE);
			
			JPanel panel_DMed = new JPanel();
			panel_DMed.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNroHist = new JLabel("Nro. Historial :");
			
			textField_NroHist = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroHist.setEditable(false);
			textField_NroHist.setColumns(10);
			
			JLabel lblAntecedentesPersonales = new JLabel("Antecedentes Personales: ");
			
			JScrollPane scrollPane = new JScrollPane();
			
			JLabel lblAntecedentesFamiliares = new JLabel("Antecedentes Familiares: ");
			
			JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
			
			textField_NroSeguro = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroSeguro.setColumns(10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			GroupLayout gl_panel_DMed = new GroupLayout(panel_DMed);
			gl_panel_DMed.setHorizontalGroup(
				gl_panel_DMed.createParallelGroup(Alignment.LEADING)
					.addGap(0, 444, Short.MAX_VALUE)
					.addGroup(gl_panel_DMed.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
							.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
						.addGap(35)
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addGap(69))
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
							.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_DMed.setVerticalGroup(
				gl_panel_DMed.createParallelGroup(Alignment.LEADING)
					.addGap(0, 237, Short.MAX_VALUE)
					.addGroup(gl_panel_DMed.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
						.addGap(18))
			);
			
			textArea_AntFam = new JTextArea();
			scrollPane_1.setViewportView(textArea_AntFam);
			
			textArea_AntPer = new JTextArea();
			scrollPane.setViewportView(textArea_AntPer);
			panel_DMed.setLayout(gl_panel_DMed);
			
			JPanel panel_DPer = new JPanel();
			panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNomb = new JLabel("Nombres :");
			
			JLabel lblCed = new JLabel("Cedula : ");
			
			textField_Ced = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
			textField_Ced.setEditable(false);
			textField_Ced.setColumns(10);
			
			textField_Nomb = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Nomb.setColumns(10);
			
			JLabel lblFechaN = new JLabel("Fecha Nac. :");
			
			JLabel lblApelli = new JLabel("Apellidos :");
			
			textField_Apelli = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Apelli.setColumns(10);
			
			fechaNac = new JDateChooser();
			GroupLayout gl_panel_DPer = new GroupLayout(panel_DPer);
			gl_panel_DPer.setHorizontalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNomb, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(6)
								.addComponent(lblCed, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
						.addGap(18)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addComponent(textField_Ced, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addComponent(textField_Nomb, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
						.addGap(44)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblFechaN, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(12)
								.addComponent(lblApelli, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
						.addGap(18)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addComponent(fechaNac, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_DPer.setVerticalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(19)
								.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_DPer.createSequentialGroup()
										.addGap(6)
										.addComponent(lblFechaN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel_DPer.createSequentialGroup()
										.addGap(6)
										.addComponent(lblCed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(textField_Ced)))
							.addGroup(Alignment.TRAILING, gl_panel_DPer.createSequentialGroup()
								.addGap(19)
								.addComponent(fechaNac, GroupLayout.PREFERRED_SIZE, 12, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(6)
								.addComponent(lblNomb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Nomb)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(6)
								.addComponent(lblApelli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Apelli))
						.addGap(17))
			);
			panel_DPer.setLayout(gl_panel_DPer);
			
			btnCancelar = new JButton("No");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCancelar.setForeground(Color.BLACK);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnCancelar.setBackground(Color.RED);
			
			btnAceptar = new JButton("Si");
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnAceptar.setBackground(Color.GREEN);
			
			JLabel lblActualizarP = new JLabel("Actualizar Paciente");
			lblActualizarP.setHorizontalAlignment(SwingConstants.CENTER);
			lblActualizarP.setForeground(Color.BLUE);
			lblActualizarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			
			JLabel lblseguroQueDesea = new JLabel("\u00BFSeguro que desea Actualizar?");
			lblseguroQueDesea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(83)
								.addComponent(lblActualizarP, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
								.addGap(92))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
								.addGap(2))
							.addComponent(panel_DMed, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(124)
								.addComponent(lblseguroQueDesea, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addGap(125))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(15)
								.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addGap(43)
								.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addGap(21)))
						.addGap(23))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblActualizarP, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addGap(26)
						.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addGap(28)
						.addComponent(panel_DMed, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(lblseguroQueDesea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGap(34))
			);
			getContentPane().setLayout(groupLayout);
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public void blanquearCampos() {
		textField_NroHist.setText("");
		textField_NroSeguro.setText("");
		textField_Ced.setText("");
		textField_Nomb.setText("");
		textField_Apelli.setText("");
		textArea_AntFam.setText("");
		textArea_AntPer.setText("");
		fechaNac.setDate(null);
	}
	
	public void addListener(ActionListener actionListener) {
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);		
	}
	
	public void setCedula(String ced) {
		textField_Ced.setText(ced);
	}
	
	public void setNombre(String nom) {
		textField_Nomb.setText(nom);
	}
	
	public void setApellido(String apell) {
		textField_Apelli.setText(apell);
	}
	
	public void setFechaNac(Date fecha){
		fechaNac.setDate(fecha);	
	}
	
	public void setNroHist(int nroHist) {
		textField_NroHist.setText(Integer.toString(nroHist));
	}
	
	public void setNroSgro(int nroSgro) {
		textField_NroSeguro.setText(Integer.toString(nroSgro));
	}
	
	public void setAntFam(String anteFam) {
		textArea_AntFam.setText(anteFam);
	}
	
	public void setAntPer(String antePer) {
		textArea_AntPer.setText(antePer);
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
