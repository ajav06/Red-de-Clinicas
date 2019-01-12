package modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
		this.crearRegistro("paciente", "cedula, nombres,apellidos,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial", "'"+paciente.getCedula()
				+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+formatter.format(paciente.getFechaNacimiento())+"','"+paciente.getAntePersonales()+"','"+paciente.getAnteFamiliares()+"',"
				+Integer.toString(paciente.getNroSeguro())+","+Integer.toString(paciente.getNroHistorial()));
	}
	
	public List<Paciente> consultarEstudiantes() throws ParseException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		ResultSet rs = null;
		resultSet = null;
		this.consultarTabla("paciente", "cedula, nombres,apellidos,fechanacimiento,antepersonales,antefamiliares,nrofeguro,nrohistorial", " WHERE estatus='a' ", rs);
		resultSet = rs;
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				String antePersonales = resultSet.getString("antepersonales");
				String anteFamiliares = resultSet.getString("antefamiliares");
				int nroSeguro = Integer.parseInt(resultSet.getString("nroseguro"));
				int nroHistorial = Integer.parseInt(resultSet.getString("nrohistorial"));
				Date fechaNacimiento = formatter.parse(resultSet.getString("fechanacimiento"));
				Paciente paciente = new Paciente(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientes;
	}
	
	public void actualizarPaciente(Paciente paciente) {
		this.actuRegistro("paciente", "nombres,apellidos,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial","'"+paciente.getNombre()+"','"
				+paciente.getApellido()+"','"+formatter.format(paciente.getFechaNacimiento())+"','"+paciente.getAntePersonales()+"','"+paciente.getAnteFamiliares()+"',"
				+Integer.toString(paciente.getNroSeguro())+","+Integer.toString(paciente.getNroHistorial()), "cedula", "'"+paciente.getCedula()+"'");
	}
	
	public Paciente buscarPaciente(String ced) throws SQLException, ParseException {
		ResultSet rs = null;
		resultSet = null;
		this.buscarRegistro("paciente", "cedula, nombres,apellidos,fechanacimiento,antepersonales,antefamiliares,nrofeguro,nrohistorial", "cedula", ced, rs);
		resultSet = rs;
		String cedula = resultSet.getString("cedula");
		String nombre = resultSet.getString("nombres");
		String apellido = resultSet.getString("apellidos");
		String antePersonales = resultSet.getString("antepersonales");
		String anteFamiliares = resultSet.getString("antefamiliares");
		int nroSeguro = Integer.parseInt(resultSet.getString("nroseguro"));
		int nroHistorial = Integer.parseInt(resultSet.getString("nrohistorial"));
		Date fechaNacimiento = formatter.parse(resultSet.getString("fechanacimiento"));
		Paciente paciente = new Paciente(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
		return paciente;
	}
	
	public void eliminarPaciente(String ced) {
		this.elimLogica("paciente", "cedula", ced);
	}

}
