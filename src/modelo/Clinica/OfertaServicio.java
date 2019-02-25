package modelo.Clinica;

public class OfertaServicio {

	public static class Builder{
		private String codigo;
		private String tipo_servicio;
		private String descripcion;
		private float precio;

		public Builder(String codigo) {
			this.codigo = codigo;
		}
		
		public Builder tipo_s(String tipo_servicio) {
			this.tipo_servicio = tipo_servicio;
			return this;
		}
		
		public Builder desc(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
		
		public Builder prec(float precio) {
			this.precio = precio;
			return this;
		}
		
		
		public OfertaServicio build() {
			OfertaServicio os = new OfertaServicio();
			os.codigo = codigo;
			os.tipo_servicio = tipo_servicio;
			os.descripcion = descripcion;
			os.precio = precio;
			return os;
			}
		}
	
	private String codigo;
	private String tipo_servicio;
	private String descripcion;
	private float precio;
	
	private OfertaServicio() {
		super();
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
