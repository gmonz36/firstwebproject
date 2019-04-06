package eHotel.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        LocalDate localDate = LocalDate.now();
		req.setAttribute("CurrentDate", DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate));
		
		switch (operation){
		case "INSERT":
			
			switch (table){
			case "HOTEL":
				req.getRequestDispatcher("InsertHotel.jsp").forward(req, resp);		
				break;
			case "CUSTOMER":
				req.getRequestDispatcher("InsertCustomer.jsp").forward(req, resp);		
				break;
			case "EMPLOYEE":
				req.getRequestDispatcher("InsertEmployee.jsp").forward(req, resp);		
				break;
			case "ROOM":
				req.getRequestDispatcher("InsertRoom.jsp").forward(req, resp);		
				break;
			}	
			break;
			
		case "UPDATE":
			
			switch (table){
			case "HOTEL":
				req.getRequestDispatcher("UpdateHotel.jsp").forward(req, resp);		
				break;
			case "CUSTOMER":
				req.getRequestDispatcher("UpdateCustomer.jsp").forward(req, resp);		
				break;
			case "EMPLOYEE":
				req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, resp);		
				break;
			case "ROOM":
				req.getRequestDispatcher("UpdateRoom.jsp").forward(req, resp);		
				break;
			}
			break;
			
		case "DELETE":
			
			switch (table){
			case "HOTEL":
				req.getRequestDispatcher("DeleteHotel.jsp").forward(req, resp);						
				break;
			case "CUSTOMER":	
				req.getRequestDispatcher("DeleteCustomer.jsp").forward(req, resp);		
				break;
			case "EMPLOYEE":
				req.getRequestDispatcher("DeleteEmployee.jsp").forward(req, resp);		
				break;
			case "ROOM":
				req.getRequestDispatcher("DeleteRoom.jsp").forward(req, resp);		
				break;
			}
			break;
		}
	}

}
