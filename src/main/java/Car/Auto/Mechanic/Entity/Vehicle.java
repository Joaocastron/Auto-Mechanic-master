package Car.Auto.Mechanic.Entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import Car.Auto.Mechanic.Models.Engine;
import Car.Auto.Mechanic.Models.Make;
import Car.Auto.Mechanic.Models.Model;

//Vehicle booking class using JPA notation
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "licence"))
public class Vehicle {

	public Vehicle() {
		super();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Make make;

	private Model model;

	private String year;

	private String licence;

	private Engine engine;

	private String comments;

	@OneToOne(fetch = FetchType.EAGER)
	private User owner;

	@OneToMany
	private Collection<Booking> booking;

	public User getUser() {
		return owner;
	}

	public void setUser(User user) {
		this.owner = user;
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

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
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

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
