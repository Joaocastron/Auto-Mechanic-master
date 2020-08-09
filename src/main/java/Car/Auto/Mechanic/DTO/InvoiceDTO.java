package Car.Auto.Mechanic.DTO;

import java.util.Set;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Models.Status;
import Car.Auto.Mechanic.DTO.SupplyDTO;

public class InvoiceDTO {

	private Booking booking;

	private Long bookingId;

	private String BookingComments;

	private Status status;

	private Double price;

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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
