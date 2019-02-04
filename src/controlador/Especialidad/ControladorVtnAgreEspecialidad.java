package controlador.Especialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Historial.ControladorVtnHistorial;
import modelo.Especialidad.Especialidad;
import modelo.Especialidad.EspecialidadBD;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;
import vista.Especialidad.VentanaAgregarEspecialidad;


public class ControladorVtnAgreEspecialidad implements ActionListener {
 private VentanaAgregarEspecialidad vtnAgreEsp;
 
 
 
 public  ControladorVtnAgreEspecialidad(int action,Especialidad especialidad) {
	 super();
	 this.vtnAgreEsp = new VentanaAgregarEspecialidad();
	 this.vtnAgreEsp.setLocationRelativeTo(null);
	 this.vtnAgreEsp.setVisible(true);
	 this.vtnAgreEsp.addListener(this);
	 
	 
	 if(action==1) {
		 
		 vtnAgreEsp.interfazRegistro();
		 vtnAgreEsp.setCodigo(especialidad.getCodigo()); 
	 }
	 else if (action==2) {
		 
		 vtnAgreEsp.interfazModificar();
		 vtnAgreEsp.llenarCampos(especialidad.getCodigo(), especialidad.getNombre(), especialidad.getDescripcion());	 
	 }
	 else if (action==3) {
		 vtnAgreEsp.interfazEliminar();
		 vtnAgreEsp.llenarCampos(especialidad.getCodigo(), especialidad.getNombre(), especialidad.getDescripcion());
		 
			 }
	 
	 
 }
 
 @Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
			registrarEspecialidad();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarEspecialidad();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarEspecialidad();
		}
		else if (actionCommand.equals("Volver")) {
			vtnAgreEsp.salir();
		}
		
	}


 private void eliminarEspecialidad() {
		try
		{
	  		EspecialidadBD especialidadBD = new EspecialidadBD();	    
	    	especialidadBD.eliminarEspecialidad(vtnAgreEsp.getCodigo());
	    	vtnAgreEsp.mostrarMensaje("la especialidad fue eliminada con exito");
	    	vtnAgreEsp.blanquearCampos();
		}catch(Exception e)
		{
			vtnAgreEsp.mostrarMensaje("No se pudo eliminar la especialidad, verifique que los datos sean correctos");
			vtnAgreEsp.blanquearCampos();
		}
		
	}

 private void modificarEspecialidad() {
		try
		{
	    	if(vtnAgreEsp.chequearLlenos()  )//Deben estar todos los campos llenos para poder incluir la especialidad
	    		
	    	   
	    		vtnAgreEsp.mostrarMensaje("Debe llenar todos los datos para poder registrar la especialidad");
	    	else
	    	{
	    		EspecialidadBD especialidadBD = new EspecialidadBD();
		    	Especialidad especialidad = new Especialidad(vtnAgreEsp.getCodigo(), vtnAgreEsp.getNombre(),vtnAgreEsp.getDescripcion());	    
		    	especialidadBD.actualizarEspecialidad(especialidad);
		    	vtnAgreEsp.mostrarMensaje("La especialidad fue modificada con exito");
		    	vtnAgreEsp.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnAgreEsp.mostrarMensaje("No se pudo registrar la especialidad, verifique que los datos sean correctos");
		}
		
	}


 
 private void registrarEspecialidad(){
	  	try
		{
	  		if(vtnAgreEsp.chequearLlenos())//Deben estar todos los campos llenos para poder incluir la especialidad
	    		vtnAgreEsp.mostrarMensaje("Debe llenar todos los datos para poder registrar la especialidad");
	    	else
	    	{
	    		EspecialidadBD especialidadBD = new EspecialidadBD();
		    	Especialidad especialidad = new Especialidad(vtnAgreEsp.getCodigo(),vtnAgreEsp.getNombre(), vtnAgreEsp.getDescripcion());
		    	especialidadBD.registarEspecialidad(especialidad);
		    	vtnAgreEsp.mostrarMensaje("La especialidad fue incluida con exito");
		    	vtnAgreEsp.blanquearCampos();
	    	}
		} catch(Exception e)
		{
			vtnAgreEsp.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}




 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

//fin agregar
}
