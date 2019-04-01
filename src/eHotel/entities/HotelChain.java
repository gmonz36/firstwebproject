package eHotel.entities;

public class HotelChain {
	private String name;
	private int streetNumber; 
	private String streetName;
	private String city;
	private String state;
	private String postalCode;
	private String numberOfHotels;
	
	public HotelChain(String name, int streetNumber, String streetName, String city, String state, String postalCode,
			String numberOfHotels) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.numberOfHotels = numberOfHotels;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getNumberOfHotels() {
		return numberOfHotels;
	}
	public void setNumberOfHotels(String numberOfHotels) {
		this.numberOfHotels = numberOfHotels;
	}
}
