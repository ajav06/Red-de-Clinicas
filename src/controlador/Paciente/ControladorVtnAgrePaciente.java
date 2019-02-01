package controlador.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Historial.ControladorVtnHistorial;
import modelo.Historial.Antecedentes;
import modelo.Historial.AntecedentesBD;
import modelo.Historial.HistorialMedico;
import modelo.Historial.HistorialMedicoBD;
import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;
import vista.Paciente.VentanaAgregarPaciente;

public class ControladorVtnAgrePaciente implements ActionListener{
	private VentanaAgregarPaciente vtnAgrePac;
	private HistorialMedico historial;
	private Antecedentes antecedentes;
	
	public ControladorVtnAgrePaciente(int action, Paciente paciente) {
		super();
		this.vtnAgrePac = new VentanaAgregarPaciente();
		this.vtnAgrePac.setLocationRelativeTo(null);
		this.vtnAgrePac.setVisible(true);
		this.vtnAgrePac.addListener(this);
		
		if(action==1) {
			vtnAgrePac.interfazRegistro();
			vtnAgrePac.setCedula(paciente.getCedula());
		}
		else if(action==2){
			vtnAgrePac.interfazModificar();
			historial = buscarHistorial();
			antecedentes = buscarAntecedentes();
			vtnAgrePac.llenarCampos(Integer.toString(historial.getNumero()), paciente.getCedula(), paciente.getNombre(), paciente.getApellido(), 
					paciente.getCasa(), paciente.getEmail(), paciente.getCelular(), paciente.getDireccion(), paciente.getEstado(), paciente.getFechaNacimiento());
			vtnAgrePac.setEdoC(paciente.getEdo_civil());
			vtnAgrePac.setSeguro(paciente.isAsegurado());
		}
		else if(action==3){
			vtnAgrePac.interfazEliminar();
			historial = buscarHistorial();
			vtnAgrePac.llenarCampos(Integer.toString(historial.getNumero()), paciente.getCedula(), paciente.getNombre(), paciente.getApellido(), 
					paciente.getCasa(), paciente.getEmail(), paciente.getCelular(), paciente.getDireccion(), paciente.getEstado(), paciente.getFechaNacimiento());
			vtnAgrePac.setEdoC(paciente.getEdo_civil());
			vtnAgrePac.setSeguro(paciente.isAsegurado());
		}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
			registrarPaciente();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarPaciente();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarPaciente();
		}
		else if (actionCommand.equals("Volver")) {
			vtnAgrePac.salir();
		}
		else if (actionCommand.equals("Buscar")) {
			historial = buscarHistorial();
			antecedentes = buscarAntecedentes();
			new ControladorVtnHistorial(vtnAgrePac.getCedula(), historial, antecedentes);
		}
	}
	
	private void eliminarPaciente() {
		try
		{
	  		PacienteBD pacienteBD = new PacienteBD();	    
	    	pacienteBD.eliminarPaciente(vtnAgrePac.getCedula());
	    	vtnAgrePac.mostrarMensaje("El Paciente fue eliminado con exito");
	    	vtnAgrePac.blanquearCampos();
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo eliminar el Paciente, verifique que los datos sean correctos");
			vtnAgrePac.blanquearCampos();
		}
		
	}

	private void modificarPaciente() {
		try
		{
	    	if(vtnAgrePac.getCedula().equals("") || vtnAgrePac.getNombre().equals("") || vtnAgrePac.getApellido().equals("") 
	    			|| vtnAgrePac.getFechaNac().equals(null) || vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		PacienteBD pacienteBD = new PacienteBD();
		    	Paciente paciente = new Paciente(vtnAgrePac.getCedula(), vtnAgrePac.getNombre(), vtnAgrePac.getApellido(), vtnAgrePac.getFechaNac(), 
		    			vtnAgrePac.getEdoC(), vtnAgrePac.getEstado(), vtnAgrePac.getEmail(), vtnAgrePac.getTlfCelular(), vtnAgrePac.getTlfCasa(), 
		    			vtnAgrePac.getDiresccion(), vtnAgrePac.getSeguro());	    
		    	pacienteBD.actualizarPaciente(paciente);
		    	vtnAgrePac.mostrarMensaje("El Paciente fue Modificado con exito");
		    	vtnAgrePac.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
		}
		
	}

	private void registrarPaciente(){
	  	try
		{
	    	if(vtnAgrePac.getCedula().equals("") || vtnAgrePac.getNombre().equals("") || vtnAgrePac.getApellido().equals("") 
	    			|| vtnAgrePac.getFechaNac().equals(null) || vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		PacienteBD pacienteBD = new PacienteBD();
		    	Paciente paciente = new Paciente(vtnAgrePac.getCedula(), vtnAgrePac.getNombre(), vtnAgrePac.getApellido(), vtnAgrePac.getFechaNac(), 
		    			vtnAgrePac.getEdoC(), vtnAgrePac.getEstado(), vtnAgrePac.getEmail(), vtnAgrePac.getTlfCelular(), vtnAgrePac.getTlfCasa(), 
		    			vtnAgrePac.getDiresccion(), vtnAgrePac.getSeguro());	    
		    	pacienteBD.registrarPaciente(paciente);
		    	vtnAgrePac.mostrarMensaje("El Paciente fue incluido con exito");
		    	vtnAgrePac.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
		}
	}
	
	private HistorialMedico buscarHistorial() {
		HistorialMedico historial1 = null;
		try
		{
	    	if(vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		HistorialMedicoBD historialDB = new HistorialMedicoBD();
	    		historial1 = historialDB.buscarHistorial(Integer.toString(vtnAgrePac.getNroHist()));
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
		}
		return historial1;
	}
	
	private Antecedentes buscarAntecedentes() {
		Antecedentes antecedentes = null;
		try
		{
	    	if(vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		AntecedentesBD antecedenteDB = new AntecedentesBD();
	    		antecedentes = antecedenteDB.buscarAntecedentes(Integer.toString(historial.getNumero()));
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
		}
		return antecedentes;
	}
}