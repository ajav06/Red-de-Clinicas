//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Intervencion;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.ConexionBD;
import modelo.Intervencion.Intervencion;

public class IntervencionBD extends ConexionBD{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private ResultSet resultSet;
	
	public IntervencionBD() {
		super();
	}
	
	public void registrarIntervencion(Intervencion intervencion) {
		this.crearRegistro("intervencion", "ced_paciente,cod_trabajo,cod_oferta,fecha", "'"+intervencion.getCedula()
				+"','"+intervencion.getCodigoT()+"','"+intervencion.getCodigoO()+"','"+formatter.format(intervencion.getFecha())+"'"    );
	}
	
	public List<Intervencion> consultarIntervenciones() throws SQLException {
		List<Intervencion> intervenciones = new ArrayList<Intervencion>();
		resultSet = this.consultarTabla("intervencion", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String codigoT = resultSet.getString("codigoT");
				String codigoO = resultSet.getString("codigoO");
				Date fecha= resultSet.getDate("fecha");
				
				Intervencion intervencion = new Intervencion(cedula, codigoT, codigoO, fecha);
				intervenciones.add(intervencion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return intervenciones;
	}
	
	public void actualizarIntervencion(Intervencion intervencion) {
		this.actuRegistro("intervencion", "ced_paciente='"+intervencion.getCedula()+"',cod_trabajo='"+intervencion.getCodigoT()+"',cod_oferta='"+intervencion.getCodigoO()+ "',fecha='"+
				formatter.format(intervencion.getFecha()),"fecha","'"+intervencion.getFecha()+"'");
	}
	
	public Intervencion buscarIntervencion(String ced) throws SQLException {
		Intervencion intervencion = null;
		resultSet = this.buscarRegistro("intervencion", "ced_paciente", "'"+ced+"'");
		
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String codigoT = resultSet.getString("codigoT");
				String codigoO = resultSet.getString("codigoO");
				Date fecha = resultSet.getDate("fecha");
				
				intervencion = new Intervencion(cedula, codigoT, codigoO, fecha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return intervencion;
	}
	
	
	public List<Intervencion> consultarFiltrarIntervencion(String filtro) throws SQLException {
		List<Intervencion> intervenciones = new ArrayList<Intervencion>();
		resultSet = this.consultarTabla("intervencion", " WHERE "+filtro);
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String codigoT = resultSet.getString("CodigoT");
				String codigoO = resultSet.getString("CodigoO");
				Date fecha = resultSet.getDate("fecha");
				
				Intervencion intervencion = new Intervencion(cedula, codigoT, codigoO, fecha);
				intervenciones.add(intervencion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return intervenciones;
	}
	
	
	

}
