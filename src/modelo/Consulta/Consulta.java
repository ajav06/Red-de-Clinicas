package modelo.Consulta;

public class Consulta 
{
	private String cedulaP; 
	private String clinica;
	private String  fecha;
	private String medico;
	private String motivo;
	private String diagnostico;
	private String tratamiento;
	public Consulta(String cedulaP, String clinica, String fecha, String medico,String motivo,String diagnostico,String tratamiento)
	{
		super();
		this.cedulaP=cedulaP;
		this.clinica=clinica;
		this.fecha=fecha;
		this.medico=medico;
		this.motivo=motivo;
		this.diagnostico=diagnostico;
		this.tratamiento=tratamiento;
		
	}
	public Consulta()
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
