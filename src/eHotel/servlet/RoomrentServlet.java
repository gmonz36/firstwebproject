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
import eHotel.entities.Renting;
import eHotel.entities.employee;

@SuppressWarnings("serial")
public class RoomrentServlet extends HttpServlet {

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
		con.rentRoom(roomInfo[0],roomInfo[1],roomInfo[2],custSSN,startDate,endDate);
		
		ArrayList<Room> bookedRooms = con.getbookedRooms(custSSN);
		req.setAttribute("bookedRooms", bookedRooms);
		req.setAttribute("custSSN", custSSN);		

		ArrayList<Renting> rentedRooms = con.getRentedRooms(custSSN,(String)session.getAttribute("chainname"),(String)session.getAttribute("hotelname"));
		req.setAttribute("rentings", rentedRooms);
		req.setAttribute("SSN", custSSN);
		
		req.getRequestDispatcher("Employee_CheckIn.jsp").forward(req, resp);
		return;
	}
}