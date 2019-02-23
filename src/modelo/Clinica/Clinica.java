package modelo.Clinica;

public class Clinica {
	
	private String codigo;
	private String nombre;
	private String estado;
	private String direccion;
	private String telefono;
	private String correo;
	


	public Clinica(String codigo, String nombre, String estado, String direccion,String telefono,String correo)
	{
		super();
		this.codigo=codigo;
		this.nombre=nombre;
		this.estado=estado;
		this.direccion=direccion;
		this.telefono=telefono;
		this.correo=correo;
		
	}
	public Clinica()
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
