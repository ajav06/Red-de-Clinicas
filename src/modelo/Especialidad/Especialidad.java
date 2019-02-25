package modelo.Especialidad;

public class Especialidad {

	public static class Builder{
		private String codigo;
		private String nombre;
		private String descripcion;

		public Builder(String codigo) {
			this.codigo = codigo;
		}
		
		public Builder nombr(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder desc(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
		
		public Especialidad build() {
			Especialidad e = new Especialidad();
			e.codigo=codigo;
			e.nombre=nombre;
			e.descripcion=descripcion;
			return e;
		}
	} 
	
private String codigo;
private String nombre;
private String descripcion;

private Especialidad() {
	super();
}

public void setCodigo(String codigo) {
	
	this.codigo=codigo;
		
}

public String getCodigo() {
	
	
	return codigo;
	
}
public void setDescripcion(String descripcion) {
	
	this.descripcion = descripcion;
		
}
public String getDescripcion () {
	
	
	return descripcion;
}

public void setNombre(String nombre) {
	
	
	this.nombre = nombre;
}

public String getNombre() {
	
	return nombre;
	
	
}






// fin especialidad class
}
