//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Historial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Historial.Antecedentes;
import modelo.Historial.AntecedentesBD;
import modelo.Historial.HistorialMedico;
import modelo.Historial.HistorialMedicoBD;
import vista.Historial.VentanaHistorial;

public class ControladorVtnHistorial implements ActionListener{
	private VentanaHistorial vtnHistorial;
	private HistorialMedicoBD historialDB;
	private AntecedentesBD antecedentesDB;
	private String cedula;
	
	public ControladorVtnHistorial(String cedula, HistorialMedico historial, Antecedentes antecedente, int action) {
		super();
		this.vtnHistorial = new VentanaHistorial();
		this.vtnHistorial.setLocationRelativeTo(null);
		this.vtnHistorial.setVisible(true);
		this.vtnHistorial.addListener(this);
	
		this.vtnHistorial.setCedula(cedula);
		if(action==1) {
			this.vtnHistorial.interfazIncluir();
			this.vtnHistorial.setNroHistorial(cedula);
		}
		else if(action==2) {
			this.vtnHistorial.interfazConsulta();
			this.vtnHistorial.llenarCampos(Float.toString(historial.getPeso()), Integer.toString(historial.getNumero()), cedula, Float.toString(historial.getAltura()), antecedente.getOtros_fis(), 
					antecedente.getAlcohol(), antecedente.getAlimentacion(), antecedente.getCatarsis(), antecedente.getDiuresis(), antecedente.getDrogas(), antecedente.getInfusiones(), 
					antecedente.getSexualidad(), antecedente.getSueno(), antecedente.getTabaco(), historial.getAnteFamiliar(), antecedente.getAlergicos(), historial.getAnteEnfAct(), 
					antecedente.getCardiacas(), antecedente.getEndocrinologicos(), historial.getEnfActual(), antecedente.getEpidemiologicos(), antecedente.getGastrointestinales(), 
					antecedente.getGinecologos(), antecedente.getHematologicos(), antecedente.getInfectologicos(), antecedente.getNeufrourologicos(),antecedente.getNeufrourologicos(), 
					antecedente.getOtras_enf(), antecedente.getQuirurgicos(), antecedente.getRespiratorias(), antecedente.getTraumatoloficos(), antecedente.getEnf_infancia());
			this.vtnHistorial.setSexo(historial.getSexo());
		}
		else if(action==3) {
			this.vtnHistorial.interfazConsulta();
			this.vtnHistorial.desactivarBotones();
			this.vtnHistorial.llenarCampos(Float.toString(historial.getPeso()), Integer.toString(historial.getNumero()), cedula, Float.toString(historial.getAltura()), antecedente.getOtros_fis(), 
					antecedente.getAlcohol(), antecedente.getAlimentacion(), antecedente.getCatarsis(), antecedente.getDiuresis(), antecedente.getDrogas(), antecedente.getInfusiones(), 
					antecedente.getSexualidad(), antecedente.getSueno(), antecedente.getTabaco(), historial.getAnteFamiliar(), antecedente.getAlergicos(), historial.getAnteEnfAct(), 
					antecedente.getCardiacas(), antecedente.getEndocrinologicos(), historial.getEnfActual(), antecedente.getEpidemiologicos(), antecedente.getGastrointestinales(), 
					antecedente.getGinecologos(), antecedente.getHematologicos(), antecedente.getInfectologicos(), antecedente.getNeufrourologicos(),antecedente.getNeufrourologicos(), 
					antecedente.getOtras_enf(), antecedente.getQuirurgicos(), antecedente.getRespiratorias(), antecedente.getTraumatoloficos(), antecedente.getEnf_infancia());
			this.vtnHistorial.setSexo(historial.getSexo());
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();	
		if (actionCommand.equals("Modificar")) {
			modificarHistorial();
		}
		else if (actionCommand.equals("Incluir")) {
			incluirHistorial();
		}
		else if (actionCommand.equals("Volver")) {
			vtnHistorial.salir();
		}
	}

	private void incluirHistorial() {
		try {
			if(vtnHistorial.validarCamposLLenos())
				vtnHistorial.mostrarMensaje("Debe llenar todos los campos para Incluir");
			else {
				historialDB = new HistorialMedicoBD();
				HistorialMedico historial = new HistorialMedico.Builder(vtnHistorial.getCedula())
						.numer(Integer.parseInt(vtnHistorial.getNumero()))
						.pes(Float.parseFloat(vtnHistorial.getPeso()))
						.altur(Float.parseFloat(vtnHistorial.getAltura()))
						.sex(vtnHistorial.getSexo())
						.enfActua(vtnHistorial.getEnfAct())
						.anteEnfAc(vtnHistorial.getAnteEnfAct())
						.anteFamilia(vtnHistorial.getAntFami())
						.build();
				historialDB.incluirHistorial(historial);
				
				antecedentesDB = new AntecedentesBD();
				Antecedentes antecedente = new Antecedentes.Builder(Integer.parseInt(vtnHistorial.getNumero()))
						.alcoho(vtnHistorial.getAlcohol())
						.droga(vtnHistorial.getDrogas())
						.infusione(vtnHistorial.getInfuciones())
						.tabac(vtnHistorial.getTabaco())
						.alimentacio(vtnHistorial.getAlimentacion())
						.diuresi(vtnHistorial.getDiuresis())
						.catarsi(vtnHistorial.getCatarsis())
						.suen(vtnHistorial.getSuenno())
						.sexualida(vtnHistorial.getSexualidad())
						.otros_fi(vtnHistorial.getOtroFis())
						.cardiaca(vtnHistorial.getCardiacas())
						.respiratoria(vtnHistorial.getRespiratorias())
						.gastrointestinale(vtnHistorial.getGastrointestinales())
						.neufrourologico(vtnHistorial.getNeofrourologicos())
						.neurologico(vtnHistorial.getNeurologicos())
						.hematologico(vtnHistorial.getHematologicos())
						.ginecologo(vtnHistorial.getGinecologicos())
						.infectologico(vtnHistorial.getInfectologicos())
						.endocrinologico(vtnHistorial.getEndocrinologicos())
						.quirurgico(vtnHistorial.getQuirurgicos())
						.traumatolofico(vtnHistorial.getTraumatologicos())
						.alergico(vtnHistorial.getAlergicos())
						.epidemiologico(vtnHistorial.getEpidemiologicos())
						.otras_en(vtnHistorial.getOtrosEnf())
						.enf_infanci(vtnHistorial.getEnfeIncancia())
						.build();
				antecedentesDB.incluirAntecedentes(antecedente);
				
				vtnHistorial.mostrarMensaje("Historial Incluido con Exito");
				vtnHistorial.desactivarBotones();
			}
			
		}catch(Exception e)
		{
			vtnHistorial.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
			vtnHistorial.mostrarMensaje(e.getClass()+e.getMessage());
		}
		
	}

	private void modificarHistorial() {
		try {
			if(vtnHistorial.validarCamposLLenos())
				vtnHistorial.mostrarMensaje("Debe llenar todos los campos para Incluir");
			else {
				historialDB = new HistorialMedicoBD();
				HistorialMedico historial = new HistorialMedico.Builder(vtnHistorial.getCedula())
						.numer(Integer.parseInt(vtnHistorial.getNumero()))
						.pes(Float.parseFloat(vtnHistorial.getPeso()))
						.altur(Float.parseFloat(vtnHistorial.getAltura()))
						.sex(vtnHistorial.getSexo())
						.enfActua(vtnHistorial.getEnfAct())
						.anteEnfAc(vtnHistorial.getAnteEnfAct())
						.anteFamilia(vtnHistorial.getAntFami())
						.build();
				historialDB.modificarHistorial(historial);
				
				antecedentesDB = new AntecedentesBD();
				Antecedentes antecedente = new Antecedentes.Builder(Integer.parseInt(vtnHistorial.getNumero()))
						.alcoho(vtnHistorial.getAlcohol())
						.droga(vtnHistorial.getDrogas())
						.infusione(vtnHistorial.getInfuciones())
						.tabac(vtnHistorial.getTabaco())
						.alimentacio(vtnHistorial.getAlimentacion())
						.diuresi(vtnHistorial.getDiuresis())
						.catarsi(vtnHistorial.getCatarsis())
						.suen(vtnHistorial.getSuenno())
						.sexualida(vtnHistorial.getSexualidad())
						.otros_fi(vtnHistorial.getOtroFis())
						.cardiaca(vtnHistorial.getCardiacas())
						.respiratoria(vtnHistorial.getRespiratorias())
						.gastrointestinale(vtnHistorial.getGastrointestinales())
						.neufrourologico(vtnHistorial.getNeofrourologicos())
						.neurologico(vtnHistorial.getNeurologicos())
						.hematologico(vtnHistorial.getHematologicos())
						.ginecologo(vtnHistorial.getGinecologicos())
						.infectologico(vtnHistorial.getInfectologicos())
						.endocrinologico(vtnHistorial.getEndocrinologicos())
						.quirurgico(vtnHistorial.getQuirurgicos())
						.traumatolofico(vtnHistorial.getTraumatologicos())
						.alergico(vtnHistorial.getAlergicos())
						.epidemiologico(vtnHistorial.getEpidemiologicos())
						.otras_en(vtnHistorial.getOtrosEnf())
						.enf_infanci(vtnHistorial.getEnfeIncancia())
						.build();
				antecedentesDB.actualizarAntecedentes(antecedente);
				
				vtnHistorial.mostrarMensaje("Historial Incluido con Exito");
				vtnHistorial.desactivarBotones();
			}
			
		}catch(Exception e)
		{
			vtnHistorial.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}
		
	}
}
