package Car.Auto.Mechanic.Entity;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import Car.Auto.Mechanic.Models.BookingType;
import Car.Auto.Mechanic.Models.Status;

// Entity booking class using JPA notation

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Booking {

	public Booking() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	private Vehicle vehicle;

	@OneToOne(fetch = FetchType.EAGER)
	private User customer;

	private BookingType type;

	private String description;

	private String comments;

	private Status status;

	private double price;

	private LocalDate timeStamp;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "booking_supplies", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "supply_id"))
	private Set<Supply> supplies;

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public BookingType getType() {
		return type;
	}

	public void setType(BookingType type) {
		this.type = type;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(Set<Supply> supplies) {
		this.supplies = supplies;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

}
