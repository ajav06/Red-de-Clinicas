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
				+"','"+clinica.getNombre()+"','"+clinica.getEstado()+"','"+clinica.getDireccion()+"','"+clinica.getTelefono()+"','"+clinica.getCorreo()+"'");
	}
	
	public List<Clinica> consultarClinicas() throws SQLException {
		List<Clinica> Clinicas = new ArrayList<Clinica>();
		resultSet = this.consultarTabla("clinica", " WHERE estatus='a' AND codigo != '0' ORDER BY codigo ASC");
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
				clinica.getDireccion()+"',telefono='"+clinica.getTelefono()+"',email='"+clinica.getCorreo()+"'","codigo", "'"+clinica.getCodigo()+"'");
	}
	
	public Clinica buscarClinica(String cod) throws SQLException 
	{
		Clinica clinica = null;
		resultSet = this.buscarRegistro("clinica", "codigo", "'"+cod+"'");

		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
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
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
				String estado = resultSet.getString("estado");
				String direccion = resultSet.getString("direccion");
				String telefono = resultSet.getString("telefono");
				String correo = resultSet.getString("email");
				Clinica clinica = new Clinica(codigo,nombre,estado,direccion,telefono,correo);
				clinicas.add(clinica);
			}
		} catch (SQLException e) {
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
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
	         String sql = "SELECT COUNT(codigo) FROM clinica";
	         rs = stmt.executeQuery(sql);
	         rs.next();
        	 ult = rs.getInt("count");
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

	public DefaultComboBoxModel nombresServicios() throws SQLException{
		DefaultComboBoxModel nombres = new DefaultComboBoxModel();
		resultSet = this.ejecutarQuery("select nombre from servicio order by codigo asc");
		try {
			while (resultSet.next())
				nombres.addElement(resultSet.getString("nombre"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarComando();
		return nombres;
	}
	
	public List<OfertaServicio> consultarServiciosClinica(String codclini) throws SQLException{
		List<OfertaServicio> os = new ArrayList<OfertaServicio>();
		resultSet = this.ejecutarQuery("select codigo, (select nombre from servicio where servicio.codigo=ofertaservicio.cod_servicio) as nombre, (select tipo_servicio from servicio where servicio.codigo = ofertaservicio.cod_servicio) as tipo, precio from ofertaservicio where cod_clinica='"+codclini+"'");
		try {
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String tipo_s = null;
				switch(resultSet.getString("tipo")) {
				case "i":
					tipo_s = "Intervención";
					break;
				
				case "c":
					tipo_s = "Consulta";
					break;
				}
				
				String nombre = resultSet.getString("nombre");
				float precio = resultSet.getFloat("precio");
				
				OfertaServicio o = new OfertaServicio(codigo, tipo_s, nombre, precio);
				os.add(o);
			}
		} catch (SQLException e) {
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
			e.printStackTrace();
		} finally {
			this.cerrarComando();
		}
		return os;
	}
	
	public List<OfertaServicio> consultarServiciosClinicaFiltrado(String codclini, char tipo) throws SQLException{
		List<OfertaServicio> os = new ArrayList<OfertaServicio>();
		resultSet = this.ejecutarQuery("select codigo, (select nombre from servicio where servicio.codigo=ofertaservicio.cod_servicio and servicio.tipo_servicio = '"+tipo+"') as nombre, (select tipo_servicio from servicio where servicio.codigo = ofertaservicio.cod_servicio and servicio.tipo_servicio = '"+tipo+"') as tipo, precio from ofertaservicio where cod_clinica='"+codclini+"'");
		try {
			while (resultSet.next()) {
				if (resultSet.getString("nombre")!=null) {
					String codigo = resultSet.getString("codigo");
					String tipo_s = null;
					switch(resultSet.getString("tipo")) {
					case "i":
						tipo_s = "Intervención";
						break;
					
					case "c":
						tipo_s = "Consulta";
						break;
					}
					
					String nombre = resultSet.getString("nombre");
					float precio = resultSet.getFloat("precio");
					
					OfertaServicio o = new OfertaServicio(codigo, tipo_s, nombre, precio);
					os.add(o);
				}
			}
		} catch (SQLException e) {
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
			e.printStackTrace();
		} finally {
			this.cerrarComando();
		}
		return os;
	}
	
	public void modificarPrecioServicio(float precio, String cod) {
		this.actuRegistro("ofertaservicio", "precio = '"+ String.valueOf(precio) + "'", "codigo", "'"+cod+"'");
	}
	
	public String nuevoCodOfertaServicio() {
		ResultSet rs=null;
		String ult = null;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT MAX(codigo::integer) FROM ofertaservicio";
	         rs = stmt.executeQuery(sql);
	         rs.next();
        	 int u = rs.getInt("max");
        	 u++;
        	 ult = String.valueOf(u);
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
		return ult;
	}
	
	public void registrarOfertaServ(String cod_serv, String cod_clini, float precio) {
		this.crearRegistro("ofertaservicio", "codigo, cod_servicio, cod_clinica, precio", "'"+nuevoCodOfertaServicio()+"','"+cod_serv+"','"+cod_clini+"',"+String.valueOf(precio));
	}
	
	public boolean verificarExistenciaOfertaServ(String cod_serv, String cod_clini) {
		ResultSet rs=null;
		boolean exis = false;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT COUNT(codigo) FROM ofertaservicio WHERE cod_servicio = '"+cod_serv+"' and cod_clinica = '"+cod_clini+"'";
	         rs = stmt.executeQuery(sql);
	         rs.next();
        	 int u = rs.getInt("count");

        	 switch(u) {
        	 case 0:
        		 exis = false;
        		 break;
        	 case 1:
        		 exis = true;
        		 break;
        	 }
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
		return exis;
	}
	
}

