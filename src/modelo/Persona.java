//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo;
import java.util.Date;

public class Persona {
	protected String cedula;
	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected String nroTelefonico;
	protected float peso;
	protected Date fechaNacimiento;
	
	public Persona() {
		super();
		this.cedula="";
		this.nombre="";
		this.apellido="";
		this.direccion="";
		this.peso=0;
	}
		
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNroTelefonico() {
		return nroTelefonico;
	}
	
	public void setNroTelefonico(String nroTelefonico) {
		this.nroTelefonico = nroTelefonico;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
}
