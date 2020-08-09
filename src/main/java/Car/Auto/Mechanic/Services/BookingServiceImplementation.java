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

//Booking class implementation
@Service
public class BookingServiceImplementation implements BookingService {

	// repositories and services instantiations
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private UserService userService;

	// authentication method identifying logged user
	public String Owner() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return null;
	}

	// method identifying logged user returning list of vehicles the user has
	@Override
	public List<Vehicle> findByUser() {

		String name = Owner();
		if (name != null) {

			User user = userService.findByEmail(name);
			return vehicleRepository.findbyUser(user.getId());
		}
		return null;
	}

	// method saving booking in the repository
	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	// method saving booking DTO as booking.
	@Override
	public Booking save(BookingDTO bookingDTO) {

		Booking booking = new Booking();

		// getting user by authentication
		String name = Owner();
		User user = userService.findByEmail(name);

		// getting vehicle chosen for booking by DTO by license
		String licence = bookingDTO.getVehicleLicence();
		Vehicle vehicle = vehicleRepository.findbyLicence(licence);

		// setting booking information by DTO
		booking.setCustomer(user);
		booking.setVehicle(vehicle);
		booking.setStatus(Status.Booked);
		booking.setType(bookingDTO.getType());
		booking.setDescription(bookingDTO.getDescription());
		booking.setTimeStamp(bookingDTO.getDate());

		return bookingRepository.save(booking);
	}

	// Methods overriding service interface returning objects;
	@Override
	public Booking findbyVehicle(long vehicle_id) {

		return bookingRepository.findByVehicle(vehicle_id);
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
