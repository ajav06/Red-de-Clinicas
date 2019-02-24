package modelo.Consulta;
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
		this.crearRegistro("consulta", "cedulaP,clinica,fecha,medico,motivo,diagnostico,tratamiento,estatus", "'"+consulta.getCedulaP()
				+"','"+consulta.getClinica()+"','"+consulta.getFecha()+"','"+consulta.getMedico()+"','"+consulta.getMotivo()+"','"+consulta.getDiagnostico()+"','"+consulta.getTratamiento()+"','a'");
	}
	
	public List<Consulta> consultarConsultas() throws SQLException {
		List<Consulta> Consultas = new ArrayList<Consulta>();
		resultSet = this.consultarTabla("consulta", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedulaP = resultSet.getString("cedulaP");
				String clinica = resultSet.getString("clinica");
				String fecha = resultSet.getString("fecha");
				String medico = resultSet.getString("medico");
				String motivo = resultSet.getString("motivo");
				String diagnostico = resultSet.getString("diagnostico");
				String tratamiento = resultSet.getString("tratamiento");
				Consulta Consulta = new Consulta(cedulaP,clinica,fecha,medico,motivo,diagnostico,tratamiento);
				Consultas.add(Consulta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
	        JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
		}
		this.cerrarComando();
		return Consultas;
	}
	public void actualizarConsulta(Consulta consulta) {
		this.actuRegistro("consulta", "clinica='"+consulta.getClinica()+"',fecha='"+
				consulta.getFecha()+"',medico='"+consulta.getMedico()+"',motivo='"+consulta.getMotivo()+"',diagnostico='"+consulta.getDiagnostico()+"',tratamiento='"+consulta.getTratamiento()+"'","cedulaP", "'"+consulta.getCedulaP()+"'");
	}
	
	public Consulta buscarConsulta(String cep) throws SQLException 
	{
		Consulta consulta = null;
		resultSet = this.buscarRegistro("consulta", "cedulaP", "'"+cep+"'");

		try {
			while (resultSet.next()) {
				String cedulaP = resultSet.getString("cedulaP");
				String clinica = resultSet.getString("clinica");
				String fecha = resultSet.getString("fecha");
				String medico = resultSet.getString("medico");
				String motivo = resultSet.getString("motivo");
				String diagnostico = resultSet.getString("diagnostico");
				String tratamiento = resultSet.getString("tratamiento");
				
				consulta = new Consulta(cedulaP,clinica,fecha,medico,motivo,diagnostico,tratamiento);	
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
				String cedulaP = resultSet.getString("cedulaP");
				String clinica = resultSet.getString("clinica");
				String fecha = resultSet.getString("fecha");
				String medico = resultSet.getString("medico");
				String motivo = resultSet.getString("motivo");
				String diagnostico = resultSet.getString("diagnostico");
				String tratamiento = resultSet.getString("tratamiento");
				Consulta consulta = new Consulta(cedulaP,clinica,fecha,medico,motivo,diagnostico,tratamiento);
				consultas.add(consulta);
			}
		} catch (SQLException e) {
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
			e.printStackTrace();
		}
		this.cerrarComando();
		return consultas;
	}


	public DefaultComboBoxModel nombresConsulta() throws SQLException{
		DefaultComboBoxModel cedulaP = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("SELECT cedulaP FROM consulta WHERE estatus = 'a'");
		try {
			while (resultSet.next())
				cedulaP.addElement(resultSet.getString("cedulaP"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return cedulaP;
	}

}
