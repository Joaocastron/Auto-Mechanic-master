package Car.Auto.Mechanic.Services;

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
	public Booking findbyVehicle(Vehicle vehicle) {
		
		return bookingRepository.findByVehicle(vehicle);
	}

	@Override
	public List<Vehicle> findByUser() {
		
		String name = Owner();
		if (name != null){
			
			User user = userService.findByEmail(name);
			return bookingRepository.findbyUser(user.getId());  
		}
		return null;
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
	public Booking save(BookingDTO bookingDTO) {
		
		Booking booking = new Booking();
		
		String name = Owner();
		User user = userService.findByEmail(name);
		
		
		booking.setCustomer(user);
		booking.setVehicle(bookingDTO.getVehicle());
		booking.setStatus(bookingDTO.getStatus());
		booking.setType(bookingDTO.getType());
		booking.setDescription(bookingDTO.getDescription());
		booking.setTimeStamp(bookingDTO.getDate());
		
		return bookingRepository.save(booking);
	}

	

	

}
