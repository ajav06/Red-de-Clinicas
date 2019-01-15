package modelo.Medico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import modelo.ConexionBD;

public class MedicoBD extends ConexionBD{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private ResultSet resultSet;
	
	public MedicoBD() {
		super();
	}
	
	public void registrarMedico(Medico medico) {
		this.crearRegistro("medico", "cedula,nombre,apellido,fechan,email,tlfcasa,tlfcelu,codespec,almamater,annogrado,horariomat,horariovesp,estudia,estatus", "'"+medico.getCedula()
		+"','"+medico.getNombre()+"','"+medico.getApellido()+"','"+formatter.format(medico.getFechaNacimiento())+"','"+medico.getEmail()+"','"+medico.getTlfcasa()+"','"+medico.getTlfcelular()+medico.getCodespec()+"','"+medico.getAlmamater()+"','"+Integer.toString(medico.getAnnogrado())+"','"+generarArrayHorarios(medico)+"','"+String.valueOf(medico.isEstudia())+"','a'");
	}
	
	public List<Medico> consultarMedicos() throws SQLException {
		List<Medico> medicos = new ArrayList<Medico>();
		resultSet = this.consultarTabla("medico", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechaNacimiento = resultSet.getDate("fechan");
				String email = resultSet.getString("email");
				
				Medico medico = new Medico(cedula,nombre, apellido,antePersonales,anteFamiliares,nroSeguro,nroHistorial,fechaNacimiento);
				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return medicos;
	}
	
	public String generarArrayHorarios(Medico medico) {
		String horarios="{\"";
		for (int i = 0; i < medico.getHorariomat().length; i++) {
			horarios += medico.getHorariomat()[i];
			if (i != (medico.getHorariomat().length-1))
				horarios += "\",\"";
		}
		horarios += "\"}','{\"";
		for (int i = 0; i < medico.getHorariovesp().length; i++) {
			horarios += medico.getHorariovesp()[i];
			if (i != (medico.getHorariovesp().length-1))
				horarios += "\",\"";
		}
		horarios += "\"}";
		return horarios;
	}
}
