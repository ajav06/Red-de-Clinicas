package controlador.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Medico.VentanaMedicoModeloTabla;
import vista.Paciente.VentanaListaPacientes;
import vista.Paciente.VentanaPacienteModeloTabla;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;

public class ControladorVtnListPacientes implements ActionListener{
	private VentanaListaPacientes vtnListPac;
	PacienteBD pacienteBD;
	Paciente paciente;
	Date hola = null;
	
	public ControladorVtnListPacientes() throws SQLException {
		super();
		this.vtnListPac = new VentanaListaPacientes();
		this.vtnListPac.setLocationRelativeTo(null);
		this.vtnListPac.setVisible(true);
		this.vtnListPac.addListener(this);
		cargarDatosPacientes();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarPaciente();
		}		
		else if (actionCommand.equals("Actualizar")) {
			actualizarPaciente();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarPaciente();
		}
		else if (actionCommand.equals("Incluir")) {
			Paciente paciente = new Paciente(vtnListPac.getCedula(), "", "", hola, 'S', "", "", "", "", "", false);
			try {
				new ControladorVtnPaciente(1, paciente);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}
		else if (actionCommand.equals("Volver")) {
			vtnListPac.salir();
		}
		else if (actionCommand.equals("Refrescar")) {
			try {
				cargarDatosPacientes();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void buscarPaciente() {
		try {
			boolean n;
			try {
				Integer.parseInt(vtnListPac.getCedula());
				n=true;
			} catch (NumberFormatException e) {
				n=false;
			}
			if (!n){ //si estoy buscando por nombre
				pacienteBD = new PacienteBD();
	    		List<Paciente> pacientes = new ArrayList<Paciente>();
				String sql = null;
				
				if(vtnListPac.getAsegurado()==0)
					sql = "lower(nombres) like lower('%"+vtnListPac.getCedula()+"%') or lower(apellidos) like lower('%"+vtnListPac.getCedula()+"%')";
				else if(vtnListPac.getAsegurado()==1)
					sql = "(lower(nombres) like lower('%"+vtnListPac.getCedula()+"%') or lower(apellidos) like lower('%"+vtnListPac.getCedula()+"%')) and asegurado=TRUE";
				else
					sql = "(lower(nombres) like lower('%"+vtnListPac.getCedula()+"%') or lower(apellidos) like lower('%"+vtnListPac.getCedula()+"%')) and asegurado=FALSE";
					
				pacientes = pacienteBD.consultarFiltrarPacientes(sql);
				this.vtnListPac.setResultados(new VentanaPacienteModeloTabla(pacientes));
				this.vtnListPac.vaciarCedula();
			} else { //si estoy buscando por cedula
				pacienteBD = new PacienteBD();
				List<Paciente> pacientes = new ArrayList<Paciente>();
				paciente = pacienteBD.buscarPaciente(vtnListPac.getCedula());
				if (paciente==null) {
					this.vtnListPac.mostrarMensaje("Paciente no encontrado.");
					cargarDatosPacientes();
				} else {
					pacientes.add(paciente);
		    		this.vtnListPac.setResultados(new VentanaPacienteModeloTabla(pacientes));
					this.vtnListPac.vaciarCedula();;
				}
			}
		} catch (Exception e) {
			vtnListPac.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
			vtnListPac.mostrarMensaje("No se pudo buscar el médico, verifique que los datos sean correctos");
		}
	}
	
	public void actualizarPaciente() {
		try {
			JTable tabla = vtnListPac.getTblPacientes();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnListPac.mostrarMensaje("Seleccione un paciente del listado para actualizarlo.");
			} else {
				String cedula = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				pacienteBD = new PacienteBD();
				paciente = pacienteBD.buscarPaciente(cedula);
				new ControladorVtnPaciente(2, paciente);
			}
		} catch (Exception e) {
			vtnListPac.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	public void eliminarPaciente() {
		try {
			JTable tabla = vtnListPac.getTblPacientes();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnListPac.mostrarMensaje("Seleccione un paciente del listado para eliminarlo.");
			} else {
				String cedula = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				pacienteBD = new PacienteBD();
				paciente = pacienteBD.buscarPaciente(cedula);
				new ControladorVtnPaciente(3, paciente);
			}
		} catch (Exception e) {
			vtnListPac.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	public void cargarDatosPacientes() throws SQLException {
		PacienteBD pacienteBD = new PacienteBD();
		List<Paciente> pacientes = pacienteBD.consultarPacientes();
		this.vtnListPac.setResultados(new VentanaPacienteModeloTabla(pacientes));
	}
}
