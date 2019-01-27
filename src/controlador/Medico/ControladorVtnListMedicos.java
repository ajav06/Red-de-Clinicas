package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vista.Medico.VentanaMedicoModeloTabla;
import vista.Medico.VentanaListaMedicos;
import modelo.Medico.*;

public class ControladorVtnListMedicos implements ActionListener {
	private VentanaListaMedicos vtnListMed;
	Medico medico;
	
	public ControladorVtnListMedicos() throws SQLException {
		super();
		this.vtnListMed = new VentanaListaMedicos();
		this.vtnListMed.setLocationRelativeTo(null);
		this.vtnListMed.setVisible(true);
		this.vtnListMed.addListener(this);
		cargarDatosMedico();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarMedicos();
		}		
		else if (actionCommand.equals("Consultar")) {
			consultarMedicos();
		}
		else if (actionCommand.equals("Registrar Nuevo")) {
			registrarMedicos();
		}
		else if (actionCommand.equals("Salir")) {
			salir();
		}
		
	}
	
	private void cargarDatosMedico() {
		
	}
	
	private void buscarMedicos() {
		try {
			if ("".equals(vtnListMed.getCedula())) {
				vtnListMed.mostrarMensaje("Introduzca un número de cédula para realizar la búsqueda.");
			} else {
				MedicoBD medicoBD = new MedicoBD();
				List<Medico> medicos = new ArrayList<Medico>();
				medico = medicoBD.buscarMedico(vtnListMed.getCedula());
				medicos.add(medico);
				this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos));
			}
		} catch (Exception e) {
			vtnListMed.mostrarMensaje("No se pudo buscar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void consultarMedicos() {
		
	}
	
	private void registrarMedicos() {
		
	}
	
	private void salir() {
		vtnListMed.salir();
	}
}
