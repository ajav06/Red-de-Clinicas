package vista.Medico;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modelo.Medico.ListadoCitas;


public class VentanaCitasMedicoModelo extends AbstractTableModel{
	private static String[] titulos = {"Cedula", "Fecha", "Clinica", "Cita"};
	private List<ListadoCitas> listado = new ArrayList<ListadoCitas>();
	
	public VentanaCitasMedicoModelo(List<ListadoCitas> listado) {
		super();
		this.listado = listado;
		this.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titulos.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listado.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ListadoCitas cita = listado.get(rowIndex);
		switch (columnIndex) {
			case 0: return cita.getCed_Paciente();
			case 1: return cita.getFecha();
			case 2: return cita.getNomb_Clinica();
			case 3: return cita.getTipo_Cita();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

}
