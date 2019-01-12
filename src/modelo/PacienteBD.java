package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Paciente;
import modelo.Conexion;

public class PacienteBD extends Conexion{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public PacienteBD() {
		super();
	}
	
	public void registrarPaciente(Paciente paciente) {
		this.crearRegistro("paciente", "cedula, nombre,apellido,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial", "'"+paciente.getCedula()
				+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"',"+paciente.getFechaNacimiento().toString()+",'"+paciente.getAntePersonales()+"','"+paciente.getAnteFamiliares()+"',"
				+Integer.toString(paciente.getNroSeguro())+","+Integer.toString(paciente.getNroHistorial()));
	}
	
	public List<Paciente> consultarEstudiantes() throws ParseException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		ResultSet resultSet = null;
		this.consultarTabla("paciente", "cedula, nombre,apellido,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial", " WHERE estatus='a' ", resultSet);
		try {
			while (resultSet.next()) {
				
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String antePersonales = resultSet.getString("antePersonales");
				String anteFamiliares = resultSet.getString("anteFamiliares");
				int nroSeguro = Integer.parseInt(resultSet.getString("nroSeguro"));
				int nroHistorial = Integer.parseInt(resultSet.getString("nroHistorial"));
				Date fechaNacimiento = formatter.parse(resultSet.getString("fechaNacimiento"));
				Paciente paciente = new Paciente(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientes;
	}
	
	public void actualizarPaciente(Paciente paciente) {
		this.actuRegistro("paciente", "nombre,apellido,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial","'"+paciente.getNombre()+"','"
				+paciente.getApellido()+"',"+paciente.getFechaNacimiento().toString()+",'"+paciente.getAntePersonales()+"','"+paciente.getAnteFamiliares()+"',"
				+Integer.toString(paciente.getNroSeguro())+","+Integer.toString(paciente.getNroHistorial()), "cedula", "'"+paciente.getCedula()+"'");
	}

}
