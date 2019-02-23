package modelo.Medico;

import java.util.Date;

public class ListadoCitas {
	String ced_Paciente, tipo_Cita, nomb_Clinica;
	int cod_Trabajo, cod_Oferta;
	Date fecha;
	
	public ListadoCitas(String ced_Paciente, String tipo_Cita, int cod_Trabajo, String nomb_Clinica, Date fecha) {
		super();
		this.ced_Paciente = ced_Paciente;
		this.tipo_Cita = tipo_Cita;
		this.cod_Trabajo = cod_Trabajo;
		this.nomb_Clinica = nomb_Clinica;
		this.fecha = fecha;
	}

	public String getCed_Paciente() {
		return ced_Paciente;
	}

	public void setCed_Paciente(String ced_Paciente) {
		this.ced_Paciente = ced_Paciente;
	}

	public String getTipo_Cita() {
		return tipo_Cita;
	}

	public void setTipo_Cita(String tipo_cita) {
		this.tipo_Cita = tipo_cita;
	}

	public int getCod_Trabajo() {
		return cod_Trabajo;
	}

	public void setCod_Trabajo(int cod_Trabajo) {
		this.cod_Trabajo = cod_Trabajo;
	}

	public int getCod_Oferta() {
		return cod_Oferta;
	}

	public void setCod_oferta(int cod_oferta) {
		this.cod_Oferta = cod_oferta;
	}

	public String getNomb_Clinica() {
		return nomb_Clinica;
	}

	public void setNomb_Clinica(String nomb_Clinica) {
		this.nomb_Clinica = nomb_Clinica;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
