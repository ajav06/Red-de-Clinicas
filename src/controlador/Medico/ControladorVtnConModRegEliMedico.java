//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Clinica.ClinicaBD;
import modelo.Especialidad.EspecialidadBD;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import modelo.Medico.Trabajo;
import modelo.Paciente.PacienteBD;
import vista.Medico.VentanaConModRegMedico;

public class ControladorVtnConModRegEliMedico implements ActionListener{
	private VentanaConModRegMedico vtnMedico;
	private List<Trabajo> horario;
	
	public ControladorVtnConModRegEliMedico(Medico medico, int accion) throws SQLException {
		super();

		ClinicaBD cli = new ClinicaBD();
		EspecialidadBD esp = new EspecialidadBD();
		
		this.vtnMedico = new VentanaConModRegMedico(cli.nombresClinicas(),esp.nombresEspecialidades());
		this.vtnMedico.setLocationRelativeTo(null);
		this.vtnMedico.setVisible(true);
		this.vtnMedico.addListener(this);
		this.vtnMedico.llenarCampos(medico.getCedula(),medico.getCod_especialidad(),medico.getNombre(),medico.getApellido(),medico.getFechaNacimiento(),medico.getEdo_civil(),medico.getEstado(),medico.getDireccion(),medico.getTlf_casa(),medico.getNroTelefonico(),medico.getEmail());
		
		if (accion==1) {
			this.vtnMedico.interfazRegistro();
			this.vtnMedico.blanquearCampos();
		} else if (accion==2) {
			this.vtnMedico.interfazConsulta();
			this.poblarHorario();
		}
	}
	
