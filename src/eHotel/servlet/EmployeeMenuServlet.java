package eHotel.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;

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
		String customerSSN = req.getParameter("SSN");
		req.setAttribute("SSN", customerSSN);


		PostgreSqlConn con = new PostgreSqlConn();
		String[] customer = con.getuserinforbycustSSN(customerSSN);
		if (customer[0]!=null) {			
			
			System.out.println(session.getAttribute("chainname"));
			ArrayList<Room> bookedRooms = con.getbookedRooms(customerSSN, (String)session.getAttribute("hotelname"),(String)session.getAttribute("chainname"), LocalDate.now());
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("SSN", customerSSN);
			
			
			req.getRequestDispatcher("Employee_CheckIn.jsp").forward(req, resp);
			return;
		}
		System.out.println("test");
		resp.sendRedirect("login_failure.jsp");
		return;
	}

}