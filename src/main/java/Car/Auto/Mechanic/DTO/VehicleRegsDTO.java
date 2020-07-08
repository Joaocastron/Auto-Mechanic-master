package Car.Auto.Mechanic.DTO;

import javax.validation.constraints.NotEmpty;

public class VehicleRegsDTO {

	@NotEmpty
	private String make;
	@NotEmpty
	private String model;
	@NotEmpty
	private String year;
	@NotEmpty
	private String licence;
	@NotEmpty
	private String engine;
	
	private String status;
	
	private String comments;

	public VehicleRegsDTO() {
		super();
		// TODO Auto-generated constructor stub
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
