package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eHotel.connections.PostgreSqlConn;

/**
 * Servlet implementation class RentingPaymentServlet
 */
@SuppressWarnings("serial")
@WebServlet("/RentingPaymentServlet")
public class RentingPaymentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		PostgreSqlConn con = new PostgreSqlConn();
		System.out.println(req.getParameter("rentingID"));
		con.payRent(req.getParameter("rentingID"));

		req.getRequestDispatcher("Employee_menu.jsp").forward(req, resp);
	}

}
