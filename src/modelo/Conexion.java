package modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion extends javax.swing.JFrame{
	protected Connection c = null;
	protected Statement stmt = null;
	private String driver;
	private String url;
	private String nombBD;
	private String usuario;
	private String contrasenna;
	
	public Conexion() {
		super();
	}
	
	public void establerPropiedadesBD(String driv, String urls, String nombDBD, String user, String contras) {
		this.driver=driv;
		this.url=urls;
		this.nombBD=nombDBD;
		this.usuario=user;
		this.contrasenna=contras;
	}
	
	public void establecerConexionBD() {
	      try {
	    	  Class.forName(getDriver());
		      c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	      } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Conexión Exitosa con la Base de Datos");
	}
	
	public void crearTabla(String nombTabla, String campos) {
	      try {
	    	  Class.forName(getDriver());
		      c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
		      
	          stmt = c.createStatement();
	          String sql = "CREATE TABLE " + nombTabla +" ( " +campos+" );";
	          stmt.executeUpdate(sql);
	          
	          stmt.close();
	          c.close();
	      } catch (Exception e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
		  }
		  JOptionPane.showMessageDialog(this, "Tabla Creada con Éxito");
	}
	
	public void crearRegistro(String nombTabla, String nombCampos, String valorCampos) {
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
	         
			 stmt = c.createStatement();
	         String sql = "INSERT INTO " + nombTabla + " ("+ nombCampos + ") " + "VALUES" + " (" + valorCampos + ");";
	         stmt.executeUpdate(sql);

	         cerrarComando();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Creado de Manera Exitosa");
	}
	
	public void actuRegistro(String nombTabla, String nombCampos, String valorCampos, String id, String valorId) {
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "UPDATE " + nombTabla +" SET " + " ( "+ nombCampos + " ) VALUES ( " + valorCampos + " ) WHERE "+ 
	         id + "="+ valorId +";";
	         stmt.executeUpdate(sql);
	         
	         cerrarComando();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Actualizado de Manera Exitosa");
	}
	
	public void elimLogica(String nombTabla, String id, String valorId) {
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "UPDATE " + nombTabla +" set " + " estatus = 'e' WHERE "+ 
	         id + "="+ valorId +";";
	         stmt.executeUpdate(sql);
	         
	         cerrarComando();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Eliminado de Manera Exitosa");
	}
	
	public ResultSet buscarRegistro(String nombTabla, String id, String valorId) {
		ResultSet rs=null;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT * FROM "+nombTabla+" WHERE "+ id +"="+valorId+ "AND estatus='a';";
	         rs = stmt.executeQuery(sql);
	         
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Buscado de Manera Exitosa");
		return rs;		
	}
	
	public ResultSet consultarTabla(String nombTabla, String adicional) {
		ResultSet rs=null;
		try {
			 Class.forName(getDriver());
		     c = DriverManager.getConnection(getUrl()+getNombBD(),getUsuario(), getContrasenna());
	         c.setAutoCommit(false);
			
	         stmt = c.createStatement();
	         String sql = "SELECT * FROM "+nombTabla+adicional+" WHERE estatus='a';";
	         rs = stmt.executeQuery(sql);
	         
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Operación Realizada de Manera Exitosa");
	      return rs;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombBD() {
		return nombBD;
	}

	public void setNombBD(String nombBD) {
		this.nombBD = nombBD;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contraseña) {
		this.contrasenna = contraseña;
	}
	
	public void cerrarComando() throws SQLException {
		c.commit();
        stmt.close();
        c.close();
	}
}
