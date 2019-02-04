package controlador.Seguro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Seguro.Seguro;
import modelo.Seguro.SeguroDB;
import vista.Seguro.VentanaSeguro;
import vista.Seguro.VentanaSeguroModeloTabla;

public class ControladorVtnSeguro implements ActionListener{
	private VentanaSeguro vtnseguro;
	private Seguro seguro;
	private SeguroDB seguroDB;
	private List<Seguro> seguros;
	private boolean modi;
	
	public ControladorVtnSeguro() throws SQLException {
		super();

		String c = "-1";
	
		seguroDB = new SeguroDB();

		try{
			c = String.valueOf(seguroDB.generarNuevoCodigoSeguro());
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		this.vtnseguro = new VentanaSeguro();
		this.vtnseguro.setLocationRelativeTo(null);
		this.vtnseguro.setVisible(true);
		this.vtnseguro.addListener(this);
		this.vtnseguro.setCodigo(c);
		modi = false;
		cargarDatosSeguros();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Buscar")) {
			buscarSeguro();
		}		
		else if (actionCommand.equals("Modificar")) {
			modificarSeguro();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarSeguro();
		}
		else if (actionCommand.equals("Incluir")) {
			incluirSeguro();
		}
		else if (actionCommand.equals("Volver")) {
			vtnseguro.salir();
		}
	}

	private void incluirSeguro() {
		try {
			if(vtnseguro.getCodigo()==null && vtnseguro.getNombre()==null && vtnseguro.getDescripcion()==null)
				vtnseguro.mostrarMensaje("Debe llenar todos los campos para Incluir");
			else {
				seguroDB = new SeguroDB();
				seguro = new Seguro(Integer.parseInt(vtnseguro.getCodigo()), vtnseguro.getNombre(), vtnseguro.getDescripcion());
				seguroDB.incluirSeguro(seguro);
				cargarDatosSeguros();
 				vtnseguro.blanquearCampos();
				vtnseguro.setCodigo(String.valueOf(seguroDB.generarNuevoCodigoSeguro()));
			}
			
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}
	}


	private void eliminarSeguro() {
		try {
			if (vtnseguro.getTblSeguros().getSelectedColumn()==-1) {
				vtnseguro.mostrarMensaje("Debe seleccionar un seguro del listado para eliminarlo.");
			} else {
				seguroDB = new SeguroDB();
				seguroDB.eliminarSeguro(String.valueOf(vtnseguro.getTblSeguros().getModel().getValueAt(vtnseguro.getTblSeguros().getSelectedRow(), 0)));
				vtnseguro.mostrarMensaje("Seguro eliminado con éxito.");
				cargarDatosSeguros();
 				vtnseguro.blanquearCampos();
				vtnseguro.setCodigo(String.valueOf(seguroDB.generarNuevoCodigoSeguro()));
			}
			
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}	
	}

	private void modificarSeguro() {
		try {
			if (!modi) {
				if (vtnseguro.getTblSeguros().getSelectedColumn()==-1) {
					vtnseguro.mostrarMensaje("Debe seleccionar un seguro del listado para modificarlo.");
				} else {
					seguro = seguroDB.buscarSeguro(String.valueOf(vtnseguro.getTblSeguros().getModel().getValueAt(vtnseguro.getTblSeguros().getSelectedRow(), 0)));
					vtnseguro.setCodigo(String.valueOf(seguro.getCodigo()));
					vtnseguro.llenarDatos(seguro.getNombre(), seguro.getDescripcion());
					modi=true;
					vtnseguro.modificar(true);
				}
			} else {
					seguro = new Seguro(Integer.parseInt(vtnseguro.getCodigo()), vtnseguro.getNombre(), vtnseguro.getDescripcion());
					seguroDB.modificarSeguro(seguro);
					cargarDatosSeguros();
					vtnseguro.blanquearCampos();
					vtnseguro.setCodigo(String.valueOf(seguroDB.generarNuevoCodigoSeguro()));
					modi=false;
					vtnseguro.modificar(false);
			}
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}		
	}

	private void buscarSeguro() {
		try {
			if(vtnseguro.getCodigo()==null)
				vtnseguro.mostrarMensaje("Debe llenar el campo 'Codigo' para Buscar");
			else {
				seguros = new ArrayList();
				seguroDB = new SeguroDB();
				Seguro seguro = seguroDB.buscarSeguro(vtnseguro.getCodigo());
				seguros.add(seguro);
				vtnseguro.mostrarMensaje(seguro.getNombre());
				this.vtnseguro.setResultados(new VentanaSeguroModeloTabla(seguros));
			}
			
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje(e.getClass() + e.getMessage());
		}
	}

	private void cargarDatosSeguros() throws SQLException {
		seguroDB = new SeguroDB();
		seguros = seguroDB.consultarSeguros();
		this.vtnseguro.setResultados(new VentanaSeguroModeloTabla(seguros));
	}

}
