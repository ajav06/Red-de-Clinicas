package controlador.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vista.Paciente.VentanaListaPacientes;
import vista.Paciente.VentanaPacienteModeloTabla;
import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;

public class ControladorVtnListPacientes implements ActionListener
{
	private VentanaListaPacientes vtnListPac;
	Paciente paciente;
	
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
		if (actionCommand.equals("...")) {
			buscarPaciente();
		}		
		else if (actionCommand.equals("Actualizar")) {
			actualizarPaciente();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarPaciente();
		}
		else if (actionCommand.equals("Incluir")) {
			new ControladorVtnAgrePaciente();
		}
	}
	
	public void buscarPaciente() {
		try
		{
	    	if(vtnListPac.getCedula().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnListPac.mostrarMensaje("Debe llenar todos los datos para poder buscar al paciente");
	    	else
	    	{
	    		PacienteBD pacienteBD = new PacienteBD();
	    		List<Paciente> pacientes = new ArrayList<Paciente>();
	    		paciente = pacienteBD.buscarPaciente(vtnListPac.getCedula());
	    		pacientes.add(paciente);
	    		this.vtnListPac.setResultados(new VentanaPacienteModeloTabla(pacientes));
		    	vtnListPac.mostrarMensaje("El Paciente fue buscado con exito");
	    	}
		}catch(Exception e)
		{
			vtnListPac.mostrarMensaje("No se pudo buscar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	public void actualizarPaciente() {
		try
		{
	    	if(vtnListPac.getCedula().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnListPac.mostrarMensaje("Debe llenar todos los datos para poder buscar al paciente");
	    	else
	    	{
	    		PacienteBD pacienteBD = new PacienteBD();	    
	    		paciente = pacienteBD.buscarPaciente(vtnListPac.getCedula());
	    		new ControladorVtnActuPaciente(paciente);
	    	}
		}catch(Exception e)
		{
			vtnListPac.mostrarMensaje("No se pudo bucar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	public void eliminarPaciente() {
		try
		{
	    	if(vtnListPac.getCedula().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnListPac.mostrarMensaje("Debe llenar todos los datos para poder buscar al paciente");
	    	else
	    	{
	    		PacienteBD pacienteBD = new PacienteBD();	    
	    		paciente = pacienteBD.buscarPaciente(vtnListPac.getCedula());
	    		new ControladorVtnElimPaciente(paciente);
	    	}
		}catch(Exception e)
		{
			vtnListPac.mostrarMensaje("No se pudo bucar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	public void cargarDatosPacientes() throws SQLException {
		PacienteBD pacienteBD = new PacienteBD();
		List<Paciente> pacientes = pacienteBD.consultarPacientes();
		this.vtnListPac.setResultados(new VentanaPacienteModeloTabla(pacientes));
	}
}
