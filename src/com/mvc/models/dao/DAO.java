package com.mvc.models.dao;

import java.util.ArrayList;

public interface DAO {

	public boolean store(Object o);
	public boolean update(Object o,int id);
	public boolean destroy(int id);
	
	public ArrayList<Object> getList();
	public Object getItem(int id);
	
}
