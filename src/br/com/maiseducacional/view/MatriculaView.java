package br.com.maiseducacional.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maiseducacional.dao.AlunoDao;
import br.com.maiseducacional.dao.MatriculaDao;
import br.com.maiseducacional.dao.PessoaDao;
import br.com.maiseducacional.model.AlunoModel;
import br.com.maiseducacional.model.MatriculaModel;
import br.com.maiseducacional.model.PcontatoModel;
import br.com.maiseducacional.model.PessoaModel;

/**
 * Classe view para matricula
 */
public class MatriculaView {

	/**
	 * Listar matriculas
	 */
	public MatriculaModel[] listarMatriculas(){
		
		MatriculaModel[] matmd = null;
		
		return matmd;
	}
	
	/**
	 * Retorna uma matricula específica
	 * @param int idMat id da matrícula
	 */
	public MatriculaModel getMatriculaById(int idMat){
		
		
		return new MatriculaModel();
	}
	
	/**
	 * Registra uma nova matricula
	 */
	public String novaMatricula(HttpServletRequest request, HttpServletResponse response) {
		
		PessoaDao pd = new PessoaDao();
		
		String cpf = request.getParameter("inpt-cpf");
		//Valida cpf *CRIAR CLASSE DE VALIDAÇÃO
		if ("".equals(cpf) || cpf.length() < 11) {
			return "CPF Invalido!";
		}
		int cpfID = pd.existeCpf(cpf);
		if (cpfID > 0) {
			return "CPF já existe no sistema, tente na página de acompanhamento!";
		}
		
		String rg = request.getParameter("inpt-rg");
		//Valida RG
		if ("".equals(rg)) {
			return "Insira um RG";
		}
		int rgID = pd.existeRg(rg);
		if (rgID > 0) {
			return "RG já existe no sistema, tente na página de acompanhamento!";
		}
		
		String dtNasc = request.getParameter("inpt-dtNasc");
		Date dtn = null;
		try {
			dtn = new SimpleDateFormat("dd/mm/yyyy").parse(dtNasc);
		} catch(ParseException pe) {
			pe.printStackTrace();
		}
		
		String natural = request.getParameter("inpt-nat");
		
		String nome = request.getParameter("inpt-nome");
		String sexo = request.getParameter("inpt-sx");
		String nMae = request.getParameter("inpt-nMae");
		String nPai = request.getParameter("inpt-nPai");
		
		String cep = request.getParameter("inpt-cep");
		String uf = request.getParameter("inpt-uf");
		String cidade = request.getParameter("inpt-cidade");
		String bairro = request.getParameter("inpt-bairro");
		String end = request.getParameter("inpt-end");
		String compl = request.getParameter("inpt-compl");
		
		String email = request.getParameter("inpt-email");
		String fone = request.getParameter("inpt-fone");
		String celular = request.getParameter("inpt-celular");
		
		String escolaridade = request.getParameter("inpt-escl");
		String aEscolar = request.getParameter("inpt-escl-ano");
		int anoEscolar = ("".equals(aEscolar) || aEscolar==null) ? 0 : Integer.parseInt(aEscolar);
		
		String instituicao = request.getParameter("inpt-inst");
		if ("".equals(instituicao) || instituicao==null){
			return "Selecione uma instituição, obrigado!";
		}
		int idIns = Integer.parseInt(instituicao);
		
		String usuario = request.getParameter("inpt-usu");
		String senha = request.getParameter("inpt-senha");
		
		//Cria o model e popula
		PessoaModel pessoa = new PessoaModel();
					pessoa.setNome(nome);
					pessoa.setRg(rg);
					pessoa.setCpf(cpf);
					pessoa.setSexo(sexo);
					pessoa.setNaturalidade(natural);
					pessoa.setDataNasc(dtn);
					pessoa.setCep(cep);
					pessoa.setUf(uf);
					pessoa.setCidade(cidade);
					pessoa.setBairro(bairro);
					pessoa.setEndereco(end);
					pessoa.setComplemento(compl);
					pessoa.setUsuario(usuario);
					pessoa.setSenha(senha);
		//Chama o método para inserir um novo registro em pessoa
		int idPessoa = pd.inserirPessoa(pessoa);
		int idAluno = 0;
		int matricula = 0;
		
		//Se retornar o id da pessoa inserida, então
		if (idPessoa < 1) {
			return "Falha ao cadastrar pessoa";
		}
		
		//Cadastra informações de contato
		PcontatoModel pcontato = new PcontatoModel();
					  pcontato.setTelefone(fone);
					  pcontato.setCelular(celular);
					  pcontato.setEmail(email);
					  pcontato.setIdPessoa(idPessoa);
		int contato = pd.inserirPessoaContato(pcontato);
		if (contato < 1) {
			return "Falha ao salvar informações de contato!";
		}
					  
		//Cadastra aluno
		AlunoModel aluno = new AlunoModel();
				   aluno.setNomePai(nPai);
				   aluno.setNomeMae(nMae);
				   aluno.setEscolaridade(escolaridade);
				   aluno.setAnoEscolar(anoEscolar);
				   aluno.setPessoaId(idPessoa);
		AlunoDao ad = new AlunoDao();
		idAluno = ad.inserirAluno(aluno);
		
		//Se não retornar o id do aluno
		if (idAluno < 1) {
			return "Falha ao cadastrar aluno";
		} else {
			MatriculaModel mtr = new MatriculaModel();
						   mtr.setIdAluno(idAluno);
						   mtr.setIdFunci(0);
						   mtr.setDtMat(new Date());
						   mtr.setDtValida(null);
						   mtr.setSituacao("Pendente");
						   mtr.setIdInstituicao(idIns);
			MatriculaDao md = new MatriculaDao();
			matricula = md.inserirMatricula(mtr);
		}

		return "A Solicitação de Matricula foi gerada com Nr. ["+matricula+"]";
	}
	
	/**
	 * Atualizar Matricula
	 * 
	 */
	public int atualizaMatricula(MatriculaModel matricula) {
		int res = 0;
		
		return res;
	}
	
	/**
	 * Apaga uma matricula especifica
	 * @Param MatriculaModel matricula
	 */
	public int deletaMatricula(MatriculaModel matricula) {
		int res = 0;
		
		return res;
	}
	
}
