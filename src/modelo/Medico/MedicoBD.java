package modelo.Medico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Medico.Trabajo;

import javax.swing.JOptionPane;

import modelo.ConexionBD;

public class MedicoBD extends ConexionBD{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private ResultSet resultSet;
	private List<Trabajo> horario;
	
	public MedicoBD() {
		super();
	}
	
	public void registrarMedico(Medico medico) {
		this.crearRegistro("medico", 
				"cedula,cod_especialidad,nombres,apellidos,fecha_nacimiento,edo_civil,"
				+ "estado,direccion,tlf_casa,tlf_movil,email",
				"'"+medico.getCedula()+"','"+medico.getCod_especialidad()+"','"+medico.getNombre()+
				"','"+medico.getApellido()+"','"+formatter.format(medico.getFechaNacimiento())+
				"','"+medico.getEdo_civil()+"','"+medico.getEstado()+"','"+medico.getDireccion()+
				"','"+medico.getTlf_casa()+"','"+medico.getNroTelefonico()+
				"','"+medico.getEmail()+"'");
	}
	
	public List<Medico> consultarMedicos() throws SQLException {
		List<Medico> medicos = new ArrayList<Medico>();
		Medico medico = null;
		resultSet = this.consultarTabla("medico", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String codespec = resultSet.getString("cod_especialidad");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechan = resultSet.getDate("fecha_nacimiento");
				char edoc = resultSet.getString("edo_civil").charAt(0);
				String edo = resultSet.getString("estado");
				String dir = resultSet.getString("direccion");
				String tlfcasa = resultSet.getString("tlf_casa");
				String tlfcelu = resultSet.getString("tlf_movil");
				String email = resultSet.getString("email");
				medico = new Medico(cedula, codespec, nombre, apellido, fechan, edoc, edo, dir, tlfcasa, tlfcelu, email);
				medicos.add(medico);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
		this.cerrarComando();
		return medicos;
	}
	
	public void actualizarMedico(Medico medico) {
		this.actuRegistro("medico", "nombres='"+medico.getNombre()+"',apellidos='"+
	medico.getApellido()+"',fecha_nacimiento='"+formatter.format(medico.getFechaNacimiento())+
	"',edo_civil='"+medico.getEdo_civil()+"',estado='"+medico.getEstado()+"',direccion='"+medico.getDireccion()
	+"',email='"+medico.getEmail()+"',tlf_casa='"+medico.getTlf_casa()+"',tlf_movil='"+
	medico.getNroTelefonico()+"'","cedula","'"+medico.getCedula()+"'");
	}
	
	public Medico buscarMedico(String ced) throws SQLException {
		Medico medico = null;
		resultSet = this.buscarRegistro("Medico", "cedula", "'"+ced+"'");
		
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String codespec = resultSet.getString("cod_especialidad");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechan = resultSet.getDate("fecha_nacimiento");
				char edoc = resultSet.getString("edo_civil").charAt(0);
				String edo = resultSet.getString("estado");
				String dir = resultSet.getString("direccion");
				String tlfcasa = resultSet.getString("tlf_casa");
				String tlfcelu = resultSet.getString("tlf_movil");
				String email = resultSet.getString("email");
				medico = new Medico(cedula, codespec, nombre, apellido, fechan, edoc, edo, dir, tlfcasa, tlfcelu, email);
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
		Medico medico = null;
		List<Medico> medicos = new ArrayList<Medico>();
		resultSet = this.consultarTabla("medico", " WHERE "+filtro);
		try {
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				String codespec = resultSet.getString("cod_especialidad");
				String nombre = resultSet.getString("nombres");
				String apellido = resultSet.getString("apellidos");
				Date fechan = resultSet.getDate("fecha_nacimiento");
				char edoc = resultSet.getString("edo_civil").charAt(0);
				String edo = resultSet.getString("estado");
				String dir = resultSet.getString("direccion");
				String tlfcasa = resultSet.getString("tlf_casa");
				String tlfcelu = resultSet.getString("tlf_movil");
				String email = resultSet.getString("email");
				medico = new Medico(cedula, codespec, nombre, apellido, fechan, edoc, edo, dir, tlfcasa, tlfcelu, email);
				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return medicos;
	}
	
	public List<Trabajo> consultarHorario(String cedula){
		Trabajo trabajo = null;
		horario = new ArrayList<Trabajo>();
		resultSet = this.buscarRegistroSinEstatus("trabajomedico", "ced_medico", "'"+cedula+"'");
		try {
			while (resultSet.next()){
				String codigo = resultSet.getString("codigo");
				String cod_clinica = resultSet.getString("cod_clinica");
				String turno = resultSet.getString("turno");
				trabajo = new Trabajo(codigo, cod_clinica, turno);
				horario.add(trabajo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return horario;
	}
	
	public void guardarHorario(List<Trabajo> horario) {
		
	}
}
