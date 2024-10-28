package com.mvc.models.conn;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conexion {
	private String host, user, pass, db, url;

	public Conexion() {
		this.host = "localhost";
		this.user = "root";
		this.pass = "";
		this.db = "db_limpiezaJuan";
		this.url = "jdbc:mysql://" + host + "/" + db;
	}

	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Connection");
			con = (Connection) DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			System.out.println("Error de conexion: " + e.getMessage());
		}

		return con;
	}

	public void desconectar(Connection con) {
		try {
			con.close();
		} catch (Exception e) {}

	}

}
