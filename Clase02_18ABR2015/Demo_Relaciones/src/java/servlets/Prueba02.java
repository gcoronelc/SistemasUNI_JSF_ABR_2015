package servlets;

import entity.Organizacion;
import entity.Proyecto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "Prueba02", urlPatterns = {"/Prueba02"})
@TransactionManagement(TransactionManagementType.BEAN)
public class Prueba02 extends HttpServlet {

	@PersistenceContext(unitName = "Demo_RelacionesPU")
	EntityManager em;
	@Resource
	private UserTransaction utx;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Prueba01</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Prueba01 at " + request.getContextPath() + "</h1>");

			utx.begin();
			String consulta = "select o from Organizacion o";
			Query query = em.createQuery(consulta);
			List<Organizacion> lista = query.getResultList();

			for (Organizacion o : lista) {
				out.println("<h2>Organización: " + o.getNombre() + "</h2>");
				for (Proyecto p  : o.getProyectos()) {
					out.println("<p>Organización: " + p.getNombre() + "</p>");
				}
			}
			utx.commit();

			out.println("<p>Todo ok.</p>");
		} catch (Exception e) {
			out.println("<p>" + e.getMessage() + "</p>");
			e.printStackTrace();
		} finally {
			out.println("</body>");
			out.println("</html>");
			out.close();
			em.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
