package com.mvc.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.models.conn.Conexion;
import com.mvc.models.vo.Cliente;
import com.mvc.models.vo.Producto;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAOProductos extends Conexion implements DAO {

	@Override
	public boolean store(Object o) {

		Connection conn = conectar();
		String sql = "INSERT INTO productos (nombre,precio,descripcion) VALUES (?,?,?)";

		try {

			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement(sql);

			Producto p = (Producto) o;

			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setString(3, p.getDescripcion());

			ps.execute();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			desconectar(conn);
		}

		return false;
	}

	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "UPDATE productos SET nombre = ? , precio = ?, descripcion = ? WHERE id_producto = ?;";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			Producto item = (Producto) o;

			ps.setString(1, item.getNombre());
			ps.setDouble(2, item.getPrecio());
			ps.setString(3, item.getDescripcion());
			ps.setInt(4, item.getId());

			ps.execute();

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
		String sql = "DELETE FROM productos WHERE id_producto = ?";
		
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
		String sql = "SELECT * FROM productos";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Object o = new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"));
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
		Object item = null;

		Connection con = conectar();
		String sql = "SELECT * FROM productos where id_producto = ?";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				item = new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"));
			}

		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return item;
	}

}
