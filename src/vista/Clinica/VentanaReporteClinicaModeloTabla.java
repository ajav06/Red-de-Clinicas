package vista.Clinica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Clinica.OfertaServicio;

public class VentanaReporteClinicaModeloTabla extends AbstractTableModel{
	private static String[] titulos = {"Tipo", "Nombre","Precio unitario", "Total generado"};
	private List<String[]> montos = new ArrayList<String[]>();

public VentanaReporteClinicaModeloTabla(List<String[]> montos) {
	super();
	this.montos=montos;
	this.fireTableDataChanged();
}

@Override
public int getColumnCount() {		
	return titulos.length;
}

@Override
public int getRowCount() {		
	return montos.size();
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	String[] monto = montos.get(rowIndex);
	switch (columnIndex) {
		case 0: return monto[0];
		case 1: return monto[1];
		case 2: return monto[2];
		case 3: return monto[3];
		}
	return null;
}

@Override
public String getColumnName(int column) {
	return titulos[column];
}

}
