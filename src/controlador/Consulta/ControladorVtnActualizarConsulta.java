//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Consulta.Consulta;
import modelo.Consulta.ConsultaBD;
import vista.Consulta.VentanaActualizarConsulta;
import vista.Consulta.VentanaRegistrarClinica;
import modelo.Medico.MedicoBD;
import modelo.Clinica.ClinicaBD;
public class ControladorVtnActualizarConsulta implements ActionListener{
	private VentanaActualizarConsulta vtnActuCon;
	public ControladorVtnActualizarConsulta(Consulta consulta) throws SQLException 
	{
		
		super();
		ClinicaBD cli = new ClinicaBD();
		MedicoBD med = new MedicoBD();
		this.vtnActuCon = new VentanaActualizarConsulta(cli.nombresClinicas(),med.nombresMedicos(),cli.nombresServicios());
		//this.vtnActuCon.setLocationRelativeTo(null);
		this.vtnActuCon.setVisible(true);
		this.vtnActuCon.addListener(this);
		this.vtnActuCon.mostrarMensaje(consulta.getClinica());
	    this.vtnActuCon.llenarCampos(consulta.getCedulaP(), consulta.getClinica(),
	    		 consulta.getFecha(),consulta.getMedico(),Integer.valueOf(consulta.getServicio()), consulta.getMotivo(), 
	    		 consulta.getDiagnostico(),consulta.getTratamiento());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Actualizar")) {
			actualizarClinica();
		}		
		else if (actionCommand.equals("Limpiar")) {
			vtnActuCon.blanquearCampos();
		}
		else if(actionCommand.equals("Cancelar"))
		{
			vtnActuCon.salir();
		}
	}
	
	private void actualizarClinica(){
	  	try
		{
	    	if(vtnActuCon.getCedulaP().equals("") || vtnActuCon.getClinica().equals("") || vtnActuCon.getFecha().equals("") 
	    			|| vtnActuCon.getMedico().equals("") || vtnActuCon.getMotivo().equals("")|| vtnActuCon.getDiagnostico().equals("")|| vtnActuCon.getTratamiento().equals("") )
	    		 //Deben estar todos los campos llenos para poder actualizar la Clinica
	    	vtnActuCon.mostrarMensaje("Debe llenar todos los datos para poder actualizar la consulta");
	    		else
	    	{
	    		ConsultaBD consultaBD = new ConsultaBD();

		    	Consulta consulta = new Consulta.Builder(vtnActuCon.getCedulaP())
		    			.clinic(vtnActuCon.getClinica())
		    			.fech(vtnActuCon.getFecha())
		    			.medic(vtnActuCon.getMedico())
		    			.motiv(vtnActuCon.getMotivo())
		    			.diagnostic(vtnActuCon.getDiagnostico())
		    			.tratamient(vtnActuCon.getTratamiento())
		    			.build();	
		    	consultaBD.actualizarConsulta(consulta);
		       vtnActuCon.mostrarMensaje("La Consulta fue actualizada con exito");
		    	vtnActuCon.blanquearCampos();
		    	vtnActuCon.salir();
	    	}
		}catch(Exception e)
		{
			vtnActuCon.mostrarMensaje("No se pudo actualizar la Consulta, verifique que los datos sean correctos");
			vtnActuCon.blanquearCampos();
		}
	}
}
