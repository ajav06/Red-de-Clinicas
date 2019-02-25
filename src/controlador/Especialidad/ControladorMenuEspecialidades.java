//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Especialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import controlador.Especialidad.ControladorVtnListaEspecialidades;
import vista.Clinica.VentanaMenuClinicas;
import controlador.Especialidad.ControladorVtnEspecElim;
import vista.Especialidad.VentanaMenuEspecialidades;
public class ControladorMenuEspecialidades implements ActionListener 
{
private VentanaMenuEspecialidades vtnMEsp;
	
	public ControladorMenuEspecialidades() 
	{
		super();
		this.vtnMEsp = new VentanaMenuEspecialidades();
		this.vtnMEsp.setLocationRelativeTo(null);
		this.vtnMEsp.setVisible(true);
		this.vtnMEsp.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Gestionar Especialidades")) {
			try {
				new ControladorVtnListaEspecialidades();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		else if (actionCommand.equals("Reactivar Especialidades")) {
			try {
				new ControladorVtnEspecElim();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
}
	}
}
