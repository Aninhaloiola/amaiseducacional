package br.com.maiseducacional.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Trabalha conexao com o banco de dados
 */
public class Conexao {

	/**
	 * Armazena conexao com o banco
	 */
	private Connection conn = null;
	/**
	 * Base de dados
	 */
	private String base = "projeto";
	/**
	 * Usuário
	 */
	private String username = "root";
	/**
	 * Senha
	 */
	private String password = "";

	/**
	 * Cria uma conexao com o banco de dados
	 */
	protected Connection getConexao() {
		try {
			if (this.conn != null) {
				return this.conn;
			}

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String config = "jdbc:mysql://localhost:3306/"+this.base+"?user="+this.username+"&pass="+this.password;
			this.conn = DriverManager.getConnection(config);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return this.conn;
	}

	/**
	 * Fecha a conexão aberta com o banco
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
