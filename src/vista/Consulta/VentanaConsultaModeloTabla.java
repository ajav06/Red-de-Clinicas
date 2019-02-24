package vista.Consulta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Consulta.Consulta;;
public class VentanaConsultaModeloTabla extends AbstractTableModel
{
	private static String[] titulos = {"Cedula del Paciente","Clinica", "Fecha", "Medico"};
	private List<Consulta> consultas = new ArrayList<Consulta>();

	public VentanaConsultaModeloTabla(List<Consulta> consultas) {
		super();
		this.consultas=consultas;
		this.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return consultas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Consulta consulta = consultas.get(rowIndex);
		switch (columnIndex) {
			case 0: return consulta.getCedulaP();
			case 1: return consulta.getClinica();
			case 2: return consulta.getFecha();
			case 3: return consulta.getMedico();
		
			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
}
