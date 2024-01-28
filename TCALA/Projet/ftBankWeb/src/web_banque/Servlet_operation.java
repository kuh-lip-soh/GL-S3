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

import designPatterns.ObservateurOperation;
import designPatterns.Observateurs;
import designPatterns.Observe;
import designPatterns.ObserveCompte;
import designPatterns.RetraitOp;
import designPatterns.VirementOp;
import entity.Client;
import entity.Compte;
import entity.Compte_Client;
import sessions.ClientLocal;
import sessions.CompteSessionBeanLocal;
import sessions.OperationSessionBeanLocal;

/**
 * Servlet implementation class Servlet_operation
 */
@WebServlet(name = "cs2", urlPatterns = { "operations_bank.do" })
public class Servlet_operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HttpSession session;
	public Client client;
	public Observateurs observateur;
	public Observe observe;
	public List<Compte_Client> comptes = null;

	@EJB
	private ClientLocal client_local;

	public Servlet_operation() {
		observateur = new ObservateurOperation();
		observe = new ObserveCompte();
		observe.addObservateur(observateur);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);
		if (session != null) {
			client = (Client) session.getAttribute("client");
			if ((client != null)) {
				comptes = client_local.getCompte_client_all(client.getId());
				request.setAttribute("client_login", client);
				request.setAttribute("comptes", comptes);
				request.getRequestDispatcher("Operation.jsp").forward(request, response);
			}
		}
		request.getRequestDispatcher("login_client.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long client_id = Long.parseLong(request.getParameter("client_id"));
		String operation = request.getParameter("operation");
		double montant = Double.parseDouble(request.getParameter("montant"));

		long compte_id = Long.parseLong(request.getParameter("compte"));

		if (operation.equals("retrait")) {
			observe.do_op(new RetraitOp(), client_id, compte_id, montant);
		} else {
			observe.do_op(new VirementOp(), client_id, compte_id, montant);
		}

		// request.setAttribute("result", result);
		// Operations operation = new Operations();
		// operation.setMontant(500);
		// operation.setId_op(1);

		// csbl.create(new Retrait(500));
		doGet(request, response);
	}

}
