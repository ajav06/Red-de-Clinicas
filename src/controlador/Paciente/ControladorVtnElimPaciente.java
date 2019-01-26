package controlador.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;
import vista.Paciente.VentanaEliminarPaciente;

public class ControladorVtnElimPaciente implements ActionListener{
	private VentanaEliminarPaciente vtnElimPac;
	
	public ControladorVtnElimPaciente(Paciente paciente) {
		super();
		this.vtnElimPac = new VentanaEliminarPaciente();
		this.vtnElimPac.setLocationRelativeTo(null);
		this.vtnElimPac.setVisible(true);
		this.vtnElimPac.addListener(this);
		this.vtnElimPac.llenarCampos(paciente.getCedula(), paciente.getNombre(), paciente.getApellido(), 
				paciente.getFechaNacimiento(), paciente.getNroHistorial(), paciente.getNroSeguro(), 
				paciente.getAntePersonales(), paciente.getAnteFamiliares());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Si")) {
			eliminarPaciente();
		}		
		else if (actionCommand.equals("No")) {
			vtnElimPac.blanquearCampos();
		}
	}
	
	private void eliminarPaciente(){
	  	try
		{
	  		PacienteBD pacienteBD = new PacienteBD();	    
	    	pacienteBD.eliminarPaciente(vtnElimPac.getCedula());
	    	vtnElimPac.mostrarMensaje("El Paciente fue eliminado con exito");
	    	vtnElimPac.blanquearCampos();
		}catch(Exception e)
		{
			vtnElimPac.mostrarMensaje("No se pudo eliminar el Paciente, verifique que los datos sean correctos");
			vtnElimPac.blanquearCampos();
		}
	}
}
