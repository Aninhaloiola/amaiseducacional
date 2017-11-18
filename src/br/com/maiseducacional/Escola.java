package br.com.maiseducacional;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import br.com.maiseducacional.lib.Requests;
import br.com.maiseducacional.model.EscolaModel;
import br.com.maiseducacional.view.EscolaView;

/**
 * Servlet implementation class Escola
 */
@WebServlet("/escola")
public class Escola extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Escola() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String retorno = request.getParameter("tpres");
		
		Requests params = new Requests();
				 params.getParameters(request);
		
		EscolaView ev = new EscolaView();
		
		//Identifica a ação
		if ("lista".equals(acao)) {
			List<EscolaModel> lsescm = ev.listarEscolas(params.getStrParam("nivel"), params.getIntParam("serie"));
		}
		
		//Se retorno do tipo json
		if ("json".equals(retorno)) {
			this.jsonRequests(ev.getEscolasJson(), response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/escola.jsp");
							  rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
	 * Processa retorno em json
	 */
	private void jsonRequests(JSONArray resjson, HttpServletResponse response) {
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			JSONObject saida = new JSONObject();
					   saida.put("result", resjson);
			
			out.print(saida.toString());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
