package modelo;
import modelo.Conexion;

public class ConexionBD extends Conexion{
	
	public ConexionBD() {
		super();
		this.establerPropiedadesBD("org.postgresql.Driver", "jdbc:postgresql://localhost:5433/", "Red-de-Clinicas", "postgres", "postgres");
	}

}
