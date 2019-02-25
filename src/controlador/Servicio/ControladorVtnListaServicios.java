package controlador.Servicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import controlador.Paciente.ControladorVtnPaciente;
import modelo.Especialidad.EspecialidadBD;
import modelo.Medico.Medico;
import modelo.Medico.MedicoBD;
import modelo.Paciente.PacienteBD;
import modelo.Servicio.Servicio;
import modelo.Servicio.ServicioBD;
import vista.Medico.VentanaMedicoModeloTabla;
import vista.Servicio.VentanaListadoServicios;
import vista.Servicio.VentanaServicioModelo;

public class ControladorVtnListaServicios implements ActionListener{
	private VentanaListadoServicios vtnServicio;
	private DefaultComboBoxModel especialidades;
	private DefaultComboBoxModel especialidades2;
	
	public ControladorVtnListaServicios() throws SQLException {
		super();
		EspecialidadBD e = new EspecialidadBD();
		especialidades = new DefaultComboBoxModel();
		especialidades.addElement("Todas Especialidades");
		especialidades2 = e.nombresEspecialidades();
		for (int i=0;i<especialidades2.getSize();i++) {
			especialidades.addElement(especialidades2.getElementAt(i));
		}
		this.vtnServicio = new VentanaListadoServicios(especialidades);
		this.vtnServicio.setLocationRelativeTo(null);
		this.vtnServicio.setVisible(true);
		cargarDatosServicio();
		this.vtnServicio.addListener(this);
	}
	
	private void cargarDatosServicio() {
		try {
			ServicioBD servicioBD = new ServicioBD();
			List<Servicio> servicios = servicioBD.listaServicios();
			this.vtnServicio.setResultados(new VentanaServicioModelo(servicios));
			this.vtnServicio.limpiarCodigo();
		} catch (Exception e) {
			vtnServicio.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarServicio();
		}		
		else if (actionCommand.equals("Actualizar")) {
			actualizarServicio();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarServicio();
		}
		else if (actionCommand.equals("Incluir")) {
			incluirServicio();		
		}
		else if (actionCommand.equals("Volver")) {
			vtnServicio.salir();
		}
		else if (actionCommand.equals("Refrescar")) {
			cargarDatosServicio();
		}
		
	}

	private void incluirServicio() {
		try {
			new ControladorVtnServicio(null, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			vtnServicio.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}		
	}

	private void eliminarServicio() {
		try {
			JTable tabla = vtnServicio.getTblServicios();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnServicio.mostrarMensaje("Seleccione un paciente del listado para actualizarlo.");
			} else {
				String codigo = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				ServicioBD servicioBD = new ServicioBD();
				Servicio ser = servicioBD.buscarServicio2(codigo);
				new ControladorVtnServicio(ser, 3);
			}
		} catch (Exception e) {
			vtnServicio.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}		
	}

	private void actualizarServicio() {
		try {
			JTable tabla = vtnServicio.getTblServicios();
			int fila = tabla.getSelectedRow();
			if (fila == -1) {
				vtnServicio.mostrarMensaje("Seleccione un paciente del listado para actualizarlo.");
			} else {
				String codigo = String.valueOf(tabla.getModel().getValueAt(fila, 0));
				ServicioBD servicioBD = new ServicioBD();
				Servicio ser = servicioBD.buscarServicio2(codigo);
				new ControladorVtnServicio(ser, 2);
			}
		} catch (Exception e) {
			vtnServicio.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
		}
		
	}

	private void buscarServicio() {
		try {
			if ("".equals(vtnServicio.getCodigo())) {
				ServicioBD servicioDB = new ServicioBD();
				List<Servicio> servicios = new ArrayList<Servicio>();
				String sql = null;
				if (vtnServicio.getEspecialidad()!=0) {
					sql = "cod_especialidad = '"+String.valueOf(vtnServicio.getEspecialidad()-1)+"'";	
					servicios = servicioDB.listaServiciosFiltro(sql);
					this.vtnServicio.setResultados(new VentanaServicioModelo(servicios));
					this.vtnServicio.limpiarCodigo();
				} else {
					cargarDatosServicio();
				}
				
			} else {
				boolean n;
				try {
					Integer.parseInt(vtnServicio.getCodigo());
					n=true;
				} catch (NumberFormatException e) {
					n=false;
				}
				if (!n){ //si estoy buscando por nombre o descripcion
					ServicioBD servicioDB = new ServicioBD();
					List<Servicio> servicios = new ArrayList<Servicio>();
					String sql = null;

					if (vtnServicio.getEspecialidad()==0) {
						sql = "lower(servicio.nombre) like lower('%"+vtnServicio.getCodigo()+"%') or lower(servicio.descripcion) like lower('%"+vtnServicio.getCodigo()+"%')";						
					} else {
						sql = "lower(servicio.nombre) like lower('%"+vtnServicio.getCodigo()+"%') or lower(servicio.descripcion) like lower('%"+vtnServicio.getCodigo()+"%') AND cod_especialidad='"+String.valueOf(vtnServicio.getEspecialidad()-1)+"'";
					}
					
					servicios = servicioDB.listaServiciosFiltro(sql);
					this.vtnServicio.setResultados(new VentanaServicioModelo(servicios));
					this.vtnServicio.limpiarCodigo();
				} else { //si estoy buscando por codigo
					ServicioBD servicioDB = new ServicioBD();
					List<Servicio> servicios = new ArrayList<Servicio>();
					Servicio servicio = servicioDB.buscarServicio(vtnServicio.getCodigo());
					if (servicio==null) {
						this.vtnServicio.mostrarMensaje("Médico no encontrado.");
						cargarDatosServicio();
					} else {
						servicios.add(servicio);
						this.vtnServicio.setResultados(new VentanaServicioModelo(servicios));
						this.vtnServicio.limpiarCodigo();
					}
				}
			}
		} catch (Exception e) {
			vtnServicio.mostrarMensaje(e.getClass().getName()+": "+e.getMessage());
			vtnServicio.mostrarMensaje("No se pudo buscar el médico, verifique que los datos sean correctos");
		}
	}

}
