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
@WebServlet("/EmployeeMenuServlet")
public class EmployeeMenuServlet extends HttpServlet {

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
		String[] customer = con.getuserinforbycustSSN(customerSSN);
		if (customer[0]!=null) {			
			
			String[] booking = con.getuserBooking(customerSSN);
			
			req.setAttribute("chainname", booking[0]);
			req.setAttribute("hotelname", booking[1]);
			req.setAttribute("roomnumber", booking[2]);
			//req.setAttribute("customerSSN", booking[3]);
			req.setAttribute("bookingid", booking[4]);
			req.setAttribute("checkindate", booking[5]);
			req.setAttribute("checkoutdate", booking[6]);
			req.getRequestDispatcher("Employee_CheckIn.jsp").forward(req, resp);
			return;
		}

		resp.sendRedirect("login_failure.jsp");
		return;
	}

}
