//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Servicio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Servicio.Servicio;

public class VentanaServicioModelo extends AbstractTableModel{
	private static String[] titulos = {"Codigo", "Nombre", "Descripci�n", "Especialidad"};
	private List<Servicio> servicios = new ArrayList<Servicio>();
	
	public VentanaServicioModelo(List<Servicio> servicios) {
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
		Servicio servicio = servicios.get(rowIndex);
		switch (columnIndex) {
			case 0: return servicio.getCodigo();
			case 1: return servicio.getNombre();
			case 2: return servicio.getDescripcion();
			case 3: return servicio.getCod_especialidad();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
}
