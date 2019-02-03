package modelo.Seguro;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

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
	
	public void incluirSeguroPaciente(SeguroPaciente seguro) {
		this.crearRegistro("seguropaciente", "numero,cod_seguro,ced_paciente", Integer.toString(seguro.getNumero())+","+Integer.toString(seguro.getCod_seguro())
		+",'"+seguro.getCed_paciente()+"'");
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
	
	public SeguroPaciente buscarSeguroPaciente(String ced) throws SQLException {
		SeguroPaciente seguro = null;
		resultSet = this.buscarRegistroSinEstatus("seguropaciente", "ced_paciente", "'"+ced+"'");
		while(resultSet.next()) {
			int numero = resultSet.getInt("numero");
			int cod_seguro = resultSet.getInt("cod_seguro");
			String descripcion = resultSet.getString("ced_paciente");
			seguro = new SeguroPaciente(numero, cod_seguro, descripcion);
		}
		this.cerrarComando();
		return seguro;
	}
	
	public void eliminarSeguro(String cod) {
		this.elimLogica("seguro","codigo", cod);
	}
	
	public void modificarSeguroPaciente(SeguroPaciente seguro) {
		this.actuRegistro("seguropaciente", "cod_seguro="+Integer.toString(seguro.getCod_seguro())+", numero="+Integer.toString(seguro.getNumero())
		,"ced_paciente","'"+seguro.getCed_paciente()+"'");
	}
	
	public void modificarSeguro(Seguro seguro) {
		this.actuRegistro("seguro", "nombre='"+seguro.getNombre()+"', descripcion='"+seguro.getDescripcion()
		+"'","codigo", Integer.toString(seguro.getCodigo()));
	}
	
	public DefaultComboBoxModel nombresSeguros() throws SQLException{
		DefaultComboBoxModel nombres = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("SELECT nombre FROM seguro WHERE estatus = 'a' ORDER BY codigo ASC");
		try {
			while (resultSet.next())
				nombres.addElement(resultSet.getString("nombre"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return nombres;
	}
	
	public int generarNuevoCodigoSeguro() throws NumberFormatException, SQLException {
		int ult = -1;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT COUNT(codigo) FROM seguro";
	         resultSet = stmt.executeQuery(sql);
	         resultSet.next();
        	 ult = resultSet.getInt("count");
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
		return ult;
	}
}
