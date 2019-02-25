//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Seguro;

public class Seguro {
	public static class Builder{
		private int codigo;
		private String nombre;
		private String descripcion;

		public Builder(int codigo) {
			this.codigo = codigo;
		}
		
		public Builder nombr(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder descripcio(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
		
		public Seguro build() {
			Seguro s = new Seguro();
			s.codigo=codigo;
			s.nombre=nombre;
			s.descripcion=descripcion;
			return s;
		}
	}
	private int codigo;
	private String nombre;
	private String descripcion;
	
	private Seguro() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	
	
}
