package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controlador.Paciente.ControladorVtnListPacientes;
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
		if (actionCommand.equals("Clínica")) {
			
		}		
		else if (actionCommand.equals("Especialidades")) {
			
		}
		else if (actionCommand.equals("Medicos")) {
			
		}
		else if (actionCommand.equals("Pacientes")) {
			try {
				new ControladorVtnListPacientes();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
