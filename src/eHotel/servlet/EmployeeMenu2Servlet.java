package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;

/**
 * Servlet implementation class EmployeeMenuServlet
 */
@SuppressWarnings("serial")
@WebServlet("/EmployeeMenu2Servlet")
public class EmployeeMenu2Servlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	

		HttpSession session = req.getSession();
		String customerSSN = req.getParameter("customerSSN");
		req.setAttribute("customerSSN", customerSSN);


		PostgreSqlConn con = new PostgreSqlConn();
		String position = con.getPositionbyUname((String) req.getParameter("username"));		


		if (position.equals("Manager")) {			
			
			req.setAttribute("employee_id", req.getParameter("username"));
			req.getRequestDispatcher("DatabaseUpdate.jsp").forward(req, resp);
			return;
		}

		resp.sendRedirect("login_failure.jsp");
		return;
	}

}
