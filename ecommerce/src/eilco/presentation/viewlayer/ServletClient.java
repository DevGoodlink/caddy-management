package eilco.presentation.viewlayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit.CutAction;

import eilco.metier.entities.Client;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/Client")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		Client customer = new Client();
		customer.setNom(request.getParameter("customerName"));
		customer.setEmail(request.getParameter("customerEmail"));
		customer.setAdresse(request.getParameter("customerAdress"));
		customer.setTelephone(request.getParameter("customerPhone"));
		session.setAttribute("customer", customer);
		
		response.sendRedirect("recapitulatif.jsp");
	}

}
