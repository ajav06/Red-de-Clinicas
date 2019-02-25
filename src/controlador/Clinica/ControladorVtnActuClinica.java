//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import vista.Clinica.VentanaActualizarClinica;

public class ControladorVtnActuClinica implements ActionListener
{
	private VentanaActualizarClinica vtnActuCli;
	
	public ControladorVtnActuClinica(Clinica clinica) 
	{
		super();
		this.vtnActuCli = new VentanaActualizarClinica();
		this.vtnActuCli.setLocationRelativeTo(null);
		this.vtnActuCli.setVisible(true);
		this.vtnActuCli.addListener(this);
	     this.vtnActuCli.llenarCampos(clinica.getCodigo(), clinica.getNombre(),
	    clinica.getEstado(),clinica.getDireccion(), clinica.getTelefono(), 
		 clinica.getCorreo());;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Actualizar")) {
			actualizarClinica();
		}		
		else if (actionCommand.equals("Limpiar")) {
			vtnActuCli.blanquearCampos();
		}
		else if(actionCommand.equals("Cancelar"))
		{
			vtnActuCli.salir();
		} else if (actionCommand.equals("Consultar")) {
			try {
				ControladorVtnListaServClinica c = new ControladorVtnListaServClinica(vtnActuCli.getCodigo(), vtnActuCli.getNombre());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (actionCommand.equals("Consultar Reportes")) {
			try {
				ControladorVtnReportesIndividual c = new ControladorVtnReportesIndividual(vtnActuCli.getCodigo());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void actualizarClinica(){
	  	try
		{
	    	if(vtnActuCli.getCodigo().equals("") || vtnActuCli.getNombre().equals("") || vtnActuCli.getEstado().equals("") 
	    			|| vtnActuCli.getDireccion().equals("") || vtnActuCli.getTelefono().equals("")|| vtnActuCli.getCorreo().equals("") )
	    		 //Deben estar todos los campos llenos para poder actualizar la Clinica
	    	vtnActuCli.mostrarMensaje("Debe llenar todos los datos para poder actualizar la clinica");
	    		else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
		    	Clinica clinica = new Clinica.Builder(vtnActuCli.getCodigo())
						.nombre_clini(vtnActuCli.getNombre())
						.estado_clini(vtnActuCli.getEstado())
						.direccion_clini(vtnActuCli.getDireccion())
						.telefono_clini(vtnActuCli.getTelefono())
						.correo_clini(vtnActuCli.getCorreo())
						.build(); 
		    	clinicaBD.actualizarClinica(clinica);
		       vtnActuCli.mostrarMensaje("La Clinica fue actualizada con exito");
		    	vtnActuCli.blanquearCampos();
		    	vtnActuCli.salir();
	    	}
		}catch(Exception e)
		{
		vtnActuCli.mostrarMensaje("No se pudo actualizar la Clinica, verifique que los datos sean correctos");
			vtnActuCli.blanquearCampos();
		}
	}
}
