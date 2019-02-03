package vista.Historial;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import bean.JTextFieldValidator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaHistorial extends javax.swing.JFrame{
	private JTextFieldValidator textField_Peso;
	private JTextFieldValidator textField_Numero;
	private JTextFieldValidator textField_Cedula;
	private JTextFieldValidator textField_Altura;
	private JTextFieldValidator textField_OtroFis;
	private JComboBox comboBox_Sexo;
	private JComboBox comboBox_Tabaco;
	private JComboBox comboBox_Alcohol;
	private JComboBox comboBox_Drogas;
	private JComboBox comboBox_Infuciones;
	private JComboBox comboBox_Sexualidad;
	private JComboBox comboBox_Diuresis;
	private JComboBox comboBox_Catarsis;
	private JComboBox comboBox_Alimentacion;
	private JComboBox comboBox_Suenno;
	private JTextArea textArea_AntFami;
	private JTextArea textArea_AnteEnfAct;
	private JTextArea textArea_EnfAct;
	private JTextArea textArea_Neurologicos;
	private JTextArea textArea_Neofrourologicos;
	private JTextArea textArea_Gastrointestinales;
	private JTextArea textArea_Respiratorias;
	private JTextArea textArea_Cardiacas;
	private JTextArea textArea_Hematologicos;
	private JTextArea textArea_Ginecologicos;
	private JTextArea textArea_Infectologicos;
	private JTextArea textArea_Endocrinologicos;
	private JTextArea textArea_Quirurgicos;
	private JTextArea textArea_Traumatologicos;
	private JTextArea textArea_Alergicos;
	private JTextArea textArea_Epidemiologicos;
	private JTextArea textArea_OtrosEnf;
	private JTextArea textArea_EnfInf;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnVolver;
	
	public VentanaHistorial() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		blanquearCampos();
		setSize(933, 698);
	}
	
	public void initGUI() {
		try {
			setTitle("Historial Medico");
			
			JLabel lblHistorialMedico = new JLabel("Historial \rMedico \ndel Paciente");
			lblHistorialMedico.setHorizontalAlignment(SwingConstants.CENTER);
			lblHistorialMedico.setForeground(Color.BLUE);
			lblHistorialMedico.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblNumero = new JLabel("Nro Historial : ");
			lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblCedula = new JLabel("Cedula :");
			lblCedula.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblPeso = new JLabel("Peso :");
			
			textField_Peso = new JTextFieldValidator(5,JTextFieldValidator.SOLO_NUMEROS);
			textField_Peso.setColumns(10);
			
			textField_Numero = new JTextFieldValidator(6,JTextFieldValidator.SOLO_NUMEROS);
			textField_Numero.setToolTipText("");
			textField_Numero.setColumns(10);
			
			textField_Cedula = new JTextFieldValidator(8,JTextFieldValidator.SOLO_NUMEROS);
			textField_Cedula.setColumns(10);
			
			JLabel lblAltura = new JLabel("Altura :");
			
			textField_Altura = new JTextFieldValidator(5,JTextFieldValidator.SOLO_NUMEROS);
			textField_Altura.setColumns(10);
			
			JLabel lblSexo = new JLabel("Sexo :");
			
			comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setModel(new DefaultComboBoxModel(new String[] {"Femenico", "Masculino", "Otro"}));
			comboBox_Sexo.setMaximumRowCount(3);
			comboBox_Sexo.setToolTipText("");
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNumero, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(19)
								.addComponent(lblCedula, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(textField_Numero, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addComponent(textField_Cedula, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
						.addGap(14)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblPeso, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField_Peso, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
								.addGap(10)
								.addComponent(lblAltura, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(comboBox_Sexo, 0, 88, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField_Altura, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_Numero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox_Sexo)))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(textField_Altura, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblAltura, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblPeso, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(textField_Peso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblCedula, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(textField_Cedula, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(14))
			);
			panel.setLayout(gl_panel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Medicos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setViewportBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Antecedentes Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			btnIncluir = new JButton("Incluir");
			
			btnModificar = new JButton("Modificar");
			
			btnVolver = new JButton("Volver");
			
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(33)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addGap(218)))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(355)
										.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(225)
								.addComponent(lblHistorialMedico, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
								.addGap(220)))
						.addGap(33))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblHistorialMedico, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addGap(24)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
							.addComponent(scrollPane_3, 0, 0, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnIncluir, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
						.addGap(18))
			);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(null);
			scrollPane_3.setViewportView(panel_2);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Habitos Toxicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			JLabel label = new JLabel("Alcohol :");
			
			JLabel label_1 = new JLabel("Tabaco :");
			
			comboBox_Tabaco = new JComboBox();
			comboBox_Tabaco.setModel(new DefaultComboBoxModel(new String[] {"Si", "No", "Nunca", "Ocasionalmente"}));
			comboBox_Tabaco.setMaximumRowCount(4);
			
			comboBox_Alcohol = new JComboBox();
			comboBox_Alcohol.setModel(new DefaultComboBoxModel(new String[] {"Si", "No", "Nunca", "Ocasionalmente"}));
			comboBox_Alcohol.setMaximumRowCount(4);
			
			JLabel label_2 = new JLabel("Infuciones :");
			
			JLabel label_3 = new JLabel("Dogras :");
			
			comboBox_Drogas = new JComboBox();
			comboBox_Drogas.setModel(new DefaultComboBoxModel(new String[] {"Si", "No", "Nunca", "Ocasionalmente"}));
			comboBox_Drogas.setMaximumRowCount(4);
			
			comboBox_Infuciones = new JComboBox();
			comboBox_Infuciones.setModel(new DefaultComboBoxModel(new String[] {"Si", "No", "Nunca", "Ocasionalmente"}));
			comboBox_Infuciones.setMaximumRowCount(4);
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(3))
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(comboBox_Tabaco, 0, 86, Short.MAX_VALUE)
								.addGap(19))
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(comboBox_Alcohol, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGap(17)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
							.addComponent(comboBox_Infuciones, 0, 85, Short.MAX_VALUE)
							.addComponent(comboBox_Drogas, 0, 85, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGap(6)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(comboBox_Drogas)
							.addComponent(comboBox_Alcohol)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGap(6)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(18)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGap(3)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(3))
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_Infuciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_Tabaco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(10))
			);
			panel_3.setLayout(gl_panel_3);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Habitos Fisiologicos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblAlimentacion = new JLabel("Alimentacion :");
			lblAlimentacion.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Alimentacion = new JComboBox();
			comboBox_Alimentacion.setModel(new DefaultComboBoxModel(new String[] {"Buena", "Mala", "Regular"}));
			comboBox_Alimentacion.setMaximumRowCount(4);
			
			JLabel lblDiuresis = new JLabel("Diuresis :");
			lblDiuresis.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Diuresis = new JComboBox();
			comboBox_Diuresis.setModel(new DefaultComboBoxModel(new String[] {"Clara", "Normal", "Osura", "Muy Oscura"}));
			comboBox_Diuresis.setMaximumRowCount(4);
			
			JLabel lblSexualidad = new JLabel("Sexualidad :");
			lblSexualidad.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Sexualidad = new JComboBox();
			comboBox_Sexualidad.setModel(new DefaultComboBoxModel(new String[] {"Alta", "Modera", "Baja"}));
			comboBox_Sexualidad.setMaximumRowCount(4);
			
			JLabel lblCatarsis = new JLabel("Catarsis :");
			lblCatarsis.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Catarsis = new JComboBox();
			comboBox_Catarsis.setModel(new DefaultComboBoxModel(new String[] {"Buena", "Normal", "Mala"}));
			comboBox_Catarsis.setMaximumRowCount(4);
			
			JLabel label_4 = new JLabel("Otros :");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			
			textField_OtroFis = new JTextFieldValidator(200,JTextFieldValidator.LETRAS_Y_ESPACIOS);
			textField_OtroFis.setColumns(10);
			
			JLabel label_5 = new JLabel("Sue\u00F1o :");
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			
			comboBox_Suenno = new JComboBox();
			comboBox_Suenno.setModel(new DefaultComboBoxModel(new String[] {"Alto", "Normal", "Poco"}));
			comboBox_Suenno.setMaximumRowCount(4);
			GroupLayout gl_panel_4 = new GroupLayout(panel_4);
			gl_panel_4.setHorizontalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_4.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblAlimentacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(11)
								.addComponent(comboBox_Alimentacion, 0, 84, Short.MAX_VALUE)
								.addGap(24)
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_4.createSequentialGroup()
										.addComponent(lblDiuresis, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(6))
									.addComponent(lblCatarsis, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
								.addGap(12)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
									.addComponent(comboBox_Catarsis, 0, 83, Short.MAX_VALUE)
									.addComponent(comboBox_Diuresis, 0, 83, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_4.createSequentialGroup()
										.addGap(22)
										.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addGap(3))
									.addGroup(gl_panel_4.createSequentialGroup()
										.addGap(3)
										.addComponent(lblSexualidad, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField_OtroFis, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
									.addGroup(gl_panel_4.createSequentialGroup()
										.addComponent(comboBox_Sexualidad, 0, 86, Short.MAX_VALUE)
										.addGap(2)))
								.addGap(18))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(comboBox_Suenno, 0, 86, Short.MAX_VALUE)
								.addGap(20))))
			);
			gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_4.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_OtroFis, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox_Alimentacion)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(3)
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
							.addComponent(lblAlimentacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(12)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSexualidad, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(3)
								.addComponent(comboBox_Sexualidad))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(3)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblDiuresis, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
									.addComponent(comboBox_Diuresis))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_Suenno)
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(comboBox_Catarsis)
							.addComponent(lblCatarsis, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(11))
			);
			panel_4.setLayout(gl_panel_4);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enfermedades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(4))
			);
			
			JLabel lblCardiacas = new JLabel("Cardiacas :");
			lblCardiacas.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblRespiratorias = new JLabel("Respiratorias : ");
			lblRespiratorias.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel label_6 = new JLabel("Gastrointestinales :");
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_4 = new JScrollPane();
			
			JScrollPane scrollPane_5 = new JScrollPane();
			
			JScrollPane scrollPane_6 = new JScrollPane();
			
			JLabel lblNeofro = new JLabel("Neofrourologicos :");
			lblNeofro.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_7 = new JScrollPane();
			
			JLabel lblNeurologicos = new JLabel("Neurologicos :");
			lblNeurologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_8 = new JScrollPane();
			
			JLabel lblHematologicos = new JLabel("Hematologicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_9 = new JScrollPane();
			
			JLabel lblGinecologicos = new JLabel("Ginecologicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_10 = new JScrollPane();
			
			JLabel lblInfectologicos = new JLabel("Infectologicos  :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_11 = new JScrollPane();
			
			JLabel lblEndocrinologicos = new JLabel("Endocrinologicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_12 = new JScrollPane();
			
			JLabel lblQuirurgicos = new JLabel("Quirurgicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_13 = new JScrollPane();
			
			JLabel lblTraumatologicos = new JLabel("Traumatologicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_14 = new JScrollPane();
			
			JLabel lblAlergicos = new JLabel("Alergicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_15 = new JScrollPane();
			
			JLabel lblEpidemiologicos = new JLabel("Epidemiologicos :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_16 = new JScrollPane();
			
			JLabel lblOtrosEnf = new JLabel("Otros :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_17 = new JScrollPane();
			
			JLabel lblEnfInfancia = new JLabel("En la Infancia :");
			lblHematologicos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JScrollPane scrollPane_18 = new JScrollPane();
			
			GroupLayout gl_panel_5 = new GroupLayout(panel_5);
			gl_panel_5.setHorizontalGroup(
				gl_panel_5.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_5.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
							.addComponent(lblCardiacas)
							.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblRespiratorias)
							.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblNeofro, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblNeurologicos)
							.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblHematologicos)
							.addComponent(scrollPane_9, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblGinecologicos)
							.addComponent(scrollPane_10, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblInfectologicos)
							.addComponent(scrollPane_11, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblEndocrinologicos)
							.addComponent(scrollPane_12, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblQuirurgicos)
							.addComponent(scrollPane_13, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblTraumatologicos)
							.addComponent(scrollPane_14, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblAlergicos)
							.addComponent(scrollPane_15, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblEpidemiologicos)
							.addComponent(scrollPane_16, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblEnfInfancia)
							.addComponent(scrollPane_18, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
							.addComponent(lblOtrosEnf)
							.addComponent(scrollPane_17, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_5.setVerticalGroup(
				gl_panel_5.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_5.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCardiacas)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblRespiratorias)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(label_6)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNeofro)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNeurologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblHematologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_9, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblGinecologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_10, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblInfectologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_11, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblEndocrinologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_12, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblQuirurgicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_13, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblTraumatologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_14, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblAlergicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_15, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblEpidemiologicos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_16, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblEnfInfancia)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_18, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblOtrosEnf)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_17, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			
			textArea_Neurologicos = new JTextArea();
			scrollPane_8.setViewportView(textArea_Neurologicos);
			
			textArea_Neofrourologicos = new JTextArea();
			scrollPane_7.setViewportView(textArea_Neofrourologicos);
			
			textArea_Gastrointestinales = new JTextArea();
			scrollPane_6.setViewportView(textArea_Gastrointestinales);
			
			textArea_Respiratorias = new JTextArea();
			scrollPane_5.setViewportView(textArea_Respiratorias);
			
			textArea_Cardiacas = new JTextArea();
			scrollPane_4.setViewportView(textArea_Cardiacas);
			
			textArea_Hematologicos = new JTextArea();
			scrollPane_9.setViewportView(textArea_Hematologicos);
			
			textArea_Ginecologicos = new JTextArea();
			scrollPane_10.setViewportView(textArea_Ginecologicos);
			
			textArea_Infectologicos = new JTextArea();
			scrollPane_11.setViewportView(textArea_Infectologicos);
			
			textArea_Endocrinologicos = new JTextArea();
			scrollPane_12.setViewportView(textArea_Endocrinologicos);
			
			textArea_Quirurgicos = new JTextArea();
			scrollPane_13.setViewportView(textArea_Quirurgicos);
			
			textArea_Traumatologicos = new JTextArea();
			scrollPane_14.setViewportView(textArea_Traumatologicos);
			
			textArea_Alergicos = new JTextArea();
			scrollPane_15.setViewportView(textArea_Alergicos);
			
			textArea_Epidemiologicos = new JTextArea();
			scrollPane_16.setViewportView(textArea_Epidemiologicos);
			
			textArea_EnfInf = new JTextArea();
			scrollPane_18.setViewportView(textArea_EnfInf);
			
			textArea_OtrosEnf = new JTextArea();
			scrollPane_17.setViewportView(textArea_OtrosEnf);
			
			panel_5.setLayout(gl_panel_5);
			panel_2.setLayout(gl_panel_2);
			
			JLabel lblEnfermedad = new JLabel("Enfermedad Actual :");
			
			JScrollPane scrollPane = new JScrollPane();
			
			JLabel lblAntEnfAct = new JLabel("Ancedentes de la Enfermedad : ");
			
			JScrollPane scrollPane_1 = new JScrollPane();
			
			JLabel lblAntFami = new JLabel("Antecedentes Familiares :");
			
			JScrollPane scrollPane_2 = new JScrollPane();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblEnfermedad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(246))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblAntEnfAct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(190))
							.addComponent(lblAntFami))
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblEnfermedad, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(lblAntEnfAct)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblAntFami)
						.addGap(8)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
						.addContainerGap())
			);
			
			textArea_AntFami = new JTextArea();
			scrollPane_2.setViewportView(textArea_AntFami);
			
			textArea_AnteEnfAct = new JTextArea();
			scrollPane_1.setViewportView(textArea_AnteEnfAct);
			
			textArea_EnfAct = new JTextArea();
			scrollPane.setViewportView(textArea_EnfAct);
			panel_1.setLayout(gl_panel_1);
			getContentPane().setLayout(groupLayout);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void blanquearCampos() {
		this.textField_Peso.setText(null);
		this.textField_Numero.setText(null);
		this.textField_Cedula.setText(null);
		this.textField_Altura.setText(null);
		this.textField_OtroFis.setText(null);
		this.comboBox_Alcohol.setSelectedIndex(0);
		this.comboBox_Alimentacion.setSelectedIndex(0);
		this.comboBox_Catarsis.setSelectedIndex(0);
		this.comboBox_Diuresis.setSelectedIndex(0);
		this.comboBox_Drogas.setSelectedIndex(0);
		this.comboBox_Infuciones.setSelectedIndex(0);
		this.comboBox_Sexo.setSelectedIndex(0);
		this.comboBox_Sexualidad.setSelectedIndex(0);
		this.comboBox_Tabaco.setSelectedIndex(0);
		this.comboBox_Suenno.setSelectedIndex(0);
		this.textArea_AntFami.setText(null);
		this.textArea_Alergicos.setText(null);
		this.textArea_AnteEnfAct.setText(null);
		this.textArea_Cardiacas.setText(null);
		this.textArea_Endocrinologicos.setText(null);
		this.textArea_EnfAct.setText(null);
		this.textArea_Epidemiologicos.setText(null);
		this.textArea_Gastrointestinales.setText(null);
		this.textArea_Ginecologicos.setText(null);
		this.textArea_Hematologicos.setText(null);
		this.textArea_Infectologicos.setText(null);
		this.textArea_Neofrourologicos.setText(null);
		this.textArea_Neurologicos.setText(null);
		this.textArea_OtrosEnf.setText(null);
		this.textArea_Quirurgicos.setText(null);
		this.textArea_Respiratorias.setText(null);
		this.textArea_Traumatologicos.setText(null);
		this.textArea_EnfInf.setText(null);
	}
	
	public boolean validarCamposLLenos() {
		boolean lleno=false;
		if(this.textField_Cedula.getText()==null && this.textField_Numero.getText()==null
			&& this.textField_Peso.getText()==null && this.textField_Altura.getText()==null) {
			lleno=true;
		}
		else {
			lleno=false;
		}
		return lleno;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void llenarCampos(String peso, String numero, String cedula, String altura,
			String otrofis, String alcohol, String alimentacion, String catarsis, 
			String diuresis, String drogas, String infuciones, String sexualidad, String suenno,
			String tabaco, String anteFa, String alergicos, String anteEnf, 
			String cardiacas, String endocri, String enfAct, String epidemio, 
			String gastroin, String ginecolo, String hemato, String infectolo,
			String neufrolo, String neurolo, String otrosEnf, String quirurgi,
			String respira, String trauma, String infan) {
		this.textField_Peso.setText(peso);
		this.textField_Numero.setText(numero);
		this.textField_Cedula.setText(cedula);
		this.textField_Altura.setText(altura);
		this.textField_OtroFis.setText(otrofis);
		this.comboBox_Alcohol.setSelectedItem(alcohol);
		this.comboBox_Alimentacion.setSelectedItem(alimentacion);
		this.comboBox_Catarsis.setSelectedItem(catarsis);
		this.comboBox_Diuresis.setSelectedItem(diuresis);
		this.comboBox_Drogas.setSelectedItem(drogas);
		this.comboBox_Infuciones.setSelectedItem(infuciones);
		this.comboBox_Sexualidad.setSelectedItem(sexualidad);
		this.comboBox_Suenno.setSelectedItem(suenno);
		this.comboBox_Tabaco.setSelectedItem(tabaco);
		this.textArea_AntFami.setText(anteFa);
		this.textArea_Alergicos.setText(alergicos);
		this.textArea_AnteEnfAct.setText(anteEnf);
		this.textArea_Cardiacas.setText(cardiacas);
		this.textArea_Endocrinologicos.setText(endocri);
		this.textArea_EnfAct.setText(enfAct);
		this.textArea_Epidemiologicos.setText(epidemio);
		this.textArea_Gastrointestinales.setText(gastroin);
		this.textArea_Ginecologicos.setText(ginecolo);
		this.textArea_Hematologicos.setText(hemato);
		this.textArea_Infectologicos.setText(infectolo);
		this.textArea_Neofrourologicos.setText(neufrolo);
		this.textArea_Neurologicos.setText(neurolo);
		this.textArea_OtrosEnf.setText(otrosEnf);
		this.textArea_Quirurgicos.setText(quirurgi);
		this.textArea_Respiratorias.setText(respira);
		this.textArea_Traumatologicos.setText(trauma);
		this.textArea_EnfInf.setText(infan);
	}
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	public void setNroHistorial(String nro) {
		textField_Numero.setText(nro);
	}
	
	public String getPeso() {
		return textField_Peso.getText();
	}

	public String getNumero() {
		return textField_Numero.getText();
	}


	public String getCedula() {
		return textField_Cedula.getText();
	}


	public String getAltura() {
		return textField_Altura.getText();
	}

	public String getOtroFis() {
		return textField_OtroFis.getText();
	}

	public char getSexo() {
		switch (comboBox_Sexo.getSelectedIndex()) {
		case 0: 
			return 'F';
		case 1: 
			return 'M';
		case 2: 
			return 'O';
		}
		return 'F';
	}
	
	public void setSexo(char sexo) {
		switch (sexo) {
		case 'F': 
			comboBox_Sexo.setSelectedIndex(0);
			break;
		case 'M': 
			comboBox_Sexo.setSelectedIndex(1);
			break;
		case 'O': 
			comboBox_Sexo.setSelectedIndex(2);
			break;
		}
	}

	public String getTabaco() {
		return comboBox_Tabaco.getSelectedItem().toString();
	}


	public String getAlcohol() {
		return comboBox_Alcohol.getSelectedItem().toString();
	}


	public String getDrogas() {
		return comboBox_Drogas.getSelectedItem().toString();
	}


	public String getInfuciones() {
		return comboBox_Infuciones.getSelectedItem().toString();
	}


	public String getSexualidad() {
		return comboBox_Sexualidad.getSelectedItem().toString();
	}
	
	public String getSuenno() {
		return comboBox_Suenno.getSelectedItem().toString();
	}

	public String getDiuresis() {
		return comboBox_Diuresis.getSelectedItem().toString();
	}


	public String getCatarsis() {
		return comboBox_Catarsis.getSelectedItem().toString();
	}


	public String getAlimentacion() {
		return comboBox_Alimentacion.getSelectedItem().toString();
	}


	public String getAntFami() {
		return textArea_AntFami.getText();
	}


	public String getAnteEnfAct() {
		return textArea_AnteEnfAct.getText();
	}


	public String getEnfAct() {
		return textArea_EnfAct.getText();
	}


	public String getNeurologicos() {
		return textArea_Neurologicos.getText();
	}

	public String getNeofrourologicos() {
		return textArea_Neofrourologicos.getText();
	}


	public String getGastrointestinales() {
		return textArea_Gastrointestinales.getText();
	}


	public String getRespiratorias() {
		return textArea_Respiratorias.getText();
	}


	public String getCardiacas() {
		return textArea_Cardiacas.getText();
	}


	public String getHematologicos() {
		return textArea_Hematologicos.getText();
	}


	public String getGinecologicos() {
		return textArea_Ginecologicos.getText();
	}


	public String getInfectologicos() {
		return textArea_Infectologicos.getText();
	}


	public String getEndocrinologicos() {
		return textArea_Endocrinologicos.getText();
	}


	public String getQuirurgicos() {
		return textArea_Quirurgicos.getText();
	}


	public String getTraumatologicos() {
		return textArea_Traumatologicos.getText();
	}


	public String getAlergicos() {
		return textArea_Alergicos.getText();
	}


	public String getEpidemiologicos() {
		return textArea_Epidemiologicos.getText();
	}
	
	public String getEnfeIncancia() {
		return textArea_EnfInf.getText();
	}

	public String getOtrosEnf() {
		return textArea_OtrosEnf.getText();
	}

	public void addListener(ActionListener actionListener) {
		btnIncluir.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		
	}
	
	public void interfazIncluir() {
		btnModificar.setEnabled(false);
		btnModificar.setVisible(false);
		textField_Numero.setEditable(false);
		textField_Cedula.setEditable(false);
	}
	
	public void interfazConsulta() {
		btnIncluir.setEnabled(false);
		btnIncluir.setVisible(false);
		textField_Numero.setEditable(false);
		textField_Cedula.setEditable(false);
	}
	
	public void setCedula(String ced) {
		this.textField_Cedula.setText(ced);
	}
	
	
}
