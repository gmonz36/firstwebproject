package eHotel.entities;

public class Room {
	
	private String chainName;
	private String hotelName;
	private int roomNumber;
	private float price;
	private String capacity;
	private String view;
	private boolean extendable;
	private String problems;
	
	public boolean equals(Room room) {
		if(chainName.equals(room.getchainName())&&hotelName.equals(room.gethotelName())&&roomNumber==room.getRoomNumber()&&
				price==room.getPrice()&&capacity.equals(room.getCapacity())
				&&view.equals(room.getView())&&extendable==room.isExtendable()&&problems.equals(room.getProblems())) {
			return true;
		}
		return false;
	}
	
	public Room(String chainName, String hotelName, int roomNumber, float price, String capacity,
			String view, boolean extendable, String problems) {
		super();
		this.chainName = chainName;
		this.hotelName = hotelName;
		this.roomNumber = roomNumber;
		this.price = price;
		this.capacity = capacity;
		this.view = view;
		this.extendable = extendable;
		this.problems = problems;
	}

	public String getchainName() {
		return chainName;
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
