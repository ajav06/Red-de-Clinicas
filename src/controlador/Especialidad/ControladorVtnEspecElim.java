package controlador.Especialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.Especialidad.VentanaEspecialidadModeloTabla;
import controlador.Clinica.ControladorVtnActuClinica;
import controlador.Clinica.ControladorVtnAgreClinica;
import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Especialidad.VentanaEspecialidadesEliminadas;
import vista.Medico.VentanaMedicoModeloTabla;
import modelo.Especialidad.Especialidad;
import modelo.Especialidad.EspecialidadBD;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
public class ControladorVtnEspecElim  implements ActionListener {
private VentanaEspecialidadesEliminadas vtnEElim;
Especialidad especialidad;
public ControladorVtnEspecElim() throws SQLException {
	super();
	this.vtnEElim = new VentanaEspecialidadesEliminadas();
	this.vtnEElim.setLocationRelativeTo(null);
	this.vtnEElim.setVisible(true);
	cargarDatosEspecialidades();
	this.vtnEElim.addListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
	String actionCommand = e.getActionCommand();
	if (actionCommand.equals("Activar")) {
		ActivarEspecilidades();
	}		
	else if (actionCommand.equals("Cancelar")) {
		vtnEElim.salir();
	}
	
}



public void ActivarEspecilidades() {
	try {
	JTable tabla = vtnEElim.getTblEspecialidades();
	int fila = tabla.getSelectedRow();
	if (fila == -1) {
		vtnEElim.mostrarMensaje("Seleccione una especialidad del listado para consultarla.");
	} else {
		String codigo = String.valueOf(tabla.getModel().getValueAt(fila, 0));
		EspecialidadBD especialidadBD = new EspecialidadBD();	    
		especialidadBD.actuRegistro("especialidad", "estatus='a'", "codigo", "'"+codigo+"'");
		MedicoBD medicoBD = new MedicoBD();
		List<Medico> medicos = new ArrayList<Medico>();
		medicos = medicoBD.consultarFiltrarMedicos("estatus='e' and cod_especialidad='"+codigo+"'");
		for (int i=0;i<medicos.size();i++) {
			medicoBD.reingresarMedico(medicos.get(i).getCedula());
		}
		vtnEElim.mostrarMensaje("Especialidad Reactivada exitosamente");
		cargarDatosEspecialidades();
	}
} catch (Exception e) {
	vtnEElim.mostrarMensaje("No se puede activar la Especialidad");
}
}


public void cargarDatosEspecialidades() throws SQLException {
	EspecialidadBD especialidadBD = new EspecialidadBD();
	List<Especialidad> especialidades = especialidadBD.consultarFiltrarEspecialidades("estatus='e' ORDER BY codigo ASC");
this.vtnEElim.setResultados(new VentanaEspecialidadModeloTabla(especialidades));
}


}
