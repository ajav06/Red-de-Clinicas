//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.Clinica.ClinicaBD;
import modelo.Consulta.Consulta;
import modelo.Consulta.ConsultaBD;
import modelo.Clinica.ClinicaBD;
import vista.Consulta.VentanaConsultarConsulta;
public class ControladorVtnConsultarConsulta {
	private VentanaConsultarConsulta vtnConsulCon;
public ControladorVtnConsultarConsulta(Consulta consulta) throws SQLException 
{
	super();
	ClinicaBD cli = new ClinicaBD();
	this.vtnConsulCon = new VentanaConsultarConsulta(cli.nombresServicios());
	this.vtnConsulCon.setLocationRelativeTo(null);
	this.vtnConsulCon.setVisible(true);
     this.vtnConsulCon.llenarCampos(consulta.getCedulaP(), consulta.getClinica(),
    		 consulta.getFecha(),consulta.getMedico(), Integer.valueOf(consulta.getServicio()), consulta.getMotivo(), 
    		 consulta.getDiagnostico(),consulta.getTratamiento());
}

}
