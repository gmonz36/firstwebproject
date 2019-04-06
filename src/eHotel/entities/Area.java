package eHotel.entities;

public class Area {
	private String state;
	private String city;
	private String numberOfRooms;
	public Area(String state, String city, String numberOfRooms) {
		super();
		this.state = state;
		this.city = city;
		this.numberOfRooms = numberOfRooms;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	
}
