package com.mvc.views.Productos;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Dimension;

public class Form extends JPanel {
	public JTextField tNombre;
	public JTextField tPrecio;
	public JButton btnRegistrar;

	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("+ Nuevo Producto");
		button.setForeground(Color.BLACK);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(12, 13, 143, 25);
		panel.add(button);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(12, 59, 56, 16);
		panel.add(label);
		
		tNombre = new JTextField();
		tNombre.setColumns(10);
		tNombre.setBounds(12, 79, 255, 22);
		panel.add(tNombre);
		
		tPrecio = new JTextField();
		tPrecio.setColumns(10);
		tPrecio.setBounds(12, 140, 255, 22);
		panel.add(tPrecio);
		
		JLabel label_1 = new JLabel("Precio");
		label_1.setBounds(12, 114, 56, 16);
		panel.add(label_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setPreferredSize(new Dimension(20, 25));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBorder(null);
		btnRegistrar.setBounds(12, 182, 78, 34);
		panel.add(btnRegistrar);

	}
	
	public void personalizarBoton(JButton button,Color bgColor, Color fgColor,Color bdColor) {
		// Cambia el color de fondo, texto y fuente
        button.setBackground(bgColor); // Color de fondo
        button.setForeground(fgColor); // Color del texto
        button.setFont(new Font("Arial", Font.PLAIN, 18)); // Fuente y tamaño del texto

        
        // Elimina el borde y añade un borde redondeado
        button.setFocusPainted(false); // Elimina el borde de enfoque
        button.setBorder(BorderFactory.createLineBorder(bdColor, 2, true));
	}

}