	public ControladorVtnConModRegEliMedico(int accion) throws SQLException {
		super();

		ClinicaBD cli = new ClinicaBD();
		EspecialidadBD esp = new EspecialidadBD();
		
		this.vtnMedico = new VentanaConModRegMedico(cli.nombresClinicas(),esp.nombresEspecialidades());
		this.vtnMedico.setLocationRelativeTo(null);
		this.vtnMedico.setVisible(true);
		this.vtnMedico.addListener(this);
		
		this.vtnMedico.interfazRegistro();
		this.vtnMedico.blanquearCampos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Registrar")) {
			registrarMedico();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarMedico();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarMedico();
		}
		else if (actionCommand.equals("Salir")) {
			salir();
		}
	}
	
	private void registrarMedico(){
	  	try
		{
	  		if(vtnMedico.chequearLlenos())//Deben estar todos los campos llenos para poder incluir al médico
	    		vtnMedico.mostrarMensaje("Debe llenar todos los datos para poder registrar al médico");
	    	else
	    	{
	    		MedicoBD medicoBD = new MedicoBD();
	    		if (medicoBD.verificarMedico(vtnMedico.getCedula(),true)==1) {
	    			Object[] opciones = {"Sí","No"};
	    			int n = JOptionPane.showOptionDialog(null,"El médico ya existe pero fue eliminado.\n¿Desea reingresar?","Médico ya existe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[1]);
	    			if (n==JOptionPane.YES_OPTION) {
	    				medicoBD.reingresarMedico(vtnMedico.getCedula());
	    				vtnMedico.mostrarMensaje("Médico reingresado exitosamente.");
	    				vtnMedico.salir();
	    			}
	    		} else if (medicoBD.verificarMedico(vtnMedico.getCedula(), false)==1) {
	    			vtnMedico.mostrarMensaje("El médico ya está registrado en el sistema.");
	    		} else {
			    	Medico medico = new Medico.Builder(vtnMedico.getCedula())
			    			.cod_especialida(vtnMedico.getEspecialidad())
			    			.nomb(vtnMedico.getNombre())
			    			.apellid(vtnMedico.getApellido())
			    			.fechaNacimient(vtnMedico.getFechaN())
			    			.edo_civi(vtnMedico.getEdoC())
			    			.estad(vtnMedico.getEstado())
			    			.direccio(vtnMedico.getDireccion())
			    			.tlf_cas(vtnMedico.getTlfCasa())
			    			.nroTelefonic(vtnMedico.getTlfCelular())
			    			.emai(vtnMedico.getEmail())
			    			.build();
			    	medicoBD.registrarMedico(medico);
			    	this.horarioNuevo();
			    	vtnMedico.mostrarMensaje("El Médico fue incluido con exito");
			    	vtnMedico.blanquearCampos();
			    	vtnMedico.salir();
	    		}
	    	}
		} catch(Exception e)
		{
			vtnMedico.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	private void modificarMedico(){
	  	try
		{
	    	if(vtnMedico.chequearLlenos()) //Deben estar todos los campos llenos para poder actualizar al paciente
	    		vtnMedico.mostrarMensaje("Debe llenar todos los datos para poder modificar al médico");
	    	else
	    	{
	    		MedicoBD medicoBD = new MedicoBD();
		    	Medico medico = new Medico.Builder(vtnMedico.getCedula())
		    			.cod_especialida(vtnMedico.getEspecialidad())
		    			.nomb(vtnMedico.getNombre())
		    			.apellid(vtnMedico.getApellido())
		    			.fechaNacimient(vtnMedico.getFechaN())
		    			.edo_civi(vtnMedico.getEdoC())
		    			.estad(vtnMedico.getEstado())
		    			.direccio(vtnMedico.getDireccion())
		    			.tlf_cas(vtnMedico.getTlfCasa())
		    			.nroTelefonic(vtnMedico.getTlfCelular())
		    			.emai(vtnMedico.getEmail())
		    			.build();
		    	medicoBD.actualizarMedico(medico);
		    	this.actuHorario();
		    	vtnMedico.mostrarMensaje("El Médico fue actualizado con exito");
		    	vtnMedico.blanquearCampos();
		    	vtnMedico.salir();
	    	}
		}catch(Exception e)
		{
			vtnMedico.mostrarMensaje(e.getMessage());
		}
	}
	
	private void eliminarMedico(){
	  	try
		{
	  		MedicoBD medicoBD = new MedicoBD();	    
	  		medicoBD.eliminarMedico(vtnMedico.getCedula());
	  		vtnMedico.mostrarMensaje("El Médico fue eliminado con exito");
	  		vtnMedico.blanquearCampos();
	  		vtnMedico.salir();
		}catch(Exception e)
		{
			vtnMedico.mostrarMensaje("No se pudo eliminar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void poblarHorario() {
		String[] turno = new String[] {"-1","-1","-1","-1","-1","-1","-1","-1","-1","-1"};
		String[] clinicas = new String[] {"-1","-1","-1","-1","-1","-1","-1","-1","-1","-1"};
		try {
			MedicoBD medicoBD = new MedicoBD();
			horario = medicoBD.consultarHorario(vtnMedico.getCedula());
			for (int i=0;i<horario.size();i++) {
				turno[i] = horario.get(i).getTurno();
				clinicas[i] = horario.get(i).getCod_clinica();
			}
		} catch (Exception e) {
			vtnMedico.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
		vtnMedico.setHorario(clinicas, turno);
	}
	
	private void horarioNuevo() throws SQLException {
		horario = new ArrayList<Trabajo>();
		Trabajo t;
		try{
			String[][] h = new String[2][10];
			h = vtnMedico.getHorario();
			for (int i=0;i<10;i++) {
				String turno = h[1][i];
				String cod_cl = h[0][i];
				String cod = null;
				t = new Trabajo.Builder(cod)
						.cod_clinic(cod_cl)
						.turn(turno)
						.build();
				horario.add(t);
			}
			MedicoBD medicoBD = new MedicoBD();
			medicoBD.registrarHorarioNvo(vtnMedico.getCedula(), horario);
		} catch (Exception e) {
			vtnMedico.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	private void actuHorario() throws SQLException {
		String[][] h = new String[2][10];
		h = vtnMedico.getHorario();
		for (int i=0;i<10;i++) {
			horario.get(i).setTurno(h[1][i]);
			horario.get(i).setCod_clinica(h[0][i]);
		}
		MedicoBD medicoBD = new MedicoBD();
		medicoBD.actualizarHorario(vtnMedico.getCedula(), horario);
	}
	
	private void salir() {
		vtnMedico.salir();
	}
}
