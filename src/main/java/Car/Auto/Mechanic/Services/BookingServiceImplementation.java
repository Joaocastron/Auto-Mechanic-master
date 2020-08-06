package Car.Auto.Mechanic.Services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Models.Status;
import Car.Auto.Mechanic.Repository.BookingRepository;
import Car.Auto.Mechanic.Repository.VehicleRepository;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private UserService userService;

	@Override
	public Booking findbyVehicle(long vehicle_id) {

		return bookingRepository.findByVehicle(vehicle_id);
	}

	@Override
	public List<Vehicle> findByUser() {

		String name = Owner();
		if (name != null) {

			User user = userService.findByEmail(name);
			return vehicleRepository.findbyUser(user.getId());
		}
		return null;
	}

	@Override
	public boolean isBooked(String vehicleLicence) {

		return bookingRepository.isBooked(vehicleLicence) > 0;
	}

	public String Owner() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return null;
	}
	
	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking save(BookingDTO bookingDTO) {

		Booking booking = new Booking();

		String name = Owner();
		User user = userService.findByEmail(name);

		String licence = bookingDTO.getVehicleLicence();
		Vehicle vehicle = vehicleRepository.findbyLicence(licence);

		booking.setCustomer(user);
		booking.setVehicle(vehicle);
		booking.setStatus(Status.BOOKED);
		booking.setType(bookingDTO.getType());
		booking.setDescription(bookingDTO.getDescription());
		booking.setTimeStamp(bookingDTO.getDate());

		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getByPeriod(LocalDate startDate, LocalDate endDate) {
		return bookingRepository.getByPeriod(startDate, endDate);
	}

	@Override
	public List<Booking> getByStatus(Status status) {
		
		return bookingRepository.getByStatus(status.ordinal());
	}

	@Override
	public List<Booking> findByUser(long userId) {
		
		return bookingRepository.findByUser(userId);
	}

	@Override
	public Booking findById(long Id) {
		
		return bookingRepository.findById(Id);
	}

	@Override
	public List<Booking> findBySearch(String customerName, String customerPhone, long bookingId, Status status) {
		
		return bookingRepository.findBySearch(customerName, customerPhone, bookingId, status);
	}

	

}
