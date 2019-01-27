package modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.ConexionBD;
import modelo.Paciente.Paciente;

public class PacienteBD extends ConexionBD{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private ResultSet resultSet;
	
	public PacienteBD() {
		super();
	}
	
	public void registrarPaciente(Paciente paciente) {
		this.crearRegistro("paciente", "cedula,nombres,apellidos,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial", "'"+paciente.getCedula()
				+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+formatter.format(paciente.getFechaNacimiento())+"','"+paciente.getAntePersonales()+"','"+paciente.getAnteFamiliares()+"',"
				+Integer.toString(paciente.getNroSeguro())+","+Integer.toString(paciente.getNroHistorial()));
	}
	
	public List<Paciente> consultarPacientes() throws SQLException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		resultSet = this.consultarTabla("paciente", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				String antePersonales = resultSet.getString("antepersonales");
				String anteFamiliares = resultSet.getString("antefamiliares");
				int nroSeguro = resultSet.getInt("nroseguro");
				int nroHistorial = resultSet.getInt("nrohistorial");
				Date fechaNacimiento = resultSet.getDate("fechanacimiento");
				Paciente paciente = new Paciente(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return pacientes;
	}
	
	public void actualizarPaciente(Paciente paciente) {
		this.actuRegistro("paciente", "nombres='"+paciente.getNombre()+"',apellidos='"+paciente.getApellido()+"',fechaNacimiento='"+
				formatter.format(paciente.getFechaNacimiento())+"',antePersonales='"+paciente.getAntePersonales()+"',anteFamiliares='"+
				paciente.getAnteFamiliares()+"',nroSeguro="+Integer.toString(paciente.getNroSeguro())+",nroHistorial="+
				Integer.toString(paciente.getNroHistorial()),"cedula", "'"+paciente.getCedula()+"'");
	}
	
	public Paciente buscarPaciente(String ced) throws SQLException {
		Paciente paciente = null;
		resultSet = this.buscarRegistro("paciente", "cedula", "'"+ced+"'");
		
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				String antePersonales = resultSet.getString("antepersonales");
				String anteFamiliares = resultSet.getString("antefamiliares");
				int nroSeguro = resultSet.getInt("nroseguro");
				int nroHistorial = resultSet.getInt("nrohistorial");
				Date fechaNacimiento = resultSet.getDate("fechanacimiento");
				paciente = new Paciente(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return paciente;
	}
	
	public void eliminarPaciente(String ced) {
		this.elimLogica("paciente", "cedula",  "'"+ced+"'");
	}
	
	public List<Paciente> consultarFiltrarPacientes(String filtro) throws SQLException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		resultSet = this.consultarTabla("paciente", " WHERE "+filtro);
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				String antePersonales = resultSet.getString("antepersonales");
				String anteFamiliares = resultSet.getString("antefamiliares");
				int nroSeguro = resultSet.getInt("nroseguro");
				int nroHistorial = resultSet.getInt("nrohistorial");
				Date fechaNacimiento = resultSet.getDate("fechanacimiento");
				Paciente paciente = new Paciente(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return pacientes;
	}

}
