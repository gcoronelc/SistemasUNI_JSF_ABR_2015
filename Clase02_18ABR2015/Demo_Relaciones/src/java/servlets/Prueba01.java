package servlets;

import entity.Organizacion;
import entity.Proyecto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "Prueba01", urlPatterns = {"/Prueba01"})
@TransactionManagement(TransactionManagementType.BEAN)
public class Prueba01 extends HttpServlet {

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

			Organizacion o = new Organizacion();
			o.setNombre("ISIL");

			Proyecto p1 = new Proyecto();
			p1.setNombre("Sistema de Matricula");
			p1.setOrganizacion(o);
			o.getProyectos().add(p1);

			Proyecto p2 = new Proyecto();
			p2.setNombre("Sistema de Notas");
			p2.setOrganizacion(o);
			o.getProyectos().add(p2);

			
			utx.begin();
			em.persist(o);
//			em.persist(p1);
//			em.persist(p2);
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
