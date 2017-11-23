package br.com.maiseducacional.model;

import java.io.Serializable;

public class LoginModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idUsu = 0;
	private String usuario = "";
	private String senha = "";
	
	public int getIdUsu() {
		return idUsu;
	}
	
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
