package br.com.maiseducacional.model;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idFunci = 0;
	private String funcao = "";
	private int pessoaId = 0;

	public int getIdFunci() {
		return idFunci;
	}

	public void setIdFunci(int idFunci) {
		this.idFunci = idFunci;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

}
