package modelo.Seguro;

public class SeguroPaciente {
	private int numero;
	private int cod_seguro;
	private String ced_paciente;
	
	public SeguroPaciente(int numero, int cod_seguro, String ced_paciente) {
		this.numero = numero;
		this.cod_seguro = cod_seguro;
		this.ced_paciente = ced_paciente;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCod_seguro() {
		return cod_seguro;
	}
	public void setCod_seguro(int cod_seguro) {
		this.cod_seguro = cod_seguro;
	}
	public String getCed_paciente() {
		return ced_paciente;
	}
	public void setCed_paciente(String ced_paciente) {
		this.ced_paciente = ced_paciente;
	}

}
