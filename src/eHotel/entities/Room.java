package eHotel.entities;

public class Room {
	
	private String hotel_chain_chainName;
	private String hotel_hotelName;
	private int roomNumber;
	private float price;
	private String capacity;
	private String view;
	private boolean extendable;
	private String problems;
	
	public Room(String hotel_chain_chainName, String hotel_hotelName, int roomNumber, float price, String capacity,
			String view, boolean extendable, String problems) {
		super();
		this.hotel_chain_chainName = hotel_chain_chainName;
		this.hotel_hotelName = hotel_hotelName;
		this.roomNumber = roomNumber;
		this.price = price;
		this.capacity = capacity;
		this.view = view;
		this.extendable = extendable;
		this.problems = problems;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean isExtendable() {
		return extendable;
	}

	public void setExtendable(boolean extendable) {
		this.extendable = extendable;
	}

	public String getProblems() {
		return problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

}
