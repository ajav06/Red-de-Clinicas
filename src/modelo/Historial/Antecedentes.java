package modelo.Historial;

public class Antecedentes {
	private int nroHistorial;
	private String alcohol;
	private String drogas;
	private String infusiones;
	private String tabaco;
	private String alimentacion;
	private String diuresis;
	private String catarsis;
	private String sueño;
	private String sexualidad;
	private String otros_fis;
	private String cardiacas;
	private String respiratorias;
	private String gastrointestinales;
	private String neufrourologicos;
	private String neurologicos;
	private String hematologicos;
	private String ginecologos;
	private String infectologicos;
	private String endocrinologicos;
	private String quirurgicos;
	private String traumatoloficos;
	private String alergicos;
	private String epidemiologicos;
	private String otras_enf;
	private String enf_infancia;
	
	public Antecedentes(int nroHistorial, String alcohol, String drogas, String infusiones, String tabaco,
			String alimentacion, String diuresis, String catarsis, String sueño, String sexualidad, String otros_fis,
			String cardiacas, String respiratorias, String gastrointestinales, String neufrourologicos, String neurologicos,
			String hematologicos, String ginecologos, String infectologicos, String endocrinologicos, String quirurgicos,
			String traumatoloficos, String alergicos, String epidemiologicos, String otras_enf, String enf_infancia) {
		super();
		this.nroHistorial = nroHistorial;
		this.alcohol = alcohol;
		this.drogas = drogas;
		this.infusiones = infusiones;
		this.tabaco = tabaco;
		this.alimentacion = alimentacion;
		this.diuresis = diuresis;
		this.catarsis = catarsis;
		this.sueño = sueño;
		this.sexualidad = sexualidad;
		this.otros_fis = otros_fis;
		this.cardiacas = cardiacas;
		this.respiratorias = respiratorias;
		this.gastrointestinales = gastrointestinales;
		this.neufrourologicos = neufrourologicos;
		this.neurologicos = neurologicos;
		this.hematologicos = hematologicos;
		this.ginecologos = ginecologos;
		this.infectologicos = infectologicos;
		this.endocrinologicos = endocrinologicos;
		this.quirurgicos = quirurgicos;
		this.traumatoloficos = traumatoloficos;
		this.alergicos = alergicos;
		this.epidemiologicos = epidemiologicos;
		this.otras_enf = otras_enf;
		this.enf_infancia = enf_infancia;
	}
	
	public int getNroHistorial() {
		return nroHistorial;
	}
	public void setNroHistorial(int nroHistorial) {
		this.nroHistorial = nroHistorial;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getDrogas() {
		return drogas;
	}
	public void setDrogas(String drogas) {
		this.drogas = drogas;
	}
	public String getInfusiones() {
		return infusiones;
	}
	public void setInfusiones(String infusiones) {
		this.infusiones = infusiones;
	}
	public String getTabaco() {
		return tabaco;
	}
	public void setTabaco(String tabaco) {
		this.tabaco = tabaco;
	}
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public String getDiuresis() {
		return diuresis;
	}
	public void setDiuresis(String diuresis) {
		this.diuresis = diuresis;
	}
	public String getCatarsis() {
		return catarsis;
	}
	public void setCatarsis(String catarsis) {
		this.catarsis = catarsis;
	}
	public String getSueño() {
		return sueño;
	}
	public void setSueño(String sueño) {
		this.sueño = sueño;
	}
	public String getSexualidad() {
		return sexualidad;
	}
	public void setSexualidad(String sexualidad) {
		this.sexualidad = sexualidad;
	}
	public String getOtros_fis() {
		return otros_fis;
	}
	public void setOtros_fis(String otros_fis) {
		this.otros_fis = otros_fis;
	}
	public String getCardiacas() {
		return cardiacas;
	}
	public void setCardiacas(String cardiacas) {
		this.cardiacas = cardiacas;
	}
	public String getRespiratorias() {
		return respiratorias;
	}
	public void setRespiratorias(String respiratorias) {
		this.respiratorias = respiratorias;
	}
	public String getGastrointestinales() {
		return gastrointestinales;
	}
	public void setGastrointestinales(String gastrointestinales) {
		this.gastrointestinales = gastrointestinales;
	}
	public String getNeufrourologicos() {
		return neufrourologicos;
	}
	public void setNeufrourologicos(String neufrourologicos) {
		this.neufrourologicos = neufrourologicos;
	}
	public String getNeurologicos() {
		return neurologicos;
	}
	public void setNeurologicos(String neurologicos) {
		this.neurologicos = neurologicos;
	}
	public String getHematologicos() {
		return hematologicos;
	}
	public void setHematologicos(String hematologicos) {
		this.hematologicos = hematologicos;
	}
	public String getGinecologos() {
		return ginecologos;
	}
	public void setGinecologos(String ginecologos) {
		this.ginecologos = ginecologos;
	}
	public String getInfectologicos() {
		return infectologicos;
	}
	public void setInfectologicos(String infectologicos) {
		this.infectologicos = infectologicos;
	}
	public String getEndocrinologicos() {
		return endocrinologicos;
	}
	public void setEndocrinologicos(String endocrinologicos) {
		this.endocrinologicos = endocrinologicos;
	}
	public String getQuirurgicos() {
		return quirurgicos;
	}
	public void setQuirurgicos(String quirurgicos) {
		this.quirurgicos = quirurgicos;
	}
	public String getTraumatoloficos() {
		return traumatoloficos;
	}
	public void setTraumatoloficos(String traumatoloficos) {
		this.traumatoloficos = traumatoloficos;
	}
	public String getAlergicos() {
		return alergicos;
	}
	public void setAlergicos(String alergicos) {
		this.alergicos = alergicos;
	}
	public String getEpidemiologicos() {
		return epidemiologicos;
	}
	public void setEpidemiologicos(String epidemiologicos) {
		this.epidemiologicos = epidemiologicos;
	}
	public String getOtras_enf() {
		return otras_enf;
	}
	public void setOtras_enf(String otras_enf) {
		this.otras_enf = otras_enf;
	}
	public String getEnf_infancia() {
		return enf_infancia;
	}
	public void setEnf_infancia(String enf_infancia) {
		this.enf_infancia = enf_infancia;
	}
	
}
