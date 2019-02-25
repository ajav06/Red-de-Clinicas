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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.Clinica.VentanaClinicaModeloTabla;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Clinica.VentanaGeneralClinica;
import vista.Medico.VentanaMedicoModeloTabla;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Medico.MedicoBD;
public class ControladorVentanaGeneralClinica implements ActionListener 
{
	private VentanaGeneralClinica vtnGCli;
	Clinica clinica;
	public ControladorVentanaGeneralClinica() throws SQLException {
		super();
		this.vtnGCli = new VentanaGeneralClinica();
		this.vtnGCli.setLocationRelativeTo(null);
		this.vtnGCli.setVisible(true);
		cargarDatosClinicas();
		this.vtnGCli.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Activar")) {
			ActivarClinica();
		}		
		else if (actionCommand.equals("Cancelar")) {
			vtnGCli.salir();
		}
		
	}
	
	
	
	public void ActivarClinica() {
		try {
		JTable tabla = vtnGCli.getTblClinica();
		int fila = tabla.getSelectedRow();
		if (fila == -1) {
			vtnGCli.mostrarMensaje("Seleccione una Clinica del listado para consultarlo.");
		} else {
			String codigo = String.valueOf(tabla.getModel().getValueAt(fila, 0));
			ClinicaBD clinicaBD = new ClinicaBD();	    
    		clinicaBD.actuRegistro("clinica", "estatus='a'", "codigo", "'"+codigo+"'");
    		vtnGCli.mostrarMensaje("Clinica Reactivada exitosamente");
			cargarDatosClinicas();
		}
	} catch (Exception e) {
		vtnGCli.mostrarMensaje("No se puede activar la clinica");
	}
	}
	
	
	public void cargarDatosClinicas() throws SQLException {
		ClinicaBD clinicaBD = new ClinicaBD();
		List<Clinica> clinicas = clinicaBD.consultarFiltrarClinicas("estatus='e' AND codigo != '0' ORDER BY codigo ASC");
	this.vtnGCli.setResultados(new VentanaClinicaModeloTabla(clinicas));
	}


}
