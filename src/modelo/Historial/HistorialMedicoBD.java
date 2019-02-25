//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Historial;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.ConexionBD;

public class HistorialMedicoBD extends ConexionBD{
	
	public HistorialMedicoBD() {
		super();
	}
	
	public void incluirHistorial(HistorialMedico hist) {
		this.crearRegistro("historialmedico", "numero, ced_paciente,  peso, altura, sexo, enfermedad_actual,"
				+ "ante_enfer_act, ante_familiar",Integer.toString(hist.getNumero())+",'"+hist.getCedPaciente()+"',"+Float.toString(hist.getPeso())+","
				+Float.toString(hist.getAltura())+",'"+hist.getSexo()+"','"+hist.getEnfActual()+"','"+hist.getAnteEnfAct()
				+"','"+hist.getAnteFamiliar()+"'");
	}
	
	public void modificarHistorial(HistorialMedico hist) {
		this.actuRegistro("historialmedico", "numero="+hist.getNumero()+", peso="+hist.getPeso()+","
				+" altura="+hist.getAltura()+", sexo='"+hist.getSexo()+"', enfermedad_actual='"+hist.getEnfActual()+"',"
				+" ante_enfer_act='"+hist.getAnteEnfAct()+"', ante_familiar='"+hist.getAnteFamiliar()+"' ", "numero", Integer.toString(hist.getNumero()));
	}
	
	public HistorialMedico buscarHistorial(String num) throws SQLException {
		ResultSet resultSet;
		HistorialMedico historial = null;
		resultSet = this.buscarRegistroSinEstatus("historialmedico", "numero", num);
		while(resultSet.next()) {
			int numero = resultSet.getInt("numero");
			String ced_paciente = resultSet.getString("ced_paciente");
			float peso = resultSet.getFloat("peso");
			float altura = resultSet.getFloat("altura");
			char sexo = resultSet.getString("sexo").charAt(0);
			String enfermedad_actual = resultSet.getString("enfermedad_actual");
			String ante_enf = resultSet.getString("ante_enfer_act");
			String ante_familiar = resultSet.getString("ante_familiar");
			historial = new HistorialMedico.Builder(ced_paciente)
					.numer(numero)
					.pes(peso)
					.altur(altura)
					.sex(sexo)
					.enfActua(enfermedad_actual)
					.anteEnfAc(ante_enf)
					.anteFamilia(ante_familiar)
					.build();
		}
		this.cerrarComando();
		return historial;
	}
	
	public HistorialMedico buscarHistorialCed(String ced) throws SQLException {
		ResultSet resultSet;
		HistorialMedico historial = null;
		resultSet = this.buscarRegistroSinEstatus("historialmedico", "ced_paciente", "'"+ced+"'");
		while(resultSet.next()) {
			int numero = resultSet.getInt("numero");
			String ced_paciente = resultSet.getString("ced_paciente");
			float peso = resultSet.getFloat("peso");
			float altura = resultSet.getFloat("altura");
			char sexo = resultSet.getString("sexo").charAt(0);
			String enfermedad_actual = resultSet.getString("enfermedad_actual");
			String ante_enf = resultSet.getString("ante_enfer_act");
			String ante_familiar = resultSet.getString("ante_familiar");
			historial = new HistorialMedico.Builder(ced_paciente)
					.numer(numero)
					.pes(peso)
					.altur(altura)
					.sex(sexo)
					.enfActua(enfermedad_actual)
					.anteEnfAc(ante_enf)
					.anteFamilia(ante_familiar)
					.build();
			}
		this.cerrarComando();
		return historial;
	}
}
