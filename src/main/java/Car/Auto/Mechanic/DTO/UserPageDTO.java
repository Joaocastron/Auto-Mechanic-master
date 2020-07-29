package Car.Auto.Mechanic.DTO;

import java.util.Collection;
import java.util.List;

import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Entity.Vehicle;

public class UserPageDTO {
	
	private User user;
	
	private List <Vehicle> vehicles;
	
	private Collection<Booking> booking;

	public UserPageDTO() {
		super();
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Collection<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Collection<Booking> booking) {
		this.booking = booking;
	}
		

}
