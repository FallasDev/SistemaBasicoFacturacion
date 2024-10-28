package com.mvc.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import com.mvc.models.dao.DAOProductos;
import com.mvc.models.dao.DaoClientes;
import com.mvc.models.dao.DaoFacturas;
import com.mvc.models.vo.Cliente;
import com.mvc.models.vo.Detalle;
import com.mvc.models.vo.Factura;
import com.mvc.models.vo.Producto;
import com.mvc.views.ViewPrincipal;
import com.mvc.views.Facturas.Form;
import com.mvc.views.Facturas.Index;

public class ControllerFacturas extends Functions implements Controller {

	private ViewPrincipal vp;
	private DaoFacturas dao;
	
	public ControllerFacturas(ViewPrincipal vp) {
		this.vp = vp;
		this.dao = new DaoFacturas();
	}

	@Override
	public void index() {
		Index v = new Index();

		v.modelo.setDataVector(getData(), getColumns());
		
		v.tBuscar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscar(v.table,v.tBuscar.getText(),1,2);
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		v.btnNuevo.addActionListener(e -> {
			new ControllerFacturas(vp).create();
		});
		
		vp.setContenido(v, "Facturas");

	}

	@Override
	public void create() {

		Form v = new Form();

		Factura f = new Factura();
		
		v.modelo.setDataVector(f.getDetalles().getData(), f.getDetalles().getColumns());
		
		cargarClientes(v);
		cargarProductos(v);
		
		
		v.btnAgregarDetalle.addActionListener(e -> {
			
			Producto p = (Producto) v.cbxProducto.getSelectedItem();
			int cantidad = (int) v.sCantidad.getValue();
			
			Detalle item = new Detalle(f.getId(), p.getId(), cantidad);
			
			item.setProducto(p);
			f.getDetalles().store(item);
			
			reloadDetalles(v, f);

		});
		
		v.btnEliminarDetalle.addActionListener(e -> {
			
			 int row = v.table.getSelectedRow();
			
			if(row == -1) {
				vp.setEstado("Seleccione el detalle que desea eliminar", false);
				return;
			}
			
			int id = (int) v.table.getValueAt(row, 0);
			
			f.getDetalles().destroy(id);
			reloadDetalles(v, f);
		});
		
		v.btnRegistrar.addActionListener(e -> {
			
			f.setFecha(v.tFecha.getDate());
			
			Cliente row = (Cliente) v.cbxCliente.getSelectedItem();
			
			int idCliente = row.getId();
			
			f.setIdCliente(idCliente);
			
			
			store(f);
	
			v.modelo.setDataVector(new Object[0][0], f.getDetalles().getColumns());
		});
		
		vp.setContenido(v, "Registro de Facturas");
	}

	public void reloadDetalles(Form v,Factura f) {
		v.lTotal.setText(f.getTotal()+"");
		v.modelo.setDataVector(f.getDetalles().getData(), f.getDetalles().getColumns());
	}
	
	@Override
	public void edit(int id) {}

	@Override
	public Object[][] getData() {
		
		Object[][] data = new Object[getList().size()][getColumns().length];
		
		int i=0;
		
		for (Object o : dao.getList()) {
			
			Factura f = (Factura) o;
			
			System.out.println(f.getTotal());
			
			data[i][0] = f.getId();
			data[i][1] = new DaoClientes().getItem(f.getIdCliente());
			data[i][2] = f.getFecha();
			data[i][3] = f.getTotaldb();
			
			i++;
		}
		
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String[] {"#","Cliente","Fecha","Total"};
	}

	@Override
	public void store(Object o) {
		dao.store(o);
	}

	@Override
	public void update(Object o, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Object> getList() {
		return dao.getList();
	}

	@Override
	public Object getItem(int id) {
		return dao.getItem(id);
	}

	public void cargarClientes(Form v) {
		ArrayList<Object> clientes = new DaoClientes().getList();

		for (Object o : clientes) {
			Cliente c = (Cliente) o;
			v.cbxCliente.addItem(c);
		}
	}

	public void cargarProductos(Form v) {
		ArrayList<Object> productos = new DAOProductos().getList();

		for (Object o : productos) {
			Producto p = (Producto) o;
			v.cbxProducto.addItem(p);
		}
	}

}
