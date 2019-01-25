package eilco.presentation.viewlayer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;
import eilco.presentation.dao.DaoManagement;

/**
 * Servlet implementation class Management
 */
@WebServlet("/Management")
public class ServletManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("logged") == null || !(boolean) session.getAttribute("logged")) {
			request.getRequestDispatcher("admin.jsp").forward(request, response);
			
		} else if((boolean) session.getAttribute("logged")){
			System.out.println(session.getAttribute("logged"));
			DaoManagement daoManagement = new DaoManagement();
			List<Categorie> categories = daoManagement.getAllCategorie();
			List<Produit> produits = daoManagement.getAllProduit();

			request.setAttribute("categories", categories);
			request.setAttribute("produits", produits);
			request.getRequestDispatcher("management.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		boolean auth=false;
		if(session.getAttribute("logged") != null && (boolean) session.getAttribute("logged")) {
			request.getRequestDispatcher("management.jsp").forward(request, response);
		}
		else {
			String username = request.getParameter("username");
			String clearPassword = request.getParameter("password");
			DaoManagement daoManagement = new DaoManagement();
			auth = daoManagement.authentification(username, clearPassword);
			session.setAttribute("logged", auth);
			if (auth) {
				List<Categorie> categories = daoManagement.getAllCategorie();
				List<Produit> produits = daoManagement.getAllProduit();

				request.setAttribute("categories", categories);
				request.setAttribute("produits", produits);
				request.getRequestDispatcher("management.jsp").forward(request, response);
			} else {
					request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		boolean auth = (boolean) session.getAttribute("logged");
		if (auth) {
			DaoManagement daoManagement = new DaoManagement();
			String operation = req.getParameter("operation");
			if(operation.equalsIgnoreCase("savecategorie")){
				String nom = req.getParameter("nom");
				Categorie c = new Categorie();
				c.setNom(nom);
				daoManagement.addCategorie(c);
				resp.getWriter().println(true);
			}else
			if(operation.equalsIgnoreCase("saveproduct")) {
				String libelle = req.getParameter("libelle");
				String description= req.getParameter("description");
				BigDecimal prix = new BigDecimal(req.getParameter("prix"));
				int idcategorie = Integer.parseInt(req.getParameter("categorie"));
				Produit p = new Produit();
				p.setNom(libelle);p.setDescription(description);p.setPrix(prix);p.setCategorie(daoManagement.getCategorieById(idcategorie));
				daoManagement.addProduit(p);
				resp.getWriter().println(true);
			}
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		boolean auth = (boolean) session.getAttribute("logged");
		if (auth) {
			int id = Integer.parseInt(req.getParameter("id"));
			String operation = req.getParameter("operation");
			DaoManagement daoManagement = new DaoManagement();
			if (operation.equalsIgnoreCase("deletecategorie")) {
				Categorie c = daoManagement.getCategorieById(id);
				daoManagement.removeCategorie(c);
				resp.getWriter().println(true);
			}
			if (operation.equalsIgnoreCase("deleteproduit")) {
				Produit p = daoManagement.getProduitById(id);
				daoManagement.removeProduit(p);
				resp.getWriter().println(true);
			}
		}
	}

}
