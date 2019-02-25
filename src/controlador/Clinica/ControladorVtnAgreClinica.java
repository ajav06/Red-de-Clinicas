package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import vista.Clinica.VentanaAgreagarClinica;
import vista.Paciente.VentanaPaciente;

public class ControladorVtnAgreClinica implements ActionListener
{
	private VentanaAgreagarClinica vtnAgreCli;
	
	public ControladorVtnAgreClinica() throws NumberFormatException, SQLException {
		super();
		ClinicaBD cli = new ClinicaBD();
		String c = "-1";
		try{
			c = String.valueOf(cli.generarNuevoCodigoClinica());
		} catch (SQLException e){
			e.printStackTrace();
		}
		this.vtnAgreCli = new VentanaAgreagarClinica(c);
		this.vtnAgreCli.setLocationRelativeTo(null);
		this.vtnAgreCli.setVisible(true);
		this.vtnAgreCli.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Registrar")) {
			registrarClinica();
		}		
		else if (actionCommand.equals("Cancelar")) {
			vtnAgreCli.salir();
		}else if (actionCommand.equals("Limpiar")) {
			vtnAgreCli.blanquearCampos();
		}
	}
	
	private void registrarClinica(){
	  	try
		{
	    	if(vtnAgreCli.getCodigo().equals("") || vtnAgreCli.getNombre().equals("") || vtnAgreCli.getEstado().equals("") 
	    			|| vtnAgreCli.getDireccion().equals("") || vtnAgreCli.getTelefono().equals("")|| vtnAgreCli.getCorreo().equals("") )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgreCli.mostrarMensaje("Debe llenar todos los datos para poder registrar la Clinica");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
		    	Clinica clinica = new Clinica.Builder(vtnAgreCli.getCodigo())
						.nombre_clini(vtnAgreCli.getNombre())
						.estado_clini(vtnAgreCli.getEstado())
						.direccion_clini(vtnAgreCli.getDireccion())
						.telefono_clini(vtnAgreCli.getTelefono())
						.correo_clini(vtnAgreCli.getCorreo())
						.build(); 
		        clinicaBD .registrarClinica(clinica);
		    	vtnAgreCli.mostrarMensaje("La Clinica fue incluida con exito");
		    	vtnAgreCli.blanquearCampos();
		    	vtnAgreCli.salir();
	    	}
		}catch(Exception e)
		{
			vtnAgreCli.mostrarMensaje("No se pudo registrar la Clinica, verifique que los datos sean correctos");
		}
	}
}
