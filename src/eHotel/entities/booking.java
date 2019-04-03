package eHotel.entities;

public class booking {
	String hotel_chain_chainName;
	String hotel_hotelName;
	int roomNumber;
	String checkInDate;
	String checkOutDate;
	
	public booking(String hotel_chain_chainName, String hotel_hotelName, int roomNumber, String checkInDate,
			String checkOutDate) {
		super();
		this.hotel_chain_chainName = hotel_chain_chainName;
		this.hotel_hotelName = hotel_hotelName;
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public String getHotel_chain_chainName() {
		return hotel_chain_chainName;
	}

	public void setHotel_chain_chainName(String hotel_chain_chainName) {
		this.hotel_chain_chainName = hotel_chain_chainName;
	}

	public String getHotel_hotelName() {
		return hotel_hotelName;
	}

	public void setHotel_hotelName(String hotel_hotelName) {
		this.hotel_hotelName = hotel_hotelName;
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
