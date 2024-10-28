package com.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mvc.models.dao.DAOProductos;
import com.mvc.models.vo.Cliente;
import com.mvc.models.vo.Producto;
import com.mvc.views.ViewPrincipal;
import com.mvc.views.Productos.Form;
import com.mvc.views.Productos.Index;

public class ControllerProductos implements Controller {

	ViewPrincipal vp;
	DAOProductos dao;

	public ControllerProductos(ViewPrincipal vp) {
		this.vp = vp;
		dao = new DAOProductos();
	}

	@Override
	public void index() {

		Index v = new Index();
		v.modelo.setDataVector(getData(), getColumns());

		v.btnNuevo.addActionListener(e -> {
			create();
		});

		v.btnActualizar.addActionListener(e -> {
			int row = v.table.getSelectedRow();

			if (row == -1) {
				vp.setEstado("Seleccione el registro que desea eliminar", false);
				return;
			}

			int id = (int) v.table.getValueAt(row, 0);
			
			edit(id);
		});

		v.btnEliminar.addActionListener(e -> {

			int row = v.table.getSelectedRow();

			if (row == -1) {
				vp.setEstado("Seleccione el registro que desea eliminar", false);
				return;
			}

			int id = (int) v.table.getValueAt(row, 0);

			int confirm = JOptionPane.showConfirmDialog(null, "Esta acción no se puede restaurar", null,
					JOptionPane.WARNING_MESSAGE);
			if (confirm == 0) {
				destroy(id);
				index();
				vp.setEstado("Registro eliminado con exito! ", true);
			}

		});

		vp.setContenido(v, "Productos");
		vp.setEstado("...", true);

	}

	@Override
	public void create() {
		Form v = new Form();
		
		v.btnRegistrar.addActionListener(e -> {
			String nombre = v.tNombre.getText();
			double precio = Double.parseDouble(v.tPrecio.getText());
			
			Producto p = new Producto(nombre, "", precio);
			
			store(p);			
			vp.setEstado("Producto registrado exitosamente", true);
		});
		
		vp.setContenido(v, "Registro de productos");
		
	}

	@Override
	public void edit(int id) {
		Form v = new Form();
		
		Producto p = (Producto) getItem(id);
		v.tNombre.setText(p.getNombre());
		v.tPrecio.setText(p.getPrecio()+"");	
	
		v.btnRegistrar.addActionListener(e -> {
			p.setNombre(p.getNombre());
			p.setPrecio(p.getPrecio());
			update(p, id);
		});
		
		vp.setContenido(v, "Actualizar Productos");
		
		
	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = getList();

		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {

			Producto item = (Producto) o;

			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			data[i][2] = item.getPrecio();

			i++;
		}
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String[] { "#", "Nombre", "Precio" };
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
