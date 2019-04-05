package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eHotel.connections.PostgreSqlConn;

/**
 * Servlet implementation class DatabaseUpdate2Servlet
 */
@SuppressWarnings("serial")
@WebServlet("/DatabaseUpdate2Servlet")
public class DatabaseUpdate2Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("Operation");
		String table = req.getParameter("Table");
		
		req.setAttribute("Operation", operation);
		req.setAttribute("Table", table);
		
		
		switch (operation){
		case "INSERT":
			
			switch (table){
			case "HOTEL":
				String[] params = new String[9];
				params[0]=req.getParameter("mSSN");
				params[1]=req.getParameter("chainName");
				params[2]=req.getParameter("hotelName");
				params[3]=req.getParameter("starRating");
				params[4]=req.getParameter("streetNo");
				params[5]=req.getParameter("streetName");
				params[6]=req.getParameter("city");
				params[7]=req.getParameter("state");
				params[8]=req.getParameter("pCode");

				PostgreSqlConn con = new PostgreSqlConn();
				con.insertNewHotel(params);	
				
				break;
			case "CUSTOMER":
				break;
			case "EMPLOYEE":
				break;
			case "ROOM":
				break;
			}
			
			
			
			break;
		case "UPDATE":
			
			switch (table){
			case "HOTEL":
				break;
			case "CUSTOMER":
				break;
			case "EMPLOYEE":
				break;
			case "ROOM":
				break;
			}
			break;
		case "DELETE":
			
			switch (table){
			case "HOTEL":
				break;
			case "CUSTOMER":
				break;
			case "EMPLOYEE":
				break;
			case "ROOM":
				break;
			}
			break;
		}
		
	}

}
