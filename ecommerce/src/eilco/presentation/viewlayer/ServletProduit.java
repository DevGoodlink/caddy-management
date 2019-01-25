package eilco.presentation.viewlayer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eilco.metier.entities.Produit;
import eilco.presentation.dao.DaoEcommerce;

/**
 * Servlet implementation class ServletProduit
 */
@WebServlet("/Produit")
public class ServletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		DaoEcommerce dao = new DaoEcommerce();
		List<Produit> produits = dao.getProduitsByCategorie(idCategorie);
		//TODO affichage des produits sur produits.jsp
		//response.getWriter().append("Catégorie"+idCategorie+ "Produits récupérés = "+produits.size()).append(request.getContextPath());
		request.setAttribute("categorie",produits.get(0).getCategorie().getNom() );//nom de la catégorie
		request.setAttribute("ListProduits", produits);
		request.setAttribute("NombreProduit", produits.size());
		request.getRequestDispatcher("produits.jsp").forward(request,response);
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
