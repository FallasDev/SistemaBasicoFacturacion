package com.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mvc.models.dao.DaoClientes;
import com.mvc.models.vo.Cliente;
import com.mvc.views.ViewPrincipal;
import com.mvc.views.Clientes.Create;
import com.mvc.views.Clientes.Index;

public class ControllerClientes implements Controller {

	DaoClientes dao;
	ViewPrincipal vp;
	
	public ControllerClientes(ViewPrincipal vp) {
		this.dao = new DaoClientes();
		this.vp = vp;
	}
	
	@Override
	public void index() {
		
		Index v = new Index();
		v.modelo.setDataVector(getData(), getColumns());
	
		
		v.btnInsertar.addActionListener(e -> {
			
			create();
			
		});
		
		v.btnEditar.addActionListener(e -> {
			
			int row = v.table.getSelectedRow();
			
			if (row == -1) {
				vp.setEstado("Seleccione el registro que desea editar", false);
				return;
			}
			
			
			int id = (int) v.table.getValueAt(row, 0);
			
			System.out.println(id);
			
			edit(id);
		});
		
		v.btnEliminar.addActionListener(e -> {
			
			int row = v.table.getSelectedRow();
			
			if (row == -1) {
				vp.setEstado("Seleccione el registro que desea eliminar", false);
				return;
			}
			
			
			int id = (int) v.table.getValueAt(row, 0);
			
			
			int confirm = JOptionPane.showConfirmDialog(null, "Esta acción no se puede restaurar",null, JOptionPane.WARNING_MESSAGE);
			if (confirm == 0) {
				destroy(id);				
				index();
				vp.setEstado("Registro eliminado con exito! ", true);
			}
						
			
		});
		
		
		vp.setContenido(v, "Clientes");
		vp.setEstado("...", true);
		
	}


	@Override
	public void create() {
		
		Create v = new Create("Registrar");
		
		v.btnRegistrar.addActionListener(e -> {
			String nombre = v.txtNombre.getText();
			String telefono = v.txtTelefono.getText();
			String direccion = v.txtDireccion.getText();
			String correo = v.txtCorreo.getText();
			
			if (nombre.split(" ").length < 2) {
				vp.setEstado("Debe ingresar el nombre completo. Ej: 'Juan Perez' ", false);
				return;
			}
			
			Cliente item = new Cliente(nombre.split(" ")[0], nombre.split(" ")[1], direccion, telefono, correo);
			
			store(item);	
			index();
			vp.setEstado("Cliente registrado exitosamente", true);
		});
	
		v.btnCancelar.addActionListener(e->{
			index();
		});
		
		vp.setContenido(v, "Ingresar cliente");
		
	}

	@Override
	public void edit(int id) {

		Create v = new Create("Editar");
		
		Cliente c = (Cliente) dao.getItem(id);

		System.out.println(c);
		v.txtNombre.setText(c.getNombre() + " " + c.getApellidos());
		v.txtCorreo.setText(c.getCorreoElectronico());
		v.txtDireccion.setText(c.getDireccion());
		v.txtTelefono.setText(c.getTelefono());
		
		
		v.btnRegistrar.addActionListener(e -> {
			update(c, id);
			index();
		});
		
		v.btnCancelar.addActionListener(e->{
			index();
		});
		
		
		vp.setContenido(v, "Editar Clientes");
		
	}

	@Override
	public Object[][] getData() {
		
		ArrayList<Object> list = dao.getList();
		
		Object[][] data = new Object[list.size()][getColumns().length];
		
		int i = 0;
		
		for (Object o : list) {
			
			Cliente item = (Cliente) o;
			
			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			data[i][2] = item.getApellidos();
			data[i][3] = item.getTelefono();
			data[i][4] = item.getCorreoElectronico();
			data[i][5] = item.getDireccion();
			
			i++;
		}
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String []{"#","Nombre","Apellidos","Telefono","Correo Electronico","Dirección"};
	}

	@Override
	public void store(Object o) {
		dao.store(o);	
	}

	@Override
	public void update(Object o, int id) {
		dao.update(o, id);
	}

	@Override
	public void destroy(int id) {
		dao.destroy(id);
	}

	@Override
	public ArrayList<Object> getList() {
		return dao.getList();
	}

	@Override
	public Object getItem(int id) {
		return dao.getItem(id);
	}
	
	
	
}
