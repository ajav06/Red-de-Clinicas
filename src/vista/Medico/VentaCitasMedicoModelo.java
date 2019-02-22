package vista.Medico;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Paciente.Paciente;

public class VentaCitasMedicoModelo extends AbstractTableModel{
	private static String[] titulos = {"Cedula", "Nombres", "Apellidos", "Fecha de Nacimineto", "Edo. Civil", "Tlf. Casa","Tlf. Celular","Email","Estado","Direccion"};
	
	public VentaCitasMedicoModelo() {
		super();
		this.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
