package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import modelo.Paciente.PacienteBD;
import vista.Medico.VentanaConModRegMedico;

public class ControladorVtnConModRegEliMedico implements ActionListener{
	private VentanaConModRegMedico vtnMedico;
	
	public ControladorVtnConModRegEliMedico(Medico medico, int accion) {
		super();

		this.vtnMedico = new VentanaConModRegMedico();
		this.vtnMedico.setLocationRelativeTo(null);
		this.vtnMedico.setVisible(true);
		this.vtnMedico.addListener(this);
		this.vtnMedico.llenarCampos(medico.getCedula(),medico.getCod_especialidad(),medico.getNombre(),medico.getApellido(),medico.getFechaNacimiento(),medico.getEdo_civil(),medico.getEstado(),medico.getDireccion(),medico.getTlf_casa(),medico.getNroTelefonico(),medico.getEmail());

		if (accion==1) {
			this.vtnMedico.interfazRegistro();
		} else if (accion==2) {
			this.vtnMedico.interfazConsulta();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Registrar")) {
			registrarMedico();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarMedico();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarMedico();
		}
		else if (actionCommand.equals("Salir")) {
			salir();
		}
	}
	
	private void registrarMedico(){
	  	try
		{
	    	//if(vtnMedico.chequearLlenos())
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		//vtnMedico.mostrarMensaje("Debe llenar todos los datos para poder registrar al médico");
	    	//else
	    	//{
	    		MedicoBD medicoBD = new MedicoBD();
//		    	Medico medico = new Medico(vtnMedico.getCedula(),vtnMedico.getNombre(),"",vtnMedico.getFechaN(),
//		    			vtnMedico.getEmail(),vtnMedico.getTlfCasa(),vtnMedico.getTlfCelular(),
//		    			vtnMedico.getEspecialidad(),vtnMedico.getAlmaMater(),vtnMedico.getAnnoG(),vtnMedico.getHorarioMatu(),vtnMedico.getHorarioVesper(),
//		    			vtnMedico.getEstudiando(),'a');
//		    	medicoBD.registrarMedico(medico);
		    	vtnMedico.mostrarMensaje("El Médico fue incluido con exito");
		    	vtnMedico.blanquearCampos();
	    	//}
		}catch(Exception e)
		{
			vtnMedico.mostrarMensaje(e.toString());
			vtnMedico.mostrarMensaje("No se pudo registrar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void modificarMedico(){
	  	try
		{
	    	if(vtnMedico.chequearLlenos())
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnMedico.mostrarMensaje("Debe llenar todos los datos para poder modificar al médico");
	    	else
	    	{
	    		MedicoBD medicoBD = new MedicoBD();
//		    	Medico medico = new Medico(vtnMedico.getCedula(),vtnMedico.getNombre(),"",vtnMedico.getFechaN(),
//		    			vtnMedico.getEmail(),vtnMedico.getTlfCasa(),vtnMedico.getTlfCelular(),
//		    			vtnMedico.getEspecialidad(),vtnMedico.getAlmaMater(),vtnMedico.getAnnoG(),vtnMedico.getHorarioMatu(),vtnMedico.getHorarioVesper(),
//		    			vtnMedico.getEstudiando(),'a');
//		    	medicoBD.actualizarMedico(medico);
		    	vtnMedico.mostrarMensaje("El Médico fue actualizado con exito");
		    	vtnMedico.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnMedico.mostrarMensaje("No se pudo actualizar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void eliminarMedico(){
	  	try
		{
	  		MedicoBD medicoBD = new MedicoBD();	    
	  		medicoBD.eliminarMedico(vtnMedico.getCedula());
	  		vtnMedico.mostrarMensaje("El Médico fue eliminado con exito");
	  		vtnMedico.blanquearCampos();
		}catch(Exception e)
		{
			vtnMedico.mostrarMensaje("No se pudo eliminar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void salir() {
		vtnMedico.salir();
	}
}
