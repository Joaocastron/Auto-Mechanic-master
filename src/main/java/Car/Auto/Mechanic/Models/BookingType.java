package Car.Auto.Mechanic.Models;

// Enum used for booking type determination

public enum BookingType {

	Annual("Annual Service"), Major("Major Service"), Repair("Repair / Fault"), MReair("Major Repair");

	public final String lable;

	private BookingType(String lable) {
		this.lable = lable;
	}

}
