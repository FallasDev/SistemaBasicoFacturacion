package com.mvc.models.vo;

import java.util.ArrayList;

public class ListaDetalles {

	private int id;
	private ArrayList<Detalle> detalles;
	
	public ListaDetalles() {
		this.id = -1;
		this.detalles = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	public void store(Detalle d) {
		d.setIdDetalle(id++);
		detalles.add(d);
	}
	
	public void destroy(int id) {
		for (Detalle d : detalles) {
			if (id == d.getIdDetalle()) {
				detalles.remove(d);
				break;
			}
		}
	}
	
	public void update(Detalle item,int id) {
		for (Detalle d : detalles) {
			if (d.getIdDetalle() == id) {
				d = item;
				break;
			}
		}
	}
	
	public Object[][] getData(){
		
		Object[][] data = new Object[detalles.size()][getColumns().length];
		
		int i = 0;
		
		for (Detalle d : detalles) {
			data[i][0] = d.getIdDetalle();
			System.out.println(d.getProducto());
			data[i][1] = d.getProducto().getNombre();
			data[i][2] = d.getCantidad();
			data[i][3] = d.getSubtotal();

			i++;
		}
		
		return data;
	}
	
	public String[] getColumns() {
		return new String[] {"#","Producto","Cantidad","Subtotal"};
	}
	
	
}
