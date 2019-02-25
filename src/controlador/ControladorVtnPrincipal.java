package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import controlador.Especialidad.ControladorVtnListaEspecialidades;
import controlador.Especialidad.ControladorMenuEspecialidades;
import controlador.Medico.ControladorVtnCitasMedico;
import controlador.Medico.ControladorVtnListMedicos;
import controlador.Consulta.ControladorVtnListaConsulta;
import controlador.Consulta.ControladorVtnRegistrarConsulta;
import controlador.Paciente.ControladorVtnListPacientes;
import controlador.Seguro.ControladorVtnSeguro;
import controlador.Servicio.ControladorVtnListaServicios;
import controlador.Clinica.ControladorVentanaMenuClinica;
import controlador.ControladorVtnReportesGlobal;
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
		
			new ControladorVentanaMenuClinica();
			
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
				new ControladorMenuEspecialidades();
			
		}
		else if (actionCommand.equals("Seguros")) {
			try {
				new ControladorVtnSeguro();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getClass() + e1.getMessage());
			}
		}
		else if (actionCommand.equals("Consultas")) {
			try {
				new ControladorVtnListaConsulta();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		else if(actionCommand.equals("Citas Medico")) {
			try {
				new ControladorVtnCitasMedico();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(actionCommand.equals("Servicios")) {
			try {
				new ControladorVtnListaServicios();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(actionCommand.equals("Salir")) {
			this.vtnPrin.salir();
		} else if (actionCommand.equals("Reportes")) {
			try {
				new ControladorVtnReportesGlobal("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
