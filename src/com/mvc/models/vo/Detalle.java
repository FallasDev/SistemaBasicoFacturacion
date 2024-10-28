package com.mvc.models.vo;

public class Detalle {

	private int idDetalle, idFactura, idProducto, cantidad;
	private Producto producto;

	public Detalle(int idDetalle, int idFactura, int idProducto, int cantidad) {
		this.idDetalle = idDetalle;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public Detalle(int idFactura, int idProducto, int cantidad) {
		this.idDetalle = -1;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public double getSubtotal() {
		return cantidad * getProducto().getPrecio();
	}
}
