//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Intervencion;

import java.awt.BorderLayout;
import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VentanaIntervencion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Ced;
	private JTextField textField_CodT;
	private JTextField textField_CodO;
	private JDateChooser fecha;
	private JButton btnIncluir;
	private JButton btnModificar;
	private JButton btnVolver;
	
	
	
	
public VentanaIntervencion() {
	super();
	initGUI();
	blanquearCampos();
	
		
	}
	
	private void initGUI(){
						try {
							setTitle("Registrar Intervencion");
							setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							setBounds(100, 100, 540, 533);
							contentPane = new JPanel();
							contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
							setContentPane(contentPane);
							contentPane.setLayout(null);
							
							JLabel lblNewLabel = new JLabel("Registrar Intervencion");
							lblNewLabel.setForeground(Color.BLUE);
							lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
							lblNewLabel.setBounds(135, 11, 283, 36);
							contentPane.add(lblNewLabel);
							
							JPanel panel = new JPanel();
							panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Intervencion Quirurjica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							panel.setBounds(39, 64, 446, 313);
							contentPane.add(panel);
							panel.setLayout(null);
							
							JLabel lblCedula = new JLabel("Cedula del Paciente:");
							lblCedula.setBounds(32, 37, 107, 14);
							panel.add(lblCedula);
							
							textField_Ced = new JTextField();
							textField_Ced.setBounds(159, 34, 181, 20);
							panel.add(textField_Ced);
							textField_Ced.setColumns(10);
							
							JLabel lblCodigoTrabajo = new JLabel("Codigo Trabajo:");
							lblCodigoTrabajo.setBounds(53, 80, 82, 14);
							panel.add(lblCodigoTrabajo);
							
							JLabel lblCodigoOferta = new JLabel("Codigo Oferta:");
							lblCodigoOferta.setBounds(63, 121, 72, 14);
							panel.add(lblCodigoOferta);
							
							textField_CodT = new JTextField();
							textField_CodT.setColumns(10);
							textField_CodT.setBounds(159, 77, 181, 20);
							panel.add(textField_CodT);
							
							textField_CodO = new JTextField();
							textField_CodO.setColumns(10);
							textField_CodO.setBounds(159, 118, 181, 20);
							panel.add(textField_CodO);
							
						    fecha = new JDateChooser();
							fecha.setBounds(159, 159, 178, 23);
							panel.add(fecha);
							
							JLabel lblFecha = new JLabel("Fecha:");
							lblFecha.setBounds(98, 159, 41, 14);
							panel.add(lblFecha);
							
							btnIncluir = new JButton("Incluir");
							btnIncluir.setBounds(23, 425, 94, 43);
							contentPane.add(btnIncluir);
							
							 btnModificar = new JButton("Modificar");
							btnModificar.setBounds(127, 425, 94, 43);
							contentPane.add(btnModificar);
							
							btnVolver = new JButton("Volver");
							btnVolver.setBounds(402, 425, 94, 43);
							contentPane.add(btnVolver);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	
	public void blanquearCampos() {
		textField_Ced.setText(null);
		textField_CodT.setText(null);
		textField_CodO.setText(null);
		fecha.setDate(null);
	}
	
	public void llenarCampos(String ced, String codt, String codo, Date fec ) {
		textField_Ced.setText(ced);
		textField_CodT.setText(codt);
		textField_CodO.setText(codo);
		fecha.setDate(fec);
		
	}
	
	public void addListener(ActionListener actionListener) {
		btnIncluir.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		
		btnVolver.addActionListener(actionListener);
	}
	
	
	public void setCedula(String ced) {
		this.textField_Ced.setText(ced);
	}
	
	public String getCedula() {
		return textField_Ced.getText();
	}
	
	
	public String getCodigoT() {
		return textField_CodT.getText();
	}
	
	public String  getCodO() {
		return textField_CodO.getText();
	}
	
	public Date getFecha() {
		return fecha.getDate();
	}
	
	
	
	public void interfazRegistro() {
		
		btnModificar.setEnabled(false);
		
		btnModificar.setVisible(false);
	
	}
	
	public void interfazModificar() {
		btnIncluir.setEnabled(false);
		btnIncluir.setVisible(false);
		textField_Ced.setEditable(false);
		fecha.setEnabled(false);
		
		
	}
	
	public boolean validarCamposLlenos() {
		if(textField_Ced.getText().equals(null) || textField_CodT.getText().equals(null) || textField_CodO.getText().equals(null) ||fecha.getDate().equals(null))
			return true;
		else
			return false;
	}
	
	public boolean validarCedula() {
		if(textField_Ced.getText().length()<7)
			return true;
		else
			return false;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	
	
	
	public void salir() {
		setVisible(false);
		dispose();
	}
	
	
	
//fin 	
}
