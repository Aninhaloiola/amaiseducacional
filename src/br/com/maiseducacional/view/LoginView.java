package br.com.maiseducacional.view;

import br.com.maiseducacional.dao.LoginDao;
import br.com.maiseducacional.model.LoginModel;

/**
 * Classe view para Login
 */
public class LoginView {
	
	private LoginModel loginMd = null;
	
	/**
	 * Verifica se um usuário e senha existe e retorna sua Id e nome
	 * @param String usu
	 * @param String senha
	 */
	public int verificarLogin(String usu, String senha){
		try {
			LoginDao ed = new LoginDao();
			this.loginMd = ed.verificaUsuPass(usu, senha);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return this.loginMd.getIdUsu();
	}
	
}