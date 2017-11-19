package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Statement;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.MatriculaModel;

/**
 * A��es relativas a entidade Aluno
 */
public class MatriculaDao extends Conexao {

	/**
	 * Obtém todos os dados de Matrícula para um Aluno específico
	 * 
	 */
	public MatriculaModel getMatriculaByAlunoId(int ida) {
		MatriculaModel md = new MatriculaModel();
		try {
			String sql = "SELECT a.situacao,a.dataMatri,a.dataValida,a.idInstituicao FROM matricula a WHERE a.aluno_idaluno = ?";
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setInt(1, ida);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				md.setSituacao(rs.getString("situacao"));
				md.setDtMat(rs.getDate("dataMatri"));
				md.setDtValida(rs.getDate("datavalida"));
				md.setIdInstituicao(rs.getInt("idInstituicao"));
			}
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return md;
	}
	
	
	/**
	 * Insere um novo registro em Aluno
	 */
	public int inserirMatricula(MatriculaModel matricula) {
		int matr = 0;
		try {
			//SQL de insert
			String sql = "INSERT INTO matricula (situacao,dataMatri,dataValida,funci_idfunci,aluno_idaluno,idInstituicao) VALUES (?,?,?,?,?,?)";
			
			//Obt�m conex�o
			Connection con = this.getConexao();
					   
			//Prepara sql para receber os par�metros
			PreparedStatement sth = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Reseta os par�metros para receber novos valores
			sth.clearParameters();
			//Atribui os valores aos par�metros da sql				  
			sth.setString(1, matricula.getSituacao());
			
			Date dtMatr = new java.sql.Date(matricula.getDtMat().getTime());
			Date dtVali = null;
			if (matricula.getDtValida()==null) {
				dtVali = new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse("0000-00-00").getTime());
			} else {
				dtVali = new java.sql.Date(matricula.getDtValida().getTime());
			}
			
			sth.setDate(2, dtMatr);
			sth.setDate(3, dtVali);
			
			if (matricula.getIdFunci()==0) {
				sth.setString(4, null);
			} else {
				sth.setString(4, null);
			}
			
			sth.setInt(5, matricula.getIdAluno());
			sth.setInt(6, matricula.getIdInstituicao());
			
			//Executa o insert e retorna o total de linhas inseridas no banco
			int ttMatr = sth.executeUpdate();
			
			//Obt�m a chave prim�ria (ID) gerada pelo banco para o aluno inserido
			ResultSet rs = sth.getGeneratedKeys();
			while(rs.next()) {
				matr = rs.getInt(1);
			}
			rs.close();
			sth.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			this.fechaConexao();
		}
		
		//Retorna o id do registro inserido em aluno
		return matr;
	}
	
}
