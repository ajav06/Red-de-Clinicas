package modelo;
import bean.ConexionUniversalBD;

public class ConexionBD extends ConexionUniversalBD{
	
	public ConexionBD() {
		super();
		this.establerPropiedadesBD("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/", "Red-de-Clinicas", "postgres", "postgres");
	}

}
