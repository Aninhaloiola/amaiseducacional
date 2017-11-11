package br.com.maiseducacional;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maiseducacional.view.MatriculaView;

/**
 * Servlet implementation class Matricula
 */
@WebServlet("/matricula")
public class Matricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String pagina = "matricula";
	
    public Matricula() {
        super();
    }

    
    
	/**
	 * Carrega o formulario para matricula
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pagina", this.pagina);
		
		request.setAttribute("aviso", "Preencha todos os campos corretamente, obrigado!");
		//Redireciona para o formulário de matrícula
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/matriculaForm.jsp");
						  rd.forward(request, response);
	}

	/**
	 * Recebe dados relativos matricula
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pagina", this.pagina);
//		response.setContentType("application/json");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		JSONObject genericOut = new JSONObject();
		//genericOut.put("dtUltAtl", dataPsq);
//		out.print(genericOut.toString());
		
		MatriculaView matv = new MatriculaView();
		String resultado = matv.novaMatricula(request, response);
		
		request.setAttribute("aviso", resultado);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/matriculaForm.jsp");
						  rd.forward(request, response);
	}

}