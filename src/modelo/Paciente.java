package modelo;
import java.util.Date;

public class Paciente extends Persona{
	String antePersonales, anteFamiliares;
	int nroSeguro,nroHistorial;
	
	public Paciente(String cedula, String nombre, String apellido, String antePersonales, String anteFamiliares, int nroSeguro, int nroHistorial, Date fechaNacimiento) {
		super();
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.antePersonales=antePersonales;
		this.anteFamiliares=anteFamiliares;
		this.nroSeguro=nroSeguro;
		this.nroHistorial=nroHistorial;
		this.fechaNacimiento=fechaNacimiento;
	}
	
	public String getAntePersonales() {
		return antePersonales;
	}
	public void setAntePersonales(String antePersonales) {
		this.antePersonales = antePersonales;
	}
	public String getAnteFamiliares() {
		return anteFamiliares;
	}
	public void setAnteFamiliares(String anteFamiliares) {
		this.anteFamiliares = anteFamiliares;
	}
	public int getNroSeguro() {
		return nroSeguro;
	}
	public void setNroSeguro(int nroSeguro) {
		this.nroSeguro = nroSeguro;
	}
	public int getNroHistorial() {
		return nroHistorial;
	}
	public void setNroHistorial(int nroHistorial) {
		this.nroHistorial = nroHistorial;
	}
	
}
