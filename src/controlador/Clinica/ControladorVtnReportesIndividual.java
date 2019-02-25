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

import vista.Clinica.VentanaAgreagarClinica;
import vista.Clinica.VentanaClinicaModeloTabla;
import vista.Clinica.VentanaListaServClinicaModeloTabla;
import vista.Clinica.VentanaListaServiciosClinica;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Clinica.VentanaReporteClinica;
import vista.Clinica.VentanaReporteClinicaModeloTabla;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Clinica.OfertaServicio;
import modelo.Medico.MedicoBD;

public class ControladorVtnReportesIndividual implements ActionListener{
	private VentanaReporteClinica vtnReportes;
	private ClinicaBD cbd;
	private String codigo;	
	
	public ControladorVtnReportesIndividual(String c) throws SQLException {
		this.vtnReportes = new VentanaReporteClinica();
		this.vtnReportes.setLocationRelativeTo(null);
		this.vtnReportes.setVisible(true);
		this.vtnReportes.addListener(this);	
		codigo = c;
		cbd = new ClinicaBD();
		VentanaReporteClinicaModeloTabla vrcmt = new VentanaReporteClinicaModeloTabla(cbd.listaServiciosIndividiual(codigo));
		this.vtnReportes.cargarTabla(vrcmt);
		this.vtnReportes.setIntervenciones(String.valueOf(cbd.totalIntervencion()));
		this.vtnReportes.setConsultas(String.valueOf(cbd.totalConsulta()));
		this.vtnReportes.setTotales(String.valueOf(cbd.totales()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Salir")) {
			this.vtnReportes.salir();
		}
		
	}
}
