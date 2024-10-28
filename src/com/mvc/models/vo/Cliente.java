package com.mvc.models.vo;

public class Cliente {
	private int id;
	private String nombre,apellidos,direccion,telefono,correoElectronico;
	
	public Cliente(int id, String nombre, String apellidos, String direccion, String telefono,
			String correoElectronico) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}
	
	public Cliente(String nombre, String apellidos, String direccion, String telefono, String correoElectronico) {
		this.id = 0;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
}
