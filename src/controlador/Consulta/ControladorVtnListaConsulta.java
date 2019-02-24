package controlador.Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controlador.Clinica.ControladorElimClinica;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Consulta.ControladorVtnRegistrarConsulta;
import vista.Consulta.VentanaConsultaModeloTabla;
import vista.Consulta.VentanaListaConsulta;
//import controlador.Clinica.ControladorVtnActuClinica;
//import controlador.Clinica.ControladorVtnAgreClinica;
//import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Consulta.VentanaListaConsulta;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import modelo.Consulta.Consulta;
import modelo.Consulta.ConsultaBD;
import controlador.Consulta.ControladorVtnConsultarConsulta;
import controlador.Consulta.ControladorVtnActualizarConsulta;

public class ControladorVtnListaConsulta implements ActionListener{
	private VentanaListaConsulta vtnListCon;
	Consulta consulta;
	public ControladorVtnListaConsulta() throws SQLException {
		super();
		this.vtnListCon = new VentanaListaConsulta();
		this.vtnListCon.setLocationRelativeTo(null);
		this.vtnListCon.setVisible(true);
		cargarDatosConsultas();
		this.vtnListCon.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("...")) {
			buscarConsulta();
		}		
		else if (actionCommand.equals("Consultar")) {
			ConsultarConsulta();
		}
		else if (actionCommand.equals("Actualizar")){
			actualizarConsulta();
		}
		else if (actionCommand.equals("Incluir")) {
			try{
				new ControladorVtnRegistrarConsulta();
			} catch (Exception x) {
				x.printStackTrace();
			}
		} else if (actionCommand.equals("")) {
			try {
				cargarDatosConsultas();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void buscarConsulta() 
	{
		try
		{
	    	if(vtnListCon.getCedulaP().equals(""))
	    		
	    	   //Deben estar todos los campos llenos para poder actualizar la Clinica
	    		vtnListCon.mostrarMensaje("Debe Llenar todos los datos para poder buscar la Consulta");
	    	else 
	    	{
	    		ConsultaBD consultaBD = new ConsultaBD();
	    		List<Consulta> consultas = new ArrayList<Consulta>();
	    		consultas = consultaBD.consultarFiltrarConsultas("lower(cedulap) like lower('%"+vtnListCon.getCedulaP()+"%') and estatus='a' ");
	    		this.vtnListCon.setResultados(new VentanaConsultaModeloTabla(consultas));
	    		vtnListCon.mostrarMensaje("La Consulta fue buscado con exito");
	    	}
	    	
		}
		catch(Exception e)
		{
			vtnListCon.mostrarMensaje(e.getClass()+e.getMessage());
		}
	}
	public void actualizarConsulta() {
		try {
		JTable tabla = vtnListCon.getTblConsultas();
		int fila = tabla.getSelectedRow();
		if (fila == -1) {
			vtnListCon.mostrarMensaje("Seleccione una Consulta del listado para consultarlo.");
		} else {
			String cedulaP = String.valueOf(tabla.getModel().getValueAt(fila, 0));
			ConsultaBD consultaBD = new ConsultaBD();	    
    		consulta = consultaBD.buscarConsulta(cedulaP);
    		new ControladorVtnActualizarConsulta(consulta);

			
		}
	} catch (Exception e) {
		vtnListCon.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
	}
	}
	public void ConsultarConsulta() {
		try {
		JTable tabla = vtnListCon.getTblConsultas();
		int fila = tabla.getSelectedRow();
		if (fila == -1) {
			vtnListCon.mostrarMensaje("Seleccione una Consulta del listado para consultarlo.");
		} else {
			String cedulaP = String.valueOf(tabla.getModel().getValueAt(fila, 0));
			ConsultaBD consultaBD = new ConsultaBD();	    
    		consulta = consultaBD.buscarConsulta(cedulaP);
    		new ControladorVtnConsultarConsulta(consulta);
			
		}
	} catch (Exception e) {
		vtnListCon.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
	}
	}
	
	
	public void cargarDatosConsultas() throws SQLException {
		ConsultaBD consultaBD = new ConsultaBD();
		List<Consulta> consultas = consultaBD.consultarConsultas();
	this.vtnListCon.setResultados(new VentanaConsultaModeloTabla(consultas));
	}
}
