package vista.Clinica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Clinica.Clinica;;

public class VentanaClinicaModeloTabla extends AbstractTableModel{
	private static String[] titulos = {"Nombre", "Estado", "Direccion", "Telefono", "Correo"};
private List<Clinica> clinicas = new ArrayList<Clinica>();

public VentanaClinicaModeloTabla(List<Clinica> clinicas) {
	super();
	this.clinicas=clinicas;
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
	Clinica clinica = clinicas.get(rowIndex);
	switch (columnIndex) {
		case 0: return clinica.getNombre();
		case 1: return clinica.getEstado();
		case 2: return clinica.getDireccion();
		case 3: return clinica.getTelefono();
		case 4: return clinica.getCorreo();
		}
	return null;
}

@Override
public String getColumnName(int column) {
	return titulos[column];
}

}
