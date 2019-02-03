package controlador.Seguro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import modelo.Seguro.Seguro;
import modelo.Seguro.SeguroDB;
import vista.Seguro.VentanaSeguro;
import vista.Seguro.VentanaSeguroModeloTabla;

public class ControladorVtnSeguro implements ActionListener{
	private VentanaSeguro vtnseguro;
	private Seguro seguro;
	private SeguroDB seguroDB;
	private List<Seguro> seguros;
	
	public ControladorVtnSeguro() throws SQLException {
		super();
		
		String c = "-1";
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
			}
			
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}
	}


	private void eliminarSeguro() {
		try {
			if(vtnseguro.getCodigo()==null)
				vtnseguro.mostrarMensaje("Debe llenar el campo 'Codigo' para Eliminar");
			else {
				seguroDB = new SeguroDB();
				seguroDB.eliminarSeguro(vtnseguro.getCodigo());
				cargarDatosSeguros();
			}
			
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}	
	}

	private void modificarSeguro() {
		try {
			if(vtnseguro.getCodigo()==null && vtnseguro.getNombre()==null && vtnseguro.getDescripcion()==null)
				vtnseguro.mostrarMensaje("Debe llenar todos los campos para Modificar");
			else {
				seguroDB = new SeguroDB();
				Seguro seguro = new Seguro(Integer.parseInt(vtnseguro.getCodigo()), vtnseguro.getNombre(), vtnseguro.getDescripcion());
				seguroDB.modificarSeguro(seguro);
				cargarDatosSeguros();
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
				seguroDB = new SeguroDB();
				seguros = null;
				Seguro seguro = seguroDB.buscarSeguro(vtnseguro.getCodigo());
				seguros.add(seguro);
				this.vtnseguro.setResultados(new VentanaSeguroModeloTabla(seguros));
			}
			
		}catch(Exception e)
		{
			vtnseguro.mostrarMensaje("No se pudo bucar el Seguro, verifique que los datos sean correctos");
		}
	}

	private void cargarDatosSeguros() throws SQLException {
		seguroDB = new SeguroDB();
		List<Seguro> seguros = seguroDB.consultarSeguros();
		this.vtnseguro.setResultados(new VentanaSeguroModeloTabla(seguros));
	}

}
