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
		this.vtnActuCli.mostrarMensaje("hasta aqui voy bien");
	     this.vtnActuCli.llenarCampos(clinica.getCodigo(), clinica.getNombre(),
	    clinica.getEstado(),clinica.getDireccion(), clinica.getTelefono(), 
		 clinica.getCorreo());;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Actualizar")) {
			actualizarClinica();
		}		
		else if (actionCommand.equals("Cancelar")) {
			vtnActuCli.blanquearCampos();
		}
	}
	
	private void actualizarClinica(){
	  	try
		{
	    	if(vtnActuCli.getCodigo().equals("") || vtnActuCli.getNombre().equals("") || vtnActuCli.getEstado().equals("") 
	    			|| vtnActuCli.getDireccion().equals("") || vtnActuCli.getTelefono().equals("")|| vtnActuCli.getCorreo().equals("") )
	    		 //Deben estar todos los campos llenos para poder actualizar la Clinica
	    	vtnActuCli.mostrarMensaje("Debe llenar todos los datos para poder actualizar la clinica");
	    		else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
		    	Clinica clinica = new Clinica(vtnActuCli.getCodigo(),vtnActuCli.getNombre(),
		    	vtnActuCli.getEstado(),vtnActuCli.getDireccion(),
		    	vtnActuCli.getTelefono(),vtnActuCli.getCorreo());	
		    	clinicaBD.actualizarClinica(clinica);
		       vtnActuCli.mostrarMensaje("La Clinica fue incluido con exito");
		    	vtnActuCli.blanquearCampos();
	    	}
		}catch(Exception e)
		{
		vtnActuCli.mostrarMensaje("No se pudo actualizar la Clinica, verifique que los datos sean correctos");
			vtnActuCli.blanquearCampos();
		}
	}
}
