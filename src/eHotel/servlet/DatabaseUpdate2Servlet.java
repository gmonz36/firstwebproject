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
		
		System.out.println(operation);
		System.out.println(table);
		
		String[] params ;
		PostgreSqlConn con = new PostgreSqlConn();
		
		switch (operation){
		case "INSERT":
			
			switch (table){
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

				con.insertNewHotel(params);	
				
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

				con.insertNewCustomer(params);	
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

				con.insertNewEmployee(params);	
				
				break;
			case "ROOM":

				params = new String[8];
				String[] amenities = new String[3];

				params[0]=req.getParameter("chainName");
				params[1]=req.getParameter("hotelName");
				params[2]=req.getParameter("roomNumber");
				params[3]=req.getParameter("price");
				params[4]=req.getParameter("capacity");
				params[5]=req.getParameter("view");
				params[6]=req.getParameter("extendable");
				params[7]=req.getParameter("problems");
				
				System.out.println(req.getParameter("problems"));
				
				if (req.getParameter("tv")!= null) amenities[0]=req.getParameter("tv");
				if (req.getParameter("airCond")!= null)amenities[1]=req.getParameter("airCond");;
				if (req.getParameter("fridge")!= null)amenities[2]=req.getParameter("fridge");;

				con.insertNewRoom(params, amenities);
				break;
			}
			
			
			
			break;
		case "UPDATE":
			
			switch (table){
			case "HOTEL":
				String[] hotel = con.getHotel(req.getParameter("chainName"),req.getParameter("hotelName"));

				req.setAttribute("chainName", hotel[0]);
				req.setAttribute("hotelName", hotel[1]);
				req.setAttribute("mSSN", hotel[2]);
				req.setAttribute("starRating", hotel[3]);
				req.setAttribute("streetNo", hotel[4]);
				req.setAttribute("streetName", hotel[5]);
				req.setAttribute("city", hotel[6]);
				req.setAttribute("state", hotel[7]);
				req.setAttribute("pCode", hotel[8]);
				req.setAttribute("numberofrooms", hotel[9]);
				
				req.getRequestDispatcher("UpdateHotel2.jsp").forward(req, resp);		
				break;
			case "CUSTOMER":
				String[] customer = con.getCustomerBySSN(req.getParameter("SSN"));
				
				req.setAttribute("ssn", customer[0]);
				req.setAttribute("firstname", customer[1]);
				req.setAttribute("lastname", customer[2]);
				req.setAttribute("streetnumber", customer[3]);
				req.setAttribute("streetname", customer[4]);
				req.setAttribute("aptnumber", customer[5]);
				req.setAttribute("city", customer[6]);
				req.setAttribute("state", customer[7]);
				req.setAttribute("postalcode", customer[8]);
				req.setAttribute("password", customer[9]);
				req.setAttribute("registrationdate", customer[10]);

				req.getRequestDispatcher("UpdateCustomer2.jsp").forward(req, resp);		
				break;
			case "EMPLOYEE":
				String[] employee = con.getEmployeeBySSN(req.getParameter("SSN"));

				req.setAttribute("ssn", employee[0]);
				req.setAttribute("firstname", employee[1]);
				req.setAttribute("lastname", employee[2]);
				req.setAttribute("streetnumber", employee[3]);
				req.setAttribute("streetname", employee[4]);
				req.setAttribute("aptnumber", employee[5]);
				req.setAttribute("city", employee[6]);
				req.setAttribute("state", employee[7]);
				req.setAttribute("postalcode", employee[8]);
				req.setAttribute("chainname", employee[9]);
				req.setAttribute("hotelname", employee[10]);
				req.setAttribute("position", employee[11]);
				req.setAttribute("username", employee[12]);
				req.setAttribute("password", employee[13]);
				

				req.getRequestDispatcher("UpdateEmployee2.jsp").forward(req, resp);		
				
				break;
			case "ROOM":
				

System.out.println("TEST");
				String[] room = con.getRoom(req.getParameter("chainName"),req.getParameter("hotelName"),req.getParameter("roomNumber"));
				req.setAttribute("chainName", room[0]);
				req.setAttribute("hotelName", room[1]);
				req.setAttribute("roomNumber", room[2]);
				req.setAttribute("price", room[3]);
				req.setAttribute("capacity", room[4]);
				req.setAttribute("view", room[5]);
				req.setAttribute("extendable", room[6]);
				req.setAttribute("problems", room[7]);
				

System.out.println("TEST2");
				String[] amenities = con.getAmenities(req.getParameter("chaiNname"),req.getParameter("hotelName"),req.getParameter("roomNumber"));

System.out.println("TEST3");
				for (String am: amenities) {
					System.out.println(am);
					if (am!=null){
						if (am.equals("Television")) {				
							req.setAttribute("Television", "Television");
						}else {
							req.setAttribute("Television", "Null");
							
						}
						if (am.equals("Air Conditioning")) {				
							req.setAttribute("airCon", "airCon");
						}else {
							req.setAttribute("airCon", "Null");
							
						}
						if (am.equals("Fridge")) {				
							req.setAttribute("Fridge", "Fridge");
						}else {
							req.setAttribute("Fridge", "Null");
							
						}
					}
					
				}

				System.out.println("AAAAAAA");

				req.getRequestDispatcher("UpdateRoom2.jsp").forward(req, resp);		
				break;
			}
			break;
		}
		
	}

}
