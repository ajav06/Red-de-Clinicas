package modelo.Historial;

public class HistorialMedico {
	public static class Builder{
		private String cedPaciente;
		private int numero;
		private float  peso;
		private float altura;
		private char sexo;
		private String enfActual;
		private String anteEnfAct;
		private String anteFamiliar;

		public Builder(String cedPaciente) {
			this.cedPaciente = cedPaciente;
		}
		
		public Builder numer(int numero) {
			this.numero = numero;
			return this;
		}
		
		public Builder pes(float  peso) {
			this.peso = peso;
			return this;
		}
		
		public Builder altur(float altura){
			this.altura = altura;
			return this;
		}
		
		public Builder sex(char sexo){
			this.sexo = sexo;
			return this;
		}
		
		public Builder enfActua(String enfActual){
			this.enfActual = enfActual;
			return this;
		}
		
		public Builder anteEnfAc(String anteEnfAct){
			this.anteEnfAct = anteEnfAct;
			return this;
		}
		
		public Builder anteFamilia(String anteFamiliar){
			this.anteFamiliar = anteFamiliar;
			return this;
		}
		
		public HistorialMedico build() {
			HistorialMedico h = new HistorialMedico();
			h.cedPaciente = cedPaciente;
			h.numero = numero;
			h.peso = peso;
			h.altura = altura;
			h.sexo = sexo;
			h.enfActual = enfActual;
			h.anteEnfAct = anteEnfAct;
			h.anteFamiliar = anteFamiliar;
			return h;
		}
		
	}
	private String cedPaciente;
	private int numero;
	private float  peso;
	private float altura;
	private char sexo;
	private String enfActual;
	private String anteEnfAct;
	private String anteFamiliar;
	
	private HistorialMedico() {
		super();
	}

	public String getCedPaciente() {
		return cedPaciente;
	}

	public void setCedPaciente(String cedPaciente) {
		this.cedPaciente = cedPaciente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEnfActual() {
		return enfActual;
	}

	public void setEnfActual(String enfActual) {
		this.enfActual = enfActual;
	}

	public String getAnteEnfAct() {
		return anteEnfAct;
	}

	public void setAnteEnfAct(String anteEnfAct) {
		this.anteEnfAct = anteEnfAct;
	}

	public String getAnteFamiliar() {
		return anteFamiliar;
	}

	public void setAnteFamiliar(String anteFamiliar) {
		this.anteFamiliar = anteFamiliar;
	}
	
	
}
