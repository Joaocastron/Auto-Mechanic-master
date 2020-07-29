package Car.Auto.Mechanic.DTO;

import java.util.List;

import Car.Auto.Mechanic.Entity.Supply;

public class InvoiceDTO {
	
	private long bookingId;
	
	private String bookingComments;
	
	private List<Supply> supplies;

	public InvoiceDTO() {
		super();
		
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingComments() {
		return bookingComments;
	}

	public void setBookingComments(String bookingComments) {
		this.bookingComments = bookingComments;
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}
	
	

}
