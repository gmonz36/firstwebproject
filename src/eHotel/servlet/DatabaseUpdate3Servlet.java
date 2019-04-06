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
		Boolean successful = false;

		String[] params ;
		PostgreSqlConn con = new PostgreSqlConn();
		
		switch (operation){
		case "UPDATE":
			

			switch(table) {
			
			case "HOTEL":

				params = new String[9];
				params[0]=req.getParameter("mSSN");
				params[1]=req.getParameter("chainName");
				params[2]=req.getParameter("hotelName");
				params[3]=req.getParameter("starRating");
				params[4]=req.getParameter("streetNo");
				params[5]=req.getParameter("streetName");
				params[6]=req.getParameter("city");
				params[7]=req.getParameter("state");
				params[8]=req.getParameter("pCode");

				successful= con.updateHotel(params);	
				break;
			case "CUSTOMER":
				params = new String[11];
				params[0]=req.getParameter("SSN");
				params[1]=req.getParameter("FirstName");
				params[2]=req.getParameter("LastName");
				params[3]=req.getParameter("streetNo");
				params[4]=req.getParameter("streetName");
				params[5]=req.getParameter("aptNo");
				params[6]=req.getParameter("city");
				params[7]=req.getParameter("state");
				params[8]=req.getParameter("pCode");
				params[9]=req.getParameter("password");
				params[10]=req.getParameter("registrationdate");

				con.updateCustomer(params);	
				break;
			case "EMPLOYEE":

				params = new String[14];
				params[0]=req.getParameter("SSN");
				params[1]=req.getParameter("FirstName");
				params[2]=req.getParameter("LastName");
				params[3]=req.getParameter("streetNo");
				params[4]=req.getParameter("streetName");
				params[5]=req.getParameter("aptNo");
				params[6]=req.getParameter("city");
				params[7]=req.getParameter("state");
				params[8]=req.getParameter("pCode");

				params[9]=req.getParameter("chainName");
				params[10]=req.getParameter("hotelName");
				params[11]=req.getParameter("position");
				params[12]=req.getParameter("username");
				params[13]=req.getParameter("password");

				con.updateEmployee(params);	
				break;
			case "ROOM":


				params = new String[8];
				String[] amenities = new String[4];

				params[0]=req.getParameter("chainName");
				params[1]=req.getParameter("hotelName");
				params[2]=req.getParameter("roomNumber");
				params[3]=req.getParameter("price");
				params[4]=req.getParameter("capacity");
				params[5]=req.getParameter("view");
				params[6]=req.getParameter("extendable");
				params[7]=req.getParameter("problems");
				
				System.out.println(req.getParameter("problems"));
				
				amenities[0]=params[0];
				amenities[1]=params[1];
				amenities[2]=params[2];	
				
				amenities[3]="Television";
				if (req.getParameter("tv")!= null) {				
					con.deleteAmenity(amenities);
				}else {
					con.insertNewAmenity(amenities);
					
				}
				amenities[3]="Air Conditioning";
				if (req.getParameter("airCond")!= null) {		
					con.deleteAmenity(amenities);
				}else {
					con.insertNewAmenity(amenities);
				}
				amenities[3]="Fridge";
				if (req.getParameter("fridge")!= null) {		
					con.deleteAmenity(amenities);
				}else {
					con.insertNewAmenity(amenities);
				}

				con.updateRoom(params);
				
				break;			
			}
			
			break;
		case "DELETE":

			switch(table) {
			
			case "HOTEL":
				successful=con.deleteHotel(req.getParameter("chainname"),req.getParameter("hotelName"));
				break;
			case "CUSTOMER":
				successful=con.deleteCustomer(req.getParameter("SSN"));
				break;
			case "EMPLOYEE":				
				successful=con.deleteEmployee(req.getParameter("SSN"));
				break;
			case "ROOM":
				String[] amenities = new String[3];

				if (req.getParameter("tv")!= null) amenities[0]=req.getParameter("tv");
				if (req.getParameter("airCond")!= null)amenities[1]=req.getParameter("airCond");;
				if (req.getParameter("fridge")!= null)amenities[2]=req.getParameter("fridge");;
				
				successful=con.deleteRoom(req.getParameter("chainname"),req.getParameter("hotelName"),Integer.parseInt(req.getParameter("roomNumber")), amenities);
				break;			
			}
			
			break;
		}
		
		if (successful) {
			System.out.println("Operation was successful");
		}else {
			System.out.println("Operation failed");			
		}
		
	}

}
