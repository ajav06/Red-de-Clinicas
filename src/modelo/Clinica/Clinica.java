package modelo.Clinica;

public class Clinica {
	
	public static class Builder{

		private String codigo;
		private String nombre;
		private String estado;
		private String direccion;
		private String telefono;
		private String correo;
		
		public Builder (String codigo)
		{
			this.codigo=codigo;
		}

		public Builder nombre_clini(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder estado_clini(String estado) {
			this.estado = estado;
			return this;
		}
		
		public Builder direccion_clini(String direccion) {
			this.direccion = direccion;
			return this;
		}
		
		public Builder telefono_clini(String telefono) {
			this.telefono = telefono;
			return this;
		}
		
		public Builder correo_clini(String correo) {
			this.correo = correo;
			return this;
		}
		
		public Clinica build() {
			Clinica cli = new Clinica();
			cli.nombre = this.nombre;
			cli.codigo = this.codigo;
			cli.estado = this.estado;
			cli.direccion = this.direccion;
			cli.telefono = this.telefono;
			cli.correo = this.correo;
			
			return cli;
		}
		
	}
	
	private String codigo;
	private String nombre;
	private String estado;
	private String direccion;
	private String telefono;
	private String correo;
	
	private Clinica()
	{
		super();
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
