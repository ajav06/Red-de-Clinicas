package controlador.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import controlador.Medico.ControladorVtnConModRegEliMedico;
import vista.Medico.VentanaMedicoModeloTabla;
import vista.Medico.VentanaListaMedicos;
import modelo.Especialidad.EspecialidadBD;
import modelo.Medico.*;

public class ControladorVtnListMedicos implements ActionListener {
	private VentanaListaMedicos vtnListMed;
	DefaultComboBoxModel especialidades;
	DefaultComboBoxModel especialidades2;
	Medico medico;
	
	public ControladorVtnListMedicos() throws SQLException {
		super();
		EspecialidadBD e = new EspecialidadBD();
		especialidades = new DefaultComboBoxModel();
		especialidades.addElement("Todas");
		especialidades2 = e.nombresEspecialidades();
		for (int i=0;i<especialidades2.getSize();i++) {
			especialidades.addElement(especialidades2.getElementAt(i));
		}
		this.vtnListMed = new VentanaListaMedicos(especialidades);
		this.vtnListMed.setLocationRelativeTo(null);
		this.vtnListMed.setVisible(true);
		cargarDatosMedico();
		this.vtnListMed.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarMedicos();
		}		
		else if (actionCommand.equals("Consultar")) {
			consultarMedicos();
		}
		else if (actionCommand.equals("Registrar Nuevo")) {
			registrarMedicos();
		}
		else if (actionCommand.equals("Salir")) {
			salir();
		}  
		else if (actionCommand.equals("Filtrar")) {
			filtrarListado();
		} 
		else if (actionCommand.isEmpty()) {
			vtnListMed.getComboBox_Especialidad().setSelectedIndex(0);
			cargarDatosMedico();
		}
	}
	
	private void cargarDatosMedico() {
		try{
			MedicoBD medicoBD = new MedicoBD();
			List<Medico> medicos = medicoBD.consultarMedicos();
			this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos,especialidades2));
			this.vtnListMed.limpiarCedula();
		} catch (SQLException e) {
			vtnListMed.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	private void buscarMedicos() {
		try {
			if ("".equals(vtnListMed.getCedula())) {
				vtnListMed.mostrarMensaje("Introduzca un número de cédula o nombre para realizar la búsqueda.");
			} else {
				boolean n;
				try {
					Integer.parseInt(vtnListMed.getCedula());
					n=true;
				} catch (NumberFormatException e) {
					n=false;
				}
				if (!n){ //si estoy buscando por nombre
					MedicoBD medicoBD = new MedicoBD();
					List<Medico> medicos = new ArrayList<Medico>();
					String sql = null;

					if (vtnListMed.getComboBox_Especialidad().getSelectedIndex()==0) {
						sql = "lower(nombres) like lower('%"+vtnListMed.getCedula()+"%') or lower(apellidos) like lower('%"+vtnListMed.getCedula()+"%')";						
					} else {
						sql = "(lower(nombres) like lower('%"+vtnListMed.getCedula()+"%') or lower(apellidos) like lower('%"+vtnListMed.getCedula()+"%')) and cod_especialidad = '"+String.valueOf(vtnListMed.getComboBox_Especialidad().getSelectedIndex()-1)+"'";
					}
					
					medicos = medicoBD.consultarFiltrarMedicos(sql);
					this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos, especialidades2));
					this.vtnListMed.limpiarCedula();
				} else { //si estoy buscando por cedula
					MedicoBD medicoBD = new MedicoBD();
					List<Medico> medicos = new ArrayList<Medico>();
					medico = medicoBD.buscarMedico(vtnListMed.getCedula());
					if (medico==null) {
						this.vtnListMed.mostrarMensaje("Médico no encontrado.");
						cargarDatosMedico();
					} else {
						medicos.add(medico);
						this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos,especialidades2));
						this.vtnListMed.limpiarCedula();
					}
				}
			}
		} catch (Exception e) {
			vtnListMed.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
			vtnListMed.mostrarMensaje("No se pudo buscar el médico, verifique que los datos sean correctos");
		}
	}
	
	private void consultarMedicos() {
		try {
			JTable tabla = vtnListMed.getTable_Medicos();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnListMed.mostrarMensaje("Seleccione un médico del listado para consultarlo.");
			} else {
				String cedula = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				MedicoBD medicoBD = new MedicoBD();
				medico = medicoBD.buscarMedico(cedula);
				ControladorVtnConModRegEliMedico c = new ControladorVtnConModRegEliMedico(medico,2);
			}
		} catch (Exception e) {
			vtnListMed.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	private void registrarMedicos() {
		medico = new Medico.Builder("").build();
		try {
			ControladorVtnConModRegEliMedico c = new ControladorVtnConModRegEliMedico(1);
		} catch (Exception e) {
			vtnListMed.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
	}
	
	private void filtrarListado() {
		if (vtnListMed.getComboBox_Especialidad().getSelectedIndex()==0) {
			cargarDatosMedico();
		} else {
			List<Medico> medicos = new ArrayList<>();
			try{
				MedicoBD medicoBD = new MedicoBD();
				String filtro = "cod_especialidad='"+vtnListMed.getEspecialidad()+"' AND estatus='a'";
				medicos = medicoBD.consultarFiltrarMedicos(filtro);
				this.vtnListMed.setResultados(new VentanaMedicoModeloTabla(medicos,especialidades2));
				this.vtnListMed.limpiarCedula();
			} catch (SQLException e) {
		         vtnListMed.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
			}
		}
	}
	
	private void salir() {
		vtnListMed.salir();
	}
}
