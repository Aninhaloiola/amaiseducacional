package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.EscolaModel;

/**
 * Ações relativas a entidade Escola
 */
public class EscolaDao extends Conexao {

	public EscolaModel getEscolaInfo(int ide) {
		EscolaModel em = new EscolaModel();
		try {
			String sql = "SELECT a.nome, a.uf, a.cidade, SUM(1) as 'total',"
						+" SUM(CASE WHEN a.situacao='Pendente' THEN 1 ELSE 0 END) as 'pendentes',"
						+" SUM(CASE WHEN a.situacao='Validada' THEN 1 ELSE 0 END) as 'validadas',"
						+" SUM(CASE WHEN a.situacao='Cancelada' THEN 1 ELSE 0 END) as 'canceladas',"
						+" SUM(CASE WHEN a.escolaridade='M' THEN 1 ELSE 0 END) as 'e_medio',"
						+" SUM(CASE WHEN a.escolaridade='F' THEN 1 ELSE 0 END) as 'e_fundamental',"
						+" SUM(CASE WHEN a.sexo='M' THEN 1 ELSE 0 END) as 'masculino',"
						+" SUM(CASE WHEN a.sexo='F' THEN 1 ELSE 0 END) as 'feminino',"
						+" SUM(CASE WHEN a.sexo='O' THEN 1 ELSE 0 END) as 'outros',"
						+" SUM(CASE WHEN a.naturalidade=1 THEN 1 ELSE 0 END) as 'brasileiros',"
						+" SUM(CASE WHEN a.naturalidade<>1 THEN 1 ELSE 0 END) as 'estrangeiros'"
						+" FROM("
						+" SELECT d.nome, d.uf, d.cidade, a.idMatricula, a.situacao, a.dataMatri, a.dataValida, b.escolaridade, c.sexo, c.naturalidade "
						+" FROM matricula a "
						+" LEFT JOIN aluno b ON(b.idAluno=a.aluno_idaluno)" 
						+" LEFT JOIN pessoa c ON(c.idPessoa=b.pessoa_id)" 
						+" RIGHT JOIN instituicao d ON(a.idInstituicao=d.idInst)"
						+" WHERE a.idInstituicao = #IDESC#) AS a";
			
			sql = sql.replaceAll("#IDESC#", ""+ide);
			
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				em.setNome(rs.getString("nome"));
				em.setUf(rs.getString("uf"));
				em.setCidade(rs.getString("cidade"));
				em.setTotalMatriculas(rs.getInt("total"));
				em.setTotalPendentes(rs.getInt("pendentes"));
				em.setTotalValidas(rs.getInt("validadas"));
				em.setTotalCanceladas(rs.getInt("canceladas"));
				em.setTotalEm(rs.getInt("e_medio"));
				em.setTotalEf(rs.getInt("e_fundamental"));
				em.setTotalMasculino(rs.getInt("masculino"));
				em.setTotalFeminino(rs.getInt("feminino"));
				em.setTotalOutros(rs.getInt("outros"));
				em.setTotalBra(rs.getInt("brasileiros"));
				em.setTotalEstrangeiros(rs.getInt("estrangeiros"));
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return em;
	}
	
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
	
	public ArrayList<EscolaModel> getListaEscolas() {
		ArrayList<EscolaModel> lsescolas = new ArrayList<EscolaModel>();
		try {
			String sql = "SELECT a.idInst, a.nome FROM instituicao a ORDER BY a.nome ASC";
			
			Connection conn = this.getConexao();
			
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  
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
