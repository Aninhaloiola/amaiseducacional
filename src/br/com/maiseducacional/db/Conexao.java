package br.com.maiseducacional.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Trabalha conex�o com o banco de dados
 */
public class Conexao {

	/**
	 * Armazena conex�o com o banco
	 */
	private Connection conn = null;

	/**
	 * Cria uma conex�o com o banco de dados
	 */
	protected Connection getConexao() {
		try {
			if (this.conn != null) {
				return this.conn;
			}

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String config = "jdbc:mysql://localhost:3306/projeto?user=root&pass=";
			this.conn = DriverManager.getConnection(config);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return this.conn;
	}

	/**
	 * Fecha a conex�o aberta com o banco
	 */
	protected void fechaConexao() {
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
