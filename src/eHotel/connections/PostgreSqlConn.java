package eHotel.connections;

import java.math.BigDecimal;
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
		
		public String[] getEmployeeBySSN(String ssn){
			getConn();

			String[] emp = new String[14];
			emp[0]=ssn;
			
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select * from person where SSN="+"'"+ssn+"'");	               
	            rs = ps.executeQuery();
	            
	            rs.next();
	            emp[1] = rs.getString("firstname");
	            emp[2] = rs.getString("lastname");
	            emp[3] = rs.getString("streetnumber");
	            emp[4] = rs.getString("streetname");
	            emp[5] = rs.getString("aptnumber");
	            emp[6] = rs.getString("city");
	            emp[7] = rs.getString("state");
	            emp[8] = rs.getString("postalcode");
	            
	            
	            ps = db.prepareStatement("select * from employee where SSN="+"'"+ssn+"'");
	            rs = ps.executeQuery();
	            
	            rs.next();
	            emp[9] = rs.getString("chainname");
	            emp[10] = rs.getString("hotelname");
	            emp[11] = rs.getString("position");
	            emp[12] = rs.getString("username");
	            emp[13] = rs.getString("password");
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return emp;       
	    }
		
		public String[] getCustomerBySSN(String ssn){
			getConn();

			String[] cust = new String[11];
			cust[0]=ssn;
			
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select * from person where SSN="+"'"+ssn+"'");	               
	            rs = ps.executeQuery();
	            
	            rs.next();
	            cust[1] = rs.getString("firstname");
	            cust[2] = rs.getString("lastname");
	            cust[3] = rs.getString("streetnumber");
	            cust[4] = rs.getString("streetname");
	            cust[5] = rs.getString("aptnumber");
	            cust[6] = rs.getString("city");
	            cust[7] = rs.getString("state");
	            cust[8] = rs.getString("postalcode");
	            
	            
	            ps = db.prepareStatement("select * from customer where SSN="+"'"+ssn+"'");
	            rs = ps.executeQuery();
	            
	            rs.next();
	            cust[9] = rs.getString("password");
	            cust[10] = rs.getString("registrationdate");
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return cust;       
	    }
		

		
		public String[] getHotel(String chainname, String hotelname){
			getConn();

			String[] cust = new String[10];
			cust[0]=chainname;
			cust[1]=hotelname;
			
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select * from hotel where chainname='"+chainname+"' and hotelname='" + hotelname + "'");	 
	            rs = ps.executeQuery();
	            
	            rs.next();
	            cust[2] = rs.getString("ssn");
	            cust[3] = rs.getString("starrating");
	            cust[4] = rs.getString("streetnumber");
	            cust[5] = rs.getString("streetname");
	            cust[6] = rs.getString("city");
	            cust[7] = rs.getString("state");
	            cust[8] = rs.getString("postalcode");
	            cust[9] = rs.getString("numberofrooms");
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return cust;       
	    }
		

		
		public String[] getRoom(String chainname, String hotelname, String roomnumber){
			getConn();

			String[] room = new String[8];
			room[0]=chainname;
			room[1]=hotelname;
			room[2]=roomnumber;
			
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select * from room where chainname="+"'"+chainname+"' and hotelname='" + hotelname + "' and roomnumber=" + roomnumber);	               
	            rs = ps.executeQuery();
	            
	            rs.next();
	            room[3] = rs.getString("price");
	            room[4] = rs.getString("capacity");
	            room[5] = rs.getString("view");
	            room[6] = rs.getString("extendable");
	            room[7] = rs.getString("problems");
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return room;       
	    }
		
		public String[] getAmenities(String chainname, String hotelname, String roomnumber){
			getConn();

			String[] amenities = new String[3];
			
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("select * from amenity where chainname="+"'"+chainname+"' and hotelname='" + hotelname + "' and roomnumber=" + roomnumber);	               
	            rs = ps.executeQuery();
	            
	            int i=0;
	            if (rs.next()) {
	            	
	            	amenities[i]=rs.getString("type");
	            	i++;
	            }
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return amenities;       
	    }
		
		public boolean deleteHotel(String chainname, String hotelname){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("DELETE FROM hotel where chainname=? and hotelname=?");	      
	            ps.setString(1, chainname);	      
	            ps.setString(2, hotelname);	                    
	            ps.executeUpdate();

	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }

		public boolean deleteCustomer(String ssn){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("DELETE FROM customer where SSN="+"'"+ssn+"'");	               
	            ps.executeUpdate();


	            ps = db.prepareStatement("DELETE FROM person where SSN="+"'"+ssn+"'");	               
	            ps.executeUpdate();
	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }
		
		public boolean deleteEmployee(String ssn){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("DELETE FROM employee where SSN="+"'"+ssn+"'");	               
	            ps.executeUpdate();


	            ps = db.prepareStatement("DELETE FROM person where SSN="+"'"+ssn+"'");	               
	            ps.executeUpdate();
	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }
		
		public boolean deleteRoom(String chainname, String hotelname, Integer roomNumber, String[] amenities){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("DELETE FROM room where chainname=? and hotelname=? and roomnumber=?");	      
	            ps.setString(1, chainname);	      
	            ps.setString(2, hotelname);	       
	            ps.setInt(3, roomNumber);	                   
	            ps.executeUpdate();
	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }
		

		public boolean deleteAmenity(String[] params){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("DELETE FROM amenity where chainname=? and hotelname=? and roomnumber=? and type=?");	      
	            ps.setString(1, params[0]);	      
	            ps.setString(2, params[1]);	       
	            ps.setInt(3, Integer.parseInt(params[2]));	       
	            ps.setString(4, params[3]);                   
	            ps.executeUpdate();

	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
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
		
		public boolean insertNewEmployee(String[] param){
			getConn();
	        try{
	        	st = db.createStatement();
	        	//Create new person entity
	        	sql = "SET search_path = 'eHotel'; insert into person values('"+param[0]+"','"+param[1]+"','"+param[2]+"',"+param[3]+",'"+param[4]+"',"+param[5]+",'"+param[6]+"','"+param[7]+"','"+param[8]+"')";
	        	System.out.print(sql);
	            st.executeUpdate(sql);
	            //Create new customer entity
	            sql = "SET search_path = 'eHotel'; insert into employee values('"+param[9]+"','"+param[10]+"','"+param[0]+"','"+param[11]+"','"+param[12]+"','"+param[13]+"')";
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
		

		public boolean insertNewRoom(String[] param, String[] amenities) {
			getConn();
	        try{
	        	st = db.createStatement();
	        	//Create new Hotel entity
	        	sql = "SET search_path = 'eHotel'; insert into room values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"','"+param[4]+"','"+param[5]+"','"+param[6]+"','"+param[7]+"')";
	        	System.out.print(sql);
	            st.executeUpdate(sql);
	            
	            for (String am: amenities){
	            	if (am!= null) {
		            	String[] params = new String[4];
		            	params[0]=param[0];
		            	params[1]=param[1];
		            	params[2]=param[2];
		            	params[3]=am;
		            	insertNewAmenity(params);
	            	}
	            }

	            return true;
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }	       
	    }
		

		public boolean insertNewAmenity (String[] param) {
			getConn();
	        try{
	        	st = db.createStatement();
	        	//Create new Hotel entity
	        	sql = "SET search_path = 'eHotel'; insert into amenity values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"')";
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
		

		public boolean updateHotel(String[] params){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("UPDATE hotel SET ssn=?,  starrating=?, streetnumber=?, streetname=?,"
	            		+ "city=?, state=?, postalcode=? where chainname=? and hotelname=?");	      
	            ps.setString(1, params[0]);	      
	            ps.setInt(2, Integer.parseInt(params[3]));	     
	            ps.setInt(3, Integer.parseInt(params[4]));	     
	            ps.setString(4, params[5]);	     
	            ps.setString(5, params[6]);	     
	            ps.setString(6, params[7]);	     
	            ps.setString(7, params[8]);	     
	            ps.setString(8, params[1]);	     
	            ps.setString(9, params[2]);	 	                    
	            ps.executeUpdate();

	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }
		

		public boolean updateCustomer(String[] params){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("UPDATE person SET firstname=?,  lastname=?, streetnumber=?, streetname=?,"
	            		+ "aptnumber=?, city=?, state=?, postalcode=? where ssn=?");	      
	            ps.setString(1, params[1]);	           
	            ps.setString(2, params[2]);	      
	            ps.setInt(3, Integer.parseInt(params[3]));	     
	            ps.setString(4, params[4]);	          
	            ps.setInt(5, Integer.parseInt(params[5]));	
	            ps.setString(6, params[6]);	     
	            ps.setString(7, params[7]);	     
	            ps.setString(8, params[8]);	     
	            ps.setString(9, params[0]);	 	                    
	            ps.executeUpdate();

	            ps = db.prepareStatement("UPDATE customer SET password=?,  registrationdate=? where ssn=?");

	            ps.setString(1, params[9]);	     
	            ps.setString(2, params[10]);	     
	            ps.setString(3, params[1]);	 	
	            ps.executeUpdate();

	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }
		

		public boolean updateEmployee(String[] params){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("UPDATE person SET firstname=?,  lastname=?, streetnumber=?, streetname=?,"
	            		+ "aptnumber=?, city=?, state=?, postalcode=? where ssn=?");	      
	            ps.setString(1, params[1]);	           
	            ps.setString(2, params[2]);	      
	            ps.setInt(3, Integer.parseInt(params[3]));	     
	            ps.setString(4, params[4]);	          
	            ps.setInt(5, Integer.parseInt(params[5]));	
	            ps.setString(6, params[6]);	     
	            ps.setString(7, params[7]);	     
	            ps.setString(8, params[8]);	     
	            ps.setString(9, params[0]);	 	                    
	            ps.executeUpdate();

	            ps = db.prepareStatement("UPDATE employee SET position=?, username=?, password=?"
	            		+ "where chainname=? and hotelname=? and ssn=?");

	            ps.setString(1, params[11]);	     
	            ps.setString(2, params[12]);	     
	            ps.setString(3, params[13]);	      
	            ps.setString(4, params[9]);	 	     
	            ps.setString(5, params[10]);	 	     
	            ps.setString(6, params[0]);	 		
	            ps.executeUpdate();

	            
	            return true;
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }     
	    }
		
		public boolean updateRoom(String[] params){
			getConn();
	        try{
	        	ps = db.prepareStatement("SET search_path = 'eHotel';");
	        	ps.executeUpdate();
	        	
	            ps = db.prepareStatement("UPDATE hotel SET price=?, capacity=?, view=?, extendable=?,"
	            		+ "problems=? where chainname=? and hotelname=? and roomnumber=?");	      
	            ps.setBigDecimal(1, (new BigDecimal(params[3])) );	      
	            ps.setInt(2, Integer.parseInt(params[4]));	     
	            ps.setString(3, params[5]);	     
	            ps.setBoolean(4, Boolean.parseBoolean(params[6]));	     
	            ps.setString(5, params[7]);
	            
	            ps.setString(6, params[0]);	     
	            ps.setString(7, params[1]);	     
	            ps.setInt(8, Integer.parseInt(params[2]));	 	                    
	            ps.executeUpdate();
	            
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

