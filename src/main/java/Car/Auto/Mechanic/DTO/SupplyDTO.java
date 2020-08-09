package Car.Auto.Mechanic.DTO;

import javax.validation.constraints.NotEmpty;

import Car.Auto.Mechanic.Entity.Supply;

public class SupplyDTO {

	private long id;
	
	@NotEmpty(message = "May not be empty")
	private String supplyName;
	
	@NotEmpty(message = "May not be empty")
	private double price;
	
	private boolean added;

	public SupplyDTO() {
		super();

	}

	public SupplyDTO(Supply supply) {
		super();
		this.id = supply.getId();
		this.supplyName = supply.getSupplyName();
		this.price = supply.getPrice();
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

}
