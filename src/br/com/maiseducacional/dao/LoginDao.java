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
	 * @param String matricula
	 */
	public LoginModel verificaUsuPass(String usuname, String password, String matricula) {
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
			
			if (!"".equals(matricula) && matricula!=null) {
				if (this.validarFunci(matricula, lm.getIdUsu()) < 1) {
					lm.setIdUsu(0);
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return lm;
	}
	
	/**
	 * Valida funcionário a partir da matrícula e id de usuário, deve ser validado usuário e senha previamente
	 * @param String matricula
	 * @param int idUsu
	 */
	public int validarFunci(String matricula, int idUsu) {
		int idFunci = 0;
		try {
			String sql = "SELECT a.idFunci FROM funcionario a WHERE a.mtrFunci = ? AND a.pessoa_id = ?";
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setString(1, matricula);
							  ps.setInt(2, idUsu);
							  
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				idFunci = rs.getInt("idFunci");
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idFunci;
	}
	
}