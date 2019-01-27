package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Medico.VentanaMedicoModeloTabla;
import vista.Medico.VentanaListaMedicos;
import modelo.Medico.*;

public class ControladorVtnListMedicos implements ActionListener {
	private VentanaListaMedicos vtnListMed;
	Medico medico;
	
	public ControladorVtnListMedicos() {
		super();
		this.vtnListMed = new VentanaListaMedicos();
		this.vtnListMed.setLocationRelativeTo(null);
		this.vtnListMed.setVisible(true);
		cargarDatosMedico();
		this.vtnListMed.addListener(this);
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
		try{
			MedicoBD medicoBD = new MedicoBD();
			List<Medico> medicos = medicoBD.consultarMedicos();
			this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos));
		} catch (SQLException e) {
			vtnListMed.mostrarMensaje(e.getMessage());
		}
	}
	
	private void buscarMedicos() {
		try {
			if ("".equals(vtnListMed.getCedula())) {
				vtnListMed.mostrarMensaje("Introduzca un número de cédula para realizar la búsqueda.");
			} else {
				MedicoBD medicoBD = new MedicoBD();
				List<Medico> medicos = new ArrayList<Medico>();
				medico = medicoBD.buscarMedico(vtnListMed.getCedula());
				if (medico.equals(null)) {
					this.vtnListMed.mostrarMensaje("Médico no encontrado.");
					cargarDatosMedico();
				} else {
					medicos.add(medico);
					this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos));
				}
			}
		} catch (Exception e) {
			vtnListMed.mostrarMensaje(e.getMessage());
			vtnListMed.mostrarMensaje("No se pudo buscar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void consultarMedicos() {
		try {
			if ("".equals(vtnListMed.getCedula())) {
				vtnListMed.mostrarMensaje("Introduzca un número de cédula para realizar la búsqueda.");
			} else {
				JTable tabla = vtnListMed.getTable_Medicos();
				int fila = tabla.getSelectedRow();
				String cedula = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				MedicoBD medicoBD = new MedicoBD();
				medico = medicoBD.buscarMedico(cedula);
				ControladorVtnConModRegEliMedico c = new ControladorVtnConModRegEliMedico(medico,2);
			}
		} catch (Exception e) {
			vtnListMed.mostrarMensaje(e.getMessage());
		}
	}
	
	private void registrarMedicos() {
		try {
			ControladorVtnConModRegEliMedico c = new ControladorVtnConModRegEliMedico(medico,1);
		} catch (Exception e) {
			vtnListMed.mostrarMensaje(e.getMessage());
		}
	}
	
	private void salir() {
		vtnListMed.salir();
	}
}
