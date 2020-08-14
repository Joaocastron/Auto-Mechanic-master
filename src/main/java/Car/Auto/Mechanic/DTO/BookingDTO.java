package Car.Auto.Mechanic.DTO;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Models.BookingType;
import Car.Auto.Mechanic.Models.Status;

public class BookingDTO {

	@NotNull(message = "Register Vehicle First")
	private Vehicle vehicle;
	
	private User Customer;
	
	private BookingType Type;
	
	@NotEmpty(message = "May not be empty")
	private String description;
	
	private String comments;
	
	private Status status;

	private String vehicleLicence;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public BookingDTO() {
		super();

	}

	public User getCustomer() {
		return Customer;
	}

	public void setCustomer(User customer) {
		Customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public BookingType getType() {
		return Type;
	}

	public void setType(BookingType type) {
		Type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getVehicleLicence() {
		return vehicleLicence;
	}

	public void setVehicleLicence(String vehicleLicence) {
		this.vehicleLicence = vehicleLicence;
	}
	

}
