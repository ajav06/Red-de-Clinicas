package modelo.Especialidad;

public class Especialidad {
	
private String codigo;
private String nombre;
private String descripcion;





public Especialidad(String cod,String nom,String des) {
	super();
	this.codigo=cod;
	this.nombre=nom;
	this.descripcion=des;
	
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
