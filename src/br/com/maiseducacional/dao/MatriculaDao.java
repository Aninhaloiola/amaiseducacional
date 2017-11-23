package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.MatriculaModel;

/**
 * Acoes relativas a entidade Aluno
 */
public class MatriculaDao extends Conexao {

	public ArrayList<MatriculaModel> getMatriculaPendenteListaByUsu(int idUsu) {
		ArrayList<MatriculaModel> mdls = new ArrayList<MatriculaModel>();
		try {
			String sql = "SELECT d.idPessoa,a.idMatricula,d.nome,a.dataMatri,c.anoEscolar, CASE WHEN c.escolaridade='M' THEN 'Ensino Médio' ELSE 'Ensino Fundamental' END as 'escolaridade' FROM matricula a"
						+" LEFT JOIN funcionario b ON (b.inst_id=a.idInstituicao)"
						+" LEFT JOIN aluno c ON(a.aluno_idaluno=c.idAluno)"
						+"LEFT JOIN pessoa d ON(c.pessoa_id=d.idPessoa)"
						+" WHERE " 
						+" b.pessoa_id = ?" 
						+" AND" 
						+" a.situacao = 'Pendente'"
						+" ORDER BY a.dataMatri ASC";
			
			Connection conn = this.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setInt(1, idUsu);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MatriculaModel md = new MatriculaModel();
							   md.setIdMatricula(rs.getInt("idMatricula"));
							   md.getPessoa().setIdPessoa(rs.getInt("idPessoa"));
							   md.getPessoa().setNome(rs.getString("nome"));
							   md.setDtMat(rs.getDate("dataMatri"));
							   md.getAm().setAnoEscolar(rs.getInt("anoEscolar"));
							   md.getAm().setEscolaridade(rs.getString("escolaridade"));
				mdls.add(md);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return mdls;
	}
	
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
			String sql = "INSERT INTO matricula (situacao,dataMatri,dataValida,funci_idfunci,aluno_idaluno,idInstituicao) VALUES (?,?,?,?,?,?)";
			
			Connection con = this.getConexao();
			
			PreparedStatement sth = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
							  sth.clearParameters();
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
			
			sth.executeUpdate();
			
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

		return matr;
	}
	
}
