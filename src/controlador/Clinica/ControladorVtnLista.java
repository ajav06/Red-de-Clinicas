package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import vista.Clinica.VentanaClinicaModeloTabla;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;

import vista.Clinica.VentanaListaClinica;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
public class ControladorVtnLista implements ActionListener
{
	private VentanaListaClinica vtnListCli;
	Clinica clinica;
	
	public ControladorVtnLista() throws SQLException {
		super();
		this.vtnListCli = new VentanaListaClinica();
		this.vtnListCli.setLocationRelativeTo(null);
		this.vtnListCli.setVisible(true);
		cargarDatosClinicas();
		this.vtnListCli.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("...")) {
			buscarClinica();
		}		
		else if (actionCommand.equals("Actualizar")) {
			actualizarClinica();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarClinica();
		}
		else if (actionCommand.equals("Incluir")) {
			try{
				new ControladorVtnAgreClinica();
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}
	
	public void buscarClinica() {
		try
		{
	    	if(vtnListCli.getCodigo().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la Clinica
	    		vtnListCli.mostrarMensaje("Debe Llenar todos los datos para poder buscar la Clinica");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
	    		List<Clinica> clinicas = new ArrayList<Clinica>();
	    		clinica = clinicaBD.buscarClinica(vtnListCli.getCodigo());
	    		clinicas.add(clinica);
	    		this.vtnListCli.setResultados(new VentanaClinicaModeloTabla(clinicas));
	    		vtnListCli.mostrarMensaje("La Clinica fue buscado con exito");
	    	}
		}catch(Exception e)
		{
			vtnListCli.mostrarMensaje("No se pudo buscar la Clinica, verifique que los datos sean correctos");
		}
	}
	
	public void actualizarClinica() {
		try
		{
	    	if(vtnListCli.getCodigo().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la Clinica
	    		vtnListCli.mostrarMensaje("Debe llenar todos los datos para poder buscar la Clinica");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();	    
	    		clinica = clinicaBD.buscarClinica(vtnListCli.getCodigo());
	    		new ControladorVtnActuClinica(clinica);
	    	}
		}catch(Exception e)
		{
			vtnListCli.mostrarMensaje(e.getClass() + e.getMessage());
		}
	}
	
	public void eliminarClinica() {
		try
		{
	    	if(vtnListCli.getCodigo().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la Clinica
	    		vtnListCli.mostrarMensaje("Debe llenar todos los datos para poder buscar la Clinica");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();	   
	    		clinica = clinicaBD.buscarClinica(vtnListCli.getCodigo());
	    		new ControladorElimClinica(clinica);
	    	}
		}catch(Exception e)
		{
			vtnListCli.mostrarMensaje("No se pudo buscar la Clinica, verifique que los datos sean correctos");
		}
	}
	
	public void cargarDatosClinicas() throws SQLException {
		ClinicaBD clinicaBD = new ClinicaBD();
		List<Clinica> clinicas = clinicaBD.consultarClinicas();
	this.vtnListCli.setResultados(new VentanaClinicaModeloTabla(clinicas));
	}

}
