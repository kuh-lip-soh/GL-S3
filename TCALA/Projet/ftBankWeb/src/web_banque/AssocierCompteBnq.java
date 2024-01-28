package web_banque;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exceptions.ErrorException;
import Exceptions.ValidationInput;
import Exceptions.Valider;
import designPatterns.*;
import entity.Banquier;
import entity.Client;
import entity.Compte;
import entity.Compte_Client;
import sessions.BanquierLocal;
import sessions.ClientLocal;
import sessions.CompteClientSessionBeanLocal;
import sessions.CompteSessionBeanLocal;

/**
 * Servlet implementation class AssocierCompteBnq
 */
@WebServlet("/AssocierCompteBnq")
public class AssocierCompteBnq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	private BanquierLocal bl;
	@EJB
	private ClientLocal client_session;
	@EJB
	private CompteSessionBeanLocal compte_session;
	@EJB

	private CompteClientSessionBeanLocal compte_client_session;
	public HttpSession session;
	AbstractFactoryCompte afc = new AbstractFactoryCompte();

	public AssocierCompteBnq() {
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

		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			request.setAttribute("clients", client_session.listerClient());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.setAttribute("comptes", compte_session.listerCompte());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("banquier", session.getAttribute("bnq"));
		request.getRequestDispatcher("/AssocierCompteBnq.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession(false);
		Banquier bnq = (Banquier) session.getAttribute("bnq");

		String compte = request.getParameter("compte");
		String compte_id = request.getParameter("compte_id");
		String client = request.getParameter("client");
		String code = request.getParameter("code");
		String solde = request.getParameter("solde");
		String type = request.getParameter("type");
		String registre = request.getParameter("registre");
		String typecc = request.getParameter("typecc");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String genre = "";
		String[] client_id = request.getParameterValues("client_id");
		Compte c;
		Client clt = null;
		/*
		 * response.setContentType("text/html");
		 * 
		 * String docType =
		 * "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		 * PrintWriter out = response.getWriter();
		 * out.println(docType +
		 * "<html>\n" +
		 * "<head><title>hhh</title></head>\n"+
		 * "<body bgcolor = \"#f0f0f0\">\n" +
		 * "<h1 align = \"center\">" +type+typecc+ "</h1>\n"
		 * );
		 * 
		 */
		ValidationInput v = new Valider();
		if (compte.equals("2")) {
			v.validerCompteNonExiste(code, solde, type, typecc, registre);
		} else {
			v.validerCompteExiste(compte_id);
		}
		if (client.equals("2")) {
			v.validerClientNonExiste(nom, prenom);
		} else {
			v.validerClientExiste(client_id);
		}

		try {

			v.validerTout(compte_client_session.getType(Long.parseLong(compte_id)),
					compte_client_session.getNumber(Long.parseLong(compte_id)));
			if (compte.equals("2")) {
				long code1 = Long.parseLong(code);

				if (type.equals("1")) {
					// compte professionnel
					compte_session.create(afc.getCompte(new FactoryProf(code1, Double.parseDouble(solde), registre)));

				} else {
					// compte particulier
					compte_session.create(afc.getCompte(new factoryPar(code1, Double.parseDouble(solde))));

				}
				c = compte_session.findCompte(code1);
			} else {
				c = compte_session.find(Long.parseLong(compte_id));
				try {
					genre = compte_client_session.getType(Long.parseLong(compte_id));
				} catch (NumberFormatException | ErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (typecc != null) {
				if (typecc.equals("1")) {
					genre = "Partag�";
				} else {
					genre = "Priv�";
				}
			}
			// client
			if (client.equals("2")) {
				Client m = new Client(nom, prenom, nom + "-client", "123456");
				client_session.addClient(m);
				try {
					clt = client_session.findClient(nom + "-client");
					Compte_Client compte_client = new Compte_Client(genre, c, clt, bnq);
					compte_client_session.add(compte_client);
				} catch (ErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				for (int i = 0; i < client_id.length; i++) {
					clt = client_session.getClient(Long.parseLong(client_id[i]));
					compte_client_session.add(new Compte_Client(genre, c, clt, bnq));
				}
			}

			session.setAttribute("comptes", bl.listerCompteBanquier(bnq.getIdBnq()));
			CompteBanquierServelet cbs = new CompteBanquierServelet();
			cbs.doGet(request, response);

		} catch (ErrorException e) {
			request.setAttribute("errorEx", e.getMessage());
		}
		this.doGet(request, response);
	}
}