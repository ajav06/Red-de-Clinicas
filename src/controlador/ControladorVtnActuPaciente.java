package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente;
import modelo.PacienteBD;
import vista.VentanaActualizarPaciente;

public class ControladorVtnActuPaciente implements ActionListener{
	private VentanaActualizarPaciente vtnActuPac;
	
	public ControladorVtnActuPaciente() {
		super();
		this.vtnActuPac = new VentanaActualizarPaciente();
		this.vtnActuPac.setLocation(480, 210);
		this.vtnActuPac.setVisible(true);
		this.vtnActuPac.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
			actualizarPaciente();
		}		
		else if (actionCommand.equals("Cancelar")) {
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
		    	Paciente paciente = new Paciente(vtnActuPac.getCedula(),vtnActuPac.getNombre(),vtnActuPac.getApellido(),vtnActuPac.getAntPer()
		    			,vtnActuPac.getAntFam(),vtnActuPac.getNroSgro(),vtnActuPac.getNroHist(),vtnActuPac.getFechaNac());		    
		    	pacienteBD.actualizarPaciente(paciente);
		    	vtnActuPac.mostrarMensaje("El Paciente fue incluido con exito");
		    	vtnActuPac.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnActuPac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
			vtnActuPac.blanquearCampos();
		}
	}
}
