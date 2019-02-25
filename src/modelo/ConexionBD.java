//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo;
import bean.ConexionUniversalBD;

public class ConexionBD extends ConexionUniversalBD{
	
	public ConexionBD() {
		super();
		this.establerPropiedadesBD("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/", "Red-de-Clinicas", "postgres", "postgres");
	}

}
