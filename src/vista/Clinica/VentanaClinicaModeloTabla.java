package vista.Clinica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Clinica;
public class VentanaClinicaModeloTabla extends AbstractTableModel
{
	private static String[] titulos = {"Codigo", "Nombre", "Estado", "Ciudad", "Ubicacion", "Telefono","Correo"};
	private List<Clinica> Clinicas = new ArrayList<Clinica>();
	
	public VentanaClinicaModeloTabla(List<Clinica> clinicas) {
		super();
		this.Clinicas=clinicas;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return clinicas.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Paciente paciente = pacientes.get(rowIndex);
		switch (columnIndex) {
			case 0: return paciente.getCedula();
			case 1: return paciente.getNombre();
			case 2: return paciente.getApellido();
			case 3: return paciente.getFechaNacimiento();
			case 4: return paciente.getNroHistorial();
			case 5: return paciente.getNroSeguro();
			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

}
