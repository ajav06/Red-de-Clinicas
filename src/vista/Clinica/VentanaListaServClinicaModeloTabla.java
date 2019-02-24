package vista.Clinica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Clinica.OfertaServicio;

public class VentanaListaServClinicaModeloTabla extends AbstractTableModel{
	private static String[] titulos = {"Código", "Tipo","Descripción", "Precio"};
	private List<OfertaServicio> servicios = new ArrayList<OfertaServicio>();

public VentanaListaServClinicaModeloTabla(List<OfertaServicio> servicios) {
	super();
	this.servicios=servicios;
	this.fireTableDataChanged();
}

@Override
public int getColumnCount() {		
	return titulos.length;
}

@Override
public int getRowCount() {		
	return servicios.size();
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	OfertaServicio servicio = servicios.get(rowIndex);
	switch (columnIndex) {
		case 0: return servicio.getCodigo();
		case 1: return servicio.getTipo_servicio();
		case 2: return servicio.getDescripcion();
		case 3: return servicio.getPrecio();
		}
	return null;
}

@Override
public String getColumnName(int column) {
	return titulos[column];
}

}
