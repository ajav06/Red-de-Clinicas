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
			this.vtnAgrePac.interfazRegistro();
			this.vtnAgrePac.setCedula(paciente.getCedula());
		}
		else if(action==2){
			this.vtnAgrePac.interfazModificar();
			this.vtnAgrePac.llenarCampos( paciente.getCedula(),paciente.getCedula(),paciente.getCedula(), paciente.getNombre(), paciente.getApellido()
					, paciente.getCasa(), paciente.getEmail(), paciente.getCedula(), paciente.getDireccion(), paciente.getEstado(), paciente.getFechaNacimiento());
			this.vtnAgrePac.setEdoC(paciente.getEdo_civil());
			
		}
		else if(action==3){
			this.vtnAgrePac.interfazEliminar();
			this.vtnAgrePac.llenarCampos( paciente.getCedula(),paciente.getCedula(),paciente.getCedula(), paciente.getNombre(), paciente.getApellido()
					, paciente.getCasa(), paciente.getEmail(), paciente.getCedula(), paciente.getDireccion(), paciente.getEstado(), paciente.getFechaNacimiento());
			this.vtnAgrePac.setEdoC(paciente.getEdo_civil());

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
			historial=buscarHistorial(Integer.toString(vtnAgrePac.getNroHist()));
			new ControladorVtnHistorial(vtnAgrePac.getCedula(), historial, buscarAntecedentes(Integer.toString(historial.getNumero())),2);
		}
		else if (actionCommand.equals("Nuevo")) {
			new ControladorVtnHistorial(vtnAgrePac.getCedula(), historial, antecedentes,1);
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
			vtnAgrePac.mostrarMensaje("No se pudo Modificar el Paciente, verifique que los datos sean correctos");
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
	
	private HistorialMedico buscarHistorialCed(String ced) {
		HistorialMedico historial1 = null;
		try
		{
	    	if(vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		HistorialMedicoBD historialDB = new HistorialMedicoBD();
	    		historial1 = historialDB.buscarHistorialCed(ced);
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje(e.getClass()+e.getMessage());
		}
		return historial1;
	}
	
	private HistorialMedico buscarHistorial(String num) {
		HistorialMedico historial1 = null;
		try
		{
	    	if(vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		HistorialMedicoBD historialDB = new HistorialMedicoBD();
	    		historial1 = historialDB.buscarHistorial(num);
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje(e.getClass()+e.getMessage());
		}
		return historial1;
	}
	
	private Antecedentes buscarAntecedentes(String num) {
		Antecedentes antecedentes = null;
		try
		{
	    	if(vtnAgrePac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgrePac.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		AntecedentesBD antecedenteDB = new AntecedentesBD();
	    		antecedentes = antecedenteDB.buscarAntecedentes(num);
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
		}
		return antecedentes;
	}
}