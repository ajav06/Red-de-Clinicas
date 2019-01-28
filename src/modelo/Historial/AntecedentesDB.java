package modelo.Historial;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.ConexionBD;
import modelo.Seguro.Seguro;

public class AntecedentesDB extends ConexionBD{
	
	public AntecedentesDB() {
		super();
	}
	
	public void incluirAntecedentes(Antecedentes ant) {
		this.crearRegistro("antecedentespersonales", "nro_historial, alcohol, drogas, infusiones, tabaco, " + 
				"alimentacion, diuresis, catarsis, suenno, sexualidad, otros_fis, " + 
				"cardiacas, respiratorias, gastrointestinales, neufrourologicos, neurologicos, " + 
				"hematologicos, ginecologos, infectologicos, endocrinologicos, quirurgicos, " + 
				"traumatologicos, alergicos, epidemiologicos, otras_enf, enf_infancia", Integer.toString(ant.getNroHistorial()) +",'"+
				ant.getAlcohol()+"','"+ant.getDrogas()+"','"+ant.getInfusiones()+"','"+ant.getTabaco()+
				"','"+ant.getAlimentacion()+"','"+ant.getDiuresis()+"','"+ant.getCatarsis()+"','"+ant.getSueno()+
				"','"+ant.getSexualidad()+"','"+ant.getOtros_fis()+"','"+ant.getCardiacas()+"','"+
				ant.getRespiratorias()+"','"+ant.getGastrointestinales()+"','"+ant.getNeufrourologicos()+"','"+
				ant.getNeurologicos()+"','"+ant.getHematologicos()+"','"+ant.getGinecologos()+"','"+ant.getInfectologicos()+
				"','"+ant.getEndocrinologicos()+"','"+ant.getQuirurgicos()+"','"+ant.getTraumatoloficos()+"','"+
				ant.getAlergicos()+"','"+ant.getEpidemiologicos()+"','"+ant.getOtras_enf()+"','"+ant.getEnf_infancia()+"'");
	}
	
	public void actualizarAntecedentes(Antecedentes ant) {
		this.actuRegistro("antecedentespersonales", "alcohol='"+ant.getAlcohol()+", drogas='"+ant.getDrogas()+"', "
				+ "infusiones='"+ant.getInfusiones()+"', tabaco='"+ant.getTabaco()+"', alimentacion='"+ant.getAlimentacion()+"', "
				+ "diuresis='"+ant.getDiuresis()+"', catarsis='"+ant.getCatarsis()+"', suenno='"+ant.getSueno()+
				"', sexualidad='"+ant.getSexualidad()+"', otros_fis='"+ant.getOtros_fis()+"', cardiacas='"+ant.getCardiacas()+"'," + 
				"respiratorias='"+ant.getRespiratorias()+"', gastrointestinales='"+ant.getGastrointestinales()+"', neufrourologicos='"
				+ant.getNeufrourologicos()+"', neurologicos='"+ant.getNeurologicos()+"', hematologicos='"+ant.getHematologicos()+"'"
				+ ", ginecologos='"+ant.getGinecologos()+"', infectologicos='"+ant.getInfectologicos()+"', "+
				"endocrinologicos='"+ant.getEndocrinologicos()+"', quirurgicos='"+ant.getQuirurgicos()+"', " + 
				"traumatologicos='"+ant.getTraumatoloficos()+"', alergicos='"+ant.getAlergicos()+"', epidemiologicos='"+ant.getEpidemiologicos()+
				"', otras_enf='"+ant.getOtras_enf()+"', enf_infancia='"+ant.getEnf_infancia()+"'", "nro_historial", Integer.toString(ant.getNroHistorial()));
	}
	
	public Antecedentes buscarAntecedentes(String num) throws SQLException {
		ResultSet resultSet;
		Antecedentes antecedente=null;
		resultSet = this.buscarRegistroSinEstatus("antecedentespersonales", "nro_historial", num);
		while(resultSet.next()) {
			int nroHistorial = resultSet.getInt("nro_historial");
			String alcohol = resultSet.getString("alcohol");
			String drogas = resultSet.getString("drogas");
			String infusiones = resultSet.getString("infusiones");
			String tabaco = resultSet.getString("tabaco");
			String alimentacion = resultSet.getString("alimentacion");
			String diuresis = resultSet.getString("diuresis");
			String catarsis = resultSet.getString("catarsis");
			String Sueno = resultSet.getString("suenno");
			String sexualidad = resultSet.getString("sexualidad");
			String otros_fis = resultSet.getString("otros_fis");
			String cardiacas = resultSet.getString("cardiacas");
			String respiratorias = resultSet.getString("respiratorias");
			String gastrointestinales = resultSet.getString("gastrointestinales");
			String neufrourologicos = resultSet.getString("neufrourologicos");
			String neurologicos = resultSet.getString("neurologicos");
			String hematologicos = resultSet.getString("hematologicos");
			String ginecologos = resultSet.getString("ginecologos");
			String infectologicos = resultSet.getString("infectologicos");
			String endocrinologicos = resultSet.getString("endocrinologicos");
			String quirurgicos = resultSet.getString("quirurgicos");
			String traumatoloficos = resultSet.getString("traumatologicos");
			String alergicos = resultSet.getString("alergicos");
			String epidemiologicos = resultSet.getString("epidemiologicos");
			String otras_enf = resultSet.getString("otras_enf");
			String enf_infancia = resultSet.getString("enf_infancia");
			antecedente = new Antecedentes(nroHistorial, alcohol, drogas, infusiones, tabaco, alimentacion, diuresis, 
					catarsis, Sueno, sexualidad, otros_fis, cardiacas, respiratorias, gastrointestinales, neufrourologicos, 
					neurologicos, hematologicos, ginecologos, infectologicos, endocrinologicos, quirurgicos, traumatoloficos, 
					alergicos, epidemiologicos, otras_enf, enf_infancia);
					
		}
		
		this.cerrarComando();
		return antecedente;
	}

}
