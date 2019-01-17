package contrilador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Clinica;
import modelo.ClinicaBD;
import vista.Clinica.VentanaAgreagarClinica;
import vista.Paciente.VentanaAgregarPaciente;

public class ControladorVtnAgreClinica implements ActionListener
{
	private VentanaAgreagarClinica vtnAgreCli;
	
	public ControladorVtnAgreClinica() {
		super();
		this.vtnAgreCli = new VentanaAgreagarClinica();
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
			vtnAgreCli.blanquearCampos();
		}
	}
	
	private void registrarClinica(){
	  	try
		{
	    	if(vtnAgreCli.getCodigo().equals("") || vtnAgreCli.getNombre().equals("") || vtnAgreCli.getEstado().equals("") 
	    			|| vtnAgreCli.getCiudad().equals("") || vtnAgreCli.getUbicacion().equals("")|| vtnAgreCli.getTelefono().equals("")|| vtnAgreCli.getCorreo().equals("") )
	    		
	    	   //Deben estar todos los campos llenos para poder registrar al paciente
	    		vtnAgreCli.mostrarMensaje("Debe llenar todos los datos para poder registrar al paciente");
	    	else
	    	{
	    		ClinicaBD clinicaBD = new ClinicaBD();
		        Clinica clinica = new Clinica(vtnAgreCli.getCodigo(),vtnAgreCli.getNombre(),vtnAgreCli.getEstado(),vtnAgreCli.getCiudad()
		    			,vtnAgreCli.getUbicacion(),vtnAgreCli.getTelefono(),vtnAgreCli.getCorreo());		    
		        ClinicaBD.registrarClinica(clinica);
		    	vtnAgreCli.mostrarMensaje("El Paciente fue incluido con exito");
		    	vtnAgreCli.blanquearCampos();
	    	}
		}catch(Exception e)
		{
			vtnAgreCli.mostrarMensaje("No se pudo registrar el Paciente, verifique que los datos sean correctos");
		}
	}
}
