package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotel.entities.HotelChain;
import eHotel.entities.Room;
import eHotel.entities.booking; 


public class  PostgreSqlConn{
	
		Connection db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Statement st = null;
	    String sql;


		public void getConn(){
			
			try {
				
				Class.forName("org.postgresql.Driver"); 
								
				db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/gmonz035",
						"gmonz035", "36Octopus36");
															
			}catch(Exception e) {
				System.out.print("error catched");
			}
						
		}
		
		public void closeDB() {
				try {
					if(rs != null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(st!=null){
						st.close();
					}
					if(db!=null){
						db.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		
		public String getpwdbyUname(String param){
			getConn();

			String pwd = "";
			
	        try{
	            ps = db.prepareStatement("SET search_path = 'eHotel'; select employee_pass from employee where employee_id=?");
	            
	            ps.setString(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd = rs.getString(1);
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		
		public String[] getuserinforbycustSSN(String ssn){
			getConn();

			String[] pwd = new String[2];
			
	        try{
	        	// st = db.createStatement();
	        	// sql = "SET search_path = 'eHotel';"; 
	        	//System.out.print(sql);
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	            //st.executeUpdate(sql);
	            ps = db.prepareStatement("select * from customer where SSN="+"'"+ssn+"'");	               
	            rs = ps.executeQuery();
	            if(rs.next()) pwd[1] = rs.getString("password");
	            
	            ps = db.prepareStatement("select * from person where SSN="+"'"+ssn+"'");
	            rs = ps.executeQuery();
	            //sql = "SET search_path = 'eHotel'; select * from person where SSN="+"'"+ssn+"'";
	        	//System.out.print(sql);
	            //rs = st.executeQuery(sql);
	            if(rs.next())  pwd[0] = rs.getString("firstName");
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		public boolean insertNewCustomer(String[] param){
			getConn();
	        try{
	        	st = db.createStatement();
	        	//Create new person entity
	        	sql = "SET search_path = 'eHotel'; insert into person values('"+param[0]+"','"+param[1]+"','"+param[2]+"',"+param[3]+",'"+param[4]+"',"+param[5]+",'"+param[6]+"','"+param[7]+"','"+param[8]+"')";
	        	System.out.print(sql);
	            st.executeUpdate(sql);
	            //Create new customer entity
	            sql = "SET search_path = 'eHotel'; insert into customer values('"+param[0]+"','"+param[9]+"','"+param[10]+"')";
	        	System.out.print(sql);
	            st.executeUpdate(sql);
	            
	            return true;
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }	       
	    }
		
		public  ArrayList<Room> getAllAvailRooms(){
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			ArrayList<booking> bookings = new ArrayList<booking>();
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'");
				ps.executeUpdate();
				ps = db.prepareStatement("select * from room");
				rs = ps.executeQuery();
				while(rs.next()){
					String chainName = rs.getString("chainName");
					String hotelName = rs.getString("hotelName");
					int roomNumber = Integer.parseInt(rs.getString("roomNumber"));
					float price = Float.parseFloat(rs.getString("price"));
					String capacity = rs.getString("capacity");
					String view = rs.getString("view");
					boolean extendable = Boolean.parseBoolean(rs.getString("extendable"));
					String problems = rs.getString("problems");
					Room room = new Room(chainName,hotelName,roomNumber,price,capacity,view,extendable,problems);
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;	
		}
		
		public  ArrayList<Room> getSearchedRooms(String startDate,String endDate,String roomCapacity,String state,String city,String hotelChain,String category,String hotelRoomNbr,String price){
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'");
				ps.executeUpdate();
				
				String query = "SELECT * FROM room NATURAL JOIN Hotel,booking WHERE (checkinDate >='"+endDate+"' OR checkoutDate <='"+startDate+"')";
				if(!roomCapacity.equals("")) {
					query+=" AND capacity ='"+roomCapacity+"'";
				}
				if(!city.equals("")) {
					query+=" AND city ='"+city+"'"; 
				}
				if(!hotelChain.equals("")) {
					query+=" AND chainName ='"+hotelChain+"'"; 
				}
				if(!category.equals("")) {
					query+=" AND category ='"+category+"'";
				}
				if(!price.equals("")) {
					query+=" AND price  ='"+price+"'";
				}
				//TODO implement search criteria for hotel total number of room
				ps = db.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()){
					String chainName = rs.getString("chainName");
					String hotelName = rs.getString("hotelName");
					int roomNumber = Integer.parseInt(rs.getString("roomNumber"));
					float roomPrice = Float.parseFloat(rs.getString("price"));
					String capacity = rs.getString("capacity");
					String view = rs.getString("view");
					boolean extendable = Boolean.parseBoolean(rs.getString("extendable"));
					String problems = rs.getString("problems");
					Room room = new Room(chainName,hotelName,roomNumber,roomPrice,capacity,view,extendable,problems);
					if(!Rooms.contains(room)) Rooms.add(room);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;	
		}
		
		public  ArrayList<Room> getbookedRooms(String custSSN){
			//TODO fix this query to query more information from the bookings
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			ArrayList<booking> bookings = new ArrayList<booking>();
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'");
				ps.executeUpdate();
				ps = db.prepareStatement("select * from booking where SSN='"+custSSN+"'");
				rs = ps.executeQuery();
				while(rs.next()){
					String chainName = rs.getString("chainName");
					String hotelName = rs.getString("hotelName");
					int roomNumber = Integer.parseInt(rs.getString("roomNumber"));
					String checkInDate = rs.getString("checkInDate");
					String checkOutDate = rs.getString("checkOutDate");
					booking booking = new booking(chainName, hotelName,roomNumber,checkInDate,checkOutDate);
					bookings.add(booking);
				}
				for(booking booking: bookings) {
					ps = db.prepareStatement("select * from room where chainName='"+booking.getchainName()
											+"' AND hotelName='"+booking.gethotelName()+"' AND roomNumber='"
											+booking.getRoomNumber()+"'");
					rs = ps.executeQuery();
					String chainName = rs.getString("chainName");
					String hotelName = rs.getString("hotelName");
					int roomNumber = Integer.parseInt(rs.getString("roomNumber"));
					float price = Float.parseFloat(rs.getString("price"));
					String capacity = rs.getString("capacity");
					String view = rs.getString("view");
					boolean extendable = Boolean.parseBoolean(rs.getString("extendable"));
					String problems = rs.getString("problems");
					Room room = new Room(chainName,hotelName,roomNumber,price,capacity,view,extendable,problems);
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public String bookRoom(String custName, String roomno){
			getConn();
			String custSSN="";
			
	        try{
	        	
	        	ps = db.prepareStatement("SET search_path = 'eHotel'; select SSN from customer where name='"+custName+"'");
				rs = ps.executeQuery();
				
				while(rs.next()){
					custSSN = rs.getString("SSN");
				}
				
				/*
	        	st = db.createStatement();
	        	sql = "SET search_path = 'eHotel'; update room set SSN='"+custSSN+"', room_status='booked' where room_no='"+roomno+"'";
	            st.executeUpdate(sql);
	            */
	            
	            return custSSN;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return "";	 
	        }finally {
	        	closeDB();
	        }
			      
	    }
		
		public  ArrayList<HotelChain> getAllHotelChains(){
			
			getConn();
			
			ArrayList<HotelChain> hotelChains = new ArrayList<HotelChain>();
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'; select * from hotel_chain" );
				rs = ps.executeQuery();
				while(rs.next()){
					String name = rs.getString("chainname");
					Integer streetNumber = Integer.parseInt(rs.getString("streetNumber"));
					String streetName = rs.getString("streetName");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String postalCode = rs.getString("postalCode");
					String numberOfHotels = rs.getString("numberOfHotels");
					HotelChain hotelChain = new HotelChain(name, streetNumber, streetName, city, state, postalCode, numberOfHotels);
					hotelChains.add(hotelChain);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return hotelChains;
			
		}	
	}

