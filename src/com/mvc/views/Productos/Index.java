package com.mvc.views.Productos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Index extends JPanel {
	public JTable table;
	public JButton btnNuevo;
	public JButton btnActualizar;
	public DefaultTableModel modelo;
	public JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setPreferredSize(new Dimension(10, 80));
		panel_2.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		personalizarBoton(btnNuevo, new Color(50, 205, 50), Color.WHITE, new Color(80, 200, 120));
		btnNuevo.setBounds(12, 25, 78, 34);
		panel_2.add(btnNuevo);
		
		btnActualizar = new JButton("Editar");
		personalizarBoton(btnActualizar, Color.ORANGE, Color.WHITE, new Color(251, 206, 177));
		btnActualizar.setBounds(102, 25, 95, 34);
		panel_2.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		personalizarBoton(btnEliminar, Color.RED, Color.WHITE, new Color(136, 8, 8));
		btnEliminar.setBounds(209, 26, 78, 34);
		panel_2.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		personalizarTabla();
		scrollPane.setViewportView(table);

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
