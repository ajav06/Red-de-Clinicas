package modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.ConexionBD;
import modelo.Paciente.Paciente;

public class PacienteBD extends ConexionBD{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private ResultSet resultSet;
	
	public PacienteBD() {
		super();
	}
	
	public void registrarPaciente(Paciente paciente) {
		this.crearRegistro("paciente", "cedula,nombres,apellidos,fecha_nacimiento,edo_civil,estado,direccion,tlf_casa,tlf_movil,email,asegurado", "'"+paciente.getCedula()
				+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+formatter.format(paciente.getFechaNacimiento())+"','"+paciente.getEdo_civil()+"','"+paciente.getEstado()+"','"
				+paciente.getDireccion()+"','"+paciente.getCasa()+"','"+paciente.getCelular()+"','"+paciente.getEmail()+"',"+Boolean.toString(paciente.isAsegurado()));
	}
	
	public List<Paciente> consultarPacientes() throws SQLException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		resultSet = this.consultarTabla("paciente", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
				char edoc = resultSet.getString("edo_civil").charAt(0);
				String edo = resultSet.getString("estado");
				String dir = resultSet.getString("direccion");
				String tlfcasa = resultSet.getString("tlf_casa");
				String tlfcelu = resultSet.getString("tlf_movil");
				String email = resultSet.getString("email");
				boolean asegurado = resultSet.getBoolean("asegurado");
				Paciente paciente = new Paciente(cedula, nombre, apellido, fechaNacimiento, edoc, edo, email, tlfcelu, tlfcasa, dir, asegurado);
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return pacientes;
	}
	
	public void actualizarPaciente(Paciente paciente) {
		this.actuRegistro("paciente", "nombres='"+paciente.getNombre()+"',apellidos='"+paciente.getApellido()+"',fecha_nacimiento='"+
				formatter.format(paciente.getFechaNacimiento())+"',edo_civil='"+paciente.getEdo_civil()+"',estado='"+paciente.getEstado()+"',direccion='"+paciente.getDireccion()
						+"',email='"+paciente.getEmail()+"',tlf_casa='"+paciente.getCasa()+"',tlf_movil='"+
						paciente.getCelular()+"', asegurado="+Boolean.toString(paciente.isAsegurado()),"cedula","'"+paciente.getCedula()+"'");
	}
	
	public Paciente buscarPaciente(String ced) throws SQLException {
		Paciente paciente = null;
		resultSet = this.buscarRegistro("paciente", "cedula", "'"+ced+"'");
		
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
				char edoc = resultSet.getString("edo_civil").charAt(0);
				String edo = resultSet.getString("estado");
				String dir = resultSet.getString("direccion");
				String tlfcasa = resultSet.getString("tlf_casa");
				String tlfcelu = resultSet.getString("tlf_movil");
				String email = resultSet.getString("email");
				boolean asegurado = resultSet.getBoolean("asegurado");
				paciente = new Paciente(cedula, nombre, apellido, fechaNacimiento, edoc, edo, email, tlfcelu, tlfcasa, dir, asegurado);
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
				Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
				char edoc = resultSet.getString("edo_civil").charAt(0);
				String edo = resultSet.getString("estado");
				String dir = resultSet.getString("direccion");
				String tlfcasa = resultSet.getString("tlf_casa");
				String tlfcelu = resultSet.getString("tlf_movil");
				String email = resultSet.getString("email");
				boolean asegurado = resultSet.getBoolean("asegurado");
				Paciente paciente = new Paciente(cedula, nombre, apellido, fechaNacimiento, edoc, edo, email, tlfcelu, tlfcasa, dir, asegurado);
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return pacientes;
	}
	
	public int verificarPaciente(String cedula, boolean eliminado) {
		ResultSet rs=null;
		String sql;
		
		if (eliminado) //verifica si existe un médico ELIMINADO con la cédula en cuestión
			sql = "SELECT COUNT(cedula) FROM paciente WHERE estatus='e' AND cedula='"+cedula+"'";
		else //verifica si existe un médico ACTIVO con la cédula en cuestión
			sql = "SELECT COUNT(cedula) FROM paciente WHERE estatus='a' AND cedula='"+cedula+"'";

		int n = -1;
		try {
			 rs = ejecutarQuery(sql);
	         rs.next();
	         n = rs.getInt("count");
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
		return n;
	}
	
	public void reingresarPaciente(String cedula) {
		try {
			this.actuRegistro("paciente", "estatus='a'", "cedula","'"+cedula+"'");
		}catch (Exception e) {
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
		}
	}

}
