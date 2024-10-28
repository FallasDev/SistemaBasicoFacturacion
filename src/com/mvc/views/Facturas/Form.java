package com.mvc.views.Facturas;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.mvc.models.vo.Cliente;
import com.mvc.models.vo.Producto;
import com.toedter.calendar.JDateChooser;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Form extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	public JButton btnRegistrar;
	public JButton btnActualizar;
	public JButton btnEliminar;
	public JButton btnEliminarDetalle;
	public JLabel lblTotal;
	public JLabel lTotal;
	public JComboBox<Producto> cbxProducto;
	public JTable table;

	public DefaultTableModel modelo;
	public JButton btnAgregarDetalle;
	public JComboBox<Cliente> cbxCliente;
	public JSpinner sCantidad;
	
	public JDateChooser tFecha;
	
	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_4.setBounds(0, 0, 288, 186);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(12, 49, 56, 16);
		panel_4.add(lblFecha);
		
		tFecha = new JDateChooser();
		tFecha.setPreferredSize(new Dimension(170, 30));
		tFecha.setBounds(12, 78, 189, 30);
		panel_4.add(tFecha);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliente.setBounds(12, 122, 56, 16);
		panel_4.add(lblCliente);
		
		JLabel lblInformacinFactura = new JLabel("Informaci\u00F3n Factura");
		lblInformacinFactura.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblInformacinFactura.setBounds(12, 13, 252, 16);
		panel_4.add(lblInformacinFactura);
		
		cbxCliente = new JComboBox<Cliente>();
		cbxCliente.setBounds(12, 151, 189, 22);
		 // Cambiando colores y fuente
        cbxCliente.setBackground(new Color(0, 122, 204)); // Color de fondo
        cbxCliente.setForeground(Color.BLACK);            // Color del texto
        cbxCliente.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y tamaño del texto

        // Estableciendo un borde redondeado
        cbxCliente.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2, true));
        AutoCompleteDecorator.decorate(cbxCliente);
        
		panel_4.add(cbxCliente);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_5.setBounds(0, 199, 288, 243);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblDetallesDeLa = new JLabel("DETALLES DE LA FACTURA");
		lblDetallesDeLa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDetallesDeLa.setBounds(12, 13, 205, 16);
		panel_5.add(lblDetallesDeLa);
		
		JLabel lblProducto = new JLabel("Producto: ");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProducto.setBounds(12, 43, 95, 16);
		panel_5.add(lblProducto);
		
		cbxProducto = new JComboBox<Producto>();
		cbxProducto.setBounds(12, 72, 188, 22);
		 // Cambiando colores y fuente
        cbxProducto.setBackground(new Color(0, 122, 204)); // Color de fondo
        cbxProducto.setForeground(Color.BLACK);            // Color del texto
        cbxProducto.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y tamaño del texto

        // Estableciendo un borde redondeado
        cbxProducto.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2, true));
        AutoCompleteDecorator.decorate(cbxProducto);

		panel_5.add(cbxProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidad.setBounds(12, 107, 81, 22);
		panel_5.add(lblCantidad);
		
		btnAgregarDetalle = new JButton("Agregar Detalle");
		btnAgregarDetalle.setBounds(12, 184, 150, 32);
		personalizarBoton(btnAgregarDetalle,new Color(0, 122, 204),Color.WHITE,new Color(0, 102, 204));
		panel_5.add(btnAgregarDetalle);
		
		sCantidad = new JSpinner();
		sCantidad.setBounds(12, 135, 95, 22);
		panel_5.add(personalizarJSpinner(sCantidad));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setPreferredSize(new Dimension(10, 55));
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		personalizarBoton(btnRegistrar, new Color(50, 205, 50), Color.WHITE, new Color(80, 200, 120));
		btnRegistrar.setBounds(479, 13, 99, 34);
		panel_1.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		personalizarBoton(btnActualizar, Color.ORANGE, Color.WHITE, new Color(251, 206, 177));
		btnActualizar.setBounds(590, 13, 89, 34);
		panel_1.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(691, 13, 89, 34);
		personalizarBoton(btnEliminar, Color.RED, Color.WHITE, new Color(136, 8, 8));
		panel_1.add(btnEliminar);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		btnEliminarDetalle = new JButton("Eliminar Detalle");
		panel_3.add(btnEliminarDetalle);
		
		lblTotal = new JLabel("Total: ");
		panel_3.add(lblTotal);
		
		lTotal = new JLabel("0");
		panel_3.add(lTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		personalizarTabla();
		scrollPane.setViewportView(table);

	}
	
	public void personalizarBoton(JButton button,Color bgColor, Color fgColor,Color bdColor) {
		// Cambia el color de fondo, texto y fuente
        button.setBackground(bgColor); // Color de fondo
        button.setForeground(fgColor); // Color del texto
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y tamaño del texto

        // Elimina el borde y añade un borde redondeado
        button.setFocusPainted(false); // Elimina el borde de enfoque
        button.setBorder(BorderFactory.createLineBorder(bdColor, 2, true));
	}
	
	public JSpinner personalizarJSpinner (JSpinner spinner) {
		// Personalización de color y fuente
        spinner.setFont(new Font("Arial", Font.BOLD, 14));  // Cambia la fuente
        spinner.setForeground(Color.WHITE);                 // Cambia el color del texto
        spinner.setBackground(new Color(0, 122, 204));      // Cambia el color de fondo
        spinner.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2, true)); // Borde redondeado
        
        // Quitar borde del campo de texto para mejor apariencia
        JComponent editor = spinner.getEditor();
        JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
        textField.setBorder(null);
        return spinner;
	}
	
	public JComboBox<Object> personalizarCombo(JComboBox<Object> comboBox){
		
		 // Cambiando colores y fuente
        comboBox.setBackground(new Color(0, 122, 204)); // Color de fondo
        comboBox.setForeground(Color.WHITE);            // Color del texto
        comboBox.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y tamaño del texto

        // Estableciendo un borde redondeado
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2, true));

        return comboBox;
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
}
