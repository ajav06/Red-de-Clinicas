package modelo.Seguro;

public class SeguroPaciente {
	public static class Builder{
		private int numero;
		private int cod_seguro;
		private String ced_paciente;

		public Builder(int numero) {
			this.numero = numero;
		}
		
		public Builder cod_segur(int cod_seguro) {
			this.cod_seguro = cod_seguro;
			return this;
		}
		
		public Builder ced_pacient(String ced_paciente) {
			this.ced_paciente = ced_paciente;
			return this;
		}
		
		public SeguroPaciente build() {
			SeguroPaciente s = new SeguroPaciente();
			s.numero = numero;
			s.cod_seguro = cod_seguro;
			s.ced_paciente = ced_paciente;
			return s;
		}
	}
	private int numero;
	private int cod_seguro;
	private String ced_paciente;
	
	public SeguroPaciente() {
		super();
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
