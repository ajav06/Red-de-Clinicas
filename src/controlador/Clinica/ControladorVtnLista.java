package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.Clinica.VentanaClinicaModeloTabla;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Clinica.VentanaListaClinica;
import vista.Medico.VentanaMedicoModeloTabla;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Medico.MedicoBD;
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
	
	public void buscarClinica() 
	{
		try
		{
	    	if(vtnListCli.getNombre().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la Clinica
	    		vtnListCli.mostrarMensaje("Debe Llenar todos los datos para poder buscar la Clinica");
	    	else 
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
	    		List<Clinica> clinicas = new ArrayList<Clinica>();
	    		clinicas = clinicaBD.consultarFiltrarClinicas("lower(nombre) like lower('%"+vtnListCli.getNombre()+"%') and estatus='a' order by codigo asc");
	    		this.vtnListCli.setResultados(new VentanaClinicaModeloTabla(clinicas));
	    		vtnListCli.mostrarMensaje("La Clinica fue buscado con exito");
	    	}
	    	
		}
		catch(Exception e)
		{
			vtnListCli.mostrarMensaje(e.getClass()+e.getMessage());
		}
	}
	
	public void actualizarClinica() {
		try {
		JTable tabla = vtnListCli.getTblClinica();
		int fila = tabla.getSelectedRow();
		if (fila == -1) {
			vtnListCli.mostrarMensaje("Seleccione una Clinica del listado para consultarlo.");
		} else {
			String codigo = String.valueOf(tabla.getModel().getValueAt(fila, 0));
			ClinicaBD clinicaBD = new ClinicaBD();	    
    		clinica = clinicaBD.buscarClinica(codigo);
    		new ControladorVtnActuClinica(clinica);
			
		}
	} catch (Exception e) {
		vtnListCli.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
	}
	}
	
	public void eliminarClinica() {
		try {
			JTable tabla = vtnListCli.getTblClinica();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnListCli.mostrarMensaje("Seleccione una Clinica del listado para consultarlo.");
			} else {
				String codigo = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				ClinicaBD clinicaBD = new ClinicaBD();	    
	    		clinica = clinicaBD.buscarClinica(codigo);
	    		new ControladorElimClinica(clinica);
				
			}
		} catch (Exception e) {
			vtnListCli.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	public void cargarDatosClinicas() throws SQLException {
		ClinicaBD clinicaBD = new ClinicaBD();
		List<Clinica> clinicas = clinicaBD.consultarClinicas();
	this.vtnListCli.setResultados(new VentanaClinicaModeloTabla(clinicas));
	}

}
