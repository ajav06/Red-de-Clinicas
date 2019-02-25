//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Medico;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Medico.Trabajo;

import javax.swing.DefaultComboBoxModel;
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
				medico = new Medico.Builder(cedula)
						.cod_especialida(codespec)
						.nomb(nombre)
						.apellid(apellido)
						.fechaNacimient(fechan)
						.edo_civi(edoc)
						.estad(edo)
						.direccio(dir)
						.tlf_cas(tlfcasa)
						.nroTelefonic(tlfcelu)
						.emai(email)
						.build();
				medicos.add(medico);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this, e.getMessage(), 0);
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
				medico = new Medico.Builder(cedula)
						.cod_especialida(codespec)
						.nomb(nombre)
						.apellid(apellido)
						.fechaNacimient(fechan)
						.edo_civi(edoc)
						.estad(edo)
						.direccio(dir)
						.tlf_cas(tlfcasa)
						.nroTelefonic(tlfcelu)
						.emai(email)
						.build();
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
				medico = new Medico.Builder(cedula)
						.cod_especialida(codespec)
						.nomb(nombre)
						.apellid(apellido)
						.fechaNacimient(fechan)
						.edo_civi(edoc)
						.estad(edo)
						.direccio(dir)
						.tlf_cas(tlfcasa)
						.nroTelefonic(tlfcelu)
						.emai(email)
						.build();
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
				trabajo = new Trabajo.Builder(codigo)
						.cod_clinic(cod_clinica)
						.turn(turno)
						.build();
				horario.add(trabajo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return horario;
	}
	
	public int generarNuevoCodigoHorario() throws NumberFormatException, SQLException {
		ResultSet rs=null;
		int ult = -1;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT COUNT (codigo) FROM trabajomedico";
	         rs = stmt.executeQuery(sql);
	         rs.next();
	         ult = rs.getInt("count");
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
	      }
		return ult;
	}
	
	public void registrarHorarioNvo(String cedula, List<Trabajo> horario) {
		try {
			for (int i=0;i<10;i++) {
				int codnvo = generarNuevoCodigoHorario();
				this.crearRegistro("trabajomedico", "codigo,cod_clinica,ced_medico,turno,max_intervenciones,max_consultas",
						"'"+codnvo+"','"+horario.get(i).getCod_clinica()+"','"+cedula+"','"+horario.get(i).getTurno()+
						"',2,8");			
			}
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
		}
	}
	
	public void actualizarHorario(String cedula, List<Trabajo> horario) throws SQLException {
		try{
			for (int i=0;i<10;i++) {
				this.actuRegistro("trabajomedico", "cod_clinica='"+horario.get(i).getCod_clinica()+"'", "codigo", "'"+horario.get(i).getCodigo()+"'");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
		}
	}
	
	public int verificarMedico(String cedula, boolean eliminado) {
		ResultSet rs=null;
		String sql;
		
		if (eliminado) //verifica si existe un médico ELIMINADO con la cédula en cuestión
			sql = "SELECT COUNT(cedula) FROM medico WHERE estatus='e' AND cedula='"+cedula+"'";
		else //verifica si existe un médico ACTIVO con la cédula en cuestión
			sql = "SELECT COUNT(cedula) FROM medico WHERE estatus='a' AND cedula='"+cedula+"'";

		int n = -1;
		try {
			 rs = ejecutarQuery(sql);
	         rs.next();
	         n = rs.getInt("count");
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
	      }
		return n;
	}
	
	public void reingresarMedico(String cedula) {
		try {
			this.actuRegistro("medico", "estatus='a'", "cedula","'"+cedula+"'");
		}catch (Exception e) {
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
		}
	}

	public DefaultComboBoxModel nombresMedicos() throws SQLException{
		DefaultComboBoxModel nombres = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("SELECT nombres, apellidos FROM medico WHERE estatus = 'a' ");
		try {
			while (resultSet.next())
				nombres.addElement(resultSet.getString("nombres") +" "+ resultSet.getString("apellidos"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return nombres;
	}

	public List<ListadoCitas> consultarCitasMedico(String cedula, Date fecha_Ini, Date fecha_Fin, int tipo) throws SQLException{
		ListadoCitas cita= null;
		List<ListadoCitas> citasMedicas = new ArrayList<ListadoCitas>();
		resultSet = this.ejecutarQuery("SELECT trabajomedico.codigo, clinica.nombre FROM trabajomedico JOIN clinica ON cod_clinica=clinica.codigo WHERE ced_medico='"+cedula+"';");
		try {
			while(resultSet.next()) {
				ResultSet rS = null;
				if(tipo==1) {
					rS = this.consultarTabla("consulta", " WHERE cod_Trabajo='"+resultSet.getString("codigo")+"' AND fecha>='"
							+formatter.format(fecha_Ini)+"' AND fecha<='"+formatter.format(fecha_Fin)+"' ");
					while(rS.next()) {
						String ced_Paciente=rS.getString("ced_paciente");
						String tipo_Cita="Consulta";
						int cod_Trabajo=rS.getInt("cod_trabajo");
						String nomb_Clinica=resultSet.getString("nombre");
						Date fecha=rS.getDate("fecha");
						cita = new ListadoCitas(ced_Paciente, tipo_Cita, cod_Trabajo, nomb_Clinica, fecha);
						citasMedicas.add(cita);
					}
				}
				else if(tipo==2) {
					rS = this.consultarTabla("intervencion", " WHERE cod_Trabajo='"+resultSet.getString("codigo")+"' AND fecha>='"
							+formatter.format(fecha_Ini)+"' AND fecha<='"+formatter.format(fecha_Fin)+"' ");
					while(rS.next()) {
						String ced_Paciente=rS.getString("ced_paciente");
						String tipo_Cita="Intervencion Quirurgica";
						int cod_Trabajo=rS.getInt("cod_trabajo");
						String nomb_Clinica=resultSet.getString("nombre");
						Date fecha=rS.getDate("fecha");
						cita = new ListadoCitas(ced_Paciente, tipo_Cita, cod_Trabajo, nomb_Clinica, fecha);
						citasMedicas.add(cita);
					}
				}
				else {
					rS = this.consultarTabla("consulta", " WHERE cod_Trabajo='"+resultSet.getString("codigo")+"' AND fecha>='"
							+formatter.format(fecha_Ini)+"' AND fecha<='"+formatter.format(fecha_Fin)+"' ");
					while(rS.next()) {
						String ced_Paciente=rS.getString("ced_paciente");
						String tipo_Cita="Consulta";
						int cod_Trabajo=rS.getInt("cod_trabajo");
						String nomb_Clinica=resultSet.getString("nombre");
						Date fecha=rS.getDate("fecha");
						cita = new ListadoCitas(ced_Paciente, tipo_Cita, cod_Trabajo, nomb_Clinica, fecha);
						citasMedicas.add(cita);
					}
					rS = this.consultarTabla("intervencion", " WHERE cod_Trabajo='"+resultSet.getString("codigo")+"' AND fecha>='"
							+fecha_Ini+"' AND fecha<='"+fecha_Fin+"' ");
					while(rS.next()) {
						String ced_Paciente=rS.getString("ced_paciente");
						String tipo_Cita="Intervencion Quirurgica";
						int cod_Trabajo=rS.getInt("cod_trabajo");
						String nomb_Clinica=resultSet.getString("nombre");
						Date fecha=rS.getDate("fecha");
						cita = new ListadoCitas(ced_Paciente, tipo_Cita, cod_Trabajo, nomb_Clinica, fecha);
						citasMedicas.add(cita);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return citasMedicas;
	}
}
