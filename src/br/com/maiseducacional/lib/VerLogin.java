package br.com.maiseducacional.lib;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe com ações gerais para login, sim, não é a melhor forma de verificar
 * 
 */
public class VerLogin {

	final private String USUSESSIONID = "USUID";
	HttpServletRequest rq = null;
	HttpServletResponse resp = null;
	HttpSession session = null;
	
	public VerLogin(HttpServletRequest rq, HttpServletResponse resp) {
		this.rq = rq;
		this.resp = resp;
		this.session = rq.getSession();
	}
	
	/**
	 * Verifica se usuário logado
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	public boolean usuLogado() throws ServletException, IOException {
		boolean logado = false;
		if ((this.session==null) || (this.session.getAttribute(this.USUSESSIONID)==null)) {
			this.destroySession();
			this.rq.setAttribute("msg", "Usuário não está logado!");
			this.rq.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(this.rq, this.resp); //Faz melhor se for gambiarra
		} else {
			logado = true;
		}
		return logado;
	}
	
	/**
	 * Obtém Id do usuário logado
	 */
	public int getUsuId(){
		int idUsu = 0;
		try {
			String id = (String) this.session.getAttribute(this.USUSESSIONID);
			idUsu = (id!=null) ? Integer.parseInt(id) : 0;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idUsu;
	}
	
	/**
	 * Cria nova sessão (mas vc pode baixar o capeta se quiser)
	 */
	public boolean initSession(String vals) {
		if (this.session==null) {
			return false;
		}
		this.session.setAttribute(this.USUSESSIONID, vals);
		return true;
	}
	
	/**
	 * Destrói a sessão (Se vc não for burro(a) vai perceber pelo nome)
	 */
	public void destroySession() {
		if (this.session!=null) {
			this.session.invalidate();
		}
	}
	
}