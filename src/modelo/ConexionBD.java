package modelo;
import modelo.Conexion;

public class ConexionBD extends Conexion{
	
	public ConexionBD() {
		super();
		super.establecerConexionBD("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/", "Red-de-Clinicas", "postgres", "postgres");
	}

}
