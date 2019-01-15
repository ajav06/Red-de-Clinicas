package modelo.Medico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import modelo.ConexionBD;
import modelo.Paciente.Paciente;

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
				Date fechan = resultSet.getDate("fechan");
				String email = resultSet.getString("email");
				String tlfcasa = resultSet.getString("tlfcasa");
				String tlfcelu = resultSet.getString("tlfcelu");
				String codespec = resultSet.getString("codespec");
				String almamater = resultSet.getString("almamater");
				int annogrado = resultSet.getInt("annogrado");
				String[] horariomat = {"Proximamente"};
				String[] horariovesp = {"Proximamente"};
				boolean estudia = resultSet.getBoolean("estudia");
				char estatus = resultSet.getString("estatus").charAt(0);
				Medico medico = new Medico(cedula,nombre,apellido,fechan,email,tlfcasa,tlfcelu,codespec,almamater,annogrado,horariomat,horariovesp,estudia,estatus);
				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return medicos;
	}
	
	public void actualizarMedico(Medico medico) {
		this.actuRegistro("medico", "nombre='"+medico.getNombre()+"',apellido='"+medico.getApellido()+"',fechan='"+formatter.format(medico.getFechaNacimiento())+"',email='"+medico.getEmail()+"',tlfcasa='"+medico.getTlfcasa()+"',tlfcelu='"+medico.getTlfcelular()+"',horariomat='{\"Proximamente\"}',horariovesp='{\\\"Proximamente\\\"}',estudia='"+String.valueOf(medico.isEstudia()),"cedula",medico.getCedula());
	}
	
	public Medico buscarMedico(String ced) throws SQLException {
		Medico medico = null;
		resultSet = this.buscarRegistro("medico", "cedula", "'"+ced+"'");
		
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechan = resultSet.getDate("fechan");
				String email = resultSet.getString("email");
				String tlfcasa = resultSet.getString("tlfcasa");
				String tlfcelu = resultSet.getString("tlfcelu");
				String codespec = resultSet.getString("codespec");
				String almamater = resultSet.getString("almamater");
				int annogrado = resultSet.getInt("annogrado");
				String[] horariomat = {"Proximamente"};
				String[] horariovesp = {"Proximamente"};
				boolean estudia = resultSet.getBoolean("estudia");
				char estatus = resultSet.getString("estatus").charAt(0);
				medico = new Medico(cedula,nombre,apellido,fechan,email,tlfcasa,tlfcelu,codespec,almamater,annogrado,horariomat,horariovesp,estudia,estatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return medico;
	}
	
	public void eliminarMedico(String ced) {
		this.elimLogica("medico", "cedula",  "'"+ced+"'");
	}
	
	public List<Medico> consultarFiltrarMedicos(String filtro) throws SQLException {
		List<Medico> medicos = new ArrayList<Medico>();
		resultSet = this.consultarTabla("medico", " WHERE "+filtro);
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechan = resultSet.getDate("fechan");
				String email = resultSet.getString("email");
				String tlfcasa = resultSet.getString("tlfcasa");
				String tlfcelu = resultSet.getString("tlfcelu");
				String codespec = resultSet.getString("codespec");
				String almamater = resultSet.getString("almamater");
				int annogrado = resultSet.getInt("annogrado");
				String[] horariomat = {"Proximamente"};
				String[] horariovesp = {"Proximamente"};
				boolean estudia = resultSet.getBoolean("estudia");
				char estatus = resultSet.getString("estatus").charAt(0);
				Medico medico = new Medico(cedula,nombre,apellido,fechan,email,tlfcasa,tlfcelu,codespec,almamater,annogrado,horariomat,horariovesp,estudia,estatus);
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
