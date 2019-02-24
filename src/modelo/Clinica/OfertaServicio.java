package modelo.Clinica;

public class OfertaServicio {

	private String codigo;
	private String tipo_servicio;
	private String descripcion;
	private float precio;
	
	public OfertaServicio(String codigo, String tipo, String descripcion, float monto) {
		this.codigo = codigo;
		this.tipo_servicio = tipo;
		this.descripcion = descripcion;
		this.precio = monto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
