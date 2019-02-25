package modelo.Medico;

public class Trabajo {
	public static class Builder{
		private String codigo;
		private String cod_clinica;
		private String turno;

		public Builder(String codigo) {
			this.codigo = codigo;
		}
		
		public Builder cod_clinic(String cod_clinica) {
			this.cod_clinica = cod_clinica;
			return this;
		}
		
		public Builder turn(String turno) {
			this.turno = turno;
			return this;
		}
		
		public Trabajo build() {
			Trabajo t = new Trabajo();
			t.codigo = codigo;
			t.cod_clinica = cod_clinica;
			t.turno = turno;
			return t;
		}
	}
	private String codigo;
	private String cod_clinica;
	private String turno;
	
	private Trabajo() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCod_clinica() {
		return cod_clinica;
	}

	public void setCod_clinica(String cod_clinica) {
		this.cod_clinica = cod_clinica;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
}
