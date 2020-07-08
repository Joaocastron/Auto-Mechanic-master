package Car.Auto.Mechanic.Entity;

import java.security.acl.Owner;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


enum make{
	
	Toyota, Nissan, Ferrari, Lamborghini
}
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "licence"))
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String make;
	private String model;
	private String year;
	private String licence;
	private String engine;
	private String status;
	private String comments;

	@OneToOne(fetch = FetchType.EAGER)
	private User owner;

	@OneToMany
	private Collection<Booking> booking;

	public Vehicle() {
		super();

	}

	
	public User getUserId() {
		return owner;
	}

	public void setUserId(User userId) {
		this.owner = userId;
	}

	public Collection<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Collection<Booking> booking) {
		this.booking = booking;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	


}
