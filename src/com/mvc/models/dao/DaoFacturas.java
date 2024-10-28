package com.mvc.models.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mvc.models.conn.Conexion;
import com.mvc.models.vo.Detalle;
import com.mvc.models.vo.Factura;
import com.mvc.models.vo.Producto;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DaoFacturas extends Conexion implements DAO {

	@Override
	public boolean store(Object o) {

		Connection conn = conectar();
		String sql = "INSERT INTO facturas (id_cliente,fecha,total) VALUES (?,?,?)";
		String sql2 = "INSERT INTO detalles (id_producto,id_factura,cantidad) VALUES (?,?,?)";

		try {

			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement ps2 = (PreparedStatement) conn.clientPrepareStatement(sql2);
				
			Factura f = (Factura) o;

			ps.setInt(1, f.getIdCliente());
			
			Timestamp fechaSQL = new Timestamp(f.getFecha().getTime());
			
			System.out.println(f.getDetalles().getDetalles());
			
			ps.setTimestamp(2, fechaSQL);
			ps.setInt(3, f.getTotal());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			int idFactura = 1;
			if (rs.next()) {
				idFactura = rs.getInt(1);			
			}
			
			for (Detalle d : f.getDetalles().getDetalles()) {
				ps2.setInt(1,d.getIdProducto());
				ps2.setInt(2,idFactura);
				ps2.setInt(3,d.getCantidad());
				ps2.execute();
			}

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
		String sql = "UPDATE facturas SET id_cliente = ? , fecha = ? WHERE id_factura = ?;";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			Factura item = (Factura) o;

			ps.setInt(1, item.getIdCliente());
			ps.setDate(2, (Date) item.getFecha());
			ps.setInt(3, item.getId());

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
		String sql = "DELETE FROM facturas WHERE id_factura = ?";
		
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
		String sql = "SELECT * FROM facturas";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Object o = new Factura(rs.getInt("id_factura"),rs.getDate("fecha"), rs.getInt("id_cliente"),rs.getInt("total"));
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
		String sql = "SELECT " + 
				" p.nombre AS producto,d.cantidad AS cantidad,f.fecha AS fecha, c.nombre AS cliente,f.id_cliente" + 
				" FROM detalles d" + 
				"	INNER JOIN facturas f ON f.id_factura = d.id_factura" + 
				"    INNER JOIN productos p ON p.id_producto = d.id_producto " + 
				"    INNER JOIN clientes c ON c.id_cliente = f.id_cliente " + 
				" WHERE f.id_factura = ?;";

		try {
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			System.out.println(sql);
			while (rs.next()) {
				item = new Factura(rs.getDate("fecha"), rs.getInt("id_cliente"));
			}

		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return item;
	}

}
