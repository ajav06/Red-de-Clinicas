package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import modelo.Medico.ListadoCitas;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import vista.Medico.VentanaCitasMedico;
import vista.Medico.VentanaCitasMedicoModelo;

public class ControladorVtnCitasMedico implements ActionListener{
	private VentanaCitasMedico vtnCitas;
	
	public ControladorVtnCitasMedico() throws ParseException {
		super();
		this.vtnCitas = new VentanaCitasMedico();
		this.vtnCitas.setLocationRelativeTo(null);
		this.vtnCitas.setVisible(true);
		this.vtnCitas.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarCitasMedico();
		}
		else if (actionCommand.equals("Volver")) {
			vtnCitas.salir();	
		}
		else if (actionCommand.equals("Vaciar")) {
			try {
				vtnCitas.blanquearCampos();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (actionCommand.equals("Filtrar")) {
			filtrarCitasMedico();
		}
	}

	private void filtrarCitasMedico() {
		try {
			MedicoBD medicoDB = new MedicoBD();
			List<ListadoCitas> listado = medicoDB.consultarCitasMedico(vtnCitas.getTextField_Cedula(), vtnCitas.getFechaIni(), vtnCitas.getFechaFin(), vtnCitas.getFiltro());
			vtnCitas.setResultados(new VentanaCitasMedicoModelo(listado));
		} catch (Exception e) {
			vtnCitas.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}

	private void buscarCitasMedico() {
		try {
			if("".equals(vtnCitas.getTextField_Cedula())) {
				vtnCitas.mostrarMensaje("Por Favor, Ingrese primero el Nro de Cedula del Médico, para poder Continuar");
			}
			else {
				MedicoBD medicoDB = new MedicoBD();
				Medico medico = medicoDB.buscarMedico(vtnCitas.getTextField_Cedula());
				if(medico==null) {
					vtnCitas.mostrarMensaje("Por Favor, Ingrese primero un Nro de Cedula del Médico valido, "
							+ "\npara poder Continuar, ya que no existe Ningún Medico con ese Nro de Cedula");
				}
				else {
					vtnCitas.mostrarMensaje("Bienvenido, "+medico.getNombre()+" "+medico.getApellido()+", "
							+ "\na continuación su agenda de Citas del Día de Hoy");
					vtnCitas.setLabelNombre(medico.getNombre()+" "+medico.getApellido());
					List<ListadoCitas> listado = medicoDB.consultarCitasMedico(medico.getCedula(), vtnCitas.getFechaIni(), vtnCitas.getFechaFin(), vtnCitas.getFiltro());
					vtnCitas.setResultados(new VentanaCitasMedicoModelo(listado));
					vtnCitas.bloquearCed();
				}
			}
		} catch (Exception e) {
			vtnCitas.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
		
	}

}
