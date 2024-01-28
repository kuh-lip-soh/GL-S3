package web_banque;

import java.io.Console;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exceptions.ErrorException;
import entity.Banquier;
import sessions.BanquierLocal;

/**
 * Servlet implementation class BanquierServelet
 */
@WebServlet("/BanquierServelet")
public class BanquierServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	private BanquierLocal bl;
	private CompteBanquierServelet cbs = new CompteBanquierServelet();

	public HttpSession session;

	public BanquierServelet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/BanquierLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(false);

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		// Banquier bnq;
		try {
			Banquier bnq = bl.seConnecter(username, pwd);
			session = request.getSession();
			session.setAttribute("bnq", bnq);
			session.setAttribute("comptes", bl.listerCompteBanquier(bnq.getIdBnq()));
			// request.setAttribute("banquier", bnq);
			// request.setAttribute("comptes", bl.listerCompteBanquier(bnq.getIdBnq()));
			cbs.doGet(request, response);
		} catch (ErrorException e1) {
			System.out.println(" a=" + e1.getMessage());
			String a = e1.getMessage();
			request.setAttribute("error_banquier", a);
			this.doGet(request, response);
		}

	}

}
