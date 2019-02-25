package modelo.Servicio;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.ConexionBD;

public class ServicioBD extends ConexionBD{
	private ResultSet resultSet;
	
	public ServicioBD() {
		super();
	}
	
	public void incluirServicio(Servicio ser) {
		this.crearRegistro("servicio", "codigo, cod_especialidad, nombre, descripcion, 	tipo_servicio", "'"+ser.getCodigo()+"', '"+ser.getCod_especialidad()+"', '"
							+ser.getNombre()+"', '"+ser.getDescripcion()+"', '"+ser.getTipo()+"'");
	}
	
	public List<Servicio> listaServicios() throws SQLException{
		List<Servicio> servicios = new ArrayList<Servicio>();
		resultSet = this.ejecutarQuery("SELECT servicio.codigo, servicio.nombre, servicio.descripcion, especialidad.nombre, servicio.tipo_servicio FROM servicio "
				+ "JOIN especialidad ON cod_especialidad=especialidad.codigo WHERE servicio.estatus='a' ORDER BY servicio.codigo ASC;");
		while(resultSet.next()) {
			String codigo = resultSet.getString(1);
			String cod_especialidad = resultSet.getString(4);
			String nombre = resultSet.getString(2);
			String descripcion = resultSet.getString(3);
			char tipo = resultSet.getString(5).charAt(0);
			Servicio servicio= new Servicio.Builder(codigo)
					.cod_especialida(cod_especialidad)
					.nombr(nombre)
					.descripcio(descripcion)
					.tip(tipo)
					.build();
			servicios.add(servicio);
		}
		this.cerrarComando();
		return servicios;
	}
	
	public List<Servicio> listaServiciosFiltro(String cod_esp) throws SQLException{
		List<Servicio> servicios = new ArrayList<Servicio>();
		resultSet = this.ejecutarQuery("SELECT servicio.codigo, servicio.nombre, servicio.descripcion, especialidad.nombre, servicio.tipo_servicio FROM servicio "
				+ "JOIN especialidad ON cod_especialidad=especialidad.codigo WHERE servicio.estatus='a' AND "+cod_esp+" ORDER BY servicio.codigo ASC;");
		while(resultSet.next()) {
			String codigo = resultSet.getString(1);
			String cod_especialidad = resultSet.getString(4);
			String nombre = resultSet.getString(2);
			String descripcion = resultSet.getString(3);
			char tipo = resultSet.getString(5).charAt(0);
			Servicio servicio= new Servicio.Builder(codigo)
					.cod_especialida(cod_especialidad)
					.nombr(nombre)
					.descripcio(descripcion)
					.tip(tipo)
					.build();
			servicios.add(servicio);
		}
		this.cerrarComando();
		return servicios;
	}
	
	public void actualizarServicio(Servicio ser) {
		this.actuRegistro("servicio", "cod_especialidad='"+ser.getCod_especialidad()+"', nombre='"+ser.getNombre()
			+"', descripcion='"+ser.getDescripcion()+"', tipo_servicio='"+ser.getTipo()+"'", "codigo", "'"+ser.getCodigo()+"'");
	}
	
	public void eliminarServicio(String codigo) {
		this.elimLogica("servicio", "codigo", "'"+codigo+"'");
	}
	
	public int verificarServicio(String codigo, boolean eliminado) {
		ResultSet rs=null;
		String sql;
		
		if (eliminado) //verifica si existe un servicio ELIMINADO con la c�dula en cuesti�n
			sql = "SELECT COUNT(codigo) FROM servicio WHERE estatus='e' AND codigo='"+codigo+"'";
		else //verifica si existe un servicio ACTIVO con la c�dula en cuesti�n
			sql = "SELECT COUNT(codigo) FROM servicio WHERE estatus='a' AND codigo='"+codigo+"'";

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
	
	public void reactivarServicio(String codigo) {
		try {
			this.actuRegistro("servicio", "estatus='a'", "codigo","'"+codigo+"'");
		}catch (Exception e) {
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
		}
	}
	
	public int generarNuevoCodigoServicio() throws NumberFormatException, SQLException {
		int ult = -1;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT COUNT(codigo) FROM servicio";
	         resultSet = stmt.executeQuery(sql);
	         resultSet.next();
        	 ult = resultSet.getInt("count");
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
	      }
		return ult;
	}
	
	public Servicio buscarServicio(String codigoS) throws SQLException {
		Servicio servicio = null;
		resultSet = this.ejecutarQuery("SELECT servicio.codigo, servicio.nombre, servicio.descripcion, especialidad.nombre, servicio.tipo_servicio FROM servicio "
				+ "JOIN especialidad ON cod_especialidad=especialidad.codigo WHERE servicio.estatus='a' AND servicio.codigo='"+codigoS+"' ORDER BY servicio.codigo ASC;");
		while(resultSet.next()) {
			String codigo = resultSet.getString(1);
			String cod_especialidad = resultSet.getString(4);
			String nombre = resultSet.getString(2);
			String descripcion = resultSet.getString(3);
			char tipo = resultSet.getString(5).charAt(0);
			servicio= new Servicio.Builder(codigo)
					.cod_especialida(cod_especialidad)
					.nombr(nombre)
					.descripcio(descripcion)
					.tip(tipo)
					.build();
			}
		this.cerrarComando();
		return servicio;
	}
	
	public Servicio buscarServicio2(String codigoS) throws SQLException {
		Servicio servicio = null;
		resultSet = this.ejecutarQuery("SELECT servicio.codigo, servicio.nombre, servicio.descripcion, especialidad.codigo, servicio.tipo_servicio FROM servicio "
				+ "JOIN especialidad ON cod_especialidad=especialidad.codigo WHERE servicio.estatus='a' AND servicio.codigo='"+codigoS+"' ORDER BY servicio.codigo ASC;");
		while(resultSet.next()) {
			String codigo = resultSet.getString(1);
			String cod_especialidad = resultSet.getString(4);
			String nombre = resultSet.getString(2);
			String descripcion = resultSet.getString(3);
			char tipo = resultSet.getString(5).charAt(0);
			servicio= new Servicio.Builder(codigo)
					.cod_especialida(cod_especialidad)
					.nombr(nombre)
					.descripcio(descripcion)
					.tip(tipo)
					.build();
			}
		this.cerrarComando();
		return servicio;
	}
}
