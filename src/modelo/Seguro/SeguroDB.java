package modelo.Seguro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.ConexionBD;

public class SeguroDB extends ConexionBD {
	private ResultSet resultSet;
	
	public SeguroDB() {
		super();
	}
	
	public void incluirSeguro(Seguro seguro) {
		this.crearRegistro("seguro", "codigo,nombre,descripcion", Integer.toString(seguro.getCodigo())+",'"+seguro.getNombre()
		+"','"+seguro.getDescripcion()+"'");
	}
	
	public List<Seguro> consultarSeguros() throws SQLException{
		List<Seguro> seguros = new ArrayList<Seguro>();
		resultSet = this.consultarTabla("seguro"," WHERE estatus='a' ");
		while(resultSet.next()) {
			int codigo = resultSet.getInt("codigo");
			String nombre = resultSet.getString("nombre");
			String descripcion = resultSet.getString("descripcion");
			Seguro seguro = new Seguro(codigo, nombre, descripcion);
			seguros.add(seguro);
		}
		this.cerrarComando();
		return seguros;
	}
	
	public Seguro buscarSeguro(String cod) throws SQLException {
		Seguro seguro = null;
		resultSet = this.buscarRegistro("seguro", "codigo", cod);
		while(resultSet.next()) {
			int codigo = resultSet.getInt("codigo");
			String nombre = resultSet.getString("nombre");
			String descripcion = resultSet.getString("descripcion");
			seguro = new Seguro(codigo, nombre, descripcion);
		}
		this.cerrarComando();
		return seguro;
	}
	
	public void eliminarSeguro(String cod) {
		this.elimLogica("seguro","codigo", cod);
	}
	
	public void modificarSeguro(Seguro seguro) {
		this.actuRegistro("seguro", "nombre='"+seguro.getNombre()+"', descripcion='"+seguro.getDescripcion()
		+"'","codigo", Integer.toString(seguro.getCodigo()));
	}
}
