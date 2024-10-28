package com.mvc.views.Clientes;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Create extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JTextField txtNombre;
	public JTextField txtTelefono;
	public JButton btnRegistrar;
	public JTextArea txtDireccion;
	public JButton btnCancelar;
	private JPanel panel;
	public JTextField txtCorreo;

	/**
	 * Create the panel.
	 */
	public Create(String butonType) {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBounds(12, 13, 586, 492);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre \r\nCompleto:");
		lblNombre.setBounds(12, 132, 149, 41);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblRegistroDeClientes = new JLabel("Registro de clientes");
		lblRegistroDeClientes.setBounds(12, 25, 269, 49);
		panel.add(lblRegistroDeClientes);
		lblRegistroDeClientes.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(192, 134, 269, 39);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("T\u00E9lefono: ");
		lblTelefono.setBounds(12, 183, 86, 36);
		panel.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(192, 184, 269, 35);
		panel.add(txtTelefono);
		//personalizarTextField(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnRegistrar = new JButton(butonType);
		personalizarBoton(btnRegistrar, new Color(50, 205, 50), Color.WHITE, new Color(80, 200, 120));
		btnRegistrar.setBounds(110, 383, 97, 33);
		panel.add(btnRegistrar);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(12, 233, 82, 22);
		panel.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtDireccion = new JTextArea();
		txtDireccion.setBounds(192, 235, 269, 45);
		panel.add(txtDireccion);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico:");
		lblCorreoElectronico.setBounds(12, 293, 149, 34);
		panel.add(lblCorreoElectronico);
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 383, 86, 33);
		personalizarBoton(btnCancelar,new Color(0, 122, 204),Color.WHITE,new Color(0, 102, 204));
		panel.add(btnCancelar);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(192, 293, 269, 34);
		panel.add(txtCorreo);

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
	
	
	public void personalizarTextField(JTextField textField) {
		
		 // Personalización de colores y borde
        textField.setBackground(new Color(76, 175, 80)); // Fondo
        textField.setForeground(Color.WHITE);             // Color del texto
        textField.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente del texto
        
        // Establecer el borde
        Border border = BorderFactory.createLineBorder(new Color(0, 102, 204), 2);
        textField.setBorder(border); // Asegúrate de que este método se pueda usar
		
	}
}
