package br.com.maiseducacional.model;

import java.io.Serializable;

public class EscolaModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idInst = 0;
	private String nome = "";
	private String cnpj = "";
	private String nivel = "";
	private String cep = "";
	private String uf = "";
	private String cidade = "";
	private String endereco = "";
	private int series;

	public int getIdInst() {
		return idInst;
	}

	public void setIdInst(int idInst) {
		this.idInst = idInst;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

}
