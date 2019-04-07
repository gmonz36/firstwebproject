package eHotel.entities;

public class booking {
	String chainName;
	String hotelName;
	int roomNumber;
	String checkInDate;
	String checkOutDate;
	String bookingid;
	
	public booking(String chainName, String hotelName, int roomNumber, String checkInDate,
			String checkOutDate, String bookingid) {
		super();
		this.chainName = chainName;
		this.hotelName = hotelName;
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingid=bookingid;
	}

	public String getchainName() {
		return chainName;
	}
	
	public String getBookingID() {
		return bookingid;
	}

	public void setchainName(String chainName) {
		this.chainName = chainName;
	}

	public String gethotelName() {
		return hotelName;
	}

	public void sethotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}
