package Car.Auto.Mechanic.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Car.Auto.Mechanic.Entity.Booking;

public class RosterDTO {

	private int days;
	
	private LocalDate dateTo;
	
	private ArrayList<LocalDate> range;
	
	private List<Booking> booking;

	public RosterDTO() {
		super();

	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
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

	public ArrayList<LocalDate> getRange() {
		return range;
	}

	public void setRange(ArrayList<LocalDate> range) {
		this.range = range;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

}
