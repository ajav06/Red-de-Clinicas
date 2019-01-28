package controlador.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;
import vista.Paciente.VentanaActualizarPaciente;

public class ControladorVtnActuPaciente implements ActionListener{
	private VentanaActualizarPaciente vtnActuPac;
	
	public ControladorVtnActuPaciente(Paciente paciente) {
		super();
		this.vtnActuPac = new VentanaActualizarPaciente();
		this.vtnActuPac.setLocationRelativeTo(null);
		this.vtnActuPac.setVisible(true);
		this.vtnActuPac.addListener(this);
//		this.vtnActuPac.llenarCampos(paciente.getCedula(), paciente.getNombre(), paciente.getApellido(), 
//				paciente.getFechaNacimiento(), paciente.getNroHistorial(), paciente.getNroSeguro(), 
//				paciente.getAntePersonales(), paciente.getAnteFamiliares());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Si")) {
			actualizarPaciente();
		}		
		else if (actionCommand.equals("No")) {
			vtnActuPac.blanquearCampos();
		}
	}
	
	private void actualizarPaciente(){
	  	try
		{
	    	if(vtnActuPac.getCedula().equals("") || vtnActuPac.getNombre().equals("") || vtnActuPac.getApellido().equals("") 
	    			|| vtnActuPac.getFechaNac().equals(null) || vtnActuPac.getNroHist()==0 )
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnActuPac.mostrarMensaje("Debe llenar todos los datos para poder actualizar al paciente");
	    	else
	    	{
	    		PacienteBD pacienteBD = new PacienteBD();
//		    	Paciente paciente = new Paciente(vtnActuPac.getCedula(),vtnActuPac.getNombre(),
//		    			vtnActuPac.getApellido(),vtnActuPac.getAntPer(),vtnActuPac.getAntFam(),
//		    			vtnActuPac.getNroSgro(),vtnActuPac.getNroHist(),vtnActuPac.getFechaNac());		    
//		    	pacienteBD.actualizarPaciente(paciente);
		    	vtnActuPac.mostrarMensaje("El Paciente fue incluido con exito");
		    	vtnActuPac.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnActuPac.mostrarMensaje("No se pudo actualizar el Paciente, verifique que los datos sean correctos");
			vtnActuPac.blanquearCampos();
		}
	}
}
