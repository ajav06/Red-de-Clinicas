package modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion extends javax.swing.JFrame{
	Connection c = null;
	Statement stmt = null;
	
	public Conexion() {
		super();
	}
	
	public void establecerConexionBD(String driver, String url, String nombBD, String usuario, String contraseña) {
	      try {
	         Class.forName(driver);
	         c = DriverManager.getConnection(url+nombBD,usuario, contraseña);
	      } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Conexión Exitosa con la Base de Datos");
	}
	
	public void crearTabla(String nombTabla, String campos) {
	      try {
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
			 stmt = c.createStatement();
	         String sql = "INSERT INTO " + nombTabla + " ( "+ nombCampos + " ) " + "VALUES" + " ( " + valorCampos + " );";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Creado de Manera Exitosa");
	}
	
	public void actuRegistro(String nombTabla, String nombCampos, String valorCampos, String id, String valorId) {
		try {
	         stmt = c.createStatement();
	         String sql = "UPDATE " + nombTabla +" set " + " ( "+ nombCampos + " ) " + "VALUES" + " ( " + valorCampos + " ) WHERE "+ 
	         id + "="+ valorId +";";
	         stmt.executeUpdate(sql);
	         
	         c.commit();
	         stmt.close();
	         c.close();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Actualizado de Manera Exitosa");
	}
	
	public void elimLogica(String nombTabla, String id, String valorId) {
		try {
	         stmt = c.createStatement();
	         String sql = "UPDATE " + nombTabla +" set " + " estatus = 'e' where "+ 
	         id + "="+ valorId +";";
	         stmt.executeUpdate(sql);
	         
	         c.commit();
	         stmt.close();
	         c.close();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Eliminado de Manera Exitosa");
	}
	
	public void buscarRegistro(String nombTabla, String nombCampos, String id, String valorId, ResultSet rs) {
		try {
	         stmt = c.createStatement();
	         rs = stmt.executeQuery( "SELECT "+ nombCampos +" FROM "+nombTabla+" WHERE"+ id +"="+valorId+ ";" );
	         stmt.close();
	         c.close();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Registro Buscado de Manera Exitosa");		
	}
	
	public void consultarTabla(String nombTabla, String nombCampos, String adicional, ResultSet rs) {
		try {
	         stmt = c.createStatement();
	         rs = stmt.executeQuery( "SELECT "+ nombCampos +" FROM "+nombTabla+adicional+";" );
	         stmt.close();
	         c.close();
		  } catch (Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(this, e.getClass().getName()+": "+e.getMessage());
	      }
	      JOptionPane.showMessageDialog(this, "Operación Realizada de Manera Exitosa");		
	}
	
	
}
