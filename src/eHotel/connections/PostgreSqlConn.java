package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotel.entities.HotelChain;
import eHotel.entities.Room; 


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
		
		
		public String[] getuserinforbycustSSN(String param){
			getConn();

			String[] pwd = new String[2];
			
	        try{
	            ps = db.prepareStatement("SET search_path = 'eHotel'; select * from customer where customer_ssn=?");
	            
	            ps.setString(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString(2);
					pwd[1] = rs.getString(3);
				}
	            
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
	        	sql = "SET search_path = 'eHotel'; insert into customer values('"+param[0]+"','"+param[1]+"','"+param[2]+"')";
	        	
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
			
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'; select * from room where room_status='available'" );
				rs = ps.executeQuery();
				while(rs.next()){
					String room_no = rs.getString("room_no");
					String room_status = rs.getString("room_status");
					Room room = new Room(room_no, room_status);
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
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("SET search_path = 'eHotel'; select * from room where customer_ssn='"+custSSN+"'");
				rs = ps.executeQuery();
				while(rs.next()){
					String room_no = rs.getString("room_no");
					String room_status = rs.getString("room_status");
					Room room = new Room(room_no, room_status);
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
					String name = rs.getString("chainName");
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

