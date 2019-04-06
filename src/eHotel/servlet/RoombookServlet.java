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
import eHotel.entities.HotelChain;
import eHotel.entities.employee;

public class RoombookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String custSSN = req.getParameter("custSSN");
		String option = req.getParameter("submit");
		String[] roomInfo = option.split("--",-2);
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		PostgreSqlConn con = new PostgreSqlConn();
		con.bookRoom(custSSN,startDate,endDate,roomInfo[0],roomInfo[1],Integer.parseInt(roomInfo[2]));
		
		resp.sendRedirect("customer_menu.jsp");
		return;
	}
}