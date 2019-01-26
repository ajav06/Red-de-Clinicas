package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Paciente.ControladorVtnAgrePaciente;

import vista.Clinica.VentanaListaClinicas;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
public class ControladorVtnLista implements ActionListener
{
	private VentanaListaClinicas vtnListCli;
	Clinica clinica;
	
	public ControladorVtnLista() throws SQLException {
		super();
		this.vtnListCli = new VentanaListaClinicas();
		this.vtnListCli.setLocationRelativeTo(null);
		this.vtnListCli.setVisible(true);
		this.vtnListCli.addListener(this);
		//cargarDatosPacientes();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("...")) {
			buscarClinica();
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
	
	public void buscarClinica() {
		try
		{
	    	if(vtnListCli.getCodigo().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la clinica
	    		vtnListCli.mostrarMensaje("Debe llenar todos los datos para poder buscar al paciente");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
	    		List<Clinica> clinicas = new ArrayList<Clinica>();
	    		clinica = clinicaBD.buscarClinica(vtnListCli.getCodigo());
	    		clinicas.add(clinica);
	    		//this.vtnListCli.setResultados(new VentanaPacienteModeloTabla(pacientes));
	    		vtnListCli.mostrarMensaje("El Paciente fue buscado con exito");
	    	}
		}catch(Exception e)
		{
			vtnListCli.mostrarMensaje("No se pudo buscar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	public void actualizarPaciente() {
		try
		{
	    	if(vtnListCli.getCodigo().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnListCli.mostrarMensaje("Debe llenar todos los datos para poder buscar al paciente");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();	    
	    		clinica = clinicaBD.buscarClinica(vtnListCli.getCodigo());
	    		new ControladorVtnActuClinica(clinica);
	    	}
		}catch(Exception e)
		{
			vtnListCli.mostrarMensaje("No se pudo bucar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	public void eliminarPaciente() {
		try
		{
	    	if(vtnListCli.getCodigo().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnListCli.mostrarMensaje("Debe llenar todos los datos para poder buscar al paciente");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();	   
	    		clinica = clinicaBD.buscarClinica(vtnListCli.getCodigo());
	    		new ControladorElimClinica(clinica);
	    	}
		}catch(Exception e)
		{
			vtnListCli.mostrarMensaje("No se pudo bucar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	public void cargarDatosPacientes() throws SQLException {
		ClinicaBD clinicaBD = new ClinicaBD();
		List<Clinica> pacientes = clinicaBD.consultarClinicas();
	//	this.vtnListCli.setResultados(new VentanaPacienteModeloTabla(pacientes));
	}

}
