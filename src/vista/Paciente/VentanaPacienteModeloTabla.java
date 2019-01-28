package vista.Paciente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Paciente.Paciente;

public class VentanaPacienteModeloTabla extends AbstractTableModel{
	private static String[] titulos = {"Cedula", "Nombres", "Apellidos", "Fecha de Nacimineto", "Edo. Civil", "Tlf. Casa","Tlf. Celular","Email","Estado","Direccion"};
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	public VentanaPacienteModeloTabla(List<Paciente> pacientes) {
		super();
		this.pacientes=pacientes;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return pacientes.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Paciente paciente = pacientes.get(rowIndex);
		switch (columnIndex) {
			case 0: return paciente.getCedula();
			case 1: return paciente.getNombre();
			case 2: return paciente.getApellido();
			case 3: return paciente.getFechaNacimiento();
			case 4: return paciente.getEdo_civil();
			case 5: return paciente.getCasa();
			case 6: return paciente.getCelular();
			case 7: return paciente.getEmail();
			case 8: return paciente.getEstado();
			case 9: return paciente.getDireccion();
			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
}
