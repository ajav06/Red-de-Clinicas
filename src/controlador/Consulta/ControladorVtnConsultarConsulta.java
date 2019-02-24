package controlador.Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Consulta.Consulta;
import modelo.Consulta.ConsultaBD;
import vista.Consulta.VentanaConsultarConsulta;
public class ControladorVtnConsultarConsulta {
	private VentanaConsultarConsulta vtnConsulCon;

public ControladorVtnConsultarConsulta(Consulta consulta) 
{
	super();
	this.vtnConsulCon = new VentanaConsultarConsulta();
	this.vtnConsulCon.setLocationRelativeTo(null);
	this.vtnConsulCon.setVisible(true);
     this.vtnConsulCon.llenarCampos(consulta.getCedulaP(), consulta.getClinica(),
    		 consulta.getFecha(),consulta.getMedico(), consulta.getMotivo(), 
    		 consulta.getDiagnostico(),consulta.getTratamiento());;
}

}
