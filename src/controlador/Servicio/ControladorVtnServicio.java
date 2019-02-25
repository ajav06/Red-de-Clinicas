package controlador.Servicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

import controlador.Historial.ControladorVtnHistorial;
import modelo.Clinica.ClinicaBD;
import modelo.Especialidad.EspecialidadBD;
import modelo.Servicio.Servicio;
import modelo.Servicio.ServicioBD;
import vista.Servicio.VentanaListadoServicios;
import vista.Servicio.VentanaServicio;

public class ControladorVtnServicio implements ActionListener{
	private VentanaServicio vtnServicio;
	private DefaultComboBoxModel especialidades;
	
	public ControladorVtnServicio(Servicio serv, int action) throws SQLException {
		super();
		EspecialidadBD e = new EspecialidadBD();
		especialidades = e.nombresEspecialidades();
		ServicioBD ser = new ServicioBD();
		if(action==1) {		
			String c = "-1";
			try{
				c = String.valueOf(ser.generarNuevoCodigoServicio());
			} catch (SQLException re){
				re.printStackTrace();
			}
			this.vtnServicio = new VentanaServicio(c,especialidades);
			this.vtnServicio.interfazIncluir();
		}
		else if(action==2) {
			this.vtnServicio = new VentanaServicio(serv.getCodigo(),especialidades);
			this.vtnServicio.llenarCampos(serv.getCodigo(), serv.getNombre(), serv.getDescripcion(), Integer.parseInt(serv.getCod_especialidad()), serv.getTipo());
			this.vtnServicio.interfazModificar();
		}
		else {
			this.vtnServicio = new VentanaServicio(serv.getCodigo(),especialidades);
			this.vtnServicio.llenarCampos(serv.getCodigo(), serv.getNombre(), serv.getDescripcion(), Integer.parseInt(serv.getCod_especialidad()), serv.getTipo());
			this.vtnServicio.interfazEliminar();
		}
		this.vtnServicio.setLocationRelativeTo(null);
		this.vtnServicio.setVisible(true);
		this.vtnServicio.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Incluir")) {
			try {
				registrarServicio();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarServicio();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarServicio();
		}
		else if (actionCommand.equals("Volver")) {
			vtnServicio.salir();
		}
	}

	private void eliminarServicio() {
		ServicioBD servicioDB = new ServicioBD();
		servicioDB.eliminarServicio(vtnServicio.getTextFieldCodigo());
		vtnServicio.mostrarMensaje("Servicio Eliminado con Exito");
		vtnServicio.vaciarCampos();
	}

	private void modificarServicio() {
		if(vtnServicio.validarCampos()) {
			ServicioBD servicioDB = new ServicioBD();
			Servicio servicio = new Servicio.Builder(String.valueOf(vtnServicio.getComboBox_Especialidad()))
					.cod_especialida(vtnServicio.getTextFieldCodigo())
					.nombr(vtnServicio.getTextField_Nombre())
					.descripcio(vtnServicio.getTextField_Descripcion())
					.tip(vtnServicio.getComboBox_Tipo())
					.build();
			servicioDB.actualizarServicio(servicio);
			vtnServicio.mostrarMensaje("Servicio Modificado con Exito");
			vtnServicio.vaciarCampos();
		}
		else
			vtnServicio.mostrarMensaje("Por Favor, Llenar todos los Campos");
	}

	private void registrarServicio() throws NumberFormatException, SQLException {
		if(vtnServicio.validarCampos()) {
			ServicioBD servicioDB = new ServicioBD();
			Servicio servicio = new Servicio.Builder(String.valueOf(vtnServicio.getComboBox_Especialidad()))
					.cod_especialida(vtnServicio.getTextFieldCodigo())
					.nombr(vtnServicio.getTextField_Nombre())
					.descripcio(vtnServicio.getTextField_Descripcion())
					.tip(vtnServicio.getComboBox_Tipo())
					.build();
			servicioDB.incluirServicio(servicio);
			vtnServicio.mostrarMensaje("Servicio Incluido con Exito");
			vtnServicio.vaciarCampos();
			String cod = String.valueOf(servicioDB.generarNuevoCodigoServicio());
			vtnServicio.setTextFieldCodigo(cod);
		}
		else
			vtnServicio.mostrarMensaje("Por Favor, Llenar todos los Campos");
	}

}
