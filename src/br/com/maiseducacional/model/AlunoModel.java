package br.com.maiseducacional.model;

import java.io.Serializable;

public class AlunoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idAluno = 0;
	private String nomePai = "";
	private String nomeMae = "";
	private String escolaridade = "";
	private int anoEscolar = 0;
	private int pessoaId = 0;

	public int getAnoEscolar() {
		return anoEscolar;
	}

	public void setAnoEscolar(int anoEscolar) {
		this.anoEscolar = anoEscolar;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

}
