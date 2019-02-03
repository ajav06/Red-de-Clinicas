package controlador.Especialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.Especialidad.Especialidad;
import modelo.Especialidad.EspecialidadBD;
import modelo.Paciente.PacienteBD;
import vista.Especialidad.VentanaEliminarEspecialidad;


public class ControladorVtnElimEspecialidad implements ActionListener {
	
	private VentanaEliminarEspecialidad vtnElimEsp;

	public ControladorVtnElimEspecialidad(Especialidad especialidad) {
		
		super();
		this.vtnElimEsp = new VentanaEliminarEspecialidad();
		this.vtnElimEsp.setLocationRelativeTo(null);
		this.vtnElimEsp.setVisible(true);
		this.vtnElimEsp.addListener(this); 	
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e ) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Si")) {
			
			eliminarEspecialidad();	
		} 
		else if (actionCommand.equals("No")) {
			
			vtnElimEsp.blanquearCampos();
			
		}
		
	}	
	
	
	private void eliminarEspecialidad(){
	  	try
		{
	  		EspecialidadBD especialidadBD = new EspecialidadBD();	    
	    	especialidadBD.eliminarEspecialidad(vtnElimEsp.getCodigo());
	    	vtnElimEsp.mostrarMensaje("La especialidad fue eliminado con exito");
	    	vtnElimEsp.blanquearCampos();
		}catch(Exception e)
		{
			vtnElimEsp.mostrarMensaje("No se pudo eliminar el Paciente, verifique que los datos sean correctos");
			vtnElimEsp.blanquearCampos();
		}
	}
	
	
	
	
	
	
	
//fin controlador eliminar
}
