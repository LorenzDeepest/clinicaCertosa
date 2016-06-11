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

import model.TipologiaEsame;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controllerTipologie")

public class ControllerTipologie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTipologie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = "/tipologieEsami.jsp";
		
		Facade facade = new Facade();
		List<TipologiaEsame> esami = new ArrayList<>();
		esami.addAll(facade.aquisisciTipologieEsami());
		facade.close();
		request.setAttribute("esami", esami);
		request.getSession().setAttribute("esami", esami);
		
		for(TipologiaEsame esame : esami){
			if(esame.getNome().equals(request.getParameter("nomeEsame"))){
				request.setAttribute("esame", esame);
				nextPage = "/dettagliEsame.jsp";
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
