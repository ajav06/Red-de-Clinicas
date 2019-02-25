
//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 
package controlador.Especialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.Especialidad.Especialidad;
import modelo.Especialidad.EspecialidadBD;
import vista.Especialidad.VentanaActualizarEspecialidad;


public class ControladorVtnActuEspecialidad implements ActionListener {
	
	private VentanaActualizarEspecialidad vtnActuEsp;

	public ControladorVtnActuEspecialidad(Especialidad especialidad) {
		
		super();
		this.vtnActuEsp = new VentanaActualizarEspecialidad();
		this.vtnActuEsp.setLocationRelativeTo(null);
		this.vtnActuEsp.setVisible(true);
		this.vtnActuEsp.addListener(this); 	
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e ) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Si")) {
			
			actualizarEspecialidad();	
		} 
		else if (actionCommand.equals("No")) {
			
			vtnActuEsp.blanquearCampos();
			
		}
		
	}	
	
	
	public void actualizarEspecialidad() {
		try {
			if (vtnActuEsp.getCodigo().equals("") || vtnActuEsp.getNombre().equals("") || vtnActuEsp.getDescripcion().equals("")   ) {
			
				vtnActuEsp.mostrarMensaje("Se deben llenar todos los datos para actualizar la especialidad");		
		} else {
			
			EspecialidadBD especialidadBD = new EspecialidadBD();
			
			vtnActuEsp.mostrarMensaje("La especialidad fue actualizada con exito");
			vtnActuEsp.blanquearCampos();	
	} 
		} catch(Exception e)
		{
			vtnActuEsp.mostrarMensaje("No se pudo actualizar la especialidad, verifique que los datos sean correctos");
			vtnActuEsp.blanquearCampos();
		}
	
	}
	
	
	
	
	
	
	
	
//fin controlador actualizar	
}
