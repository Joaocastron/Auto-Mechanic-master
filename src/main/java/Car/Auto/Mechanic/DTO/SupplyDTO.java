package Car.Auto.Mechanic.DTO;

import Car.Auto.Mechanic.Entity.Supply;

public class SupplyDTO {
	
	private long id;
	private String supplyName;
	private double price;
	private boolean added;
	
	
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
