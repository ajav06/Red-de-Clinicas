//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Consulta;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import modelo.ConexionBD;
import modelo.Consulta.Consulta;

public class ConsultaBD extends ConexionBD{
private ResultSet resultSet;
	
	public ConsultaBD()
	{
		super();
	}
	
	public void registrarConsulta(Consulta consulta) 
	{
		this.crearRegistro("consulta", "ced_paciente,clinica,fecha,medico,cod_oferta,motivo,diagnostico,tratamiento,estatus", "'"+consulta.getCedulaP()
				+"','"+consulta.getClinica()+"','"+String.valueOf(consulta.getFecha())+"','"+consulta.getMedico()+"','"+consulta.getServicio()+"','"+consulta.getMotivo()+"','"+consulta.getDiagnostico()+"','"+consulta.getTratamiento()+"','a'");
	}
	
	public List<Consulta> consultarConsultas() throws SQLException {
		List<Consulta> Consultas = new ArrayList<Consulta>();
		resultSet = this.consultarTabla("consulta", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedulaP = resultSet.getString("ced_paciente");
				String clinica = resultSet.getString("clinica");
				String fecha = resultSet.getString("fecha");
				String medico = resultSet.getString("medico");
				String servicio = resultSet.getString("cod_oferta");
				String motivo = resultSet.getString("motivo");
				String diagnostico = resultSet.getString("diagnostico");
				String tratamiento = resultSet.getString("tratamiento");
				Consulta Consulta = new Consulta.Builder(cedulaP)
						.clinic(clinica)
						.fech(fecha)
						.medic(medico)
						.motiv(motivo)
						.diagnostic(diagnostico)
						.tratamient(tratamiento)
						.build();
				Consultas.add(Consulta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
		}
		this.cerrarComando();
		return Consultas;
	}
	public void actualizarConsulta(Consulta consulta) {
		this.actuRegistro("consulta", "clinica='"+consulta.getClinica()+"',fecha='"+
				consulta.getFecha()+"',medico='"+consulta.getMedico()+"',cod_oferta='"+consulta.getServicio()+"',motivo='"+consulta.getMotivo()+"',diagnostico='"+consulta.getDiagnostico()+"',tratamiento='"+consulta.getTratamiento()+"'","ced_paciente", "'"+consulta.getCedulaP()+"'");
	}
	
	public Consulta buscarConsulta(String cep) throws SQLException 
	{
		Consulta consulta = null;
		resultSet = this.buscarRegistro("consulta", "ced_paciente", "'"+cep+"'");

		try {
			while (resultSet.next()) {
				String ced_paciente = resultSet.getString("ced_paciente");
				String clinica = resultSet.getString("clinica");
				String fecha = resultSet.getString("fecha");
				String medico = resultSet.getString("medico");
				String servicio = resultSet.getString("cod_oferta");
				String motivo = resultSet.getString("motivo");
				String diagnostico = resultSet.getString("diagnostico");
				String tratamiento = resultSet.getString("tratamiento");
				
				consulta = new Consulta.Builder(ced_paciente)
						.clinic(clinica)
						.fech(fecha)
						.medic(medico)
						.motiv(motivo)
						.diagnostic(diagnostico)
						.tratamient(tratamiento)
						.build();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return consulta;
	}
	
	public void eliminarConsulta(String cep) {
		this.elimLogica("consulta", "cedulaP", "'"+cep+"'");
	}
	
	public List<Consulta> consultarFiltrarConsultas(String filtro) throws SQLException {
		List<Consulta> consultas = new ArrayList<Consulta>();
		resultSet = this.consultarTabla("consulta", " WHERE "+filtro);
		try {
			while (resultSet.next()) {
				String ced_paciente = resultSet.getString("ced_paciente");
				String clinica = resultSet.getString("clinica");
				String fecha = resultSet.getString("fecha");
				String medico = resultSet.getString("medico");
				String servicio = resultSet.getString("cod_oferta");
				String motivo = resultSet.getString("motivo");
				String diagnostico = resultSet.getString("diagnostico");
				String tratamiento = resultSet.getString("tratamiento");
				Consulta consulta = new Consulta.Builder(ced_paciente)
											.clinic(clinica)
											.fech(fecha)
											.medic(medico)
											.motiv(motivo)
											.diagnostic(diagnostico)
											.tratamient(tratamiento)
											.build();	
				consultas.add(consulta);
			}
		} catch (SQLException e) {
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
			e.printStackTrace();
		}
		this.cerrarComando();
		return consultas;
	}


	public DefaultComboBoxModel nombresConsulta() throws SQLException{
		DefaultComboBoxModel cedulaP = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("SELECT ced_paciente FROM consulta WHERE estatus = 'a'");
		try {
			while (resultSet.next())
				cedulaP.addElement(resultSet.getString("ced_paciente"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return cedulaP;
	}

}
