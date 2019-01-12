import controlador.Paciente.ControladorVtnAgrePaciente;
import modelo.ConexionBD;

public class Principal {
	public static void main(String[] args) {
		new ConexionBD();
		new ControladorVtnAgrePaciente();
	}
}
