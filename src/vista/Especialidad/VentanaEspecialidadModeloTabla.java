//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Especialidad;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Especialidad.Especialidad;


public class VentanaEspecialidadModeloTabla extends AbstractTableModel {

	private static String[] titulos= {"Codigo","Nombre","Descripcion"};
	private List<Especialidad> especialidades = new ArrayList<Especialidad>();
	
	public VentanaEspecialidadModeloTabla(List<Especialidad> especialidades) {
		super();
		this.especialidades=especialidades;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return especialidades.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Especialidad especialidad = especialidades.get(rowIndex);
		switch (columnIndex) {
			case 0: return especialidad.getCodigo();
			case 1: return especialidad.getNombre();
			case 2: return especialidad.getDescripcion();
			
			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
	
	
	
	
	
	
	
	
	
	
	
//fin tabla	
}
