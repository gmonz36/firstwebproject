package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseUpdateServlet
 */
@SuppressWarnings("serial")
@WebServlet("/DatabaseUpdateServlet")
public class DatabaseUpdateServlet extends HttpServlet {

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

				req.getRequestDispatcher("InsertHotel.jsp").forward(req, resp);			
				
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
