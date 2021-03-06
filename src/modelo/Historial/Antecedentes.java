//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package modelo.Historial;

public class Antecedentes {
	public static class Builder{
		private int nroHistorial;
		private String alcohol;
		private String drogas;
		private String infusiones;
		private String tabaco;
		private String alimentacion;
		private String diuresis;
		private String catarsis;
		private String sueno;
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

		public Builder(int nroHistorial) {
			this.nroHistorial = nroHistorial;
		}
		
		public Builder alcoho(String alcohol) {
			this.alcohol = alcohol;
			return this;
		}
		
		public Builder droga(String drogas) {
			this.drogas = drogas;
			return this;
		}
		
		public Builder infusione(String infusiones) {
			this.infusiones = infusiones;
			return this;
		}
		
		public Builder tabac(String tabaco) {
			this.tabaco = tabaco;
			return this;
		}
		
		public Builder alimentacio(String alimentacion) {
			this.alimentacion = alimentacion;
			return this;
		}
		
		public Builder diuresi(String diuresis) {
			this.diuresis = diuresis;
			return this;
		}
		
		public Builder catarsi(String catarsis) {
			this.catarsis = catarsis;
			return this;
		}
		
		public Builder suen(String sueno) {
			this.sueno = sueno;
			return this;
		}
		
		public Builder sexualida(String sexualidad) {
			this.sexualidad = sexualidad;
			return this;
		}
		
		public Builder otros_fi(String otros_fis) {
			this.otros_fis = otros_fis;
			return this;
		}
		
		public Builder cardiaca(String cardiacas) {
			this.cardiacas = cardiacas;
			return this;
		}
		
		public Builder respiratoria(String respiratorias) {
			this.respiratorias = respiratorias;
			return this;
		}
		
		public Builder gastrointestinale(String gastrointestinales) {
			this.gastrointestinales = gastrointestinales;
			return this;
		}
		
		public Builder neufrourologico(String neufrourologicos){
			this.neufrourologicos = neufrourologicos;
			return this;
		}
		
		public Builder neurologico(String neurologicos){
			this.neurologicos = neurologicos;
			return this;			
		}
		
		public Builder hematologico(String hematologicos){
			this.hematologicos = hematologicos;
			return this;
		}
		
		public Builder ginecologo(String ginecologos){
			this.ginecologos = ginecologos;
			return this;
		}
		
		public Builder infectologico(String infectologicos){
			this.infectologicos = infectologicos;
			return this;
		}
		
		public Builder endocrinologico(String endocrinologicos){
			this.endocrinologicos = endocrinologicos;
			return this;
		}
		
		public Builder quirurgico(String quirurgicos){
			this.quirurgicos = quirurgicos;
			return this;
		}
		
		public Builder traumatolofico(String traumatoloficos){
			this.traumatoloficos = traumatoloficos;
			return this;
		}
		
		public Builder alergico(String alergicos){
			this.alergicos = alergicos;
			return this;
		}
		
		public Builder epidemiologico(String epidemiologicos){
			this.epidemiologicos = epidemiologicos;
			return this;
		}
		
		public Builder otras_en(String otras_enf){
			this.otras_enf = otras_enf;
			return this;
		}
		
		public Builder enf_infanci(String enf_infanci){
			this.enf_infancia = enf_infanci;
			return this;
		}
		
		public Antecedentes build() {
			Antecedentes a = new Antecedentes();
			a.nroHistorial = nroHistorial;
			a.alcohol = alcohol;
			a.drogas = drogas;
			a.infusiones = infusiones;
			a.tabaco = tabaco;
			a.alimentacion = alimentacion;
			a.diuresis = diuresis;
			a.catarsis = catarsis;
			a.sueno = sueno;
			a.sexualidad = sexualidad;
			a.otros_fis = otros_fis;
			a.cardiacas = cardiacas;
			a.respiratorias = respiratorias;
			a.gastrointestinales = gastrointestinales;
			a.neufrourologicos = neufrourologicos;
			a.neurologicos = neurologicos;
			a.hematologicos = hematologicos;
			a.ginecologos = ginecologos;
			a.infectologicos = infectologicos;
			a.endocrinologicos = endocrinologicos;
			a.quirurgicos = quirurgicos;
			a.traumatoloficos = traumatoloficos;
			a.alergicos = alergicos;
			a.epidemiologicos = epidemiologicos;
			a.otras_enf = otras_enf;
			a.enf_infancia = enf_infancia;
			return a;
		}
		
	}
	private int nroHistorial;
	private String alcohol;
	private String drogas;
	private String infusiones;
	private String tabaco;
	private String alimentacion;
	private String diuresis;
	private String catarsis;
	private String sueno;
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
	
	private Antecedentes() {
		super();
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
	public String getSueno() {
		return sueno;
	}
	public void setSueno(String sueno) {
		this.sueno = sueno;
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
