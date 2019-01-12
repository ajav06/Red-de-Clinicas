package modelo;
import java.sql.*;

public class Conexion {
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
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}
	
	public void crearTabla(String nombTabla, String campos) {
	      try {
	          stmt = c.createStatement();
	          String sql = "CREATE TABLE " + nombTabla +" ( " +campos+" );";
	          stmt.executeUpdate(sql);
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Table created successfully");
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
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
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
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
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
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	}
	
	public void buscarRegistro(String nombTabla, String nombCampos, String id, String valorId, ResultSet rs) {
		try {
	         stmt = c.createStatement();
	         rs = stmt.executeQuery( "SELECT "+ nombCampos +" FROM "+nombTabla+" WHERE"+ id +"="+valorId+ ";" );
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");		
	}
	
	public void consultarTabla(String nombTabla, String nombCampos, String id, String valorId, ResultSet rs) {
		try {
	         stmt = c.createStatement();
	         rs = stmt.executeQuery( "SELECT "+ nombCampos +" FROM "+nombTabla+" WHERE"+ id +"="+valorId+ ";" );
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");		
	}
	
	
}
