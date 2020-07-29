package Car.Auto.Mechanic.Entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Supply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String SupplyName;

	private double price;
	
	@ManyToMany(mappedBy = "supplies")
	private Set<Invoice> invoices;

	public Supply() {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSupplyName() {
		return SupplyName;
	}

	public void setSupplyName(String supplyName) {
		SupplyName = supplyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
