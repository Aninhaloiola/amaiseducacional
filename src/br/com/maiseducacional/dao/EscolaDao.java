package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.EscolaModel;

/**
 * Ações relativas a entidade Escola
 */
public class EscolaDao extends Conexao {

	/**
	 * Obtém uma instituição a partir da respectiva ID
	 */
	public EscolaModel getEscolaById(int ide) {
		EscolaModel em = new EscolaModel();
		try {
			String sql = "SELECT a.idInst, a.nome, a.cnpj, "
					   + "CASE " 
					   + "WHEN a.nivel='F' THEN 'Ensino Fundamental'" 
					   + "WHEN a.nivel='M' THEN 'Ensino Médio'" 
					   + "ELSE 'Não identificado'" 
					   + "END as 'nivel', "
					   + " a.nivel, a.cep, a.uf, a.cidade, a.endereco, a.series "
					   + "FROM instituicao a "
					   + "WHERE a.idInst = ?";
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setInt(1, ide);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				em.setIdInst(rs.getInt("idInst"));
				em.setNome(rs.getString("nome"));
				em.setCnpj(rs.getString("cnpj"));
				em.setNivel(rs.getString("nivel"));
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return em;
	}
	
	/**
	 * Obtém lista de escolas de acordo com o nivel e serie
	 * @param String nivel
	 * @param int serie
	 */
	public List<EscolaModel> getListaEscolasByNivelSerie(String nivel, int serie) {
		ArrayList<EscolaModel> lsescolas = new ArrayList<EscolaModel>();
		try {
			String sql = "SELECT a.idInst, a.nome FROM instituicao a WHERE a.nivel = ? AND a.series >= ? ORDER BY a.nome ASC";
			
			Connection conn = this.getConexao();
			
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setString(1, nivel);
							  ps.setInt(2, serie);
							  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EscolaModel em = new EscolaModel();
							em.setIdInst(rs.getInt("idInst"));
							em.setNome(rs.getString("nome"));
				lsescolas.add(em);
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return lsescolas;
	}

}
