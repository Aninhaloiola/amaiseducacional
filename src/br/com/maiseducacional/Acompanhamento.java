package br.com.maiseducacional;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maiseducacional.lib.VerLogin;
import br.com.maiseducacional.view.AcompanhaView;

/**
 * Servlet implementation class Acompanhamento
 */
@WebServlet("/acompanhamento")
public class Acompanhamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acompanhamento() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VerLogin loginGer = new VerLogin(request,response);
		loginGer.usuLogado();
		
		AcompanhaView av = new AcompanhaView();
		Map<String,Object> matricula = av.getMatriculaDadosByUsu(loginGer.getUsuId());
		
		request.setAttribute("pessoa", matricula.get("pessoa"));
		request.setAttribute("contato", matricula.get("contato"));
		request.setAttribute("aluno", matricula.get("aluno"));
		request.setAttribute("matricula", matricula.get("matricula"));
		request.setAttribute("insti", matricula.get("insti"));
		
		request.setAttribute("pagina", "index");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/acompanha/indexAcompanha.jsp");
						  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
