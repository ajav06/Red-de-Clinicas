package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vista.Clinica.VentanaClinicaModeloTabla;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;

import vista.Clinica.VentanaListaClinica;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
public class ControladorVtnLista implements ActionListener
{
	private VentanaListaClinica vtnListCli;
	Clinica clinica;
	
	public ControladorVtnLista() throws SQLException {
		super();
		this.vtnListCli = new VentanaListaClinica();
		this.vtnListCli.setLocationRelativeTo(null);
		this.vtnListCli.setVisible(true);
		this.vtnListCli.addListener(this);
		cargarDatosClinicas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("...")) {
			buscarClinica();
		}		
		else if (actionCommand.equals("Actualizar")) {
			buscarClinica();
		}
		else if (actionCommand.equals("Eliminar")) {
			new ControladorVtnActuClinica(clinica);
		}
		else if (actionCommand.equals("Incluir")) {
			new ControladorVtnAgreClinica();
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
	
	public void cargarDatosClinicas() throws SQLException {
		ClinicaBD clinicaBD = new ClinicaBD();
		List<Clinica> clinicas = clinicaBD.consultarClinicas();
	this.vtnListCli.setResultados(new VentanaClinicaModeloTabla(clinicas));
	}

}
