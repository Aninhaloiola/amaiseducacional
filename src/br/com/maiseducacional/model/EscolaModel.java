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

	private int totalMatriculas = 0;
	private int totalValidas = 0;
	private int totalPendentes = 0;
	private int totalCanceladas = 0;
	private int totalEm = 0;
	private int totalEf = 0;
	private int totalMasculino = 0;
	private int totalFeminino = 0;
	private int totalOutros = 0;
	private int totalBra = 0;
	private int totalEstrangeiros = 0;

	public int getTotalEm() {
		return totalEm;
	}

	public void setTotalEm(int totalEm) {
		this.totalEm = totalEm;
	}

	public int getTotalEf() {
		return totalEf;
	}

	public void setTotalEf(int totalEf) {
		this.totalEf = totalEf;
	}

	public int getTotalMasculino() {
		return totalMasculino;
	}

	public void setTotalMasculino(int totalMasculino) {
		this.totalMasculino = totalMasculino;
	}

	public int getTotalFeminino() {
		return totalFeminino;
	}

	public void setTotalFeminino(int totalFeminino) {
		this.totalFeminino = totalFeminino;
	}

	public int getTotalOutros() {
		return totalOutros;
	}

	public void setTotalOutros(int totalOutros) {
		this.totalOutros = totalOutros;
	}

	public int getTotalBra() {
		return totalBra;
	}

	public void setTotalBra(int totalBra) {
		this.totalBra = totalBra;
	}

	public int getTotalEstrangeiros() {
		return totalEstrangeiros;
	}

	public void setTotalEstrangeiros(int totalEstrangeiros) {
		this.totalEstrangeiros = totalEstrangeiros;
	}

	public int getTotalMatriculas() {
		return totalMatriculas;
	}

	public void setTotalMatriculas(int totalMatriculas) {
		this.totalMatriculas = totalMatriculas;
	}

	public int getTotalValidas() {
		return totalValidas;
	}

	public void setTotalValidas(int totalValidas) {
		this.totalValidas = totalValidas;
	}

	public int getTotalPendentes() {
		return totalPendentes;
	}

	public void setTotalPendentes(int totalPendentes) {
		this.totalPendentes = totalPendentes;
	}

	public int getTotalCanceladas() {
		return totalCanceladas;
	}

	public void setTotalCanceladas(int totalCanceladas) {
		this.totalCanceladas = totalCanceladas;
	}

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
