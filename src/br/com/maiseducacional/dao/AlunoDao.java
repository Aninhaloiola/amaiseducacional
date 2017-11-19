package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.AlunoModel;

/**
 * Ações relativas a entidade Aluno
 */
public class AlunoDao extends Conexao {

	/**
	 * Obtém dados de um aluno a partir do ID de pessoa 
	 */
	public AlunoModel getAlunoByPessoaId(int idp) {
		AlunoModel am = new AlunoModel();
		try {
			String sql = "SELECT a.idAluno, a.nomePai, a.nomeMae, "
					   + "CASE WHEN a.escolaridade='M' THEN 'Ensino Médio' "
					   + "WHEN a.escolaridade='F' THEN 'Ensino Fundamental' " 
					   + "ELSE 'Não identificada' END as 'escolaridade', a.anoEscolar "
					   + " FROM aluno a WHERE a.pessoa_id = ?";
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setInt(1, idp);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				am.setIdAluno(rs.getInt("idAluno"));
				am.setNomePai(rs.getString("nomePai"));
				am.setNomeMae(rs.getString("nomeMae"));
				am.setEscolaridade(rs.getString("escolaridade"));
				am.setAnoEscolar(rs.getInt("anoEscolar"));
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return am;
	}
	
	/**
	 * Insere um novo registro em Aluno
	 */
	public int inserirAluno(AlunoModel aluno) {
		int idAluno = 0;
		int ttAluno = 0;
		
		try {
			//SQL de insert
			String sql = "INSERT INTO aluno (nomePai, nomeMae, escolaridade, pessoa_id) VALUES (?,?,?,?)";
			
			//Obt�m conex�o
			Connection con = this.getConexao();
					   
			//Prepara sql para receber os par�metros
			PreparedStatement sth = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Reseta os par�metros para receber novos valores
			sth.clearParameters();
			//Atribui os valores aos par�metros da sql				  
			sth.setString(1, aluno.getNomePai());
			sth.setString(2, aluno.getNomeMae());
			sth.setString(3, aluno.getEscolaridade());
			sth.setInt(4, aluno.getPessoaId());
			
			//Executa o insert e retorna o total de linhas inseridas no banco
			ttAluno = sth.executeUpdate();
			
			//Obt�m a chave prim�ria (ID) gerada pelo banco para o aluno inserido
			ResultSet rs = sth.getGeneratedKeys();
			while(rs.next()) {
				idAluno = rs.getInt(1);
			}
			rs.close();
			sth.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			this.fechaConexao();
		}
		
		//Retorna o id do registro inserido em aluno
		return idAluno;
	}
	
}
