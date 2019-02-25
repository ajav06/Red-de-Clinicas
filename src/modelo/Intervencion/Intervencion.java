package modelo.Intervencion;
import java.util.Date;



public class Intervencion {
	
	String cedula, codigoT, codigoO;
	Date fecha;
	
	public Intervencion(String cedula, String codigoT, String codigoO, Date fecha) {
		super();
		this.cedula=cedula;
		this.codigoT=codigoT;
		this.codigoO = codigoO;
		this.fecha=fecha;
		
	}
	

	
	

	


	
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setCodigoT(String codigoT) {
		
		this.codigoT=codigoT;
			
	}

	public String getCodigoT() {		
		return codigoT;
		
	}
	
	public void setCodigoO(String codigoO) {
		
		this.codigoO=codigoO;
			
	}

	public String getCodigoO() {		
		return codigoO;
		
	}
	
		
	
	public void setFecha(Date fecha) {
		
		this.fecha = fecha;
			
	}
	public Date getFecha () {
		
		
		return fecha;
	}

	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//fin	
}
