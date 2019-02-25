package modelo.Consulta;

public class Consulta 
{
	public static class Builder{
		private String cedulaP; 
		private String clinica;
		private String  fecha;
		private String medico;
		private String motivo;
		private String diagnostico;
		private String tratamiento;

		public Builder(String cedulaP) {
			this.cedulaP = cedulaP;
		}
		
		public Builder clinic(String clinica) {
			this.clinica = clinica;
			return this;
		}
		
		public Builder fech(String fecha) {
			this.fecha = fecha;
			return this;
		}
		
		public Builder medic(String medico) {
			this.medico = medico;
			return this;
		}
		
		public Builder motiv(String motivo) {
			this.motivo = motivo;
			return this;
		}
		
		public Builder diagnostic(String diagnostico) {
			this.diagnostico = diagnostico;
			return this;
		}
		
		public Builder tratamient(String tratamiento) {
			this.tratamiento = tratamiento;
			return this;
		}
		
		public Consulta build() {
			Consulta c = new Consulta();
			c.cedulaP=cedulaP;
			c.clinica=clinica;
			c.fecha=fecha;
			c.medico=medico;
			c.motivo=motivo;
			c.diagnostico=diagnostico;
			c.tratamiento=tratamiento;
			return c;
		}
	}
	
	private String cedulaP; 
	private String clinica;
	private String  fecha;
	private String medico;
	private String motivo;
	private String diagnostico;
	private String tratamiento;
	
	private Consulta()
	{
		super();
	}
	
	public String getCedulaP() {
		return cedulaP;
	}
	public void setCedulaP(String cedulaP) {
		this.cedulaP = cedulaP;
	}
	public String getClinica() {
		return clinica;
	}
	public void setClinica(String clinica) {
		this.clinica = clinica;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	
}
