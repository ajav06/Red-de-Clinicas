package modelo.Servicio;

public class Servicio {
	private String codigo, cod_especialidad, nombre, descripcion;
	private char tipo;
	
	public Servicio(String cod_especialidad, String codigo, String nombre, String descripcion, char tipo) {
		super();
		this.codigo = codigo;
		this.cod_especialidad = cod_especialidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
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
