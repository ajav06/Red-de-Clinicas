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
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Clinica.VentanaListaServiciosClinica;
import vista.Medico.VentanaMedicoModeloTabla;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Medico.MedicoBD;

public class ControladorVtnListaServClinica implements ActionListener
{
	private VentanaListaServiciosClinica vtnLSVC;
	private ClinicaBD cbd;
	
	public ControladorVtnListaServClinica(String codclini) {
		cbd = new ClinicaBD();
		this.vtnLSVC = new VentanaListaServiciosClinica();
		this.vtnLSVC.setLocationRelativeTo(null);
		this.vtnLSVC.setVisible(true);
		this.vtnLSVC.addListener(this);		
		cargarServicios(c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
			incluirOfertaServicio();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarOfertaServicio();
		} else if (actionCommand.equals("Limpiar")) {
			vtnLSVC.limpiar();
		} else if (actionCommand.equals("Salir")) {
			vtnLSVC.salir();
		}
	}
	
	public void cargarServicios(String codclini) {
		
	}
}
