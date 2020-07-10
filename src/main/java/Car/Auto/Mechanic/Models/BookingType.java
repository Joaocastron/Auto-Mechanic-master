package Car.Auto.Mechanic.Models;

public enum BookingType {

	Annual("Annual Service"), Major("Major Service"), Repair("Repair / Fault"), MReair("Major Repair");
	
	private final String displayType;

	private BookingType(String displayType) {
	        this.displayType = displayType;
	    }

	public String getDisplayValue() {
	        return displayType;}
}
