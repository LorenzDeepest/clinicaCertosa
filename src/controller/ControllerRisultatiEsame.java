package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Esame;
import model.Paziente;
import model.TipologiaEsame;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/controllerRisultatiEsame")

public class ControllerRisultatiEsame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerRisultatiEsame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/risultatiEsame.jsp";
		String s = request.getParameter("nomeEsame");
		String nomeEsame= s.substring(0, s.indexOf(':')-1);
		String dataEsame = s.substring(s.indexOf(':')+2);
		
		Paziente paziente = (Paziente)request.getSession().getAttribute("pazienteCorrente");
		List<Esame> esami = new ArrayList<>(paziente.getEsami());
		request.getSession().setAttribute("esami", esami);
		for(Esame esame : esami){
			String nomeCorrente = esame.getTipologiaEsame().getNome();
			String dataCorrente = esame.getDataEsame().toString();
			if(nomeEsame.equals(nomeCorrente) && dataEsame.equals(dataCorrente)){
				request.setAttribute("esame", esame);
				break;
			}
		}		
		nextPage = response.encodeURL(nextPage);
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
