package com.mvc.views.Clientes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Index extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DefaultTableModel modelo;
	public JButton btnInsertar;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JTable table;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(10, 80));
		panel_1.setLayout(null);
		
		btnInsertar = new JButton("Nuevo");
		btnInsertar.setBounds(12, 25, 78, 34);
		personalizarBoton(btnInsertar, new Color(50, 205, 50), Color.WHITE, new Color(80, 200, 120));
		
		panel_1.add(btnInsertar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(102, 25, 95, 34);
		personalizarBoton(btnEditar, Color.ORANGE, Color.WHITE, new Color(251, 206, 177));
		panel_1.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(209, 26, 78, 34);
		personalizarBoton(btnEliminar, Color.RED, Color.WHITE, new Color(136, 8, 8));
		panel_1.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
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
