package modelo.Medico;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import modelo.ConexionBD;
import modelo.Paciente.Paciente;

public class MedicoBD extends ConexionBD{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private ResultSet resultSet;
	
	public MedicoBD() {
		super();
	}
	
	public void registrarMedico(Medico medico) {
		this.crearRegistro("medico", "cedula,nombres,apellidos,fechaNacimiento,antePersonales,anteFamiliares,nroSeguro,nroHistorial", "'"+paciente.getCedula()
				+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+formatter.format(paciente.getFechaNacimiento())+"','"+paciente.getAntePersonales()+"','"+paciente.getAnteFamiliares()+"',"
				+Integer.toString(paciente.getNroSeguro())+","+Integer.toString(paciente.getNroHistorial()));
	}
	
}
