package br.com.maiseducacional;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maiseducacional.lib.Requests;
import br.com.maiseducacional.model.EscolaModel;
import br.com.maiseducacional.view.ConsultarEscolaView;

/**
 * Servlet implementation class Consultar Escola
 * 
 */
@WebServlet("/consultarescola")
public class ConsultarEscola extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarEscola() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Requests rq = new Requests();
				 rq.getParameters(request);
		
		ConsultarEscolaView av = new ConsultarEscolaView();
		
		ArrayList<EscolaModel> escolaLs = av.getListaEscolas();
		if (escolaLs.size() < 1) {
			request.setAttribute("msg", "Não foi possível obter a lista de escolas, atualize a página e tente novamente, obrigado!");
		}
		request.setAttribute("escolas", escolaLs);
		
		int idEscola = rq.getIntParam("inpt-escola");
		if (idEscola > 0) {
			EscolaModel em = av.getEscolaDadosById(idEscola);
			request.setAttribute("escInfo", em);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/escola/escola.jsp");
		  				  rd.forward(request, response);
	}
	
}