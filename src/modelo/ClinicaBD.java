package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.ConexionBD;
import modelo.Clinica;;

public class ClinicaBD extends ConexionBD
{
	private ResultSet resultSet;
	public ClinicaBD()
	{
		super();
	}
	public void registrarClinica(Clinica clinica) 
	{
		this.crearRegistro("clinica", "codigo,nombres,estado,ciudad,ubicacion,telefono,correo", "'"+clinica.getCodigo()
				+"','"+clinica.getNombre()+"','"+clinica.getEstado()+"','"+clinica.getCiudad()+"','"+clinica.getUbicacion()+"','"+clinica.getTelefono()+"',"
				+clinica.getCorreo());
	}
	
	public List<Clinica> consultarClinicas() throws SQLException {
		List<Clinica> Clinicas = new ArrayList<Clinica>();
		resultSet = this.consultarTabla("clinica", " WHERE estatus='a' ");
		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombres");
				String estado = resultSet.getString("estados");
				String ciudad = resultSet.getString("ciudad");
				String ubicacion = resultSet.getString("ubicacion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("nrohistorial");
				Clinica clinica = new Clinica(codigo,nombre,estado,ciudad,ubicacion,telefono,correo);
				Clinicas.add(clinica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return Clinicas;
	}
	
	public void actualizarClinica(Clinica clinica) {
		this.actuRegistro("clinica", "nombres='"+clinica.getNombre()+"',estado='"+clinica.getEstado()+"',ciudad='"+
				clinica.getCiudad()+"',ubicacion='"+clinica.getUbicacion()+"',telefono='"+
				clinica.getTelefono()+"',correo="+clinica.getCorreo(),"codigo", "'"+clinica.getCodigo()+"'");
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
				String ciudad = resultSet.getString("ciudad");
				String ubicacion = resultSet.getString("ubicacion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("correo");
				clinica = new Clinica(codigo,nombre, estado,ciudad,ubicacion,telefono,correo);
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
				String ciudad = resultSet.getString("ciudad");
				String ubicacion = resultSet.getString("ubicacion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("correo");
				Clinica clinica = new Clinica(codigo,nombre,estado,ciudad,ubicacion,telefono,correo);
				clinicas.add(clinica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return clinicas;
	}

	
}

