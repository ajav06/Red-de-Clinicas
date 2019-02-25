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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Especialidad.Especialidad;
import modelo.Especialidad.EspecialidadBD;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
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
			Object[] opciones = {"Sí","No"};
	  		int n = JOptionPane.showOptionDialog(null,"Eliminar una especialidad eliminará a todos los médicos asociados a la misma. \n¿Desea continuar?","Eliminar especialidad",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[1]);
			if (n==JOptionPane.YES_OPTION) {
		  		EspecialidadBD especialidadBD = new EspecialidadBD();	  
		  		List<Medico> medicos = new ArrayList<Medico>();
		  		MedicoBD medicoBD = new MedicoBD();
		    	especialidadBD.eliminarEspecialidad(vtnElimEsp.getCodigo());
		    	medicos = medicoBD.consultarFiltrarMedicos("cod_especialidad = '"+vtnElimEsp.getCodigo()+"'");
		    	for (int i=0;i<medicos.size();i++) {
		    		medicoBD.eliminarMedico(medicos.get(i).getCedula());
		    	}
		    	vtnElimEsp.mostrarMensaje("La especialidad fue eliminado con exito");
		    	vtnElimEsp.blanquearCampos();
			}
		}catch(Exception e)
		{
			vtnElimEsp.mostrarMensaje("No se pudo eliminar el Paciente, verifique que los datos sean correctos");
			vtnElimEsp.blanquearCampos();
		}
	}
	
	
	
	
	
	
	
//fin controlador eliminar
}
