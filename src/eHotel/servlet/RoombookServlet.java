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
		int roomno = Integer.parseInt(req.getParameter("option_no"));
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		System.out.println(endDate);
		System.out.println(custSSN);
		ArrayList<Room> roomList = (ArrayList<Room>) req.getAttribute("allRooms");
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		con.bookRoom(custSSN,startDate,endDate,roomList.get(roomno-1).getchainName(),roomList.get(roomno-1).gethotelName(),roomList.get(roomno-1).getRoomNumber());
		
		resp.sendRedirect("customer_menu.jsp");
		return;
	}
}