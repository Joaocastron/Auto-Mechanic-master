package Car.Auto.Mechanic.DTO;

import java.util.Set;

import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.DTO.SupplyDTO;

public class InvoiceDTO {

	private Booking booking;

	private long bookingId;

	private String BookingComments;

	private Set<SupplyDTO> supplies;

	public InvoiceDTO() {
		super();

	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Set<SupplyDTO> getSupplies() {
		return supplies;
	}

	public void setSupplies(Set<SupplyDTO> supplies) {
		this.supplies = supplies;
	}

	public String getBookingComments() {
		return BookingComments;
	}

	public void setBookingComments(String bookingComments) {
		BookingComments = bookingComments;
	}

}
