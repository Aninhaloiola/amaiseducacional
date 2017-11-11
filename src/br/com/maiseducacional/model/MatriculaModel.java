package br.com.maiseducacional.model;

import java.util.Date;

public class MatriculaModel {

	private int idMatricula = 0;
	private String situacao = "";
	private Date dtMat = null;
	private Date dtValida = null;
	private int idFunci = 0;
	private String idFunciNulo = null;
	private int idAluno = 0;
	private int idInstituicao = 0;

	public int getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(int idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getIdFunciNulo() {
		return idFunciNulo;
	}

	public void setIdFunciNulo(String idFunciNulo) {
		this.idFunciNulo = idFunciNulo;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDtMat() {
		return dtMat;
	}

	public void setDtMat(Date dtMat) {
		this.dtMat = dtMat;
	}

	public Date getDtValida() {
		return dtValida;
	}

	public void setDtValida(Date dtValida) {
		this.dtValida = dtValida;
	}

	public int getIdFunci() {
		return idFunci;
	}

	public void setIdFunci(int idFunci) {
		this.idFunci = idFunci;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

}
