package modelo.Medico;

import java.util.Date;

import modelo.Persona;

public class Medico extends Persona {
	String email, tlfcasa, tlfcelular, codespec, almamater;
	int annogrado;
	String[] horariomat, horariovesp;
	boolean estudia;
	
	public Medico(String cedula, String nombre, String apellido, Date fechaNacimiento, String em, String tlfc, String tlfce, String cespec, String almam, int annog, String[] hmat, String[] hvesp, boolean e) {
		super();
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechaNacimiento=fechaNacimiento;
		this.email = em;
		this.tlfcasa = tlfc;
		this.tlfcelular = tlfce;
		this.codespec = cespec;
		this.almamater = almam; 
		this.annogrado = annog;
		this.horariomat = hmat;
		this.horariovesp = hvesp;
		this.estudia = e;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlfcasa() {
		return tlfcasa;
	}

	public void setTlfcasa(String tlfcasa) {
		this.tlfcasa = tlfcasa;
	}

	public String getTlfcelular() {
		return tlfcelular;
	}

	public void setTlfcelular(String tlfcelular) {
		this.tlfcelular = tlfcelular;
	}

	public String getCodespec() {
		return codespec;
	}

	public void setCodespec(String codespec) {
		this.codespec = codespec;
	}

	public String getAlmamater() {
		return almamater;
	}

	public void setAlmamater(String almamater) {
		this.almamater = almamater;
	}

	public int getAnnogrado() {
		return annogrado;
	}

	public void setAnnogrado(int annogrado) {
		this.annogrado = annogrado;
	}

	public String[] getHorariomat() {
		return horariomat;
	}

	public void setHorariomat(String[] horariomat) {
		this.horariomat = horariomat;
	}

	public String[] getHorariovesp() {
		return horariovesp;
	}

	public void setHorariovesp(String[] horariovesp) {
		this.horariovesp = horariovesp;
	}

	public boolean isEstudia() {
		return estudia;
	}

	public void setEstudia(boolean estudia) {
		this.estudia = estudia;
	}
	
	
}
