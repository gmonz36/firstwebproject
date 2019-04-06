package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eHotel.connections.PostgreSqlConn;

/**
 * Servlet implementation class DatabaseUpdate3Servlet
 */
@SuppressWarnings("serial")
@WebServlet("/DatabaseUpdate3Servlet")
public class DatabaseUpdate3Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String operation = req.getParameter("Operation");
		String table = req.getParameter("Table");

		String[] params ;
		PostgreSqlConn con = new PostgreSqlConn();
		
		switch (operation){
		case "UPDATE":
			

			switch(table) {
			
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

			switch(table) {
			
			case "HOTEL":
				break;
			case "CUSTOMER":
				break;
			case "EMPLOYEE":
				
				con.deleteEmployee(req.getParameter("SSN"));
				break;
			case "ROOM":
				break;			
			}
			
			break;
		}
		
	}

}
