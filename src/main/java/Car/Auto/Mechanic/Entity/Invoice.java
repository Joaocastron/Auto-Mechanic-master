package Car.Auto.Mechanic.Entity;

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

//Invoice booking class using JPA notation
@Entity
public class Invoice {

	public Invoice() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	private Booking booking;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "invoices_supplies", joinColumns = @JoinColumn(name = "invoice_id"), inverseJoinColumns = @JoinColumn(name = "supply_id"))
	private Set<Supply> supplies;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Set<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(Set<Supply> supplies) {
		this.supplies = supplies;
	}

}
