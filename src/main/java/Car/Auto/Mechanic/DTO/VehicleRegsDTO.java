package Car.Auto.Mechanic.DTO;

import javax.validation.constraints.NotEmpty;

import Car.Auto.Mechanic.Models.Engine;
import Car.Auto.Mechanic.Models.Make;
import Car.Auto.Mechanic.Models.Model;

public class VehicleRegsDTO {

	@NotEmpty
	private Make make;
	@NotEmpty
	private Model model;
	@NotEmpty
	private String year;
	@NotEmpty
	private String licence;

	@NotEmpty
	private Engine engine;

	private String comments;

	public VehicleRegsDTO() {
		super();
		// TODO Auto-generated constructor stub
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
