package Car.Auto.Mechanic.Entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import Car.Auto.Mechanic.DTO.SupplyDTO;

//Supply booking class using JPA notation
@Entity
public class Supply {

	public Supply() {
		super();
	}

	public Supply(SupplyDTO supplyDTO) {
		super();
		this.id = supplyDTO.getId();
		this.SupplyName = supplyDTO.getSupplyName();
		this.price = supplyDTO.getPrice();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String SupplyName;

	private double price;
	
	@ManyToMany(mappedBy = "supplies")
	private Set<Invoice> invoices;

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
