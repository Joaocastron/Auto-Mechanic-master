package Car.Auto.Mechanic.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long customerId;

	private String customerName;

	private String vehicleModel;

	private String vehicleLicence;

	private long bookingId;

	private String bookingDescription;

	private String bookingComments;

	private double bookingPrice;

	private ArrayList<String> suppliesName;

	private ArrayList<Double> suppliesPrice;

	private double total;

	public Invoice() {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleLicence() {
		return vehicleLicence;
	}

	public void setVehicleLicence(String vehicleLicence) {
		this.vehicleLicence = vehicleLicence;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public String getBookingComments() {
		return bookingComments;
	}

	public void setBookingComments(String bookingComments) {
		this.bookingComments = bookingComments;
	}

	public double getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	public List<String> getSupplies() {
		return getSupplies();
	}

	public ArrayList<String> getSuppliesName() {
		return suppliesName;
	}

	public void setSuppliesName(ArrayList<String> suppliesName) {
		this.suppliesName = suppliesName;
	}

	public ArrayList<Double> getSuppliesPrice() {
		return suppliesPrice;
	}

	public void setSuppliesPrice(ArrayList<Double> suppliesPrice) {
		this.suppliesPrice = suppliesPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
