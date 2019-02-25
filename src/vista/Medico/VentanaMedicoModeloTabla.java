//RED DE CLÍNICAS
//Proyecto de Laboratorio 1
//
//Integrantes:
//Gabriel Roa 25919459
//Albert Acevedo 26710983
//Marielba Maldonádo 26088718
//Juan Cardenas 

package vista.Medico;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

import modelo.Medico.Medico;

public class VentanaMedicoModeloTabla extends AbstractTableModel{
	private static String[] titulos = {"Cedula", "Nombre", "Especialidad"};
	private static DefaultComboBoxModel especialidades;
	private List<Medico> medicos = new ArrayList<Medico>();

	public VentanaMedicoModeloTabla(List<Medico> medicos, DefaultComboBoxModel dc) {
		super();
		this.medicos=medicos;
		this.especialidades = dc;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {		
		return titulos.length;
	}

	@Override
	public int getRowCount() {		
		return medicos.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Medico medico = medicos.get(rowIndex);
		switch (columnIndex) {
			case 0: return medico.getCedula();
			case 1: return (medico.getNombre() + " " + medico.getApellido());
			case 2: return especialidades.getElementAt(Integer.parseInt(medico.getCod_especialidad())); 
			}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
}
