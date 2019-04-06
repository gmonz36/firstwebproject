package eHotel.entities;

public class hotelRoomCapacity {
	private String chainName;
	private String hotelName;
	private String capacity;
	public hotelRoomCapacity(String chainName, String hotelName, String capacity) {
		super();
		this.chainName = chainName;
		this.hotelName = hotelName;
		this.capacity = capacity;
	}
	public String getChainName() {
		return chainName;
	}
	public void setChainName(String chainName) {
		this.chainName = chainName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
}
