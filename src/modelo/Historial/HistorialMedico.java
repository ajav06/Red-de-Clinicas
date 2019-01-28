package modelo.Historial;

public class HistorialMedico {
	private String cedPaciente;
	private int numero;
	private float  peso;
	private float altura;
	private char sexo;
	private String enfActual;
	private String anteEnfAct;
	private String anteFamiliar;
	
	public HistorialMedico(String cedPaciente, int numero, float  peso, float altura, 
			char sexo, String enfActual, String anteEnfAct, String anteFamiliar) {
		super();
		this.cedPaciente = cedPaciente;
		this.numero = numero;
		this.peso = peso;
		this.altura = altura;
		this.sexo = sexo;
		this.enfActual = enfActual;
		this.anteEnfAct = anteEnfAct;
		this.anteFamiliar = anteFamiliar;
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
