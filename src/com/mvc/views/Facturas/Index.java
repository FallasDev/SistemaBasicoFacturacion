package com.mvc.views.Facturas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

public class Index extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton btnNuevo;
	public JTextField tBuscar;
	
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public JTable table;
	
	private JPanel panel;
	private JPanel panel_1;
	

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable(modelo);
		personalizarTabla();
		table.setBounds(273, 195, 1, 1);
		table.setRowSorter(filtro);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(620, 300));
		add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 80));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		btnNuevo = new JButton("+Nueva");
		btnNuevo.setBounds(12, 25, 78, 34);
		personalizarBoton(btnNuevo, new Color(50, 205, 50), Color.WHITE, new Color(80, 200, 120));
		panel.add(btnNuevo);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_1, BorderLayout.NORTH);
		
		JLabel lblBuscar = new JLabel("Buscar");
		panel_1.add(lblBuscar);
		
		tBuscar = new JTextField();
		panel_1.add(tBuscar);
		tBuscar.setColumns(10);

	}
	
	public void personalizarTabla() {
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setSelectionForeground(Color.WHITE);
        table.setGridColor(new Color(0xF8F4E4));
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(0x0CA5B0));
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(new Color(0xA5B3AA), 1));
	}
	
	public void personalizarBoton(JButton button,Color bgColor, Color fgColor,Color bdColor) {
		// Cambia el color de fondo, texto y fuente
        button.setBackground(bgColor); // Color de fondo
        button.setForeground(fgColor); // Color del texto
        button.setFont(new Font("Arial", Font.BOLD, 18)); // Fuente y tamaño del texto

        
        // Elimina el borde y añade un borde redondeado
        button.setFocusPainted(false); // Elimina el borde de enfoque
        button.setBorder(BorderFactory.createLineBorder(bdColor, 2, true));
	}
}
