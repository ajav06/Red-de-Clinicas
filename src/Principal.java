import modelo.ConexionBD;
import controlador.ControladorVtnActuPaciente;
import controlador.ControladorVtnAgrePaciente;

public class Principal {
	public static void main(String[] args) {
		new ConexionBD();
		new ControladorVtnAgrePaciente();
	}
}
