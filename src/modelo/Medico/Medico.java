package modelo.Medico;

import java.util.Date;

import modelo.Persona;

public class Medico extends Persona {
	String cod_especialidad, estado, tlf_casa, email;
	char edo_civil;
	
	public Medico() {
		super();

	}
	
	public Medico(String ced, String codesp, String nomb, String ap, Date fechan, char edoc,
			String edo, String dir, String tlfc, String tlfm, String em) {
		super();
		this.cedula = ced;
		this.cod_especialidad = codesp;
		this.nombre = nomb;
		this.apellido = ap;
		this.fechaNacimiento = fechan;
		this.edo_civil = edoc;
		this.estado = edo;
		this.direccion = dir;
		this.tlf_casa = tlfc;
		this.nroTelefonico = tlfm;
		this.email = em;
	}

	public String getCod_especialidad() {
		return cod_especialidad;
	}

	public void setCod_especialidad(String cod_especialidad) {
		this.cod_especialidad = cod_especialidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTlf_casa() {
		return tlf_casa;
	}

	public void setTlf_casa(String tlf_casa) {
		this.tlf_casa = tlf_casa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getEdo_civil() {
		return edo_civil;
	}

	public void setEdo_civil(char edo_civil) {
		this.edo_civil = edo_civil;
	}

}
