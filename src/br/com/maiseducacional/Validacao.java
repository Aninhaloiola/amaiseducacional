package br.com.maiseducacional;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maiseducacional.lib.Requests;
import br.com.maiseducacional.lib.VerLogin;
import br.com.maiseducacional.view.AcompanhaView;
import br.com.maiseducacional.view.ValidacaoView;

/**
 * Servlet implementation class Validacao
 */
@WebServlet("/validacao")
public class Validacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validacao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Requests req = new Requests();
				 req.getParameters(request);
				 
		VerLogin loginGer = new VerLogin(request,response);
		loginGer.usuLogado();
		
		ValidacaoView av = new ValidacaoView();
		
		String msg = "";
		
		int mtr = req.getIntParam("mtr");
		int pid = req.getIntParam("p");
		String acao = req.getStrParam("acao");
		
		if ("detalhar".equals(acao)) {
			AcompanhaView acv = new AcompanhaView();
			
			Map<String,Object> matricula = acv.getMatriculaDadosByUsu(pid);
			request.setAttribute("pessoa", matricula.get("pessoa"));
			request.setAttribute("contato", matricula.get("contato"));
			request.setAttribute("aluno", matricula.get("aluno"));
			request.setAttribute("matricula", matricula.get("matricula"));
			request.setAttribute("insti", matricula.get("insti"));
			request.setAttribute("acao", "detalhar");
			
		} else if ("validar".equals(acao)) {
			int valida = av.validarMatricula(mtr, loginGer.getUsuId());
			msg = (valida > 0) ? "Matricula validada!" : "Falha ao validar matricula!";
			
		} else if ("cancelar".equals(acao)) {
			int cancelada = av.cancelarMatricula(mtr, loginGer.getUsuId());
			msg = (cancelada > 0) ? "Matricula Cancelada!" : "Falha ao Cancelar matricula!";
			
		} else {
			Map<String,Object> lsmtr = av.getMatriculaListaByUsu(loginGer.getUsuId());
			request.setAttribute("pendls", lsmtr.get("pendentes"));
			request.setAttribute("validals", lsmtr.get("validadas"));
			request.setAttribute("cancelals", lsmtr.get("canceladas"));
		}
		
		request.setAttribute("msg", msg);
		String pagina = ("detalhar".equals(acao)) ? "acompanha/indexAcompanha" : "validacao/indexValida";
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/"+pagina+".jsp");
						  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
