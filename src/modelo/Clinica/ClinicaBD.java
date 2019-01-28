package modelo.Clinica;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import modelo.ConexionBD;

public class ClinicaBD extends ConexionBD
{
	private ResultSet resultSet;
	
	public ClinicaBD()
	{
		super();
	}
	
	public void registrarClinica(Clinica clinica) 
	{
		this.crearRegistro("clinica", "codigo,nombre,estado,direccion,telefono,email", "'"+clinica.getCodigo()
				+"','"+clinica.getNombre()+"','"+clinica.getEstado()+"','"+clinica.getDireccion()+"','"+clinica.getTelefono()+","+clinica.getCorreo());
	}
	
	public List<Clinica> consultarClinicas() throws SQLException {
		List<Clinica> Clinicas = new ArrayList<Clinica>();
		resultSet = this.consultarTabla("clinica", " WHERE estatus='a' AND codigo != '0' ");
		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
				String estado = resultSet.getString("estado");
				String direccion = resultSet.getString("direccion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("email");
				Clinica Clinica = new Clinica(codigo,nombre,estado,direccion,telefono,correo);
				Clinicas.add(Clinica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
	        JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
		}
		this.cerrarComando();
		return Clinicas;
	}
	
	public void actualizarClinica(Clinica clinica) {
		this.actuRegistro("clinica", "nombre='"+clinica.getNombre()+"',estado='"+clinica.getEstado()+"',direccion='"+
				clinica.getDireccion()+"',telefono='"+clinica.getTelefono()+"',email="+clinica.getCorreo(),"codigo", "'"+clinica.getCodigo()+"'");
	}
	
	public Clinica buscarClinica(String cod) throws SQLException 
	{
		Clinica clinica = null;
		resultSet = this.buscarRegistro("clinica", "codigo", "'"+cod+"'");
		
		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombres");
				String estado = resultSet.getString("estado");
				String direccion = resultSet.getString("direccion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("email");
				clinica = new Clinica(codigo,nombre, estado,direccion,telefono,correo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return clinica;
	}
	public void eliminarClinica(String cod) {
		this.elimLogica("clinica", "codigo",  "'"+cod+"'");
	}
	
	public List<Clinica> consultarFiltrarClinicas(String filtro) throws SQLException {
		List<Clinica> clinicas = new ArrayList<Clinica>();
		resultSet = this.consultarTabla("clinica", " WHERE "+filtro);
		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codido");
				String nombre = resultSet.getString("nombre");
				String estado = resultSet.getString("estado");
				String direccion = resultSet.getString("direccion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("email");
				Clinica clinica = new Clinica(codigo,nombre,estado,direccion,telefono,correo);
				clinicas.add(clinica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return clinicas;
	}
	
	public int generarNuevoCodigoClinica() throws NumberFormatException, SQLException {
		ResultSet rs=null;
		int ult = -1;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT CAST (codigo as integer) FROM clinica ORDER BY codigo DESC LIMIT 1";
	         rs = stmt.executeQuery(sql);
	         if (!rs.next()) {
	        	 ult=0;
	         } else {
		 		 ult = Integer.parseInt(rs.getString("codigo"));
		 		 ult++;
	         }
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
		return ult;
	}

	public DefaultComboBoxModel nombresClinicas() throws SQLException{
		DefaultComboBoxModel nombres = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("SELECT nombre FROM clinica WHERE estatus = 'a' ORDER BY codigo ASC");
		try {
			while (resultSet.next())
				nombres.addElement(resultSet.getString("nombre"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return nombres;
	}
}

