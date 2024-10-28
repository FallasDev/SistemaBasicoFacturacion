package com.mvc.models.vo;

import java.util.Date;

public class Factura {

	private int id, idCliente;
	private ListaDetalles detalles;
	private Date fecha;
	private int total;
	
	public Factura() {
		this.id = 1;
		this.fecha = new Date(12, 1, 1);
		this.idCliente = -1;
		this.detalles = new ListaDetalles();
		this.total = getTotal();
	}
	
	public Factura(int id, Date fecha,int idCliente,int total) {
		this.id = id;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.detalles = new ListaDetalles();
		this.total = total;
	}
	
	public Factura(Date fecha,int idCliente) {
		this.id = -1;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.detalles = new ListaDetalles();
		this.total = getTotal();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListaDetalles getDetalles() {
		return detalles;
	}

	public void setDetalles(ListaDetalles detalles) {
		this.detalles = detalles;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTotal() {
		int total = 0;
		
		for (Detalle d : detalles.getDetalles()) {
			total += d.getSubtotal();
		}
		System.out.println(total);
		return total;
	}
	
	public int getTotaldb() {
		return total;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", idCliente=" + idCliente + ", detalles=" + detalles + ", fecha=" + fecha + "]";
	}
	
	

}
