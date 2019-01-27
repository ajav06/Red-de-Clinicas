package controlador.Clinica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//import controlador.Medico.ControladorVtnConModRegEliMedico;
//import controlador.Medico.ControladorVtnEspecialidades;
//import controlador.Paciente.ControladorVtnListPacientes;
import vista.VentanaPrincipal;

public class ControladorVtnPrincipal implements ActionListener{
	private VentanaPrincipal vtnPrin;
	
	public ControladorVtnPrincipal() {
		super();
		this.vtnPrin = new VentanaPrincipal();
		this.vtnPrin.setLocationRelativeTo(null);
		this.vtnPrin.setVisible(true);
		this.vtnPrin.addListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		 actionCommand.equals("Clinica");
		new ControladorVtnAgreClinica();
			
			
		}		
	
			//} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			//}
		
	}


