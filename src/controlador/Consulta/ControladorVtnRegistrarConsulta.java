package controlador.Consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.Clinica.ClinicaBD;
import modelo.Medico.MedicoBD;
import modelo.Consulta.Consulta;
import modelo.Consulta.ConsultaBD;
import vista.Consulta.VentanaRegistrarClinica;

public class ControladorVtnRegistrarConsulta implements ActionListener{
private VentanaRegistrarClinica vtnReCon;
	
	public ControladorVtnRegistrarConsulta() throws NumberFormatException, SQLException {
		super();
		ClinicaBD cli = new ClinicaBD();
		MedicoBD med = new MedicoBD();
		this.vtnReCon = new VentanaRegistrarClinica(cli.nombresClinicas(),med.nombresMedicos());
		//this.vtnReCon.setLocationRelativeTo(null);
		this.vtnReCon.setVisible(true);
		this.vtnReCon.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Registrar")) {
			registrarClinica();
		}		
		else if (actionCommand.equals("Cancelar")) {
			vtnReCon.salir();
		}else if (actionCommand.equals("Limpiar")) {
			vtnReCon.blanquearCampos();
		}
	}
	
	private void registrarClinica(){
	  	try
		{
	    	if(vtnReCon.getCedulaP().equals("") || vtnReCon.getClinica().equals("") || vtnReCon.getFecha().equals("") 
	    			|| vtnReCon.getMedico().equals("") || vtnReCon.getMotivo().equals("")|| vtnReCon.getDiagnostico().equals("")|| vtnReCon.getTratamiento().equals("") )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnReCon.mostrarMensaje("Debe llenar todos los datos para poder registrar la Consulta");
	    	else
	    	{
	    		ConsultaBD consultaBD = new ConsultaBD();
	    		Consulta consulta = new Consulta(vtnReCon.getCedulaP(), vtnReCon.getClinica(),vtnReCon.getFecha(),vtnReCon.getMedico(),vtnReCon.getMotivo(),vtnReCon.getDiagnostico(),vtnReCon.getTratamiento());		    
	    		consultaBD .registrarConsulta(consulta);
	    		vtnReCon.mostrarMensaje("La Consulta fue registrada con exito");
	    		vtnReCon.blanquearCampos();
	    		vtnReCon.salir();
	    	}
		}catch(Exception e)
		{
			vtnReCon.mostrarMensaje("No se pudo registrar la Consulta, verifique que los datos sean correctos");
		}
	}
}