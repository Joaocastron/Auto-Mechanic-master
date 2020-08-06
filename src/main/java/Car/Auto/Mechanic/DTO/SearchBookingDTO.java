package Car.Auto.Mechanic.DTO;

import java.util.List;

import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Models.Status;

public class SearchBookingDTO {
	
	private User user;
	
	private List <Booking> booking;
	
	private String getName;
	
	private String getPhone;
	
	private long getBookingId;
	
	 private Status getStatus; 

	public SearchBookingDTO() {
		super();
	
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public String getGetName() {
		return getName;
	}

	public void setGetName(String getName) {
		this.getName = getName;
	}

	public String getGetPhone() {
		return getPhone;
	}

	public void setGetPhone(String getPhone) {
		this.getPhone = getPhone;
	}

	public long getGetBookingId() {
		return getBookingId;
	}

	public void setGetBookingId(long getBookingId) {
		this.getBookingId = getBookingId;
	}

	public Status getGetStatus() {
		return getStatus;
	}

	public void setGetStatus(Status getStatus) {
		this.getStatus = getStatus;
	}

	
	
	
	
	

}
