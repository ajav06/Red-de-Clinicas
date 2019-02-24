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
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Clinica.VentanaListaServiciosClinica;
import vista.Medico.VentanaMedicoModeloTabla;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Clinica.OfertaServicio;
import modelo.Medico.MedicoBD;

public class ControladorVtnListaServClinica implements ActionListener
{
	private VentanaListaServiciosClinica vtnLSVC;
	private ClinicaBD cbd;
	private String codmodi;
	String codigo_clinica;
	
	public ControladorVtnListaServClinica(String codclini, String nombclini) throws SQLException {
		cbd = new ClinicaBD();
		codmodi = null;
		this.vtnLSVC = new VentanaListaServiciosClinica(nombclini);
		this.vtnLSVC.setLocationRelativeTo(null);
		this.vtnLSVC.setVisible(true);
<<<<<<< HEAD
		this.vtnLSVC.addListener(this);	
		codigo_clinica = codclini;
		cargarServicios(codigo_clinica);
		this.vtnLSVC.cbDescServicio.setModel(cbd.nombresServicios());
=======
		this.vtnLSVC.addListener(this);		
		//cargarServicios(c);
>>>>>>> branch 'master' of https://github.com/ajav06/Red-de-Clinicas.git
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
<<<<<<< HEAD
			try {
				incluirOfertaServicio();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
=======
			//incluirOfertaServicio();
>>>>>>> branch 'master' of https://github.com/ajav06/Red-de-Clinicas.git
		}		
		else if (actionCommand.equals("Modificar")) {
<<<<<<< HEAD
			try {
				modificarOfertaServicio();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
=======
			//modificarOfertaServicio();
>>>>>>> branch 'master' of https://github.com/ajav06/Red-de-Clinicas.git
		} else if (actionCommand.equals("Limpiar")) {
			vtnLSVC.limpiar();
		} else if (actionCommand.equals("Salir")) {
			vtnLSVC.salir();
		} else if (actionCommand.equals("Buscar")) {
			try {
				filtrarServicios(codigo_clinica, vtnLSVC.tipoFiltrado());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void filtrarServicios(String codclini, char tipo) throws SQLException {
		this.vtnLSVC.mostrarMensaje("select (select nombre from servicio where servicio.codigo=ofertaservicio.cod_servicio and servicio.tipo_servicio = '"+tipo+"') as nombre, (select tipo_servicio from servicio where servicio.codigo = ofertaservicio.cod_servicio and servicio.tipo_servicio = '"+tipo+"') as tipo, precio from ofertaservicio where cod_clinica='"+codclini+"'");
		if (tipo!='x') {
			List<OfertaServicio> os = cbd.consultarServiciosClinicaFiltrado(codclini, tipo);
			this.vtnLSVC.setResultados(new VentanaListaServClinicaModeloTabla(os));
		} else {
			cargarServicios(codclini);
		}
	}

	private void modificarOfertaServicio() throws SQLException {
		if (this.vtnLSVC.tipoInterfaz == false) {
			this.vtnLSVC.interfazModificar();
			this.vtnLSVC.setPrecio(this.vtnLSVC.obtenerPrecioSeleccionado());
			codmodi = this.vtnLSVC.codSeleccionado();
		} else {
			if (this.vtnLSVC.camposLlenos()) {
			cbd.modificarPrecioServicio(this.vtnLSVC.getPrecio(), codmodi);
			codmodi = null;
			this.vtnLSVC.limpiar();
			this.vtnLSVC.mostrarMensaje("Precio del servicio modificado con éxito.");
			cargarServicios(codigo_clinica);
			} else {
				this.vtnLSVC.mostrarMensaje("Debe introducir el precio del servicio.");
			}
		}
	}

	private void incluirOfertaServicio() throws SQLException {
		if (cbd.verificarExistenciaOfertaServ(this.vtnLSVC.codServicioSeleccionado(), codigo_clinica)) {
			this.vtnLSVC.mostrarMensaje("El servicio que está intentando registrar ya existe.");
		} else {
			if (this.vtnLSVC.camposLlenos()) {
				cbd.registrarOfertaServ(this.vtnLSVC.codServicioSeleccionado(), codigo_clinica, this.vtnLSVC.getPrecio());
				this.vtnLSVC.limpiar();
				this.vtnLSVC.mostrarMensaje("El servicio se ha registrado con éxito.");
				cargarServicios(codigo_clinica);
			} else {
				this.vtnLSVC.mostrarMensaje("Debe introducir el precio del servicio.");
			}
		}
	}

	public void cargarServicios(String codclini) throws SQLException {
		List<OfertaServicio> os = cbd.consultarServiciosClinica(codclini);
		this.vtnLSVC.setResultados(new VentanaListaServClinicaModeloTabla(os));
	}
}
