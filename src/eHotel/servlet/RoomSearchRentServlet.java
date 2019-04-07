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
import eHotel.entities.HotelChain;
import eHotel.entities.Room;

/**
 * Servlet implementation class RoomSearch
 */
@WebServlet("/RoomSearchRent")
public class RoomSearchRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomSearchRentServlet() {
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
		
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String chainname = (String)session.getAttribute("chainname");
		String hotelname = (String)session.getAttribute("hotelname");
		String roomCapacity = req.getParameter("roomCapacity");
		String price = req.getParameter("price");
		String custSSN = req.getParameter("custSSN");
		PostgreSqlConn con = new PostgreSqlConn();
		ArrayList<Room> searchedRooms = con.getSearchedRooms(startDate,endDate,roomCapacity,"","",chainname,hotelname,"","",price);
			
		req.setAttribute("allRooms", searchedRooms);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate", endDate);
		req.setAttribute("custSSN", custSSN);

		req.getRequestDispatcher("renting.jsp").forward(req, resp);
		return;
	}
}
