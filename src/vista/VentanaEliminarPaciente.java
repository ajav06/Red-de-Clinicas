package vista;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import bean.*;
import javax.swing.JTextArea;

public class VentanaEliminarPaciente extends javax.swing.JFrame{
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private JTextFieldValidator  textField_NroHist;
	private JTextFieldValidator  textField_NroSeguro;
	private JTextFieldValidator  textField_Ced;
	private JTextFieldValidator  textField_Nomb;
	private JTextFieldValidator  textField_Apelli;
	private JTextField textField_FechaN;
	private JTextArea textArea_AntFam;
	private JTextArea textArea_AntPer;
	private JButton btnCancelar;
	private JButton btnAceptar;
			
	public VentanaEliminarPaciente () {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setForeground(Color.BLUE);
			
			JLabel lblEliminarP = new JLabel("Eliminar Paciente");
			lblEliminarP.setForeground(Color.BLUE);
			lblEliminarP.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			lblEliminarP.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panel_DMed = new JPanel();
			panel_DMed.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNroHist = new JLabel("Nro. Historial :");
			
			textField_NroHist = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroHist.setEditable(false);
			textField_NroHist.setColumns(10);
			
			JLabel lblNroSeguro = new JLabel("Nro. Seguro :");
			
			textField_NroSeguro = new JTextFieldValidator(20,JTextFieldValidator.SOLO_NUMEROS);
			textField_NroSeguro.setEditable(false);
			textField_NroSeguro.setColumns(10);
			
			JLabel lblAntecedentesPersonales = new JLabel("Antecedentes Personales: ");
			
			JLabel lblAntecedentesFamiliares = new JLabel("Antecedentes Familiares: ");
			
			JScrollPane scrollPane_1 = new JScrollPane();
			
			JScrollPane scrollPane_2 = new JScrollPane();
			GroupLayout gl_panel_DMed = new GroupLayout(panel_DMed);
			gl_panel_DMed.setHorizontalGroup(
				gl_panel_DMed.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_DMed.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addComponent(lblNroHist, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_NroHist, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
							.addComponent(lblAntecedentesPersonales, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
						.addGap(35)
						.addGroup(gl_panel_DMed.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addComponent(lblAntecedentesFamiliares, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addGap(69))
							.addGroup(gl_panel_DMed.createSequentialGroup()
								.addComponent(lblNroSeguro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(textField_NroSeguro, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
							.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_DMed.setVerticalGroup(
				gl_panel_DMed.createParallelGroup(Alignment.LEADING)
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
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
						.addGap(18))
			);
			
			textArea_AntFam = new JTextArea();
			scrollPane_2.setViewportView(textArea_AntFam);
			
			textArea_AntPer = new JTextArea();
			scrollPane_1.setViewportView(textArea_AntPer);
			panel_DMed.setLayout(gl_panel_DMed);
			
			btnCancelar = new JButton("No");
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setForeground(Color.BLACK);
			
			btnAceptar = new JButton("Si");
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnAceptar.setBackground(Color.GREEN);
			
			JLabel lblseguroQueDesea = new JLabel("\u00BFSeguro que desea Eliminarlo?");
			lblseguroQueDesea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			
			JPanel panel_DPer = new JPanel();
			panel_DPer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNomb = new JLabel("Nombres :");
			
			JLabel lblCed = new JLabel("Cedula : ");
			
			textField_Ced = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
			textField_Ced.setEditable(false);
			textField_Ced.setColumns(10);
			
			textField_Nomb = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Nomb.setEditable(false);
			textField_Nomb.setColumns(10);
			
			JLabel lblFechaN = new JLabel("Fecha Nac. :");
			
			JLabel lblApelli = new JLabel("Apellidos :");
			
			textField_Apelli = new JTextFieldValidator(50,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_Apelli.setEditable(false);
			textField_Apelli.setColumns(10);
			
			textField_FechaN = new JTextField();
			textField_FechaN.setEditable(false);
			textField_FechaN.setColumns(10);
			GroupLayout gl_panel_DPer = new GroupLayout(panel_DPer);
			gl_panel_DPer.setHorizontalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGap(0, 448, Short.MAX_VALUE)
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
							.addComponent(textField_Apelli, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_DPer.setVerticalGroup(
				gl_panel_DPer.createParallelGroup(Alignment.LEADING)
					.addGap(0, 103, Short.MAX_VALUE)
					.addGroup(gl_panel_DPer.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_panel_DPer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(6)
								.addComponent(lblFechaN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_FechaN, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addGroup(gl_panel_DPer.createSequentialGroup()
								.addGap(6)
								.addComponent(lblCed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_Ced))
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
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
								.addGap(22))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(panel_DMed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(15)
										.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
										.addGap(43)
										.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
										.addGap(21))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(83)
										.addComponent(lblEliminarP, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
										.addGap(92))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(124)
										.addComponent(lblseguroQueDesea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(125)))
								.addGap(26))))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblEliminarP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(28)
						.addComponent(panel_DPer, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addGap(26)
						.addComponent(panel_DMed, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(lblseguroQueDesea, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
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
		textField_FechaN.setText("");
		textArea_AntFam.setText("");
		textArea_AntPer.setText("");
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
		textField_FechaN.setText(formatter.format(fecha));		
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
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
