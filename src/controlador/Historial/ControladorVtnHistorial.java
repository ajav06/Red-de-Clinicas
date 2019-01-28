package controlador.Historial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Historial.Antecedentes;
import modelo.Historial.AntecedentesDB;
import modelo.Historial.HistorialMedico;
import modelo.Historial.HistorialMedicoDB;
import vista.Historial.VentanaHistorial;

public class ControladorVtnHistorial implements ActionListener{
	private VentanaHistorial vtnHistorial;
	private HistorialMedicoDB historialDB;
	private AntecedentesDB antecedentesDB;
	private String cedula;
	
	public ControladorVtnHistorial(String cedula, HistorialMedico historial, Antecedentes antecedente) {
		super();
		this.vtnHistorial = new VentanaHistorial();
		this.vtnHistorial.setLocationRelativeTo(null);
		this.vtnHistorial.setVisible(true);
		this.vtnHistorial.addListener(this);
		
		this.cedula=cedula;
		this.vtnHistorial.setCedula(cedula);
		this.vtnHistorial.llenarCampos(Float.toString(historial.getPeso()), Integer.toString(historial.getNumero()), cedula, Float.toString(historial.getAltura()), antecedente.getOtros_fis(), 
				antecedente.getAlcohol(), antecedente.getAlimentacion(), antecedente.getCatarsis(), antecedente.getDiuresis(), antecedente.getDrogas(), antecedente.getInfusiones(), 
				antecedente.getSexualidad(), antecedente.getSueno(), antecedente.getTabaco(), historial.getAnteFamiliar(), antecedente.getAlergicos(), historial.getAnteEnfAct(), 
				antecedente.getCardiacas(), antecedente.getEndocrinologicos(), historial.getEnfActual(), antecedente.getEpidemiologicos(), antecedente.getGastrointestinales(), 
				antecedente.getGinecologos(), antecedente.getHematologicos(), antecedente.getInfectologicos(), antecedente.getNeufrourologicos(),antecedente.getNeufrourologicos(), 
				antecedente.getOtras_enf(), antecedente.getQuirurgicos(), antecedente.getRespiratorias(), antecedente.getTraumatoloficos(), antecedente.getEnf_infancia());
		this.vtnHistorial.setSexo(historial.getSexo());
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
				historialDB = new HistorialMedicoDB();
				HistorialMedico historial = new HistorialMedico(cedula, Integer.parseInt(vtnHistorial.getNumero()), Float.parseFloat(vtnHistorial.getPeso()), 
						Float.parseFloat(vtnHistorial.getAltura()), vtnHistorial.getSexo(), vtnHistorial.getEnfAct(), vtnHistorial.getAnteEnfAct(), vtnHistorial.getAntFami());
				historialDB.incluirHistorial(historial);
				
				antecedentesDB = new AntecedentesDB();
				Antecedentes antecedente = new Antecedentes(Integer.parseInt(vtnHistorial.getNumero()), vtnHistorial.getAlcohol(), vtnHistorial.getDrogas(), vtnHistorial.getInfuciones(), 
						vtnHistorial.getTabaco(), vtnHistorial.getAlimentacion(), vtnHistorial.getDiuresis(), vtnHistorial.getCatarsis(), vtnHistorial.getSuenno(), vtnHistorial.getSexualidad(), 
						vtnHistorial.getOtroFis(), vtnHistorial.getCardiacas(), vtnHistorial.getRespiratorias(), vtnHistorial.getGastrointestinales(), vtnHistorial.getNeofrourologicos(), 
						vtnHistorial.getNeurologicos(), vtnHistorial.getHematologicos(), vtnHistorial.getGinecologicos(), vtnHistorial.getInfectologicos(), vtnHistorial.getEndocrinologicos(), 
						vtnHistorial.getQuirurgicos(), vtnHistorial.getTraumatologicos(), vtnHistorial.getAlergicos(), vtnHistorial.getEpidemiologicos(), vtnHistorial.getOtrosEnf(), vtnHistorial.getEnfeIncancia());
				antecedentesDB.incluirAntecedentes(antecedente);
				
				vtnHistorial.mostrarMensaje("Historial Incluido con Exito");
			}
			
		}catch(Exception e)
		{
			vtnHistorial.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}
		
	}

	private void modificarHistorial() {
		try {
			if(!vtnHistorial.validarCamposLLenos())
				vtnHistorial.mostrarMensaje("Debe llenar todos los campos para Incluir");
			else {
				historialDB = new HistorialMedicoDB();
				HistorialMedico historial = new HistorialMedico(cedula, Integer.parseInt(vtnHistorial.getNumero()), Float.parseFloat(vtnHistorial.getPeso()), 
						Float.parseFloat(vtnHistorial.getAltura()), vtnHistorial.getSexo(), vtnHistorial.getEnfAct(), vtnHistorial.getAnteEnfAct(), vtnHistorial.getAntFami());
				historialDB.modificarHistorial(historial);
				
				antecedentesDB = new AntecedentesDB();
				Antecedentes antecedente = new Antecedentes(Integer.parseInt(vtnHistorial.getNumero()), vtnHistorial.getAlcohol(), vtnHistorial.getDrogas(), vtnHistorial.getInfuciones(), 
						vtnHistorial.getTabaco(), vtnHistorial.getAlimentacion(), vtnHistorial.getDiuresis(), vtnHistorial.getCatarsis(), vtnHistorial.getSuenno(), vtnHistorial.getSexualidad(), 
						vtnHistorial.getOtroFis(), vtnHistorial.getCardiacas(), vtnHistorial.getRespiratorias(), vtnHistorial.getGastrointestinales(), vtnHistorial.getNeofrourologicos(), 
						vtnHistorial.getNeurologicos(), vtnHistorial.getHematologicos(), vtnHistorial.getGinecologicos(), vtnHistorial.getInfectologicos(), vtnHistorial.getEndocrinologicos(), 
						vtnHistorial.getQuirurgicos(), vtnHistorial.getTraumatologicos(), vtnHistorial.getAlergicos(), vtnHistorial.getEpidemiologicos(), vtnHistorial.getOtrosEnf(), vtnHistorial.getEnfeIncancia());
				antecedentesDB.actualizarAntecedentes(antecedente);
				
				vtnHistorial.mostrarMensaje("Historial Incluido con Exito");
			}
			
		}catch(Exception e)
		{
			vtnHistorial.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}
		
	}
}
