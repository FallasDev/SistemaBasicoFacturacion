package com.mvc.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.models.conn.Conexion;
import com.mvc.models.vo.Cliente;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DaoClientes extends Conexion implements DAO {

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "INSERT INTO clientes (nombre,apellidos,direccion,telefono,correo_electronico) VALUES (?,?,?,?,?)";
		
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			Cliente item = (Cliente) o;
			
			ps.setString(1, item.getNombre());
			ps.setString(2, item.getApellidos());
			ps.setString(3, item.getDireccion());
			ps.setString(4, item.getTelefono());
			ps.setString(5, item.getCorreoElectronico());
			
			
			return ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}
		
		return false;
	}

	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "UPDATE clientes SET nombre = ? , apellidos = ?, direccion = ?, telefono = ?, correo_electronico = ? WHERE id_cliente = ?;";
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			Cliente item = (Cliente) o;
			
			ps.setString(1, item.getNombre());
			ps.setString(2, item.getApellidos());
			ps.setString(3, item.getDireccion());
			ps.setString(4, item.getTelefono());
			ps.setString(5, item.getCorreoElectronico());
			ps.setInt(6, id);
			
			ps.execute();
			
			System.out.println("Actualizado");

			return true;
			
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}
		
		return false;
	}

	@Override
	public boolean destroy(int id) {
		Connection con = conectar();
		String sql = "DELETE FROM clientes WHERE id_cliente = ?";
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			
			ps.setInt(1, id);
			
			
			return ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}
		
		return false;
	}

	@Override
	public ArrayList<Object> getList() {
		
		ArrayList<Object> data = new ArrayList<>();
		
		Connection con = conectar();
		String sql = "SELECT * FROM clientes";
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Object o = new Cliente(
						rs.getInt("id_cliente"),
						rs.getString("nombre"), 
						rs.getString("apellidos"), 
						rs.getString("direccion"), 
						rs.getString("telefono"), 
						rs.getString("correo_electronico"));
				data.add(o);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}
		
		return data;
	}

	@Override
	public Object getItem(int id) {

		Object o = null;
		
		Connection con = conectar();
		String sql = "SELECT * FROM clientes where id_cliente = ?";
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				o = new Cliente(
						rs.getInt("id_cliente"),
						rs.getString("nombre"), 
						rs.getString("apellidos"), 
						rs.getString("direccion"), 
						rs.getString("telefono"), 
						rs.getString("correo_electronico"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}
		
		return o;
	}

}
