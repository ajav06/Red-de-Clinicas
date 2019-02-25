//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Intervencion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import controlador.Historial.ControladorVtnHistorial;
import modelo.Intervencion.Intervencion;
import modelo.Intervencion.IntervencionBD;


import vista.Intervencion.VentanaIntervencion;

public class ControladorVtnIntervencion implements ActionListener{
	private VentanaIntervencion vtnAgreInt;
	private IntervencionBD intervencionBD;
	private Intervencion intervencion;
	
	
	public ControladorVtnIntervencion(int action, Intervencion intervencion) throws SQLException {
		super();
		this.vtnAgreInt = new VentanaIntervencion();
		this.vtnAgreInt.setLocationRelativeTo(null);
		this.vtnAgreInt.setVisible(true);
		this.vtnAgreInt.addListener(this);
	
		
		if(action==1) {
			this.vtnAgreInt.interfazRegistro();
		}
		else if(action==2){
			this.vtnAgreInt.interfazModificar();
			this.vtnAgreInt.llenarCampos( intervencion.getCedula(),intervencion.getCodigoT(), intervencion.getCodigoO(), intervencion.getFecha());
			
			
		}
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
			registrarIntervencion();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarIntervencion();
		}
		
		else if (actionCommand.equals("Volver")) {
			vtnAgreInt.salir();
		}
		
		
		}
	
	
	

	private void modificarIntervencion() {
		try
		{
	    	if(vtnAgreInt.getCedula().equals("") || vtnAgreInt.getCodigoT().equals("") || vtnAgreInt.getCodO().equals("") || vtnAgreInt.getFecha().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder registrar la intervencion
	    		vtnAgreInt.mostrarMensaje("Debe llenar todos los datos para poder registrar la intervencion");
	    	else
	    	{
	    		intervencionBD = new IntervencionBD();
		    	intervencion = new Intervencion(vtnAgreInt.getCedula(), vtnAgreInt.getCodigoT(), vtnAgreInt.getCodO(), vtnAgreInt.getFecha() );	    
		    	intervencionBD.actualizarIntervencion(intervencion);
		    	
		    	
		    	
		    	vtnAgreInt.mostrarMensaje("La Intervencion fue Modificado con exito");
		    	vtnAgreInt.blanquearCampos();
		    	vtnAgreInt.salir();
	    	}
		}catch(Exception e)
		{
			vtnAgreInt.mostrarMensaje("No se pudo Modificar la Intervencion, verifique que los datos sean correctos");
		}
		
	}

	private void registrarIntervencion(){
	  	try
		{
	    	if(vtnAgreInt.validarCamposLlenos() )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar la intervencion
	    		vtnAgreInt.mostrarMensaje("Debe llenar todos los datos para poder registrar la intervencion");
	    	else
	    	{
	    		intervencionBD = new IntervencionBD();
		    	intervencion = new Intervencion(vtnAgreInt.getCedula(), vtnAgreInt.getCodigoT(), vtnAgreInt.getCodO(), vtnAgreInt.getFecha() );	    
		    	intervencionBD.actualizarIntervencion(intervencion);
		       	
		    	vtnAgreInt.mostrarMensaje("La intervencion fue incluido con exito");
		    	vtnAgreInt.blanquearCampos();
		    	vtnAgreInt.salir();
	    	}
		}catch(Exception e)
		{
			vtnAgreInt.mostrarMensaje("No se pudo registrar la Intervencion, verifique que los datos sean correctos");
		}
	}
	
}