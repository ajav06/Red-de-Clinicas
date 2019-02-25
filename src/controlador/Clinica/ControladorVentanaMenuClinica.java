//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package controlador.Clinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import controlador.Clinica.ControladorVentanaGeneralClinica;
import vista.Clinica.VentanaMenuClinicas;;
public class ControladorVentanaMenuClinica implements ActionListener {
	private VentanaMenuClinicas vtnMClinica;
	
	public ControladorVentanaMenuClinica() {
		super();
		this.vtnMClinica = new VentanaMenuClinicas();
		this.vtnMClinica.setLocationRelativeTo(null);
		this.vtnMClinica.setVisible(true);
		this.vtnMClinica.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Gestionar Clinicas")) {
			try {
				new ControladorVtnLista();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		else if (actionCommand.equals("Reactivar Clinicas")) {
			try {
				new ControladorVentanaGeneralClinica();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
		
		
	}

}
