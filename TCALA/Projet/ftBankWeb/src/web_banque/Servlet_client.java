package web_banque;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Client;
import entity.Compte_Client;
import sessions.ClientLocal;

@WebServlet(name = "cs", urlPatterns = { "login_client_bank.do" })
public class Servlet_client extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ClientLocal client_local;
	public List<Client> clients = null;
	public List<Compte_Client> comptes = null;
	public entity.Error error = null;
	public Client client;
	public HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(false);
		if (session != null) {
			client = (Client) session.getAttribute("client");
			if ((client != null)) {
				comptes = client_local.getCompte_client_all_lakhdar(client.getId());
				request.setAttribute("client_login", client);
				request.setAttribute("comptes", comptes);
				request.getRequestDispatcher("list_comptes.jsp").forward(request, response);
			} else if ((error != null)) {
				request.setAttribute("error_client_login", error);
				request.getRequestDispatcher("login_client.jsp").forward(request, response);
			} else if ((error == null)) {
				request.getRequestDispatcher("login_client.jsp").forward(request, response);
			}
		}
		request.getRequestDispatcher("login_client.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String action = request.getParameter("action");
		if (action.equals("logout")) {
			clients = null;
			error = null;
			comptes = null;
			session.invalidate();
			doGet(request, response);
		}
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		clients = client_local.seConnecter(username, pwd);

		if ((clients != null) && (!clients.isEmpty())) {
			session = request.getSession();
			session.setAttribute("client", clients.get(0));

			request.setAttribute("client_login", clients.get(0));
			comptes = client_local.getCompte_client_all_lakhdar(clients.get(0).getId());
			request.setAttribute("comptes", comptes);
			request.getRequestDispatcher("list_comptes.jsp").forward(request, response);
		}
		// clients =null;
		error = new entity.Error("username ou password invalid !!!");
		// request.setAttribute("error_client_login", Error);
		// request.getRequestDispatcher("login_client.jsp").forward(request, response);
		doGet(request, response);
	}

}
