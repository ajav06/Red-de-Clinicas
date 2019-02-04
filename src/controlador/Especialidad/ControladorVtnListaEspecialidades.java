package controlador.Especialidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vista.Especialidad.VentanaListaEspecialidad;
import vista.Especialidad.VentanaEspecialidadModeloTabla;
import modelo.Especialidad.Especialidad;
import modelo.Especialidad.EspecialidadBD;

public class ControladorVtnListaEspecialidades implements ActionListener{
	private VentanaListaEspecialidad vtnListEsp;
	Especialidad especialidad;
	
	public ControladorVtnListaEspecialidades() throws SQLException {
		super();
		this.vtnListEsp = new VentanaListaEspecialidad();
		this.vtnListEsp.setLocationRelativeTo(null);
		this.vtnListEsp.setVisible(true);
		this.vtnListEsp.addListener(this);
		cargarDatosEspecialidades();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarEspecialidad();
		}		
		else if (actionCommand.equals("Actualizar")) {
			actualizarEspecialidad();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarEspecialidad();
		}
		else if (actionCommand.equals("Incluir")) {
			// buscarEspecialidad();
			new ControladorVtnAgreEspecialidad( 1, especialidad);		
		}
		else if (actionCommand.equals("Salir")) {  // Volver
			vtnListEsp.salir();
		}
	}
	
	public void buscarEspecialidad() {
		try
		{
	    	if(vtnListEsp.getcodigonombre().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la especialidad
	    		vtnListEsp.mostrarMensaje("Debe llenar todos los datos para poder buscar la especialidad");
	    	else
	    	{
	    		EspecialidadBD especialidadBD = new EspecialidadBD();
	    		List<Especialidad> especialidades = new ArrayList<Especialidad>();
	    		especialidad = especialidadBD.buscarEspecialidad(vtnListEsp.getcodigonombre());
	    		especialidades.add(especialidad);
	    		this.vtnListEsp.setResultados(new VentanaEspecialidadModeloTabla(especialidades));
		    	vtnListEsp.mostrarMensaje("La especialidad fue buscada con exito");
	    	}
		}catch(Exception e)
		{
			vtnListEsp.mostrarMensaje("No se pudo buscar la especialidad, verifique que los datos sean correctos");
		}
	}
	
	public void actualizarEspecialidad() {
		try
		{
	    	if(vtnListEsp.getcodigonombre().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la especialidad
	    		vtnListEsp.mostrarMensaje("Debe llenar todos los datos para poder buscar la especialidad");
	    	else
	    	{
	    		EspecialidadBD especialidadBD = new EspecialidadBD();	    
	    		especialidad = especialidadBD.buscarEspecialidad(vtnListEsp.getcodigonombre());
	    		new ControladorVtnAgreEspecialidad(2, especialidad);
	    	}
		}catch(Exception e)
		{
			vtnListEsp.mostrarMensaje("No se pudo bucar la Especialidad, verifique que los datos sean correctos");
		}
	}
	
	public void eliminarEspecialidad() {
		try
		{
	    	if(vtnListEsp.getcodigonombre().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la especialidad
	    		vtnListEsp.mostrarMensaje("Debe llenar todos los datos para poder buscar la especialidad");
	    	else
	    	{
	    		EspecialidadBD especialidadBD = new EspecialidadBD();	    
	    		especialidad = especialidadBD.buscarEspecialidad(vtnListEsp.getcodigonombre());
	    		new ControladorVtnAgreEspecialidad(3, especialidad);
	    	}
		}catch(Exception e)
		{
			vtnListEsp.mostrarMensaje("No se pudo buscar la especialidad, verifique que los datos sean correctos");
		}
	}
	
	public void cargarDatosEspecialidades() throws SQLException {
		EspecialidadBD especialidadBD = new EspecialidadBD();
		List<Especialidad> especialidades = especialidadBD.consultarEspecialidades();
		this.vtnListEsp.setResultados(new VentanaEspecialidadModeloTabla(especialidades));
	}
}
