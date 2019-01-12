package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente;
import modelo.PacienteBD;
import vista.VentanaAgregarPaciente;

public class ControladorVtnAgrePaciente implements ActionListener{
	private VentanaAgregarPaciente vtnAgrePac;
	
	public ControladorVtnAgrePaciente() {
		super();
		this.vtnAgrePac = new VentanaAgregarPaciente();
		this.vtnAgrePac.setLocation(480, 210);
		this.vtnAgrePac.setVisible(true);
		this.vtnAgrePac.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Guardar")) {
			registrarPaciente();
		}		
		else if (actionCommand.equals("Cancelar")) {
			vtnAgrePac.blanquearCampos();
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
		    	Paciente paciente = new Paciente(vtnAgrePac.getCedula(),vtnAgrePac.getNombre(),vtnAgrePac.getApellido(),vtnAgrePac.getAntPer()
		    			,vtnAgrePac.getAntFam(),vtnAgrePac.getNroSgro(),vtnAgrePac.getNroHist(),vtnAgrePac.getFechaNac());		    
		    	pacienteBD.registrarPaciente(paciente);
		    	vtnAgrePac.mostrarMensaje("El Paciente fue incluido con exito");
		    	vtnAgrePac.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnAgrePac.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
			vtnAgrePac.blanquearCampos();
		}
	}
}