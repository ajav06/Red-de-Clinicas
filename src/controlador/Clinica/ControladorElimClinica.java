package controlador.Clinica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import vista.Clinica.VentanaEliminarClinica;

public class ControladorElimClinica implements ActionListener
{
	private VentanaEliminarClinica vtnElimCli;
	public ControladorElimClinica(Clinica clinica) {
		super();
		this.vtnElimCli = new VentanaEliminarClinica();
		this.vtnElimCli.setLocationRelativeTo(null);
		this.vtnElimCli.setVisible(true);
		this.vtnElimCli.addListener(this);
		this.vtnElimCli.llenarCampos(clinica.getCodigo(), clinica.getNombre(), clinica.getEstado(), 
				clinica.getDireccion(), clinica.getTelefono(), 
				clinica.getCorreo());
	}
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Eliminar")) {
			eliminarClinica();
		}		
		else if (actionCommand.equals("Cancelar")) {
			vtnElimCli.blanquearCampos();
		}}
		private void eliminarClinica()
		{
		  	try
			{
		  		ClinicaBD clinicaBD = new ClinicaBD();	    
		    	clinicaBD.eliminarClinica(vtnElimCli.getCodigo());
		    	vtnElimCli.mostrarMensaje("La Clinica fue eliminado con exito");
		    	vtnElimCli.blanquearCampos();
			}catch(Exception e)
			{
				vtnElimCli.mostrarMensaje("No se pudo eliminar la Clinica, verifique que los datos sean correctos");
				vtnElimCli.blanquearCampos();
			}
		}
	}


