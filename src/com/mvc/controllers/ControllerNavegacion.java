package com.mvc.controllers;

import javax.swing.JLabel;

import com.mvc.views.ViewPrincipal;

public class ControllerNavegacion {
	
	ViewPrincipal vp;
	
	public ControllerNavegacion() {
		vp = new ViewPrincipal();
	}
	
	public void init() {
		
		vp.btnListaFacturas.addActionListener(e -> {
			new ControllerFacturas(vp).index();
		});
		
		vp.btnClientes.addActionListener(e -> {
			new ControllerClientes(vp).index();
		});
		
		vp.btnProductos.addActionListener(e->{
			new ControllerProductos(vp).index();
		});
		
		vp.btnFactura.addActionListener(e -> {
			new ControllerFacturas(vp).create();
		});
		
		
		
		vp.init();
		
		new ControllerFacturas(vp).create();
	}
}
