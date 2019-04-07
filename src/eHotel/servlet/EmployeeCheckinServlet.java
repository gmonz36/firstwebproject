package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.booking;

/**
 * Servlet implementation class EmployeeCheckinServlet
 */

@WebServlet("/EmployeePaymentServlet")
@SuppressWarnings("serial")
public class EmployeeCheckinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		PostgreSqlConn con = new PostgreSqlConn();
		booking book = con.getBookingbyID((String)req.getParameter("bookingID"));
		String ssn=(String)req.getParameter("SSN");
		
		con.rentRoom(book, ssn);
		

		req.getRequestDispatcher("Employee_menu.jsp").forward(req, resp);
		
		
		
		return;	
	}

}
