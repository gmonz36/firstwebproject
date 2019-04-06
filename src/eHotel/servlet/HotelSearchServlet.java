package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Hotel;
import eHotel.entities.Room;

/**
 * Servlet implementation class HotelSearchServlet
 */
@WebServlet("/HotelSearchServlet")
public class HotelSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		PostgreSqlConn con = new PostgreSqlConn();
		String hotel = req.getParameter("hotel");
		String[] hotelInfo = hotel.split(" from chain ");
		ArrayList<Room> rooms = con.getAllRoomsFromHotel(hotelInfo[1],hotelInfo[0]);
		req.setAttribute("allRooms", rooms);
		req.getRequestDispatcher("hotel_capacity_display.jsp").forward(req, resp);
		return;	
	}

}
