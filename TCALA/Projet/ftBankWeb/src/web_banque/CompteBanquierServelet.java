package web_banque;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Banquier;

/**
 * Servlet implementation class CompteBanquierServelet
 */
@WebServlet("/CompteBanquierServelet")
public class CompteBanquierServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteBanquierServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(false);
		request.setAttribute("comptes", session.getAttribute("comptes"));
		request.setAttribute("banquier", session.getAttribute("bnq"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/compteBanquier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
