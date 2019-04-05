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
	        	// st = db.createStatement();
	        	// sql = "SET search_path = 'eHotel';"; 
	        	//System.out.print(sql);
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	            //st.executeUpdate(sql);
	            ps = db.prepareStatement("select * from customer where person_SSN="+"'"+ssn+"'");	               
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
	            	booking[0]=rs.getString("hotel_chain_chainname");
	            	booking[1]=rs.getString("hotel_hotelname");
	            	booking[2]=rs.getString("room_roomnumber");
	            	booking[3]=rs.getString("customerSSN");
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
					String hotel_chain_chainName = rs.getString("hotel_chain_chainName");
					String hotel_hotelName = rs.getString("hotel_hotelName");
					int roomNumber = Integer.parseInt(rs.getString("room_roomNumber"));
					float price = Float.parseFloat(rs.getString("price"));
					String capacity = rs.getString("capacity");
					String view = rs.getString("view");
					boolean extendable = Boolean.parseBoolean(rs.getString("extendable"));
					String problems = rs.getString("problems");
					Room room = new Room(hotel_chain_chainName,hotel_hotelName,roomNumber,price,capacity,view,extendable,problems);
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
		
		public  ArrayList<Room> getbookedRooms(String custSSN){
			//TODO fix this query to query more information from the bookings
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			ArrayList<booking> bookings = new ArrayList<booking>();
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'");
				ps.executeUpdate();
				ps = db.prepareStatement("select * from booking where customer_ssn='"+custSSN+"'");
				rs = ps.executeQuery();
				while(rs.next()){
					String hotel_chain_chainName = rs.getString("hotel_chain_chainName");
					String hotel_hotelName = rs.getString("hotel_hotelName");
					int roomNumber = Integer.parseInt(rs.getString("room_roomNumber"));
					String checkInDate = rs.getString("checkInDate");
					String checkOutDate = rs.getString("checkOutDate");
					booking booking = new booking(hotel_chain_chainName, hotel_hotelName,roomNumber,checkInDate,checkOutDate);
					bookings.add(booking);
				}
				for(booking booking: bookings) {
					ps = db.prepareStatement("select * from room where hotel_chain_chainName='"+booking.getHotel_chain_chainName()
											+"' AND hotel_hotelName='"+booking.getHotel_hotelName()+"' AND room_roomNumber='"
											+booking.getRoomNumber()+"'");
					rs = ps.executeQuery();
					String hotel_chain_chainName = rs.getString("hotel_chain_chainName");
					String hotel_hotelName = rs.getString("hotel_hotelName");
					int roomNumber = Integer.parseInt(rs.getString("room_roomNumber"));
					float price = Float.parseFloat(rs.getString("price"));
					String capacity = rs.getString("capacity");
					String view = rs.getString("view");
					boolean extendable = Boolean.parseBoolean(rs.getString("extendable"));
					String problems = rs.getString("problems");
					Room room = new Room(hotel_chain_chainName,hotel_hotelName,roomNumber,price,capacity,view,extendable,problems);
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
	        	
	        	ps = db.prepareStatement("SET search_path = 'eHotel'; select customer_ssn from customer where customer_name='"+custName+"'");
				rs = ps.executeQuery();
				
				while(rs.next()){
					custSSN = rs.getString("customer_ssn");
				}
				
				
	        	st = db.createStatement();
	        	sql = "SET search_path = 'eHotel'; update room set customer_ssn='"+custSSN+"', room_status='booked' where room_no='"+roomno+"'";
	            st.executeUpdate(sql);
	            
	            
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
		
		
		
		
//		public static void main(String []args) {
//			PostgreSqlConn con = new PostgreSqlConn();
//			con.getConn();
//			String pwd = con.getpwdbyUname("8366341");
//			
//			System.out.println(pwd);
//				
//			
//			
//		}

		
	}

