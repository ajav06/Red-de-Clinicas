package modelo.Paciente;
import java.util.Date;

import modelo.Persona;

public class Paciente extends Persona{
	char edo_civil;
	String estado, email, celular,casa, direccion;
	boolean asegurado;
	
	public Paciente(String cedula, String nombre, String apellido, Date fechaNacimiento,
			char edo_civil, String estado, String email, String celular, String casa, String direccion, boolean asegurado) {
		super();
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechaNacimiento=fechaNacimiento;
		this.edo_civil = edo_civil;
		this.estado = estado;
		this.email = email;
		this.celular = celular;
		this.celular = celular;
		this.direccion = direccion;
		this.asegurado = asegurado;
	}
	
	public char getEdo_civil() {
		return edo_civil;
	}

	public void setEdo_civil(char edo_civil) {
		this.edo_civil = edo_civil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isAsegurado() {
		return asegurado;
	}

	public void setAsegurado(boolean asegurado) {
		this.asegurado = asegurado;
	}
	
	
}
