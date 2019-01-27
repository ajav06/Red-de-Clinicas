package modelo.Medico;

public class Trabajo {
	private String codigo;
	private String cod_clinica;
	private String turno;
	
	public Trabajo(String cod, String c, String t) {
		codigo = cod;
		cod_clinica = c;
		turno = t;
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
