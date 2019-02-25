package controlador.Intervencion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controlador.Paciente.ControladorVtnPaciente;
import vista.Intervencion.VentanaListaIntervencion;
import vista.Intervencion.VentanaIntervencionModeloTabla;
import modelo.Intervencion.Intervencion;
import modelo.Intervencion.IntervencionBD;
import modelo.Paciente.Paciente;

public class ControladorVtnListIntervenciones implements ActionListener{
	private VentanaListaIntervencion vtnListInt;
	Intervencion intervencion;
	Date hola = null;
	public ControladorVtnListIntervenciones() throws SQLException {
		super();
		this.vtnListInt = new VentanaListaIntervencion();
		this.vtnListInt.setLocationRelativeTo(null);
		this.vtnListInt.setVisible(true);
		this.vtnListInt.addListener(this);
		cargarDatosIntervenciones();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarEspecialidad();
		}		
		else if (actionCommand.equals("Actualizar")) {
			actualizarIntervencion();
		}
		
		else if (actionCommand.equals("Incluir")) {
			Intervencion intervencion = new Intervencion(vtnListInt.getcedula(), "", "", hola );
			try {
				new ControladorVtnIntervencion(1, intervencion);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		} else if (actionCommand.equals("Volver")) {
			vtnListInt.salir();
		} 
		else if (actionCommand.equals("Refrescar")) {
			try {
				cargarDatosIntervenciones();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	
		}
	
	}
	
	
	public void buscarEspecialidad() {
		try
		{
	    	if(vtnListInt.getcedula().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la intervencion
	    		vtnListInt.mostrarMensaje("Debe llenar todos los datos para poder buscar la intervencion");
	    	else
	    	{
	    		IntervencionBD intervencionBD = new IntervencionBD();
	    		List<Intervencion> intervenciones = new ArrayList<Intervencion>();
	    		intervenciones = intervencionBD.consultarFiltrarIntervencion("lower(pac_cedula) like lower('%"+vtnListInt.getcedula()+"%')  order by codigo asc");
	    		this.vtnListInt.setResultados(new VentanaIntervencionModeloTabla(intervenciones));
		    	vtnListInt.mostrarMensaje("La intervencion fue buscada con exito");
	    	}
		}catch(Exception e)
		{
			vtnListInt.mostrarMensaje("No se pudo buscar la intervencion, verifique que los datos sean correctos");
		}
	}
	
	public void actualizarIntervencion() {
		try
		{
			if (vtnListInt.gettableIntervencion().getSelectedColumn()==-1) {
				vtnListInt.mostrarMensaje("Debe seleccionar una intervencion para modificarla.");
			} else {
	    		IntervencionBD intervencionBD = new IntervencionBD();	    
	    		intervencion = intervencionBD.buscarIntervencion(String.valueOf(vtnListInt.gettableIntervencion().getModel().getValueAt(vtnListInt.gettableIntervencion().getSelectedRow(), 0)));
	    		new ControladorVtnIntervencion(2, intervencion);
			}
		}catch(Exception e)
		{
			vtnListInt.mostrarMensaje("No se pudo bucar la intervencion, verifique que los datos sean correctos");
		}
	}
	
	
	public void cargarDatosIntervenciones() throws SQLException {
		IntervencionBD intervencionBD = new IntervencionBD();
		List<Intervencion> intervenciones = intervencionBD.consultarIntervenciones();
		this.vtnListInt.setResultados(new VentanaIntervencionModeloTabla(intervenciones));
	}
}
