package com.mvc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;

public class ViewPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnFactura;
	public JButton btnListaFacturas;
	public JButton btnProductos;
	public JButton btnClientes;
	private JPanel panelContenido;
	private JPanel panel_1;
	private JPanel header;
	private JPanel footer;
	private JLabel lblLimpiezatotal;
	private JLabel lblModulo;
	private JLabel lblEstado;
	private JLabel lblEstadovalue;

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1200, 700));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		header = new JPanel();
		header.setBorder(new EmptyBorder(4, 8, 4, 0));
		panel_1.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		lblLimpiezatotal = new JLabel("LimpiezaTotal");
		lblLimpiezatotal.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblLimpiezatotal.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblLimpiezatotal.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLimpiezatotal.setHorizontalAlignment(SwingConstants.LEFT);
		header.add(lblLimpiezatotal);
		
		lblModulo = new JLabel("Modulo");
		lblModulo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblModulo.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblModulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		header.add(lblModulo, BorderLayout.SOUTH);
		
		panelContenido = new JPanel();
		panel_1.add(panelContenido);
		
		panelContenido.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNavegacion = new JPanel();
		panelNavegacion.setPreferredSize(new Dimension(140, 10));
		panel.add(panelNavegacion, BorderLayout.WEST);
		panelNavegacion.setLayout(null);
		
		btnFactura = new JButton("Factura");
		btnFactura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFactura.setBorder(null);
		btnFactura.setBounds(0, 0, 140, 41);
		panelNavegacion.add(btnFactura);
		
		btnListaFacturas = new JButton("Lista Facturas");
		btnListaFacturas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListaFacturas.setBounds(0, 41, 140, 41);
		btnListaFacturas.setBorder(new EmptyBorder(4, 6, 4, 6));
		panelNavegacion.add(btnListaFacturas);
		
		btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProductos.setBorder(null);
		btnProductos.setBounds(0, 81, 140, 41);
		panelNavegacion.add(btnProductos);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClientes.setBorder(null);
		btnClientes.setBounds(0, 122, 140, 41);
		panelNavegacion.add(btnClientes);
		panel_1.add(panelContenido, BorderLayout.CENTER);
		
		footer = new JPanel();
		footer.setPreferredSize(new Dimension(100, 30));
		panel_1.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblEstado = new JLabel("Estado: ");
		footer.add(lblEstado);
		
		lblEstadovalue = new JLabel("estadoValue");
		lblEstadovalue.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(lblEstadovalue);
	}
	
	public void init() {
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de Gestión de Articulos de Limpieza");
	}
	
	public void setContenido(JComponent c, String titulo) {
		
		lblModulo.setText(titulo);
		
		
		
		panelContenido.removeAll();
		panelContenido.add(c, BorderLayout.CENTER);
		panelContenido.repaint();
		panelContenido.revalidate();
		
	}
	
	public void setEstado(String estado, boolean exito) {
		
		lblEstadovalue.setText(estado);
		
		if (exito) {
			footer.setBackground(new Color(0, 128, 128));
		}else {
			footer.setBackground(Color.RED);
		}
		
	}

}
