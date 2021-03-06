//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Especialidad;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


import modelo.ConexionBD;
import modelo.Especialidad.Especialidad;

public class EspecialidadBD extends ConexionBD {
	
	private ResultSet resultSet;

	public EspecialidadBD() {
		super();
	}

	public void registarEspecialidad(Especialidad especialidad) {
		
		this.crearRegistro("especialidad", "codigo,nombre,descripcion","'"+especialidad.getCodigo()+"','"+especialidad.getNombre()+"','"+especialidad.getDescripcion()+"'" );

		
	}
	
	public List<Especialidad> consultarEspecialidades() throws SQLException {
		
		List<Especialidad> especialidades = new ArrayList<Especialidad>();
		resultSet = this.consultarTabla("especialidad", " WHERE estatus='a' ORDER BY codigo ASC ");
		
		try {
			while(resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				
				Especialidad especialidad = new Especialidad.Builder(codigo)
						.nombr(nombre)
						.desc(descripcion)
						.build();
				especialidades.add(especialidad);
				
			}
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return especialidades;
		
	}
	
	
	
	public void actualizarEspecialidad(Especialidad especialidad) {
		
		this.actuRegistro("especialidad", "codigo='"+especialidad.getCodigo()+"',nombre='"+especialidad.getNombre()+"',descripcion='"+especialidad.getDescripcion()+"'","codigo","'"+especialidad.getCodigo()+"'");
		
	
	}
	
	public Especialidad buscarEspecialidad(String cod)throws SQLException {
		Especialidad especialidad = null;
		resultSet = this.buscarRegistro("especialidad", "codigo", "'"+cod+"'");
		
		try {
			while (resultSet.next()) {
				
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				
				
				especialidad = new Especialidad.Builder(codigo)
						.nombr(nombre)
						.desc(descripcion)
						.build();			
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return especialidad;
		
	
		
	}
	
	public void eliminarEspecialidad(String cod) {
		
		this.elimLogica("especialidad","codigo","'"+cod+"'");
		
	}
	
	
	
	public List<Especialidad> consultarFiltrarEspecialidades(String filtro) throws SQLException{
		List<Especialidad> especialidades = new ArrayList<Especialidad>();
		resultSet = this.consultarTabla("especialidad", " WHERE "+filtro);
	
		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				
				Especialidad especialidad = new Especialidad.Builder(codigo)
						.nombr(nombre)
						.desc(descripcion)
						.build();
				especialidades.add(especialidad);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return especialidades;
		
		
		
		
	}
	
	public DefaultComboBoxModel nombresEspecialidades() throws SQLException{
		DefaultComboBoxModel nombres = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("SELECT nombre FROM especialidad WHERE estatus = 'a' ORDER BY codigo ASC");
		try {
			while (resultSet.next())
				nombres.addElement(resultSet.getString("nombre"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return nombres;
	}
	
	public int generarNuevoCodigoEspecialidad() throws NumberFormatException, SQLException {
		ResultSet rs=null;
		int ult = -1;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT COUNT (codigo) FROM especialidad";
	         rs = stmt.executeQuery(sql);
	         rs.next();
	         ult = rs.getInt("count");
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(null, this, e.getClass().getName()+": "+e.getMessage(), 0);
	      }
		return ult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//fin especialidadDB	
}
