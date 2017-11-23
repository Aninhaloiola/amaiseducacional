package br.com.maiseducacional;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.maiseducacional.lib.Requests;
import br.com.maiseducacional.lib.VerLogin;
import br.com.maiseducacional.view.LoginView;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pagina", "login");
		String acao = request.getParameter("acao");
		VerLogin loginGer = new VerLogin(request,response);
		
		if ("sair".equals(acao)) {
			loginGer.destroySession();
		}
		
		String tipo = request.getParameter("tipo");
			   request.setAttribute("tipo", tipo);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
						  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		VerLogin loginGer = new VerLogin(request, response);
		
		Requests rq = new Requests();
				 rq.getParameters(request);
		
		String tipo = rq.getStrParam("tipo");
		String usu = rq.getStrParam("inpt-usu");
		String senha = rq.getStrParam("inpt-senha");
		String matricula = rq.getStrParam("inpt-matr");
				 
		LoginView lv = new LoginView();
			  int idUsu = lv.verificarLogin(usu, senha, matricula);
		
		String pagina = ("validar".equals(tipo)) ? "validacao" : "acompanhamento";
			  
		if (idUsu > 0) {
			loginGer.initSession(""+idUsu);
			response.sendRedirect("/maiseducacional/"+pagina);
		} else {
			request.setAttribute("msg", "Usuário não está logado!");
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response); //Faz melhor se for gambiarra
		}
	}

}
