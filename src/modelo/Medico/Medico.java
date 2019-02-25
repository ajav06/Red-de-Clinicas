//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Medico;

import java.util.Date;

import modelo.Persona;

public class Medico extends Persona {
	public static class Builder{
		private String cedula;
		private String nombre;
		private String apellido;
		private Date fechaNacimiento;
		private String direccion; 
		private String nroTelefonico;
		private String cod_especialidad;
		private String estado;
		private String tlf_casa;
		private String email;
		private char edo_civil;

		public Builder(String cedula) {
			this.cedula = cedula;
		}
		
		public Builder nomb(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder apellid(String apellido) {
			this.apellido = apellido;
			return this;
		}
		
		public Builder fechaNacimient(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
			return this;
		}
		
		public Builder direccio(String direccion) {
			this.direccion = direccion;
			return this;
		}
		
		public Builder nroTelefonic(String nroTelefonico) {
			this.nroTelefonico = nroTelefonico;
			return this;
		}
		
		public Builder cod_especialida(String cod_especialidad) {
			this.cod_especialidad = cod_especialidad;
			return this;
		}
		
		public Builder estad(String estado) {
			this.estado = estado;
			return this;
		}
		
		public Builder tlf_cas(String tlf_casa) {
			this.tlf_casa = tlf_casa;
			return this;
		}
		
		public Builder emai(String email) {
			this.email = email;
			return this;
		}
		
		public Builder edo_civi(char edo_civil) {
			this.edo_civil = edo_civil;
			return this;
		}
		
		public Medico build() {
			Medico m = new Medico();
			m.cedula = cedula;
			m.cod_especialidad = cod_especialidad;
			m.nombre = nombre;
			m.apellido = apellido;
			m.fechaNacimiento = fechaNacimiento;
			m.edo_civil = edo_civil;
			m.estado = estado;
			m.direccion = direccion;
			m.tlf_casa = tlf_casa;
			m.nroTelefonico = nroTelefonico;
			m.email = email;
			return m;
		}
	}
	
	String cod_especialidad, estado, tlf_casa, email;
	char edo_civil;
	
	private Medico() {
		super();

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
