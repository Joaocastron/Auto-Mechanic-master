package Car.Auto.Mechanic.DTO;

import java.time.LocalDate;
import java.util.List;

import Car.Auto.Mechanic.Entity.Booking;

public class RosterDTO {
	
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private List<Booking> booking;
	
	public RosterDTO() {
		super();
		
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	
	
	

}
