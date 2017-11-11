package br.com.maiseducacional.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.maiseducacional.db.Conexao;
import br.com.maiseducacional.model.PcontatoModel;
import br.com.maiseducacional.model.PessoaModel;

/**
 * Ações relativas a entidade Pessoa
 */
public class PessoaDao extends Conexao {

	/**
	 * Verifica se o CPF já existe
	 * @parma String cpf
	 */
	public int existeCpf(String cpf) {
		int pessoaID = 0;
		
		try {
			String sql = "SELECT a.idPessoa FROM pessoa a WHERE a.cpf = ?";
			
			Connection conn = this.getConexao();
			
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setString(1, cpf);
							  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pessoaID = rs.getInt("idPessoa");
			}
			
			rs.close();
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return pessoaID;
	}
	
	/**
	 * Verifica se já existe RG
	 * @param String rg
	 */
	public int existeRg(String rg) {
		int pessoaID = 0;
		try {
			String sql = "SELECT a.idPessoa FROM pessoa a WHERE a.rg = ?";
			
			Connection conn = this.getConexao();
			
			PreparedStatement ps = conn.prepareStatement(sql);
							  ps.clearParameters();
							  ps.setString(1, rg);
							  
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pessoaID = rs.getInt("idPessoa");
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return pessoaID;
	}
	
	/**
	 * Inseri um novo registo
	 * 
	 * @param PessoaModel pessoa
	 * @return int retorna a ID do último registro inserido
	 */
	public int inserirPessoa(PessoaModel pessoa) {
		int idPessoa = 0;
		int ttInseri = 0;

		try {
			//Sql com insert
			String sql = "INSERT INTO pessoa (nome,rg,cpf,sexo,naturalidade,dataNasc,cep,uf,cidade,bairro,endereco,complemento,usuario,senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//Obtém conexão
			Connection conn = this.getConexao();
			
			//Prepara o sql insert e tenta retornar o ID do último registro inserido
			PreparedStatement sth = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			//Reseta os parâmetros
			sth.clearParameters();
			
			//Atribui os parâmetros ao sql insert
			sth.setString(1, pessoa.getNome());
			sth.setString(2, pessoa.getRg());
			sth.setString(3, pessoa.getCpf());
			sth.setString(4, pessoa.getSexo());
			sth.setString(5, pessoa.getNaturalidade());
			
			Date dtn = new Date(pessoa.getDataNasc().getTime());
			sth.setDate(6, dtn);
			
			sth.setString(7, pessoa.getCep());
			sth.setString(8, pessoa.getUf());
			sth.setString(9, pessoa.getCidade());
			sth.setString(10, pessoa.getBairro());
			sth.setString(11, pessoa.getEndereco());
			sth.setString(12, pessoa.getComplemento());
			
			sth.setString(13, pessoa.getUsuario());
			sth.setString(14, pessoa.getSenha());
			
			//Executa o sql e retorna 1 se inserida uma linha, sen�o, zero
			ttInseri = sth.executeUpdate();
			
			//Obt�m o ID do �ltimo registro inserido, necess�rio para cadastrar em aluno e funcion�rio
			ResultSet rs = sth.getGeneratedKeys();
	        if (rs.next()){
	            idPessoa = rs.getInt(1);
	        }
	        rs.close(); //Fecha o result set, assim o garbage collection do java limpa a mem�ria
			
	        //Fecha o statement
	        sth.close();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Retorna o id
		return idPessoa;
	}
	
	/**
	 * Insere informações de contato para uma pessoa
	 * @param PcontatoModel
	 * @return int total inserido
	 */
	public int inserirPessoaContato(PcontatoModel pcontato) {
		int ttInseri = 0;

		try {
			//Sql com insert
			String sql = "INSERT INTO pcontato (telefone,celular,email,idPessoa) VALUES (?,?,?,?)";
			
			//Obtém conexão
			Connection conn = this.getConexao();
			
			//Prepara o sql insert e tenta retornar o ID do último registro inserido
			PreparedStatement sth = conn.prepareStatement(sql);
			
			//Reseta os parâmetros
			sth.clearParameters();
			
			//Atribui os parâmetros ao sql insert
			sth.setString(1, pcontato.getTelefone());
			sth.setString(2, pcontato.getCelular());
			sth.setString(3, pcontato.getEmail());
			sth.setInt(4, pcontato.getIdPessoa());
			
			//Executa o sql e retorna 1 se inserida uma linha, senão, zero
			ttInseri = sth.executeUpdate();
	        sth.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ttInseri;
	}

}
