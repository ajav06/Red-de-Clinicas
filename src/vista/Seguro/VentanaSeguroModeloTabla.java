package vista.Seguro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Seguro.Seguro;

public class VentanaSeguroModeloTabla extends AbstractTableModel{
	private static String[] titulos = {"Codigo", "Nombre", "Descripción"};
	private List<Seguro> seguros = new ArrayList<Seguro>();
	
	public VentanaSeguroModeloTabla(List<Seguro> seguros) {
		super();
		this.seguros=seguros;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return seguros.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Seguro seguro = seguros.get(rowIndex);
		switch (columnIndex) {
			case 0: return seguro.getCodigo();
			case 1: return seguro.getNombre();
			case 2: return seguro.getDescripcion();

			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
}
