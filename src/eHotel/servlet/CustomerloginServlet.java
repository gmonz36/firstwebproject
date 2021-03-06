package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;
import eHotel.entities.employee;

@SuppressWarnings("serial")
public class CustomerloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String custSSN = req.getParameter("userSSN");
		String pwd = req.getParameter("pwd");
		
		PostgreSqlConn con = new PostgreSqlConn();
//		[0]:name,[1]:pwd
		String[] pwdfromdb = con.getuserinforbycustSSN(custSSN);
		
		if (pwd.equals(pwdfromdb[1])) {			
			
			ArrayList<Room> bookedRooms = con.getbookedRooms(custSSN);
			ArrayList<Room> allRooms = con.getAllAvailRooms();
			
			req.setAttribute("CustName", pwdfromdb[0]);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);
			req.setAttribute("custSSN", custSSN);

			req.getRequestDispatcher("customer_menu.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}