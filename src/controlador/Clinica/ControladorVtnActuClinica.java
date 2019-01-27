package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Clinica.Clinica;
import modelo.Clinica.ClinicaBD;
import vista.Clinica.VentanaActualizarClinica;

public class ControladorVtnActuClinica implements ActionListener
{
	private VentanaActualizarClinica vtnActuCli;
	
	public ControladorVtnActuClinica(Clinica clinica) 
	{
		super();
		this.vtnActuCli = new VentanaActualizarClinica();
		this.vtnActuCli.setLocationRelativeTo(null);
		this.vtnActuCli.setVisible(true);
		this.vtnActuCli.addListener(this);
//		this.vtnActuCli.llenarCampos(clinica.getCodigo(), clinica.getNombre(), clinica.getEstado(),clinica.getDireccion(), clinica.getTelefono(), 
//				clinica.getCorreo());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Si")) {
			actualizarPaciente();
		}		
		else if (actionCommand.equals("No")) {
			vtnActuCli.blanquearCampos();
		}
	}
	
	private void actualizarPaciente(){
	  	try
		{
	    	if(vtnActuCli.getCodigo().equals("") || vtnActuCli.getNombre().equals("") || vtnActuCli.getEstado().equals("") 
	    			|| vtnActuCli.getCiudad().equals("") || vtnActuCli.getUbicacion().equals("")|| vtnActuCli.getTelefono().equals("")|| vtnActuCli.getCorreo().equals("") )
	    		 //Deben estar todos los campos llenos para poder actualizar al paciente
	    	vtnActuCli.mostrarMensaje("Debe llenar todos los datos para poder actualizar al paciente");
	    		else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
//		    	Clinica clinica = new Clinica(vtnActuCli.getCodigo(),vtnActuCli.getNombre(),
//		    		vtnActuCli.getEstado(),vtnActuCli.getCiudad(),vtnActuCli.getUbicacion(),
//		    		vtnActuCli.getTelefono(),vtnActuCli.getCorreo());	
//		    	clinicaBD.actualizarClinica(clinica);
		       vtnActuCli.mostrarMensaje("El Paciente fue incluido con exito");
		    	vtnActuCli.blanquearCampos();
	    	}
		}catch(Exception e)
		{
		//	vtnActuCli.mostrarMensaje("No se pudo actualizar el Paciente, verifique que los datos sean correctos");
			vtnActuCli.blanquearCampos();
		}
	}
}
