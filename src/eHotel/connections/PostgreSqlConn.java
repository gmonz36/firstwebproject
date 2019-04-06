package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eHotel.entities.Hotel;
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

	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select password from employee where username=?");	            
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
		

		public String getPositionbyUname(String param){
			getConn();

			String position = "";
			
	        try{

	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select position from employee where username=?");	            
	            ps.setString(1, param);	   
	            rs = ps.executeQuery();
				while(rs.next()) {
					position = rs.getString(1);
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return position;       
	    }
		
		public String[] getuserinforbycustSSN(String ssn){
			getConn();

			String[] pwd = new String[2];
			
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	            ps = db.prepareStatement("select * from customer where SSN="+"'"+ssn+"'");	               
	            rs = ps.executeQuery();
	            if(rs.next()) pwd[1] = rs.getString("password");
	            
	            ps = db.prepareStatement("select * from person where SSN="+"'"+ssn+"'");
	            rs = ps.executeQuery();
	            if(rs.next())  pwd[0] = rs.getString("firstName");
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		

		public String[] getuserBooking(String ssn){
			getConn();

			String[] booking= new String[7];
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select * from Booking where checkindate<=now() and checkoutdate>= now()"
	            		+ "and customer_SSN=?");	               
	            ps.setString(1, ssn);	              
	            rs = ps.executeQuery();
	            
	            if (rs.next()) {
	            	booking[0]=rs.getString("chainname");
	            	booking[1]=rs.getString("hotelname");
	            	booking[2]=rs.getString("roomnumber");
	            	booking[3]=rs.getString("SSN");
	            	booking[4]=rs.getString("bookingid");
	            	booking[5]=rs.getString("checkindate");
	            	booking[6]=rs.getString("checkoutdate");
	            }
	            	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return booking;       
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

		public boolean insertNewHotel (String[] param){
			getConn();
	        try{
	        	st = db.createStatement();
	        	//Create new Hotel entity
	        	sql = "SET search_path = 'eHotel'; insert into hotel values('"+param[0]+"','"+param[1]+"','"+param[2]+"',"+param[3]+","+param[4]+",'"+param[5]+"','"+param[6]+"','"+param[7]+"','"+param[8]+"')";
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
				
				String query = "SELECT * FROM room LEFT JOIN hotel ON room.hotelName=Hotel.HotelName AND room.chainName=Hotel.chainName LEFT JOIN booking ON "
						+ "	room.chainName=booking.chainName AND room.hotelName=booking.hotelName AND room.roomNumber=booking.roomNumber "
						+ " WHERE (checkinDate >='"+endDate+"' OR checkoutDate <='"+startDate+"' OR( checkinDate IS NULL AND checkoutDate IS NULL))";
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
					rs.next();
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
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
			return Rooms;
			
		}
		
		public void bookRoom(String SSN,String startDate,String endDate,String chainName,String hotelName,int roomNumber){
			getConn();
			
	        try{
	        	String bookingID = "";
	        	Random random = new Random();
	        	for(int i=0;i<10;i++) {
	        		bookingID+=random.nextInt(9);
	        	}
	        	ps = db.prepareStatement("SET search_path = 'eHotel'; INSERT INTO booking VALUES ('"+chainName+"', '"+hotelName+"', '"+roomNumber+"', '"+SSN+"', '"+bookingID+"', '"+startDate+"', '"+endDate+"')");
				ps.executeUpdate();
	        }catch(SQLException e){
	            e.printStackTrace(); 
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
		
		public  ArrayList<Hotel> getAllHotels(){
			getConn();
			
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel';");
				ps.executeUpdate();
				ps = db.prepareStatement("select * from hotel" );
				rs = ps.executeQuery();
				while(rs.next()){
					String chainName = rs.getString("chainname");
					String hotelName = rs.getString("hotelname");
					Integer starRating = Integer.parseInt(rs.getString("starRating"));
					Integer streetNumber = Integer.parseInt(rs.getString("streetNumber"));
					String streetName = rs.getString("streetName");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String postalCode = rs.getString("postalCode");
					Hotel hotel = new Hotel(chainName, hotelName, starRating, streetNumber, streetName, city, state, postalCode);
					hotels.add(hotel);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return hotels;
		}	

	public  ArrayList<Room> getAllRoomsFromHotel(String cName, String hName){
		getConn();
		
		ArrayList<Room> Rooms = new ArrayList<Room>();
		try {
			ps = db.prepareStatement("SET search_path = 'eHotel'");
			ps.executeUpdate();
			ps = db.prepareStatement("select * from room WHERE chainName= '"+cName+"' AND hotelName= '"+hName+"'");
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
	public  ArrayList<Room> getAreaRooms(String state,String city){
		getConn();
		
		ArrayList<Room> Rooms = new ArrayList<Room>();
		try {
			ps = db.prepareStatement("SET search_path = 'eHotel'");
			ps.executeUpdate();
			
			String query = "SELECT * FROM room LEFT JOIN hotel ON room.hotelName=Hotel.HotelName AND room.chainName=Hotel.chainName WHERE state ='"+state+"' AND city ='"+city+"'";
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
}

