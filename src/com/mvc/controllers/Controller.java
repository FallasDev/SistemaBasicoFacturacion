package com.mvc.controllers;

import java.util.ArrayList;

public interface Controller {
	
	
	//Views
	
	public void index();
	public void create();
	public void edit(int id);
	
	public Object[][] getData();
	public String[] getColumns();
	
	//Models
	
	public void store(Object o);
	public void update(Object o,int id);
	public void destroy(int id);
	public ArrayList<Object> getList();
	public Object getItem(int id); 
	
	
}
