package Car.Auto.Mechanic.DTO;

import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;

public class InvoiceDTO {
	
	private Booking booking;
	
	private User user;

	public InvoiceDTO() {
		super();
		
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
