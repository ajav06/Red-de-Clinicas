package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Especialidad.ControladorVtnListaEspecialidades;
import controlador.Especialidad.ControladorVtnAgreEspecialidad;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Clinica.ControladorVtnLista;
import controlador.Especialidad.ControladorVtnEspecialidades;
import controlador.Historial.ControladorVtnHistorial;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import controlador.Medico.ControladorVtnListMedicos;
import controlador.Paciente.ControladorVtnListPacientes;
import controlador.Seguro.ControladorVtnSeguro;
import vista.VentanaPrincipal;

public class ControladorVtnPrincipal implements ActionListener{
	private VentanaPrincipal vtnPrin;
	
	public ControladorVtnPrincipal() {
		super();
		this.vtnPrin = new VentanaPrincipal();
		this.vtnPrin.setLocationRelativeTo(null);
		this.vtnPrin.setVisible(true);
		this.vtnPrin.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Clinica")) {
			try {
				new ControladorVtnLista();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		else if (actionCommand.equals("Medicos")) {
			try {
				new ControladorVtnListMedicos();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (actionCommand.equals("Pacientes")) {
			try {
				new ControladorVtnListPacientes();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (actionCommand.equals("Especialidades")) {
			try {
				new ControladorVtnListaEspecialidades();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (actionCommand.equals("Seguros")) {
			try {
				new ControladorVtnSeguro();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getClass() + e1.getMessage());
			}
		}
	}
}
