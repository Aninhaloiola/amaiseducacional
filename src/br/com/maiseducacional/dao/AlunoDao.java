package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.AlunoModel;

/**
 * A��es relativas a entidade Aluno
 */
public class AlunoDao extends Conexao {

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
