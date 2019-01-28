package modelo.Historial;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.ConexionBD;

public class HistorialMedicoDB extends ConexionBD{
	
	public HistorialMedicoDB() {
		super();
	}
	
	public void incluirHistorial(HistorialMedico hist) {
		this.crearRegistro("historialmedico", "ced_paciente, numero, peso, altura, sexo, enfermedad_actual,"
				+ "ante_enfer_act, ante_familiar", "'"+hist.getCedPaciente()+"',"+Integer.toString(hist.getNumero())+","+Float.toString(hist.getPeso())+","
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
			historial = new HistorialMedico(ced_paciente, numero, peso, altura, sexo, enfermedad_actual, ante_enf, ante_familiar);
		}
		this.cerrarComando();
		return historial;
	}
}
