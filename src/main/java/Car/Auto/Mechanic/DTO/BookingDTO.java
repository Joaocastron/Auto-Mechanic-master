package Car.Auto.Mechanic.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Car.Auto.Mechanic.Entity.Vehicle;

public class BookingDTO {

	private Vehicle vehicle;
	private String Type;
	private String description;
	private String comments;
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
