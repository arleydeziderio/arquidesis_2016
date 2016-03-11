package com.deziderio.aula2.conexao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// ----------------------------------------------------------- // Obtem
	// conexão com o banco de dados
	public Connection conectar() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_db", "root", "");
		return conn;
	}

	public void desconectar() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
