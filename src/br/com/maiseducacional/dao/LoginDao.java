package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.LoginModel;

public class LoginDao extends Conexao {

	/**
	 * Verifica se nome de usuário e senha existem
	 * @param String usuname
	 * @param String password
	 */
	public LoginModel verificaUsuPass(String usuname, String password) {
		LoginModel lm = new LoginModel();
		try {
			String sql = "SELECT a.idPessoa as 'idUsu' FROM pessoa a WHERE a.usuario = ? AND a.senha = ? LIMIT 1";
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setString(1, usuname);
							  ps.setString(2, password);
							  
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lm.setIdUsu(rs.getInt("idUsu"));
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return lm;
	}
	
}