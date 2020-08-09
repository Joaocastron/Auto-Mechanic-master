package Car.Auto.Mechanic.Models;

//Enum used for Booking Status car determination
public enum Status {

	Booked("Booked"), InService("In Service"), Completed("Completed"), Collected("Collected"),
	Unrepairable("Unrepairable / Scrapped");

	public final String lable;

	private Status(String lable) {

		this.lable = lable;
	}

}
