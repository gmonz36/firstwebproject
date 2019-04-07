package eHotel.entities;

public class Renting {
	String chainName;
	String hotelName;
	int roomNumber;
	String checkInDate;
	String checkOutDate;
	String rentingid;
	String payment;
	
	public Renting(String chainName, String hotelName, int roomNumber, String checkInDate,
			String checkOutDate, String rentingid, String payment) {
		super();
		this.chainName = chainName;
		this.hotelName = hotelName;
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.rentingid=rentingid;
		this.payment=payment;
	}

	public String getchainName() {
		return chainName;
	}
	
	public String getRentingID() {
		return rentingid;
	}

	public void setchainName(String chainName) {
		this.chainName = chainName;
	}

	public String gethotelName() {
		return hotelName;
	}

	public String getPayment() {
		return payment;
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
