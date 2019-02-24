package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JTable;

import controlador.Paciente.ControladorVtnPaciente;
import modelo.Medico.ListadoCitas;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import modelo.Paciente.Paciente;
import modelo.Paciente.PacienteBD;
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
			MedicoBD medicoDB = new MedicoBD();
			List<ListadoCitas> listado;
			try {
				vtnCitas.blanquearCampos();
				listado = medicoDB.consultarCitasMedico(" ", vtnCitas.getFechaIni(), vtnCitas.getFechaFin(), vtnCitas.getFiltro());
				vtnCitas.setResultados(new VentanaCitasMedicoModelo(listado));
			} catch (ParseException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (actionCommand.equals("Filtrar")) {
			filtrarCitasMedico();
		}
		else if (actionCommand.equals("Ver Inf. Paciente")) {
			consultarPaciente();	
		}
	}

	private void consultarPaciente() {
		try {
			JTable tabla = vtnCitas.getTblCitas();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnCitas.mostrarMensaje("Seleccione un paciente del listado para Ver su Información.");
			} else {
				String cedula = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				PacienteBD pacienteBD = new PacienteBD();
				Paciente paciente = pacienteBD.buscarPaciente(cedula);
				new ControladorVtnPaciente(4, paciente);
			}
		} catch (Exception e) {
			vtnCitas.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
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
					vtnCitas.mostrarMensaje("Bienvenido, Dr./Dra. "+medico.getNombre()+" "+medico.getApellido()+", "
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
