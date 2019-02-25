package vista.Intervencion;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Intervencion.Intervencion;


public class VentanaIntervencionModeloTabla extends AbstractTableModel {

	private static String[] titulos= {"Cedula Paciente","Codigo Trabajo","Codigo Oferta","Fecha"};
	private List<Intervencion> intervenciones = new ArrayList<Intervencion>();
	
	public VentanaIntervencionModeloTabla(List<Intervencion> intervenciones) {
		super();
		this.intervenciones=intervenciones;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return intervenciones.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Intervencion intervencion = intervenciones.get(rowIndex);
		switch (columnIndex) {
			case 0: return intervencion.getCedula();
			case 1: return intervencion.getCodigoT();
			case 2: return intervencion.getCodigoO();
			case 3: return intervencion.getFecha();
			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
	
	
	
	
	
	
	
	
	
	
	
//fin tabla	
}