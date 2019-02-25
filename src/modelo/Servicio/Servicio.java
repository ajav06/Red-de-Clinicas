//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Servicio;

public class Servicio {
	public static class Builder{
		private String codigo;
		private String cod_especialidad;
		private String nombre;
		private String descripcion;
		private char tipo;
		
		public Builder(String codigo) {
			this.codigo = codigo;
		}
		
		public Builder cod_especialida(String cod_especialidad) {
			this.cod_especialidad = cod_especialidad;
			return this;
		}
		
		public Builder nombr(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder descripcio(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
		
		public Builder tip(char tipo) {
			this.tipo = tipo;
			return this;
		}
		
		public Servicio build() {
			Servicio s = new Servicio();
			s.codigo = codigo;
			s.cod_especialidad = cod_especialidad;
			s.nombre = nombre;
			s.descripcion = descripcion;
			s.tipo = tipo;
			return s;
		}
	}
	private String codigo;
	private String cod_especialidad;
	private String nombre;
	private String descripcion;
	private char tipo;
	
	private Servicio() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCod_especialidad() {
		return cod_especialidad;
	}

	public void setCod_especialidad(String cod_especialidad) {
		this.cod_especialidad = cod_especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
}
