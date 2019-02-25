package vista.Clinica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaReporteClinica extends JFrame {

	private JPanel contentPane;
	private JTable tblListado;
	private JTextField txtIntervenciones;
	private JTextField txtConsultas;
	private JTextField txtTotal;
	private JButton btnSalir;

	/**
	 * Create the frame.
	 */
	public VentanaReporteClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReporteDeIngresos = new JLabel("Reporte de Ingresos");
		lblReporteDeIngresos.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Listado de Consultas e Intervenciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Totales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		btnSalir = new JButton("Salir");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(lblReporteDeIngresos))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSalir))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReporteDeIngresos)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSalir)
					.addContainerGap())
		);
		
		JLabel lblPorIntervencin = new JLabel("Por intervenciones:");
		
		txtIntervenciones = new JTextField();
		txtIntervenciones.setColumns(10);
		
		JLabel lblPorConsultas = new JLabel("Por consultas:");
		
		txtConsultas = new JTextField();
		txtConsultas.setColumns(10);
		
		JLabel lblTotalGenerado = new JLabel("Total Generado:");
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPorIntervencin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIntervenciones, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPorConsultas, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtConsultas, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblTotalGenerado, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPorIntervencin)
						.addComponent(txtIntervenciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblPorConsultas))
						.addComponent(txtConsultas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblTotalGenerado))
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblListado = new JTable();
		scrollPane.setViewportView(tblListado);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void setIntervenciones(String i) {
		txtIntervenciones.setText(i);
	}
	
	public void setConsultas(String i) {
		txtConsultas.setText(i);
	}
	
	public void setTotales(String i) {
		txtTotal.setText(i);
	}
	
	public void cargarTabla(AbstractTableModel a) {
		tblListado.setModel(a);
	}
	
	public void salir() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void addListener(ActionListener actionListener) {
		btnSalir.addActionListener(actionListener);
	}
}
